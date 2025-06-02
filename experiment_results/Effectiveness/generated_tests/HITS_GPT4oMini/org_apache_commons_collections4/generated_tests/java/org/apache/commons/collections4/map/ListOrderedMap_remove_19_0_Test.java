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

class ListOrderedMap_remove_19_0_Test {

    private ListOrderedMap<String, String> listOrderedMap;

    @BeforeEach
    void setUp() {
        listOrderedMap = new ListOrderedMap<>(new HashMap<>());
        listOrderedMap.setValue(0, "Value1");
        listOrderedMap.setValue(1, "Value2");
        listOrderedMap.setValue(2, "Value3");
    }

    @Test
    void testRemove_ValidIndex() {
        // Remove "Value2"
        String removedValue = listOrderedMap.remove(1);
        assertEquals("Value2", removedValue);
        // Check if "Value2" is removed
        assertNull(listOrderedMap.get(1));
        // "Value3" should now be at index 1
        assertEquals("Value3", listOrderedMap.get(1));
    }

    @Test
    void testRemove_FirstElement() {
        // Remove "Value1"
        String removedValue = listOrderedMap.remove(0);
        assertEquals("Value1", removedValue);
        // "Value2" should now be at index 0
        assertEquals("Value2", listOrderedMap.get(0));
    }

    @Test
    void testRemove_LastElement() {
        // Remove "Value3"
        String removedValue = listOrderedMap.remove(2);
        assertEquals("Value3", removedValue);
        // Index 2 should throw exception
        assertThrows(IndexOutOfBoundsException.class, () -> listOrderedMap.get(2));
    }

    @Test
    void testRemove_InvalidIndex() {
        // Index out of bounds
        assertThrows(IndexOutOfBoundsException.class, () -> listOrderedMap.remove(3));
        // Negative index
        assertThrows(IndexOutOfBoundsException.class, () -> listOrderedMap.remove(-1));
    }

    @Test
    void testRemove_EmptyMap() {
        ListOrderedMap<String, String> emptyMap = new ListOrderedMap<>(new HashMap<>());
        // Removing from an empty map
        assertThrows(IndexOutOfBoundsException.class, () -> emptyMap.remove(0));
    }
}
