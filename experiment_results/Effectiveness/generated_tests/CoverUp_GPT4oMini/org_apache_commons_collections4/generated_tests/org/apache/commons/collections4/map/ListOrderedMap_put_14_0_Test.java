package org.apache.commons.collections4.map;

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

    private ListOrderedMap<String, String> listOrderedMap;

    @BeforeEach
    void setUp() {
        listOrderedMap = new ListOrderedMap<>(new HashMap<>());
    }

    @Test
    void testPutAtValidIndex() {
        assertNull(listOrderedMap.put(0, "key1", "value1"));
        assertEquals("value1", listOrderedMap.put(0, "key1", "updatedValue1"));
        assertEquals("updatedValue1", listOrderedMap.put(1, "key1", "newerValue1"));
    }

    @Test
    void testPutAtIndexOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            listOrderedMap.put(-1, "key2", "value2");
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            // assuming size is 0
            listOrderedMap.put(2, "key2", "value2");
        });
    }

    @Test
    void testPutWithKeyAlreadyExists() {
        listOrderedMap.put(0, "key3", "value3");
        assertEquals("value3", listOrderedMap.put(0, "key3", "newValue3"));
        assertEquals("newValue3", listOrderedMap.put(0, "key3", "anotherNewValue3"));
    }

    @Test
    void testPutWithKeyAtDifferentIndex() {
        listOrderedMap.put(0, "key4", "value4");
        listOrderedMap.put(1, "key5", "value5");
        // update key4
        assertNull(listOrderedMap.put(0, "key4", "updatedValue4"));
        // update key5
        assertEquals("value5", listOrderedMap.put(0, "key5", "updatedValue5"));
    }

    @Test
    void testPutWithKeyAtLastPosition() {
        listOrderedMap.put(0, "key6", "value6");
        // Adding at last position
        assertNull(listOrderedMap.put(1, "key7", "value7"));
        // Updating key7
        assertEquals("value7", listOrderedMap.put(1, "key7", "updatedValue7"));
    }

    @Test
    void testPutWithNullKeyAndValue() {
        assertNull(listOrderedMap.put(0, null, null));
        // Adding null key
        assertEquals(null, listOrderedMap.put(0, null, "valueNull"));
    }

    @Test
    void testPutWithNullKey() {
        listOrderedMap.put(0, "key8", "value8");
        assertThrows(NullPointerException.class, () -> {
            listOrderedMap.put(1, null, "value9");
        });
    }

    @Test
    void testPutWithNullValue() {
        listOrderedMap.put(0, "key9", "value9");
        // Updating key9 with null value
        assertNull(listOrderedMap.put(1, "key9", null));
    }
}
