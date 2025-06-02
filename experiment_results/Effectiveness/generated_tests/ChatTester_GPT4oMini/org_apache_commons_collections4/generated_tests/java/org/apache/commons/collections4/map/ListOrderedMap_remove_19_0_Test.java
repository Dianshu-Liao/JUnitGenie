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

class ListOrderedMap_remove_19_0_Test {

    private ListOrderedMap<String, String> listOrderedMap;

    @BeforeEach
    void setUp() {
        listOrderedMap = new ListOrderedMap<>();
        // Assuming there's a method to put items in the map for testing
        listOrderedMap.put("key1", "value1");
        listOrderedMap.put("key2", "value2");
        listOrderedMap.put("key3", "value3");
    }

    @Test
    void testRemoveValidIndex() throws Exception {
        // Remove the item at index 1
        String removedValue = invokeRemove(1);
        // Verify the removed value
        assertEquals("value2", removedValue);
        // Verify the size after removal
        assertEquals(2, listOrderedMap.size());
        // Verify the remaining keys
        assertNull(listOrderedMap.get("key2"));
        assertEquals("value1", listOrderedMap.get("key1"));
        assertEquals("value3", listOrderedMap.get("key3"));
    }

    @Test
    void testRemoveInvalidIndex() throws Exception {
        // Attempt to remove an item at an invalid index
        assertThrows(IndexOutOfBoundsException.class, () -> invokeRemove(5));
    }

    private String invokeRemove(int index) throws Exception {
        Method method = ListOrderedMap.class.getDeclaredMethod("remove", int.class);
        method.setAccessible(true);
        return (String) method.invoke(listOrderedMap, index);
    }
}
