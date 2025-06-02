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

public class MultiKeyMap_get_11_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value1");
        multiKeyMap.put(new MultiKey<>("keyA", "keyB", "keyC"), "value2");
    }

    @Test
    public void testGetExistingKeys() {
        String value = multiKeyMap.get("key1", "key2", "key3");
        assertEquals("value1", value, "Should return the correct value for existing keys");
    }

    @Test
    public void testGetAnotherSetOfExistingKeys() {
        String value = multiKeyMap.get("keyA", "keyB", "keyC");
        assertEquals("value2", value, "Should return the correct value for another set of existing keys");
    }

    @Test
    public void testGetNonExistingKeys() {
        String value = multiKeyMap.get("nonExistingKey1", "nonExistingKey2", "nonExistingKey3");
        assertNull(value, "Should return null for non-existing keys");
    }

    @Test
    public void testGetWithNullKeys() {
        String value = multiKeyMap.get(null, null, null);
        assertNull(value, "Should return null when all keys are null");
    }

    @Test
    public void testGetWithPartialNullKeys() {
        String value = multiKeyMap.get("key1", null, "key3");
        assertNull(value, "Should return null when keys are partially null and do not match any entry");
    }

    @Test
    public void testGetWithDifferentKeyOrder() {
        String value = multiKeyMap.get("key3", "key2", "key1");
        assertNull(value, "Should return null when keys are in a different order");
    }

    @Test
    public void testGetWithDifferentValueType() {
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "differentValue");
        String value = multiKeyMap.get("key1", "key2", "key3");
        assertEquals("differentValue", value, "Should return the updated value for existing keys");
    }
}
