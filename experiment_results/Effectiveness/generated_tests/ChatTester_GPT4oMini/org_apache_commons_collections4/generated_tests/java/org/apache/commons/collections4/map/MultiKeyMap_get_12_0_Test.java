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

public class MultiKeyMap_get_12_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    public void testGetReturnsValueWhenKeyExists() throws Exception {
        // Arrange
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object expectedValue = "value";
        // Use reflection to set up the internal state of MultiKeyMap
        Method addMethod = MultiKeyMap.class.getDeclaredMethod("add", Object.class, Object.class, Object.class, Object.class, Object.class);
        addMethod.setAccessible(true);
        addMethod.invoke(multiKeyMap, key1, key2, key3, key4, expectedValue);
        // Act
        Object actualValue = multiKeyMap.get(key1, key2, key3, key4);
        // Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetReturnsNullWhenKeyDoesNotExist() {
        // Act
        Object actualValue = multiKeyMap.get("nonExistingKey1", "nonExistingKey2", "nonExistingKey3", "nonExistingKey4");
        // Assert
        assertNull(actualValue);
    }

    @Test
    public void testGetHandlesNullKeys() throws Exception {
        // Arrange
        Object expectedValue = "value";
        Method addMethod = MultiKeyMap.class.getDeclaredMethod("add", Object.class, Object.class, Object.class, Object.class, Object.class);
        addMethod.setAccessible(true);
        addMethod.invoke(multiKeyMap, null, null, null, null, expectedValue);
        // Act
        Object actualValue = multiKeyMap.get(null, null, null, null);
        // Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testGetWithDifferentKeysReturnsNull() throws Exception {
        // Arrange
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        Object key4 = "key4";
        Object expectedValue = "value";
        Method addMethod = MultiKeyMap.class.getDeclaredMethod("add", Object.class, Object.class, Object.class, Object.class, Object.class);
        addMethod.setAccessible(true);
        addMethod.invoke(multiKeyMap, key1, key2, key3, key4, expectedValue);
        // Act
        Object actualValue = multiKeyMap.get("differentKey1", "differentKey2", "differentKey3", "differentKey4");
        // Assert
        assertNull(actualValue);
    }
}
