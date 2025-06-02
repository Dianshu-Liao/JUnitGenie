package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Set;
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
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

public class Flat3Map_keySet_11_0_Test {

    private Flat3Map<String, Integer> flat3Map;

    @BeforeEach
    public void setUp() {
        flat3Map = new Flat3Map<>();
    }

    @Test
    public void testKeySetWhenDelegateMapIsNull() {
        Set<String> keySet = flat3Map.keySet();
        assertNotNull(keySet, "KeySet should not be null when delegateMap is null");
        assertTrue(keySet.isEmpty(), "KeySet should be empty when delegateMap is null");
    }

    @Test
    public void testKeySetWhenDelegateMapIsNotNull() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        flat3Map = new Flat3Map<>(map);
        Set<String> keySet = flat3Map.keySet();
        assertNotNull(keySet, "KeySet should not be null when delegateMap is not null");
        assertEquals(2, keySet.size(), "KeySet size should match the size of the underlying map");
        assertTrue(keySet.contains("key1"), "KeySet should contain 'key1'");
        assertTrue(keySet.contains("key2"), "KeySet should contain 'key2'");
    }

    @Test
    public void testKeySetWithEmptyDelegateMap() {
        HashMap<String, Integer> map = new HashMap<>();
        flat3Map = new Flat3Map<>(map);
        Set<String> keySet = flat3Map.keySet();
        assertNotNull(keySet, "KeySet should not be null when delegateMap is empty");
        assertTrue(keySet.isEmpty(), "KeySet should be empty when delegateMap is empty");
    }

    @Test
    public void testKeySetWithNullKey() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(null, 1);
        flat3Map = new Flat3Map<>(map);
        Set<String> keySet = flat3Map.keySet();
        assertNotNull(keySet, "KeySet should not be null when delegateMap contains null key");
        assertTrue(keySet.contains(null), "KeySet should contain null key");
    }

    @Test
    public void testKeySetWithMultipleEntries() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);
        flat3Map = new Flat3Map<>(map);
        Set<String> keySet = flat3Map.keySet();
        assertNotNull(keySet, "KeySet should not be null with multiple entries");
        assertEquals(3, keySet.size(), "KeySet size should match the number of entries in the map");
        assertTrue(keySet.contains("key1"), "KeySet should contain 'key1'");
        assertTrue(keySet.contains("key2"), "KeySet should contain 'key2'");
        assertTrue(keySet.contains("key3"), "KeySet should contain 'key3'");
    }
}
