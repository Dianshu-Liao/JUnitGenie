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

public class MultiKeyMap_containsKey_5_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    public void testContainsKey_WithFourNullKeys() {
        assertFalse(multiKeyMap.containsKey(null, null, null, null), "Should return false for four null keys");
    }

    @Test
    public void testContainsKey_WithOneKeyPresent() {
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value");
        assertTrue(multiKeyMap.containsKey("key1", "key2", "key3", "key4"), "Should return true for present keys");
    }

    @Test
    public void testContainsKey_WithDifferentKeys() {
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value");
        assertFalse(multiKeyMap.containsKey("key1", "differentKey", "key3", "key4"), "Should return false for different keys");
    }

    @Test
    public void testContainsKey_WithPartialKeys() {
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value");
        assertFalse(multiKeyMap.containsKey("key1", null, "key3", "key4"), "Should return false for partial match with null");
    }

    @Test
    public void testContainsKey_WithMultipleEntries() {
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        multiKeyMap.put(new MultiKey<>("key5", "key6", "key7", "key8"), "value2");
        assertTrue(multiKeyMap.containsKey("key5", "key6", "key7", "key8"), "Should return true for another present key set");
        assertFalse(multiKeyMap.containsKey("key1", "key2", "key3", "differentKey"), "Should return false for a different key");
    }

    @Test
    public void testContainsKey_WithDifferentObjectTypes() {
        multiKeyMap.put(new MultiKey<>(1, 2, 3, 4), "value");
        assertTrue(multiKeyMap.containsKey(1, 2, 3, 4), "Should return true for Integer keys");
        assertFalse(multiKeyMap.containsKey("1", "2", "3", "4"), "Should return false for String keys");
    }

    @Test
    public void testContainsKey_WithNullAndNonNullKeys() {
        multiKeyMap.put(new MultiKey<>(null, "key2", "key3", "key4"), "value");
        assertTrue(multiKeyMap.containsKey(null, "key2", "key3", "key4"), "Should return true for null and non-null keys");
        assertFalse(multiKeyMap.containsKey("key1", "key2", "key3", "key4"), "Should return false for non-matching key set");
    }
}
