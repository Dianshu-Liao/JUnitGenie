package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.AbstractHashedMap;
import org.apache.commons.collections4.map.Flat3Map;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.lang.reflect.Field;
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
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

class Flat3Map_keySet_11_1_Test {

    private Flat3Map<String, String> flat3Map;

    @BeforeEach
    void setUp() {
        flat3Map = new Flat3Map<>();
    }

    @Test
    void testKeySetWhenDelegateMapIsNull() {
        Set<String> keySet = flat3Map.keySet();
        assertNotNull(keySet);
        assertTrue(keySet.isEmpty());
    }

    @Test
    void testKeySetWhenDelegateMapIsNotNull() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        // Use reflection to set the delegateMap
        try {
            Field delegateMapField = Flat3Map.class.getDeclaredField("delegateMap");
            delegateMapField.setAccessible(true);
            delegateMapField.set(flat3Map, new AbstractHashedMap<>(map));
            Set<String> keySet = flat3Map.keySet();
            assertNotNull(keySet);
            assertEquals(3, keySet.size());
            assertTrue(keySet.contains("key1"));
            assertTrue(keySet.contains("key2"));
            assertTrue(keySet.contains("key3"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
}
