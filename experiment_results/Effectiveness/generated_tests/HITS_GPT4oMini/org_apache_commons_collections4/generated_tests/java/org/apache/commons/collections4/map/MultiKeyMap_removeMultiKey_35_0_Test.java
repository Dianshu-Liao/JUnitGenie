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

public class MultiKeyMap_removeMultiKey_35_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value1");
        multiKeyMap.put(new MultiKey<>("keyA", "keyB", "keyC"), "value2");
    }

    @Test
    public void testRemoveMultiKey_ExistingKeys() {
        String removedValue = multiKeyMap.removeMultiKey("key1", "key2", "key3");
        assertEquals("value1", removedValue);
        // Should return null after removal
        assertNull(multiKeyMap.removeMultiKey("key1", "key2", "key3"));
    }

    @Test
    public void testRemoveMultiKey_NonExistingKeys() {
        String removedValue = multiKeyMap.removeMultiKey("nonKey1", "nonKey2", "nonKey3");
        // Should return null since the keys do not exist
        assertNull(removedValue);
    }

    @Test
    public void testRemoveMultiKey_PartialMatch() {
        String removedValue = multiKeyMap.removeMultiKey("key1", "keyA", "keyC");
        // Should return null since there is no exact match
        assertNull(removedValue);
    }

    @Test
    public void testRemoveMultiKey_DifferentOrder() {
        String removedValue = multiKeyMap.removeMultiKey("key3", "key2", "key1");
        // Should return null since the order of keys matters
        assertNull(removedValue);
    }

    @Test
    public void testRemoveMultiKey_WithNullKeys() {
        multiKeyMap.put(new MultiKey<>(null, "key2", "key3"), "value3");
        String removedValue = multiKeyMap.removeMultiKey(null, "key2", "key3");
        assertEquals("value3", removedValue);
        // Should return null after removal
        assertNull(multiKeyMap.removeMultiKey(null, "key2", "key3"));
    }

    @Test
    public void testRemoveMultiKey_ThreeNullKeys() {
        multiKeyMap.put(new MultiKey<>(null, null, null), "value4");
        String removedValue = multiKeyMap.removeMultiKey(null, null, null);
        assertEquals("value4", removedValue);
        // Should return null after removal
        assertNull(multiKeyMap.removeMultiKey(null, null, null));
    }
}
