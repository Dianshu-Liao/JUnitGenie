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

class ListOrderedMap_put_14_0_Test {

    private ListOrderedMap<String, Integer> listOrderedMap;

    @BeforeEach
    void setUp() {
        listOrderedMap = new ListOrderedMap<>(new HashMap<>());
    }

    @Test
    void testPutAtValidIndex() {
        Integer result = listOrderedMap.put(0, "key1", 1);
        assertNull(result, "Expected null when adding a new key");
        result = listOrderedMap.put(1, "key2", 2);
        assertNull(result, "Expected null when adding another new key");
        assertEquals(1, listOrderedMap.get("key1"));
        assertEquals(2, listOrderedMap.get("key2"));
    }

    @Test
    void testPutAtIndexWithExistingKey() {
        listOrderedMap.put(0, "key1", 1);
        listOrderedMap.put(1, "key2", 2);
        Integer result = listOrderedMap.put(0, "key1", 3);
        assertEquals(1, result, "Expected to return the old value when key already exists");
        assertEquals(3, listOrderedMap.get("key1"));
        assertEquals(2, listOrderedMap.get("key2"));
    }

    @Test
    void testPutAtInvalidIndexNegative() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            listOrderedMap.put(-1, "key1", 1);
        });
        assertEquals("Index: -1, Size: 0", exception.getMessage());
    }

    @Test
    void testPutAtInvalidIndexGreaterThanSize() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            listOrderedMap.put(1, "key1", 1);
        });
        assertEquals("Index: 1, Size: 0", exception.getMessage());
    }

    @Test
    void testPutAtIndexAdjustsExistingKeyPosition() {
        listOrderedMap.put(0, "key1", 1);
        listOrderedMap.put(1, "key2", 2);
        // Update key1 to new value at index 0
        listOrderedMap.put(0, "key1", 3);
        assertEquals(3, listOrderedMap.get("key1"));
        assertEquals(2, listOrderedMap.get("key2"));
        // Now put key1 at index 1
        Integer result = listOrderedMap.put(1, "key1", 4);
        assertEquals(3, result, "Expected to return the old value when key already exists");
        assertEquals(4, listOrderedMap.get("key1"));
        assertEquals(2, listOrderedMap.get("key2"));
    }
}
