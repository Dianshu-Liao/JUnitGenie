package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
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

public class MultiKeyMap_removeAll_32_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap();
        // Adding some initial values to the MultiKeyMap for testing
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value1");
        multiKeyMap.put(new MultiKey<>("key4", "key5", "key6"), "value2");
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key7"), "value3");
    }

    @Test
    public void testRemoveAll_WithMatchingKeys() {
        boolean modified = multiKeyMap.removeAll("key1", "key2", "key3");
        assertTrue(modified, "Expected the map to be modified when matching keys are removed.");
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key1", "key2", "key3")), "The entry with matching keys should be removed.");
    }

    @Test
    public void testRemoveAll_WithNonMatchingKeys() {
        boolean modified = multiKeyMap.removeAll("nonKey1", "nonKey2", "nonKey3");
        assertFalse(modified, "Expected the map not to be modified when no matching keys are found.");
    }

    @Test
    public void testRemoveAll_WithPartialMatchingKeys() {
        boolean modified = multiKeyMap.removeAll("key1", "key2", "nonKey3");
        assertFalse(modified, "Expected the map not to be modified when only some keys match.");
    }

    @Test
    public void testRemoveAll_WithKeysOfDifferentSize() {
        boolean modified = multiKeyMap.removeAll("key1", "key2", "key3");
        assertTrue(modified, "Expected the map to be modified when matching keys are removed.");
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key1", "key2", "key3")), "The entry with matching keys should be removed.");
        assertTrue(multiKeyMap.containsKey(new MultiKey<>("key1", "key2", "key3", "key7")), "The entry with different key length should remain.");
    }

    @Test
    public void testRemoveAll_EmptyMap() {
        MultiKeyMap emptyMap = new MultiKeyMap();
        boolean modified = emptyMap.removeAll("key1", "key2", "key3");
        assertFalse(modified, "Expected the map not to be modified when it is empty.");
    }
}
