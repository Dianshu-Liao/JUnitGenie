package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.AbstractHashedMap;
import org.apache.commons.collections4.map.Flat3Map;
import java.lang.reflect.Method;
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

public class Flat3Map_size_17_0_Test {

    private Flat3Map<String, String> flat3Map;

    @BeforeEach
    public void setUp() {
        flat3Map = new Flat3Map<>();
    }

    @Test
    public void testSizeWhenDelegateMapIsNull() {
        // Test when delegateMap is null
        assertEquals(0, flat3Map.size());
    }

    @Test
    public void testSizeWhenDelegateMapIsNotNull() throws Exception {
        // Test when delegateMap is not null
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        // Using reflection to set the private delegateMap field
        Method putAllMethod = Flat3Map.class.getDeclaredMethod("putAll", Map.class);
        putAllMethod.setAccessible(true);
        putAllMethod.invoke(flat3Map, map);
        // Accessing the private delegateMap directly
        Method setDelegateMapMethod = Flat3Map.class.getDeclaredMethod("setDelegateMap", AbstractHashedMap.class);
        setDelegateMapMethod.setAccessible(true);
        AbstractHashedMap<String, String> delegateMap = new AbstractHashedMap<>(map);
        setDelegateMapMethod.invoke(flat3Map, delegateMap);
        assertEquals(2, flat3Map.size());
    }

    // Helper method to set the delegateMap (reflection)
    private void setDelegateMap(AbstractHashedMap<String, String> delegateMap) throws Exception {
        Method setDelegateMapMethod = Flat3Map.class.getDeclaredMethod("setDelegateMap", AbstractHashedMap.class);
        setDelegateMapMethod.setAccessible(true);
        setDelegateMapMethod.invoke(flat3Map, delegateMap);
    }
}
