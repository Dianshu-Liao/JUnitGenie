package org.apache.commons.collections4.bidimap;

import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement.KEY;
import static org.apache.commons.collections4.bidimap.TreeBidiMap.DataElement.VALUE;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.keyvalue.UnmodifiableMapEntry;

public class TreeBidiMap_putAll_51_0_Test {

    private TreeBidiMap<String, Integer> treeBidiMap;

    @BeforeEach
    public void setUp() {
        treeBidiMap = new TreeBidiMap<>();
    }

    @Test
    public void testPutAllWithEmptyMap() {
        Map<String, Integer> emptyMap = new HashMap<>();
        treeBidiMap.putAll(emptyMap);
        assertEquals(0, getNodeCount(treeBidiMap));
    }

    @Test
    public void testPutAllWithNonEmptyMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        treeBidiMap.putAll(map);
        assertEquals(3, getNodeCount(treeBidiMap));
    }

    @Test
    public void testPutAllWithDuplicateKeys() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        // Duplicate key
        map.put("one", 3);
        treeBidiMap.putAll(map);
        // Should overwrite "one"
        assertEquals(2, getNodeCount(treeBidiMap));
    }

    @Test
    public void testPutAllWithNullKey() {
        Map<String, Integer> map = new HashMap<>();
        // Null key
        map.put(null, 1);
        assertThrows(NullPointerException.class, () -> {
            treeBidiMap.putAll(map);
        });
    }

    @Test
    public void testPutAllWithNullValue() {
        Map<String, Integer> map = new HashMap<>();
        // Null value
        map.put("one", null);
        treeBidiMap.putAll(map);
        // Should allow null value
        assertEquals(1, getNodeCount(treeBidiMap));
    }

    @Test
    public void testPutAllWithMixedEntries() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        // Mixed entry with null value
        map.put("two", null);
        map.put("three", 3);
        map.put("four", 4);
        // Duplicate key with new value
        map.put("one", 10);
        treeBidiMap.putAll(map);
        // Should overwrite "one" and count others
        assertEquals(4, getNodeCount(treeBidiMap));
    }

    // Reflection method to access private nodeCount field
    private int getNodeCount(TreeBidiMap<?, ?> treeBidiMap) {
        try {
            java.lang.reflect.Field field = TreeBidiMap.class.getDeclaredField("nodeCount");
            field.setAccessible(true);
            return (int) field.get(treeBidiMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
