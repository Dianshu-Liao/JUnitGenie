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

public class MultiKeyMap_removeAll_30_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>(new HashedMap<>());
    }

    @Test
    public void testRemoveAll_WithSingleKeyPresent() {
        MultiKey<String> key1 = new MultiKey<>(new String[] { "key1" });
        multiKeyMap.put(key1, "value1");
        assertTrue(multiKeyMap.removeAll("key1"), "Should return true when key is removed");
        assertFalse(multiKeyMap.containsKey(key1), "Key1 should be removed from the map");
    }

    @Test
    public void testRemoveAll_WithMultipleKeysPresent() {
        MultiKey<String> key1 = new MultiKey<>(new String[] { "key1" });
        MultiKey<String> key2 = new MultiKey<>(new String[] { "key2" });
        multiKeyMap.put(key1, "value1");
        multiKeyMap.put(key2, "value2");
        assertTrue(multiKeyMap.removeAll("key1"), "Should return true when key1 is removed");
        assertFalse(multiKeyMap.containsKey(key1), "Key1 should be removed from the map");
        assertTrue(multiKeyMap.containsKey(key2), "Key2 should still be present in the map");
    }

    @Test
    public void testRemoveAll_WithNoKeysPresent() {
        assertFalse(multiKeyMap.removeAll("key1"), "Should return false when no keys are removed");
    }

    @Test
    public void testRemoveAll_WithNullKey() {
        MultiKey<String> key1 = new MultiKey<>(new String[] { "key1" });
        multiKeyMap.put(key1, "value1");
        assertFalse(multiKeyMap.removeAll(null), "Should return false when null key is passed");
        assertTrue(multiKeyMap.containsKey(key1), "Key1 should still be present in the map");
    }

    @Test
    public void testRemoveAll_WithMultipleSameKeys() {
        MultiKey<String> key1 = new MultiKey<>(new String[] { "key1" });
        MultiKey<String> key2 = new MultiKey<>(new String[] { "key1" });
        multiKeyMap.put(key1, "value1");
        multiKeyMap.put(key2, "value2");
        assertTrue(multiKeyMap.removeAll("key1"), "Should return true when key1 is removed");
        assertFalse(multiKeyMap.containsKey(key1), "Key1 should be removed from the map");
        assertFalse(multiKeyMap.containsKey(key2), "Key2 should also be removed from the map");
    }
}
