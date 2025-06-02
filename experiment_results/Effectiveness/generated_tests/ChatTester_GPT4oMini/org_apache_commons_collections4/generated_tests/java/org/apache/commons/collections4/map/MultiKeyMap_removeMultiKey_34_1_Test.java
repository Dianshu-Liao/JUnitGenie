package org.apache.commons.collections4.map;

import java.lang.reflect.Method;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MultiKeyMap_removeMultiKey_34_1_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    public void testRemoveMultiKey_WhenKeyExists_ShouldReturnValue() throws Exception {
        // Arrange
        String key1 = "key1";
        String key2 = "key2";
        multiKeyMap.put(key1, key2, "value");
        // Act
        Object result = invokeRemoveMultiKey(key1, key2);
        // Assert
        assertEquals("value", result);
    }

    @Test
    public void testRemoveMultiKey_WhenKeyDoesNotExist_ShouldReturnNull() throws Exception {
        // Arrange
        String key1 = "nonExistingKey1";
        String key2 = "nonExistingKey2";
        // Act
        Object result = invokeRemoveMultiKey(key1, key2);
        // Assert
        assertNull(result);
    }

    @Test
    public void testRemoveMultiKey_WhenMultipleKeysExist_ShouldRemoveCorrectOne() throws Exception {
        // Arrange
        String key1a = "key1";
        String key2a = "key2";
        String key1b = "key1";
        String key2b = "key3";
        multiKeyMap.put(key1a, key2a, "valueA");
        multiKeyMap.put(key1b, key2b, "valueB");
        // Act
        Object result = invokeRemoveMultiKey(key1a, key2a);
        // Assert
        assertEquals("valueA", result);
        // Ensure it's removed
        assertNull(invokeRemoveMultiKey(key1a, key2a));
        // Ensure other key is intact
        assertEquals("valueB", invokeRemoveMultiKey(key1b, key2b));
    }

    private Object invokeRemoveMultiKey(Object key1, Object key2) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("removeMultiKey", Object.class, Object.class);
        method.setAccessible(true);
        return method.invoke(multiKeyMap, key1, key2);
    }
}
