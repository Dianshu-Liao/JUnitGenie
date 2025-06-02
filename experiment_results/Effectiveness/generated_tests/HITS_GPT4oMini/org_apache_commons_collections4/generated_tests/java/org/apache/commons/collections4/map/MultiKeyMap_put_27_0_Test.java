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

class MultiKeyMap_put_27_0_Test {

    @Test
    void testPutWithValidKeyAndValue() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        MultiKey<String> key = new MultiKey<>("key1", "key2");
        String value = "value1";
        String previousValue = multiKeyMap.put(key, value);
        assertNull(previousValue, "Expected no previous value for new key");
        String retrievedValue = multiKeyMap.get(key);
        assertEquals(value, retrievedValue, "Expected to retrieve the value associated with the key");
    }

    @Test
    void testPutWithDuplicateKey() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        MultiKey<String> key = new MultiKey<>("key1", "key2");
        String value1 = "value1";
        String value2 = "value2";
        multiKeyMap.put(key, value1);
        String previousValue = multiKeyMap.put(key, value2);
        assertEquals(value1, previousValue, "Expected to retrieve the previous value for the duplicate key");
        String retrievedValue = multiKeyMap.get(key);
        assertEquals(value2, retrievedValue, "Expected to retrieve the new value associated with the key");
    }

    @Test
    void testPutWithNullKey() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        MultiKey<String> key = null;
        String value = "value1";
        assertThrows(IllegalArgumentException.class, () -> {
            multiKeyMap.put(key, value);
        }, "Expected IllegalArgumentException when key is null");
    }

    @Test
    void testPutWithNullValue() {
        MultiKeyMap<String, String> multiKeyMap = new MultiKeyMap<>();
        MultiKey<String> key = new MultiKey<>("key1", "key2");
        String value = null;
        String previousValue = multiKeyMap.put(key, value);
        assertNull(previousValue, "Expected no previous value for new key");
        String retrievedValue = multiKeyMap.get(key);
        assertNull(retrievedValue, "Expected to retrieve null for the key with null value");
    }
}
