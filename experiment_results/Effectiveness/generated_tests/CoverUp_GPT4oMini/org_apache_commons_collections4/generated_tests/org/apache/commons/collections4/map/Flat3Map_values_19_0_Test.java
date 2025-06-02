package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.AbstractHashedMap;
import org.apache.commons.collections4.map.Flat3Map;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
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

class Flat3Map_values_19_0_Test {

    private Flat3Map<String, String> flat3Map;

    @BeforeEach
    void setUp() {
        flat3Map = new Flat3Map<>();
    }

    @Test
    void testValuesWithDelegateMap() throws Exception {
        // Create a delegate map and set it using reflection
        Map<String, String> delegateMap = new HashMap<>();
        delegateMap.put("key1", "value1");
        delegateMap.put("key2", "value2");
        delegateMap.put("key3", "value3");
        // Use reflection to set the private delegateMap field
        setPrivateField(flat3Map, "delegateMap", new AbstractHashedMap<>(delegateMap));
        Collection<String> values = flat3Map.values();
        assertNotNull(values);
        assertEquals(3, values.size());
        assertTrue(values.contains("value1"));
        assertTrue(values.contains("value2"));
        assertTrue(values.contains("value3"));
    }

    @Test
    void testValuesWithoutDelegateMap() {
        Collection<String> values = flat3Map.values();
        assertNotNull(values);
        assertTrue(values.isEmpty());
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
