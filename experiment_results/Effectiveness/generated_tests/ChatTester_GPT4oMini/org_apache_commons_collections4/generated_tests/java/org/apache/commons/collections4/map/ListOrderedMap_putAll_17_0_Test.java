package org.apache.commons.collections4.map;

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
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.list.UnmodifiableList;

public class ListOrderedMap_putAll_17_0_Test {

    private ListOrderedMap<String, Integer> listOrderedMap;

    @BeforeEach
    public void setUp() {
        listOrderedMap = new ListOrderedMap<>();
    }

    @Test
    public void testPutAllWithEmptyMap() {
        Map<String, Integer> emptyMap = new HashMap<>();
        listOrderedMap.putAll(emptyMap);
        assertEquals(0, listOrderedMap.size());
    }

    @Test
    public void testPutAllWithNonEmptyMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        listOrderedMap.putAll(map);
        assertEquals(1, listOrderedMap.get("One"));
        assertEquals(2, listOrderedMap.get("Two"));
        assertEquals(2, listOrderedMap.size());
    }

    @Test
    public void testPutAllWithDuplicateKeys() {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        // Duplicate key, should overwrite
        map.put("One", 2);
        listOrderedMap.putAll(map);
        // Should be 2, not 1
        assertEquals(2, listOrderedMap.get("One"));
        // Size should be 1
        assertEquals(1, listOrderedMap.size());
    }

    @Test
    public void testPutAllWithNullKey() {
        Map<String, Integer> map = new HashMap<>();
        map.put(null, 1);
        listOrderedMap.putAll(map);
        assertTrue(listOrderedMap.containsKey(null));
        assertEquals(1, listOrderedMap.get(null));
    }

    @Test
    public void testPutAllWithNullValue() {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", null);
        listOrderedMap.putAll(map);
        assertTrue(listOrderedMap.containsKey("One"));
        assertNull(listOrderedMap.get("One"));
    }

    @Test
    public void testPutAllWithMixedEntries() {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put(null, 3);
        map.put("Three", null);
        listOrderedMap.putAll(map);
        assertEquals(1, listOrderedMap.get("One"));
        assertEquals(2, listOrderedMap.get("Two"));
        assertEquals(3, listOrderedMap.get(null));
        assertNull(listOrderedMap.get("Three"));
        assertEquals(4, listOrderedMap.size());
    }
}
