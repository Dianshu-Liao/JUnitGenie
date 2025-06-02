package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.ListOrderedMap;
import java.util.NoSuchElementException;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.list.UnmodifiableList;

class ListOrderedMap_firstKey_4_0_Test {

    private ListOrderedMap<String, String> listOrderedMap;

    @BeforeEach
    void setUp() {
        listOrderedMap = new ListOrderedMap<>();
    }

    @Test
    void testFirstKeyThrowsExceptionWhenEmpty() {
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            listOrderedMap.firstKey();
        });
        assertEquals("Map is empty", exception.getMessage());
    }

    @Test
    void testFirstKeyReturnsFirstInsertedKey() {
        // Assuming this method adds "key1" to the insertOrder
        listOrderedMap.setValue(0, "value1");
        // Assuming this method adds "key2" to the insertOrder
        listOrderedMap.setValue(1, "value2");
        assertEquals("key1", listOrderedMap.firstKey());
    }

    // This test will require an appropriate setup in the setValue method to add keys to the insertOrder
    @Test
    void testFirstKeyWithMultipleKeys() {
        // Assuming this method adds "key1"
        listOrderedMap.setValue(0, "value1");
        // Assuming this method adds "key2"
        listOrderedMap.setValue(1, "value2");
        // Assuming this method adds "key3"
        listOrderedMap.setValue(2, "value3");
        assertEquals("key1", listOrderedMap.firstKey());
    }
}
