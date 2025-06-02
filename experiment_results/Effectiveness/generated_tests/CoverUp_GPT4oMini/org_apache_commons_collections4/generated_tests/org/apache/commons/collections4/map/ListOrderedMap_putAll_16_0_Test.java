package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.ListOrderedMap;
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

class ListOrderedMap_putAll_16_0_Test {

    private ListOrderedMap<String, String> listOrderedMap;

    @BeforeEach
    void setUp() {
        listOrderedMap = new ListOrderedMap<>();
    }

    @Test
    void testPutAllWithValidIndex() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        listOrderedMap.putAll(0, map);
        assertEquals(2, listOrderedMap.size());
        assertEquals("value1", listOrderedMap.get("key1"));
        assertEquals("value2", listOrderedMap.get("key2"));
    }

    @Test
    void testPutAllWithIndexGreaterThanSize() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            listOrderedMap.putAll(1, map);
        });
    }

    @Test
    void testPutAllWithNegativeIndex() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            listOrderedMap.putAll(-1, map);
        });
    }

    @Test
    void testPutAllReplacingExistingKey() {
        listOrderedMap.put(0, "key1", "value1");
        listOrderedMap.put(1, "key2", "value2");
        Map<String, String> map = new HashMap<>();
        map.put("key1", "newValue1");
        map.put("key3", "value3");
        listOrderedMap.putAll(0, map);
        assertEquals(3, listOrderedMap.size());
        assertEquals("newValue1", listOrderedMap.get("key1"));
        assertEquals("value2", listOrderedMap.get("key2"));
        assertEquals("value3", listOrderedMap.get("key3"));
    }

    @Test
    void testPutAllWithEmptyMap() {
        listOrderedMap.put(0, "key1", "value1");
        listOrderedMap.putAll(0, new HashMap<>());
        assertEquals(1, listOrderedMap.size());
        assertEquals("value1", listOrderedMap.get("key1"));
    }
}
