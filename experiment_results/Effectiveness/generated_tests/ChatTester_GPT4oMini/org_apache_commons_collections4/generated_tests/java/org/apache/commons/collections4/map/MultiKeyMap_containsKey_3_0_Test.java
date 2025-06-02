package org.apache.commons.collections4.map;

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

public class MultiKeyMap_containsKey_3_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    public void testContainsKey_WithExistingKeys_ReturnsTrue() throws Exception {
        // Arrange
        Object key1 = "key1";
        Object key2 = "key2";
        // Assume this method adds an entry to the map
        addEntryToMap(key1, key2);
        // Act
        boolean result = invokeContainsKey(key1, key2);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testContainsKey_WithNonExistingKeys_ReturnsFalse() throws Exception {
        // Arrange
        Object key1 = "key1";
        Object key2 = "key2";
        // Act
        boolean result = invokeContainsKey(key1, key2);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testContainsKey_WithNullKeys_ReturnsFalse() throws Exception {
        // Act
        boolean result = invokeContainsKey(null, null);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testContainsKey_WithPartialKeyMatch_ReturnsFalse() throws Exception {
        // Arrange
        Object key1 = "key1";
        Object key2 = "key2";
        Object key3 = "key3";
        // Assume this method adds an entry to the map
        addEntryToMap(key1, key2);
        // Act
        // key2 does not match
        boolean result = invokeContainsKey(key1, key3);
        // Assert
        assertFalse(result);
    }

    private void addEntryToMap(Object key1, Object key2) {
        // Mock or manipulate the internal state of multiKeyMap to add an entry
        // This is a placeholder for the actual implementation
    }

    private boolean invokeContainsKey(Object key1, Object key2) throws Exception {
        java.lang.reflect.Method method = MultiKeyMap.class.getDeclaredMethod("containsKey", Object.class, Object.class);
        method.setAccessible(true);
        return (boolean) method.invoke(multiKeyMap, key1, key2);
    }
}
