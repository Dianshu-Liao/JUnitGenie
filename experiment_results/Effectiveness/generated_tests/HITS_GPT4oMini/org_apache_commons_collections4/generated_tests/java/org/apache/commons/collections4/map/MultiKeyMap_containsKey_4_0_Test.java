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

public class MultiKeyMap_containsKey_4_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    public void testContainsKey_WithNullKeys() {
        // Assuming that the map does not contain null keys
        assertFalse(multiKeyMap.containsKey(null, null, null));
    }

    @Test
    public void testContainsKey_WithUniqueKeys() {
        // Setup the map with unique keys
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value1");
        assertTrue(multiKeyMap.containsKey("key1", "key2", "key3"));
    }

    @Test
    public void testContainsKey_WithDifferentKeys() {
        // Setup the map with a specific key set
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value1");
        assertFalse(multiKeyMap.containsKey("key1", "key2", "differentKey"));
    }

    @Test
    public void testContainsKey_WithSameHashCodeDifferentValues() {
        // Setup the map with keys that have the same hash code but different values
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value1");
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key4"), "value2");
        assertTrue(multiKeyMap.containsKey("key1", "key2", "key3"));
        assertTrue(multiKeyMap.containsKey("key1", "key2", "key4"));
    }

    @Test
    public void testContainsKey_WithEmptyMap() {
        // Test for a key in an empty map
        assertFalse(multiKeyMap.containsKey("key1", "key2", "key3"));
    }

    @Test
    public void testContainsKey_WithNullAndNonNullKeys() {
        // Setup the map with a key that has null in it
        multiKeyMap.put(new MultiKey<>("key1", null, "key3"), "value1");
        assertTrue(multiKeyMap.containsKey("key1", null, "key3"));
        assertFalse(multiKeyMap.containsKey("key1", "key2", "key3"));
    }
}
