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

class ListOrderedMap_remove_20_0_Test {

    private ListOrderedMap<String, String> listOrderedMap;

    @BeforeEach
    void setUp() {
        listOrderedMap = new ListOrderedMap<>(new HashMap<>());
    }

    @Test
    void testRemove_KeyExists() {
        // Arrange
        listOrderedMap.put("key1", "value1");
        listOrderedMap.put("key2", "value2");
        // Act
        String result = listOrderedMap.remove("key1");
        // Assert
        assertEquals("value1", result);
        assertNull(listOrderedMap.get("key1"));
    }

    @Test
    void testRemove_KeyDoesNotExist() {
        // Arrange
        listOrderedMap.put("key1", "value1");
        // Act
        String result = listOrderedMap.remove("key2");
        // Assert
        assertNull(result);
        assertEquals("value1", listOrderedMap.get("key1"));
    }

    @Test
    void testRemove_NullKey() {
        // Arrange
        listOrderedMap.put("key1", "value1");
        // Act
        String result = listOrderedMap.remove(null);
        // Assert
        assertNull(result);
        assertEquals("value1", listOrderedMap.get("key1"));
    }

    @Test
    void testRemove_EmptyMap() {
        // Act
        String result = listOrderedMap.remove("key1");
        // Assert
        assertNull(result);
    }

    @Test
    void testRemove_KeyExistsWithMultipleEntries() {
        // Arrange
        listOrderedMap.put("key1", "value1");
        listOrderedMap.put("key2", "value2");
        listOrderedMap.put("key3", "value3");
        // Act
        String result = listOrderedMap.remove("key2");
        // Assert
        assertEquals("value2", result);
        assertNull(listOrderedMap.get("key2"));
        assertEquals("value1", listOrderedMap.get("key1"));
        assertEquals("value3", listOrderedMap.get("key3"));
    }

    // Reflection test to invoke private methods if necessary
    @Test
    void testRemove_UsingReflection() throws Exception {
        // Arrange
        listOrderedMap.put("key1", "value1");
        Class<?> clazz = listOrderedMap.getClass();
        java.lang.reflect.Method removeMethod = clazz.getDeclaredMethod("remove", Object.class);
        removeMethod.setAccessible(true);
        // Act
        String result = (String) removeMethod.invoke(listOrderedMap, "key1");
        // Assert
        assertEquals("value1", result);
        assertNull(listOrderedMap.get("key1"));
    }
}
