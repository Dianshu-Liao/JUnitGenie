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
        assertEquals("value1", listOrderedMap.get("key1"));
        assertEquals("value2", listOrderedMap.get("key2"));
    }

    @Test
    void testPutAllWithIndexOutOfBounds() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            listOrderedMap.putAll(-1, map);
        });
        assertEquals("Index: -1, Size: 0", exception.getMessage());
    }

    @Test
    void testPutAllWithReplacingExistingKey() {
        listOrderedMap.put(0, "key1", "value1");
        Map<String, String> map = new HashMap<>();
        map.put("key1", "newValue1");
        map.put("key2", "value2");
        listOrderedMap.putAll(0, map);
        assertEquals("newValue1", listOrderedMap.get("key1"));
        assertEquals("value2", listOrderedMap.get("key2"));
    }

    @Test
    void testPutAllWithNonExistingKey() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        listOrderedMap.putAll(0, map);
        assertEquals("value1", listOrderedMap.get("key1"));
        assertEquals("value2", listOrderedMap.get("key2"));
    }

    @Test
    void testPutAllWithMixedKeys() {
        listOrderedMap.put(0, "key1", "value1");
        Map<String, String> map = new HashMap<>();
        // existing key
        map.put("key1", "newValue1");
        // new key
        map.put("key2", "value2");
        // another new key
        map.put("key3", "value3");
        // Insert at index 1
        listOrderedMap.putAll(1, map);
        // Check if existing key is updated
        assertEquals("newValue1", listOrderedMap.get("key1"));
        // Check if new key is added
        assertEquals("value2", listOrderedMap.get("key2"));
        // Check if another new key is added
        assertEquals("value3", listOrderedMap.get("key3"));
    }
}
