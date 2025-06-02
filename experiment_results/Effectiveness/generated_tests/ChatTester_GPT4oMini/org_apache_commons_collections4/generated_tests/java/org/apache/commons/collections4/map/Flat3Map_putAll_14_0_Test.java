package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Flat3Map_putAll_14_0_Test {

    private Flat3Map<String, String> flat3Map;

    private AbstractHashedMap<String, String> mockDelegateMap;

    @BeforeEach
    void setUp() {
        flat3Map = new Flat3Map<>();
        mockDelegateMap = Mockito.mock(AbstractHashedMap.class);
        setPrivateField(flat3Map, "delegateMap", mockDelegateMap);
    }

    @Test
    void putAll_EmptyMap_NoAction() {
        Map<String, String> emptyMap = new HashMap<>();
        flat3Map.putAll(emptyMap);
        verify(mockDelegateMap, never()).putAll(any());
    }

    @Test
    void putAll_DelegateMapNotNull_CallsDelegatePutAll() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        flat3Map.putAll(map);
        verify(mockDelegateMap).putAll(map);
    }

    @Test
    void putAll_SizeLessThan4_PutsEntriesIndividually() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        flat3Map.putAll(map);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            verify(flat3Map, times(1)).put(entry.getKey(), entry.getValue());
        }
    }

    @Test
    void putAll_SizeGreaterThanOrEqual4_ConvertsAndCallsDelegate() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        flat3Map.putAll(map);
        // Invoke the private method using reflection
        try {
            java.lang.reflect.Method method = Flat3Map.class.getDeclaredMethod("convertToMap");
            method.setAccessible(true);
            method.invoke(flat3Map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        verify(mockDelegateMap).putAll(map);
    }

    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
