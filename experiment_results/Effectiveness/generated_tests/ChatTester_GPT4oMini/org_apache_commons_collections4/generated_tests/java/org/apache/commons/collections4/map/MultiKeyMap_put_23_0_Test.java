package org.apache.commons.collections4.map;

import java.lang.reflect.Method;
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
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.AbstractHashedMap.HashEntry;

class MultiKeyMap_put_23_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    void testPutNewEntry() throws Exception {
        // Arrange
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String key5 = "key5";
        String value = "value";
        // Act
        Object result = invokePutMethod(key1, key2, key3, key4, key5, value);
        // Assert
        // Expecting null as it is a new entry
        assertNull(result);
    }

    @Test
    void testPutUpdateExistingEntry() throws Exception {
        // Arrange
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String key5 = "key5";
        String initialValue = "initialValue";
        String updatedValue = "updatedValue";
        // First put to add the entry
        invokePutMethod(key1, key2, key3, key4, key5, initialValue);
        // Act
        Object result = invokePutMethod(key1, key2, key3, key4, key5, updatedValue);
        // Assert
        // Expecting initial value to be returned
        assertEquals(initialValue, result);
    }

    @Test
    void testPutWithDifferentKeys() throws Exception {
        // Arrange
        String key1A = "key1A";
        String key2A = "key2A";
        String key3A = "key3A";
        String key4A = "key4A";
        String key5A = "key5A";
        String valueA = "valueA";
        String key1B = "key1B";
        String key2B = "key2B";
        String key3B = "key3B";
        String key4B = "key4B";
        String key5B = "key5B";
        String valueB = "valueB";
        // Act
        Object resultA = invokePutMethod(key1A, key2A, key3A, key4A, key5A, valueA);
        Object resultB = invokePutMethod(key1B, key2B, key3B, key4B, key5B, valueB);
        // Assert
        // Expecting null for first entry
        assertNull(resultA);
        // Expecting null for second entry
        assertNull(resultB);
    }

    @Test
    void testPutWithNullValue() throws Exception {
        // Arrange
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String key5 = "key5";
        // Act
        Object result = invokePutMethod(key1, key2, key3, key4, key5, null);
        // Assert
        // Expecting null as it is a new entry with a null value
        assertNull(result);
    }

    private Object invokePutMethod(String key1, String key2, String key3, String key4, String key5, String value) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("put", Object.class, Object.class, Object.class, Object.class, Object.class, Object.class);
        method.setAccessible(true);
        return method.invoke(multiKeyMap, key1, key2, key3, key4, key5, value);
    }
}
