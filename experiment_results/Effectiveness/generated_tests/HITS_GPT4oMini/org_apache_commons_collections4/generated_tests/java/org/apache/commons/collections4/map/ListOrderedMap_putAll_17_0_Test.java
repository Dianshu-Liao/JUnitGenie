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
    public void testPutAll_EmptyMap() {
        Map<String, Integer> map = new HashMap<>();
        listOrderedMap.putAll(map);
        assertTrue(listOrderedMap.decorated().isEmpty(), "The map should be empty after putting an empty map.");
    }

    @Test
    public void testPutAll_NonEmptyMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        listOrderedMap.putAll(map);
        assertEquals(2, listOrderedMap.decorated().size(), "The size should be 2 after putting two entries.");
        assertEquals(1, listOrderedMap.decorated().get("one"), "The value for key 'one' should be 1.");
        assertEquals(2, listOrderedMap.decorated().get("two"), "The value for key 'two' should be 2.");
    }

    @Test
    public void testPutAll_OverwriteExistingKeys() {
        listOrderedMap.put("one", 1);
        listOrderedMap.put("two", 2);
        Map<String, Integer> map = new HashMap<>();
        // This should overwrite the existing value for 'one'
        map.put("one", 10);
        listOrderedMap.putAll(map);
        assertEquals(2, listOrderedMap.decorated().size(), "The size should still be 2 after overwriting.");
        assertEquals(10, listOrderedMap.decorated().get("one"), "The value for key 'one' should be updated to 10.");
        assertEquals(2, listOrderedMap.decorated().get("two"), "The value for key 'two' should remain 2.");
    }

    @Test
    public void testPutAll_DuplicateKeys() {
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        // Duplicate key with a different value
        map.put("one", 2);
        listOrderedMap.putAll(map);
        assertEquals(1, listOrderedMap.decorated().size(), "The size should be 1 since 'one' is duplicated.");
        assertEquals(2, listOrderedMap.decorated().get("one"), "The value for key 'one' should be the last inserted value (2).");
    }
}
