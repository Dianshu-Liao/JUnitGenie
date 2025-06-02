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

public class MultiKeyMap_removeAll_30_1_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    public void testRemoveAll_WithSingleKey() {
        MultiKey<String> key1 = new MultiKey<>(new String[] { "key1" });
        MultiKey<String> key2 = new MultiKey<>(new String[] { "key2" });
        multiKeyMap.put(key1, "value1");
        multiKeyMap.put(key2, "value2");
        boolean modified = multiKeyMap.removeAll("key1");
        assertTrue(modified, "Expected the map to be modified.");
        assertFalse(multiKeyMap.containsKey(key1), "Expected key1 to be removed.");
        assertTrue(multiKeyMap.containsKey(key2), "Expected key2 to still exist.");
    }

    @Test
    public void testRemoveAll_WithMultipleKeys() {
        MultiKey<String> key1 = new MultiKey<>(new String[] { "key1", "extra1" });
        MultiKey<String> key2 = new MultiKey<>(new String[] { "key1", "extra2" });
        multiKeyMap.put(key1, "value1");
        multiKeyMap.put(key2, "value2");
        boolean modified = multiKeyMap.removeAll("key1");
        assertTrue(modified, "Expected the map to be modified.");
        assertFalse(multiKeyMap.containsKey(key1), "Expected key1 to be removed.");
        assertFalse(multiKeyMap.containsKey(key2), "Expected key2 to be removed.");
    }

    @Test
    public void testRemoveAll_WithNonExistingKey() {
        MultiKey<String> key1 = new MultiKey<>(new String[] { "key1" });
        MultiKey<String> key2 = new MultiKey<>(new String[] { "key2" });
        multiKeyMap.put(key1, "value1");
        multiKeyMap.put(key2, "value2");
        boolean modified = multiKeyMap.removeAll("nonExistingKey");
        assertFalse(modified, "Expected the map not to be modified.");
        assertTrue(multiKeyMap.containsKey(key1), "Expected key1 to still exist.");
        assertTrue(multiKeyMap.containsKey(key2), "Expected key2 to still exist.");
    }

    @Test
    public void testRemoveAll_EmptyMap() {
        boolean modified = multiKeyMap.removeAll("key1");
        assertFalse(modified, "Expected the map not to be modified.");
    }
}
