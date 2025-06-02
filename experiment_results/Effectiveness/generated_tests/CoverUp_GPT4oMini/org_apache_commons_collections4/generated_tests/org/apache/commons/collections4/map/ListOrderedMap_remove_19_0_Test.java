package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.ListOrderedMap;
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
    void testRemoveValidIndex() {
        String removedValue = listOrderedMap.remove(1);
        assertEquals("Value2", removedValue);
        assertThrows(IndexOutOfBoundsException.class, () -> listOrderedMap.get(1));
    }

    @Test
    void testRemoveFirstElement() {
        String removedValue = listOrderedMap.remove(0);
        assertEquals("Value1", removedValue);
        assertThrows(IndexOutOfBoundsException.class, () -> listOrderedMap.get(0));
    }

    @Test
    void testRemoveLastElement() {
        String removedValue = listOrderedMap.remove(2);
        assertEquals("Value3", removedValue);
        assertThrows(IndexOutOfBoundsException.class, () -> listOrderedMap.get(2));
    }

    @Test
    void testRemoveInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> listOrderedMap.remove(5));
    }

    @Test
    void testRemoveNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> listOrderedMap.remove(-1));
    }
}
