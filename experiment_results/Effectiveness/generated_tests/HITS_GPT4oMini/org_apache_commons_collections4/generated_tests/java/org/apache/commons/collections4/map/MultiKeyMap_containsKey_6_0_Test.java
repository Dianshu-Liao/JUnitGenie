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

public class MultiKeyMap_containsKey_6_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    public void testContainsKey_WithFiveNonNullKeys_ReturnsTrue() {
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4", "key5"), "value");
        assertTrue(multiKeyMap.containsKey("key1", "key2", "key3", "key4", "key5"));
    }

    @Test
    public void testContainsKey_WithFiveNonNullKeys_ReturnsFalse() {
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4", "key5"), "value");
        assertFalse(multiKeyMap.containsKey("key1", "key2", "key3", "key4", "key6"));
    }

    @Test
    public void testContainsKey_WithNullKeys_ReturnsTrue() {
        multiKeyMap.put(new MultiKey<>(null, null, null, null, null), "value");
        assertTrue(multiKeyMap.containsKey(null, null, null, null, null));
    }

    @Test
    public void testContainsKey_WithMixedNullAndNonNullKeys_ReturnsTrue() {
        multiKeyMap.put(new MultiKey<>("key1", null, "key3", "key4", null), "value");
        assertTrue(multiKeyMap.containsKey("key1", null, "key3", "key4", null));
    }

    @Test
    public void testContainsKey_WithMixedNullAndNonNullKeys_ReturnsFalse() {
        multiKeyMap.put(new MultiKey<>("key1", null, "key3", "key4", null), "value");
        assertFalse(multiKeyMap.containsKey("key1", "key2", "key3", "key4", null));
    }

    @Test
    public void testContainsKey_WithDifferentKeyTypes_ReturnsTrue() {
        multiKeyMap.put(new MultiKey<>(1, 2.0, 'c', true, "string"), "value");
        assertTrue(multiKeyMap.containsKey(1, 2.0, 'c', true, "string"));
    }

    @Test
    public void testContainsKey_WithDifferentKeyTypes_ReturnsFalse() {
        multiKeyMap.put(new MultiKey<>(1, 2.0, 'c', true, "string"), "value");
        assertFalse(multiKeyMap.containsKey(1, 2.0, 'c', false, "string"));
    }

    @Test
    public void testContainsKey_WithEmptyMap_ReturnsFalse() {
        assertFalse(multiKeyMap.containsKey("key1", "key2", "key3", "key4", "key5"));
    }
}
