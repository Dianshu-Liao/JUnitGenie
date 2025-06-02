package org.apache.commons.collections4.map;

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
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.AbstractHashedMap.HashEntry;

public class MultiKeyMap_removeAll_31_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    public void testRemoveAll_ExistingKeys() {
        // Setup: Add entries with MultiKeys (assumed to be set up correctly)
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");
        // Execute: Remove entries with specific keys
        boolean result = multiKeyMap.removeAll("key1", "key2");
        // Verify: The entry should be removed
        assertTrue(result);
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key1", "key2")));
    }

    @Test
    public void testRemoveAll_NonExistingKeys() {
        // Setup: Add entries that do not match the keys
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");
        // Execute: Attempt to remove non-existing keys
        boolean result = multiKeyMap.removeAll("key1", "key2");
        // Verify: No entry should be removed
        assertFalse(result);
    }

    @Test
    public void testRemoveAll_MultipleEntries() {
        // Setup: Add multiple entries with the same keys
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value2");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value3");
        // Execute: Remove entries with specific keys
        boolean result = multiKeyMap.removeAll("key1", "key2");
        // Verify: Both entries should be removed
        assertTrue(result);
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key1", "key2")));
    }

    @Test
    public void testRemoveAll_EmptyMap() {
        // Execute: Attempt to remove from an empty map
        boolean result = multiKeyMap.removeAll("key1", "key2");
        // Verify: No entry should be removed
        assertFalse(result);
    }

    @Test
    public void testRemoveAll_SingleEntryMatch() {
        // Setup: Add a single entry that matches the keys
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        // Execute: Remove the entry with specific keys
        boolean result = multiKeyMap.removeAll("key1", "key2");
        // Verify: The entry should be removed
        assertTrue(result);
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key1", "key2")));
    }

    @Test
    public void testRemoveAll_MultipleMatches() {
        // Setup: Add multiple entries with the same keys
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value2");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value3");
        // Execute: Remove entries with specific keys
        boolean result = multiKeyMap.removeAll("key1", "key2");
        // Verify: Both entries should be removed
        assertTrue(result);
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key1", "key2")));
    }

    @Test
    public void testRemoveAll_NoMatchingKeys() {
        // Setup: Add entries with keys that do not match
        multiKeyMap.put(new MultiKey<>("key5", "key6"), "value4");
        multiKeyMap.put(new MultiKey<>("key7", "key8"), "value5");
        // Execute: Attempt to remove with keys that do not exist
        boolean result = multiKeyMap.removeAll("key1", "key2");
        // Verify: No entries should be removed
        assertFalse(result);
    }
}
