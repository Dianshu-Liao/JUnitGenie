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

public class ListOrderedMap_putAll_16_0_Test {

    private ListOrderedMap<String, Integer> listOrderedMap;

    @BeforeEach
    public void setUp() {
        listOrderedMap = new ListOrderedMap<>();
    }

    @Test
    public void testPutAllWithValidIndex() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        listOrderedMap.putAll(0, map);
        assertEquals(2, listOrderedMap.size());
        assertTrue(listOrderedMap.containsKey("one"));
        assertTrue(listOrderedMap.containsKey("two"));
        assertEquals(1, listOrderedMap.get("one"));
        assertEquals(2, listOrderedMap.get("two"));
    }

    @Test
    public void testPutAllWithIndexGreaterThanSize() {
        Map<String, Integer> map = new HashMap<>();
        map.put("three", 3);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            listOrderedMap.putAll(1, map);
        });
    }

    @Test
    public void testPutAllWithNegativeIndex() {
        Map<String, Integer> map = new HashMap<>();
        map.put("four", 4);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            listOrderedMap.putAll(-1, map);
        });
    }

    @Test
    public void testPutAllWithExistingKey() {
        listOrderedMap.put(0, "five", 5);
        Map<String, Integer> map = new HashMap<>();
        map.put("five", 10);
        map.put("six", 6);
        listOrderedMap.putAll(0, map);
        assertEquals(2, listOrderedMap.size());
        // Existing key value should be updated
        assertEquals(10, listOrderedMap.get("five"));
        // New key should be added
        assertEquals(6, listOrderedMap.get("six"));
    }

    @Test
    public void testPutAllWithEmptyMap() {
        Map<String, Integer> map = new HashMap<>();
        listOrderedMap.putAll(0, map);
        // Size should remain 0
        assertEquals(0, listOrderedMap.size());
    }

    @Test
    public void testPutAllWithMultipleEntries() {
        Map<String, Integer> map = new HashMap<>();
        map.put("seven", 7);
        map.put("eight", 8);
        listOrderedMap.putAll(0, map);
        assertEquals(2, listOrderedMap.size());
        assertTrue(listOrderedMap.containsKey("seven"));
        assertTrue(listOrderedMap.containsKey("eight"));
        assertEquals(7, listOrderedMap.get("seven"));
        assertEquals(8, listOrderedMap.get("eight"));
    }
}
