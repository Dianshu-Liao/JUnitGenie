package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;
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

class MultiKeyMap_removeAll_33_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    void testRemoveAll_KeysExist() {
        // Prepare the MultiKeyMap with some entries
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        multiKeyMap.put(new MultiKey<>("key5", "key6", "key7", "key8"), "value2");
        // Remove the keys that exist
        boolean modified = multiKeyMap.removeAll("key1", "key2", "key3", "key4");
        assertTrue(modified);
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3", "key4")));
    }

    @Test
    void testRemoveAll_KeysDoNotExist() {
        // Prepare the MultiKeyMap with some entries
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        // Attempt to remove keys that do not exist
        boolean modified = multiKeyMap.removeAll("nonexistentKey1", "nonexistentKey2", "nonexistentKey3", "nonexistentKey4");
        assertFalse(modified);
        assertNotNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3", "key4")));
    }

    @Test
    void testRemoveAll_MultipleKeys() {
        // Prepare the MultiKeyMap with multiple entries
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value2");
        multiKeyMap.put(new MultiKey<>("key5", "key6", "key7", "key8"), "value3");
        // Remove keys that exist
        boolean modified = multiKeyMap.removeAll("key1", "key2", "key3", "key4");
        assertTrue(modified);
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3", "key4")));
    }

    @Test
    void testRemoveAll_NoMatchingKeys() {
        // Prepare the MultiKeyMap with some entries
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        // Remove keys that exist but do not match
        boolean modified = multiKeyMap.removeAll("key1", "key2", "differentKey3", "key4");
        assertFalse(modified);
        assertNotNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3", "key4")));
    }

    @Test
    void testRemoveAll_EmptyMap() {
        // Attempt to remove keys from an empty map
        boolean modified = multiKeyMap.removeAll("key1", "key2", "key3", "key4");
        assertFalse(modified);
    }
}
