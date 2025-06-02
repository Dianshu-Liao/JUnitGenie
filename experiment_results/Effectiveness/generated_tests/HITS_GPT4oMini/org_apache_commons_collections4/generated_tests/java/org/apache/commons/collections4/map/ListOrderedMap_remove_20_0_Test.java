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

class ListOrderedMap_remove_20_0_Test {

    private ListOrderedMap<String, Integer> listOrderedMap;

    @BeforeEach
    void setUp() {
        listOrderedMap = new ListOrderedMap<>();
        listOrderedMap.put("one", 1);
        listOrderedMap.put("two", 2);
        listOrderedMap.put("three", 3);
    }

    @Test
    void testRemoveExistingKey() {
        Integer removedValue = listOrderedMap.remove("two");
        assertEquals(2, removedValue);
        assertNull(listOrderedMap.get("two"));
    }

    @Test
    void testRemoveNonExistingKey() {
        Integer removedValue = listOrderedMap.remove("four");
        assertNull(removedValue);
    }

    @Test
    void testRemoveKeyThatWasAlreadyRemoved() {
        listOrderedMap.remove("one");
        Integer removedValue = listOrderedMap.remove("one");
        assertNull(removedValue);
    }

    @Test
    void testRemoveKeyWithNullValue() {
        listOrderedMap.put("nullValue", null);
        Integer removedValue = listOrderedMap.remove("nullValue");
        assertNull(removedValue);
        assertNull(listOrderedMap.get("nullValue"));
    }

    @Test
    void testRemoveKeyFromEmptyMap() {
        ListOrderedMap<String, Integer> emptyMap = new ListOrderedMap<>();
        Integer removedValue = emptyMap.remove("anyKey");
        assertNull(removedValue);
    }
}
