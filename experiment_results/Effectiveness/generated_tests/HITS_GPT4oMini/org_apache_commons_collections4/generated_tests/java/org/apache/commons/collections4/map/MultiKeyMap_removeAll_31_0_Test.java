package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
import java.util.HashMap;
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

public class MultiKeyMap_removeAll_31_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap(new HashedMap<>());
    }

    @Test
    public void testRemoveAll_ExistingKeys_ReturnsTrue() {
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");
        boolean result = multiKeyMap.removeAll("key1", "key2");
        assertTrue(result);
    }

    @Test
    public void testRemoveAll_NonExistingKeys_ReturnsFalse() {
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");
        boolean result = multiKeyMap.removeAll("key5", "key6");
        assertFalse(result);
    }

    @Test
    public void testRemoveAll_MultipleEntries_RemovesCorrectly() {
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value2");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value3");
        boolean result = multiKeyMap.removeAll("key1", "key2");
        assertTrue(result);
    }

    @Test
    public void testRemoveAll_EmptyMap_ReturnsFalse() {
        boolean result = multiKeyMap.removeAll("key1", "key2");
        assertFalse(result);
    }

    @Test
    public void testRemoveAll_SingleEntry_NoRemoval() {
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        boolean result = multiKeyMap.removeAll("key3", "key4");
        assertFalse(result);
    }

    @Test
    public void testRemoveAll_DifferentSizes() {
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value2");
        boolean result = multiKeyMap.removeAll("key1", "key2");
        assertTrue(result);
    }
}
