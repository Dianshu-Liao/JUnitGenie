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

public class MultiKeyMap_removeMultiKey_34_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    public void testRemoveMultiKey_RemovesExistingKey_ReturnsValue() throws Exception {
        // Arrange
        Object key1 = "key1";
        Object key2 = "key2";
        Object expectedValue = "value";
        // Mock method to add entry
        addMockEntry(key1, key2, expectedValue);
        // Act
        Object result = invokeRemoveMultiKey(key1, key2);
        // Assert
        assertEquals(expectedValue, result);
    }

    @Test
    public void testRemoveMultiKey_KeyDoesNotExist_ReturnsNull() throws Exception {
        // Arrange
        Object key1 = "key1";
        Object key2 = "key2";
        // Act
        Object result = invokeRemoveMultiKey(key1, key2);
        // Assert
        assertNull(result);
    }

    @Test
    public void testRemoveMultiKey_WithDifferentKeys_ReturnsNull() throws Exception {
        // Arrange
        Object key1 = "key1";
        Object key2 = "key2";
        Object differentKey1 = "differentKey1";
        Object differentKey2 = "differentKey2";
        // Mock method to add entry
        addMockEntry(key1, key2, "value");
        // Act
        Object result = invokeRemoveMultiKey(differentKey1, differentKey2);
        // Assert
        assertNull(result);
    }

    private Object invokeRemoveMultiKey(Object key1, Object key2) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("removeMultiKey", Object.class, Object.class);
        method.setAccessible(true);
        return method.invoke(multiKeyMap, key1, key2);
    }

    private void addMockEntry(Object key1, Object key2, Object value) {
        try {
            // Access the private method to add a mock entry
            Method addMethod = MultiKeyMap.class.getDeclaredMethod("addEntry", Object.class, Object.class, Object.class);
            addMethod.setAccessible(true);
            addMethod.invoke(multiKeyMap, key1, key2, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
