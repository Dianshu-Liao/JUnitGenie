package org.apache.commons.collections4.map;

import java.util.HashMap;
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
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.list.UnmodifiableList;

class ListOrderedMap_put_15_0_Test {

    private ListOrderedMap<String, Integer> listOrderedMap;

    @BeforeEach
    void setUp() {
        listOrderedMap = new ListOrderedMap<>(new HashMap<>());
    }

    @Test
    void testPut_NewKey() {
        Integer result = listOrderedMap.put("key1", 1);
        assertNull(result, "Expected null when adding a new key");
        assertEquals(1, listOrderedMap.get("key1"), "Value for 'key1' should be 1");
    }

    @Test
    void testPut_ExistingKey() {
        listOrderedMap.put("key1", 1);
        Integer result = listOrderedMap.put("key1", 2);
        assertEquals(1, result, "Expected previous value when updating an existing key");
        assertEquals(2, listOrderedMap.get("key1"), "Value for 'key1' should be updated to 2");
    }

    @Test
    void testPut_MultipleKeys() {
        listOrderedMap.put("key1", 1);
        listOrderedMap.put("key2", 2);
        listOrderedMap.put("key3", 3);
        assertEquals(3, listOrderedMap.get("key3"), "Value for 'key3' should be 3");
        assertEquals(2, listOrderedMap.get("key2"), "Value for 'key2' should be 2");
        assertEquals(1, listOrderedMap.get("key1"), "Value for 'key1' should be 1");
    }

    @Test
    void testPut_OrderPreservation() {
        listOrderedMap.put("key1", 1);
        listOrderedMap.put("key2", 2);
        listOrderedMap.put("key3", 3);
        // Check values in the order they were inserted
        assertEquals(1, listOrderedMap.get("key1"), "Value for 'key1' should be 1");
        assertEquals(2, listOrderedMap.get("key2"), "Value for 'key2' should be 2");
        assertEquals(3, listOrderedMap.get("key3"), "Value for 'key3' should be 3");
    }
}
