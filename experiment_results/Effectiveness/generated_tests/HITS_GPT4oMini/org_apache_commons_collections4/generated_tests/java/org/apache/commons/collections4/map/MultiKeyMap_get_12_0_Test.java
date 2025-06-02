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

public class MultiKeyMap_get_12_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        multiKeyMap.put(new MultiKey<>("keyA", "keyB", "keyC", "keyD"), "value2");
    }

    @Test
    public void testGet_ExistingKeys() {
        String result = multiKeyMap.get("key1", "key2", "key3", "key4");
        assertEquals("value1", result, "Should return the correct value for the existing keys");
    }

    @Test
    public void testGet_AnotherSetOfExistingKeys() {
        String result = multiKeyMap.get("keyA", "keyB", "keyC", "keyD");
        assertEquals("value2", result, "Should return the correct value for another set of existing keys");
    }

    @Test
    public void testGet_NonExistingKeys() {
        String result = multiKeyMap.get("nonKey1", "nonKey2", "nonKey3", "nonKey4");
        assertNull(result, "Should return null for non-existing keys");
    }

    @Test
    public void testGet_PartiallyExistingKeys() {
        String result = multiKeyMap.get("key1", "key2", "nonKey3", "nonKey4");
        assertNull(result, "Should return null when some keys are non-existing");
    }

    @Test
    public void testGet_NullKeys() {
        String result = multiKeyMap.get(null, null, null, null);
        assertNull(result, "Should return null when all keys are null");
    }

    @Test
    public void testGet_MixedNullAndNonNullKeys() {
        String result = multiKeyMap.get("key1", null, "key3", null);
        assertNull(result, "Should return null when some keys are null");
    }
}
