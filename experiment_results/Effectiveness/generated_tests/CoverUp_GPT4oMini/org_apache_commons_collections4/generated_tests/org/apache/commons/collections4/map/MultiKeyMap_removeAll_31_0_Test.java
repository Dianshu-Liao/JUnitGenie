package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;
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
import java.util.Objects;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.AbstractHashedMap.HashEntry;

class MultiKeyMap_removeAll_31_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    void testRemoveAll_KeyExists() {
        // Arrange
        MultiKey<String> key1 = new MultiKey<>("key1", "key2");
        MultiKey<String> key2 = new MultiKey<>("key3", "key4");
        multiKeyMap.put(key1, "value1");
        multiKeyMap.put(key2, "value2");
        // Act
        boolean result = multiKeyMap.removeAll("key1", "key2");
        // Assert
        assertTrue(result);
        // key1 should be removed
        assertNull(multiKeyMap.get(key1));
        // key2 should still exist
        assertNotNull(multiKeyMap.get(key2));
    }

    @Test
    void testRemoveAll_KeyDoesNotExist() {
        // Arrange
        MultiKey<String> key1 = new MultiKey<>("key1", "key2");
        MultiKey<String> key2 = new MultiKey<>("key3", "key4");
        multiKeyMap.put(key1, "value1");
        // Act
        boolean result = multiKeyMap.removeAll("key5", "key6");
        // Assert
        assertFalse(result);
        // key1 should still exist
        assertNotNull(multiKeyMap.get(key1));
    }

    @Test
    void testRemoveAll_MultipleKeys() {
        // Arrange
        MultiKey<String> key1 = new MultiKey<>("key1", "key2");
        MultiKey<String> key2 = new MultiKey<>("key3", "key4");
        MultiKey<String> key3 = new MultiKey<>("key1", "key2");
        multiKeyMap.put(key1, "value1");
        multiKeyMap.put(key2, "value2");
        multiKeyMap.put(key3, "value3");
        // Act
        boolean result = multiKeyMap.removeAll("key1", "key2");
        // Assert
        assertTrue(result);
        // key1 should be removed
        assertNull(multiKeyMap.get(key1));
        // key3 should also be removed
        assertNull(multiKeyMap.get(key3));
        // key2 should still exist
        assertNotNull(multiKeyMap.get(key2));
    }

    @Test
    void testRemoveAll_EmptyMap() {
        // Act
        boolean result = multiKeyMap.removeAll("key1", "key2");
        // Assert
        // No keys to remove
        assertFalse(result);
    }

    @Test
    void testRemoveAll_NullKeys() {
        // Arrange
        MultiKey<String> key1 = new MultiKey<>(null, null);
        multiKeyMap.put(key1, "value1");
        // Act
        boolean result = multiKeyMap.removeAll(null, null);
        // Assert
        assertTrue(result);
        // key1 should be removed
        assertNull(multiKeyMap.get(key1));
    }
}
