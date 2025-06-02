package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
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
import org.apache.commons.collections4.map.AbstractHashedMap.HashEntry;

class MultiKeyMap_put_26_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    void testPutNewEntry() {
        String key1 = "key1";
        String key2 = "key2";
        String value = "value1";
        // Act
        String oldValue = multiKeyMap.put(key1, key2, value);
        // Assert
        assertNull(oldValue, "Expected old value to be null for new entry");
        assertEquals(value, multiKeyMap.put(key1, key2, value), "Expected to retrieve the same value");
    }

    @Test
    void testPutExistingEntry() {
        String key1 = "key1";
        String key2 = "key2";
        String value1 = "value1";
        String value2 = "value2";
        // Act
        multiKeyMap.put(key1, key2, value1);
        String oldValue = multiKeyMap.put(key1, key2, value2);
        // Assert
        assertEquals(value1, oldValue, "Expected to retrieve the old value");
        assertEquals(value2, multiKeyMap.put(key1, key2, value2), "Expected to retrieve the same value after update");
    }

    @Test
    void testPutWithNullKeys() {
        String value = "value1";
        // Act
        String oldValue = multiKeyMap.put(null, null, value);
        // Assert
        assertNull(oldValue, "Expected old value to be null for new entry with null keys");
        assertEquals(value, multiKeyMap.put(null, null, value), "Expected to retrieve the same value for null keys");
    }

    @Test
    void testPutWithOneNullKey() {
        String key1 = "key1";
        String key2 = null;
        String value = "value1";
        // Act
        String oldValue = multiKeyMap.put(key1, key2, value);
        // Assert
        assertNull(oldValue, "Expected old value to be null for new entry with one null key");
        assertEquals(value, multiKeyMap.put(key1, key2, value), "Expected to retrieve the same value for one null key");
    }

    @Test
    void testPutDifferentKeyCombination() {
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String value1 = "value1";
        String value2 = "value2";
        // Act
        multiKeyMap.put(key1, key2, value1);
        String oldValue = multiKeyMap.put(key1, key3, value2);
        // Assert
        assertNull(oldValue, "Expected old value to be null for new entry with different key combination");
        assertEquals(value2, multiKeyMap.put(key1, key3, value2), "Expected to retrieve the same value for different keys");
    }
}
