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

public class MultiKeyMap_removeMultiKey_37_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4", "key5"), "value1");
        multiKeyMap.put(new MultiKey<>("keyA", "keyB", "keyC", "keyD", "keyE"), "value2");
    }

    @Test
    public void testRemoveMultiKey_ExistingKeys() {
        // Test removing an existing multi-key
        String removedValue = multiKeyMap.removeMultiKey("key1", "key2", "key3", "key4", "key5");
        assertEquals("value1", removedValue);
        // Verify the key is removed
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3", "key4", "key5")));
    }

    @Test
    public void testRemoveMultiKey_NonExistingKeys() {
        // Test removing a non-existing multi-key
        String removedValue = multiKeyMap.removeMultiKey("nonExistentKey1", "nonExistentKey2", "nonExistentKey3", "nonExistentKey4", "nonExistentKey5");
        assertNull(removedValue);
    }

    @Test
    public void testRemoveMultiKey_ExistingKeyDifferentOrder() {
        // Test removing an existing multi-key with different order of keys
        String removedValue = multiKeyMap.removeMultiKey("key5", "key4", "key3", "key2", "key1");
        assertEquals("value1", removedValue);
        // Verify the key is removed
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3", "key4", "key5")));
    }

    @Test
    public void testRemoveMultiKey_WithNullKeys() {
        // Test removing a multi-key with null values
        multiKeyMap.put(new MultiKey<>(null, null, null, null, null), "nullValue");
        String removedValue = multiKeyMap.removeMultiKey(null, null, null, null, null);
        assertEquals("nullValue", removedValue);
        // Verify the key is removed
        assertNull(multiKeyMap.get(new MultiKey<>(null, null, null, null, null)));
    }

    @Test
    public void testRemoveMultiKey_EmptyMap() {
        // Test remove on an empty map
        MultiKeyMap<String, String> emptyMap = new MultiKeyMap<>();
        String removedValue = emptyMap.removeMultiKey("key1", "key2", "key3", "key4", "key5");
        assertNull(removedValue);
    }
}
