package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap.HashEntry;
import java.lang.reflect.Field;
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

public class MultiKeyMap_containsKey_6_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    public void testContainsKey_WhenKeysExist_ShouldReturnTrue() throws Exception {
        // Arrange
        addEntry("key1", "key2", "key3", "key4", "key5");
        // Act
        boolean result = invokeContainsKey("key1", "key2", "key3", "key4", "key5");
        // Assert
        assertTrue(result);
    }

    @Test
    public void testContainsKey_WhenKeysDoNotExist_ShouldReturnFalse() throws Exception {
        // Act
        boolean result = invokeContainsKey("nonExistingKey1", "nonExistingKey2", "nonExistingKey3", "nonExistingKey4", "nonExistingKey5");
        // Assert
        assertFalse(result);
    }

    @Test
    public void testContainsKey_WhenNullKeys_ShouldReturnFalse() throws Exception {
        // Act
        boolean result = invokeContainsKey(null, null, null, null, null);
        // Assert
        assertFalse(result);
    }

    private void addEntry(Object key1, Object key2, Object key3, Object key4, Object key5) throws Exception {
        // Use reflection to access the private method to add an entry
        Method putMethod = MultiKeyMap.class.getDeclaredMethod("put", Object.class, Object.class, Object.class, Object.class, Object.class);
        putMethod.setAccessible(true);
        putMethod.invoke(multiKeyMap, key1, key2, key3, key4, key5);
    }

    private boolean invokeContainsKey(Object key1, Object key2, Object key3, Object key4, Object key5) throws Exception {
        Method containsKeyMethod = MultiKeyMap.class.getDeclaredMethod("containsKey", Object.class, Object.class, Object.class, Object.class, Object.class);
        containsKeyMethod.setAccessible(true);
        return (boolean) containsKeyMethod.invoke(multiKeyMap, key1, key2, key3, key4, key5);
    }
}
