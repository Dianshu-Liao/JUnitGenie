package org.apache.commons.collections4.map;

import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class ListOrderedMap_put_14_0_Test {

    private ListOrderedMap<String, String> listOrderedMap;

    @BeforeEach
    void setUp() {
        listOrderedMap = new ListOrderedMap<>();
    }

    @Test
    void testPutWithValidIndex() throws Exception {
        // Arrange
        int index = 0;
        String key = "key1";
        String value = "value1";
        // Act
        invokePutMethod(index, key, value);
        // Assert
        assertEquals(value, invokeGetMethod(key));
    }

    @Test
    void testPutWithIndexAtEnd() throws Exception {
        // Arrange
        listOrderedMap.put(0, "key1", "value1");
        int index = 1;
        String key = "key2";
        String value = "value2";
        // Act
        invokePutMethod(index, key, value);
        // Assert
        assertEquals(value, invokeGetMethod(key));
    }

    @Test
    void testPutWithNegativeIndex() {
        // Arrange
        int index = -1;
        String key = "key1";
        String value = "value1";
        // Act & Assert
        IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class, () -> {
            invokePutMethod(index, key, value);
        });
        assertEquals("Index: -1, Size: 0", thrown.getMessage());
    }

    @Test
    void testPutWithIndexGreaterThanSize() {
        // Arrange
        int index = 1;
        String key = "key1";
        String value = "value1";
        // Act & Assert
        IndexOutOfBoundsException thrown = assertThrows(IndexOutOfBoundsException.class, () -> {
            invokePutMethod(index, key, value);
        });
        assertEquals("Index: 1, Size: 0", thrown.getMessage());
    }

    @Test
    void testPutReplacesExistingKey() throws Exception {
        // Arrange
        listOrderedMap.put(0, "key1", "value1");
        int index = 0;
        String key = "key1";
        String newValue = "newValue1";
        // Act
        String oldValue = invokePutMethod(index, key, newValue);
        // Assert
        assertEquals("value1", oldValue);
        assertEquals(newValue, invokeGetMethod(key));
    }

    @Test
    void testPutMovesExistingKeyToNewIndex() throws Exception {
        // Arrange
        listOrderedMap.put(0, "key1", "value1");
        listOrderedMap.put(1, "key2", "value2");
        // Move "key2" to index 0
        int index = 0;
        String key = "key2";
        String newValue = "newValue2";
        // Act
        invokePutMethod(index, key, newValue);
        // Assert
        assertEquals(newValue, invokeGetMethod(key));
        // Access the private field 'insertOrder' using reflection
        Method getInsertOrderMethod = ListOrderedMap.class.getDeclaredMethod("getInsertOrder");
        getInsertOrderMethod.setAccessible(true);
        List<String> insertOrder = (List<String>) getInsertOrderMethod.invoke(listOrderedMap);
        assertEquals("key2", insertOrder.get(0));
        assertEquals("key1", insertOrder.get(1));
    }

    private String invokePutMethod(int index, String key, String value) throws Exception {
        Method method = ListOrderedMap.class.getDeclaredMethod("put", int.class, Object.class, Object.class);
        method.setAccessible(true);
        return (String) method.invoke(listOrderedMap, index, key, value);
    }

    private String invokeGetMethod(String key) throws Exception {
        Method method = ListOrderedMap.class.getDeclaredMethod("get", Object.class);
        method.setAccessible(true);
        return (String) method.invoke(listOrderedMap, key);
    }
}
