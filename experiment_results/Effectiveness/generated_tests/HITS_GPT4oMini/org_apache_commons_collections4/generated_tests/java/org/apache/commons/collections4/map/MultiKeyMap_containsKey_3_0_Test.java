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
    public void testContainsKey_WithNullKeys() {
        // Test with both keys as null
        assertFalse(multiKeyMap.containsKey(null, null));
    }

    @Test
    public void testContainsKey_WithFirstKeyNull() {
        // Test with first key as null and second key as a valid object
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value");
        assertFalse(multiKeyMap.containsKey(null, "key2"));
    }

    @Test
    public void testContainsKey_WithSecondKeyNull() {
        // Test with second key as null and first key as a valid object
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value");
        assertFalse(multiKeyMap.containsKey("key1", null));
    }

    @Test
    public void testContainsKey_WithBothKeysPresent() {
        // Test with both keys present
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value");
        assertTrue(multiKeyMap.containsKey("key1", "key2"));
    }

    @Test
    public void testContainsKey_WithOnlyFirstKeyPresent() {
        // Test with only the first key present
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value");
        assertFalse(multiKeyMap.containsKey("key1", "key3"));
    }

    @Test
    public void testContainsKey_WithOnlySecondKeyPresent() {
        // Test with only the second key present
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value");
        assertFalse(multiKeyMap.containsKey("key3", "key2"));
    }

    @Test
    public void testContainsKey_WithDifferentKeys() {
        // Test with different keys
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value");
        assertFalse(multiKeyMap.containsKey("key2", "key1"));
    }

    @Test
    public void testContainsKey_WithMultipleEntries() {
        // Test with multiple entries and check for a specific combination
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");
        assertTrue(multiKeyMap.containsKey("key1", "key2"));
        assertTrue(multiKeyMap.containsKey("key3", "key4"));
        assertFalse(multiKeyMap.containsKey("key1", "key4"));
    }
}
