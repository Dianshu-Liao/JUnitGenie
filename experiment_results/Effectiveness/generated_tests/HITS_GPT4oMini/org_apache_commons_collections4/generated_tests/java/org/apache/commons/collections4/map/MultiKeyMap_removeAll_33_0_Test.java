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

public class MultiKeyMap_removeAll_33_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    public void testRemoveAll_WhenKeysMatch_ShouldReturnTrueAndRemoveEntry() {
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        multiKeyMap.put(new MultiKey<>("key5", "key6", "key7", "key8"), "value2");
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3", "key4");
        assertTrue(result);
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3", "key4")));
        assertNotNull(multiKeyMap.get(new MultiKey<>("key5", "key6", "key7", "key8")));
    }

    @Test
    public void testRemoveAll_WhenKeysDoNotMatch_ShouldReturnFalse() {
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        boolean result = multiKeyMap.removeAll("key5", "key6", "key7", "key8");
        assertFalse(result);
        assertNotNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3", "key4")));
    }

    @Test
    public void testRemoveAll_WhenMultipleEntriesMatch_ShouldRemoveAllMatchingEntries() {
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value2");
        multiKeyMap.put(new MultiKey<>("key5", "key6", "key7", "key8"), "value3");
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3", "key4");
        assertTrue(result);
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3", "key4")));
        assertEquals("value3", multiKeyMap.get(new MultiKey<>("key5", "key6", "key7", "key8")));
    }

    @Test
    public void testRemoveAll_WhenNoEntriesExist_ShouldReturnFalse() {
        boolean result = multiKeyMap.removeAll("key1", "key2", "key3", "key4");
        assertFalse(result);
    }

    @Test
    public void testRemoveAll_WhenKeysAreNull_ShouldReturnFalse() {
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        boolean result = multiKeyMap.removeAll(null, null, null, null);
        assertFalse(result);
        assertNotNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3", "key4")));
    }

    @Test
    public void testRemoveAll_WhenKeysPartiallyMatch_ShouldNotRemoveEntry() {
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        boolean result = multiKeyMap.removeAll("key1", "wrongKey", "key3", "key4");
        assertFalse(result);
        assertNotNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3", "key4")));
    }
}
