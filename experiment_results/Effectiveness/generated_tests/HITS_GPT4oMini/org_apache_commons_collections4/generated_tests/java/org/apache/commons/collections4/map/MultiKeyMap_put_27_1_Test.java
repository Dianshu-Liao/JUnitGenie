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

public class MultiKeyMap_put_27_1_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    public void testPutWithValidKeyAndValue() {
        MultiKey<String> key = new MultiKey<>("key1", "key2");
        String value = "value1";
        String result = multiKeyMap.put(key, value);
        assertNull(result, "Expected previous value to be null for a new key.");
        assertEquals(value, multiKeyMap.put(key, value), "Expected to retrieve the same value.");
    }

    @Test
    public void testPutWithDuplicateKey() {
        MultiKey<String> key = new MultiKey<>("key1", "key2");
        String initialValue = "value1";
        String newValue = "value2";
        multiKeyMap.put(key, initialValue);
        String result = multiKeyMap.put(key, newValue);
        assertEquals(initialValue, result, "Expected to retrieve the previous value for the duplicate key.");
        assertEquals(newValue, multiKeyMap.put(key, newValue), "Expected to retrieve the new value.");
    }

    @Test
    public void testPutWithNullKey() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            multiKeyMap.put(null, "value");
        });
        String expectedMessage = "key must not be null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), "Expected NullPointerException for null key.");
    }

    @Test
    public void testPutWithNullValue() {
        MultiKey<String> key = new MultiKey<>("key1", "key2");
        String result = multiKeyMap.put(key, null);
        assertNull(result, "Expected previous value to be null for a new key.");
        assertNull(multiKeyMap.put(key, null), "Expected to retrieve null for the same key.");
    }

    @Test
    public void testPutWithMultipleKeys() {
        MultiKey<String> key1 = new MultiKey<>("key1", "key2");
        MultiKey<String> key2 = new MultiKey<>("key3", "key4");
        String value1 = "value1";
        String value2 = "value2";
        multiKeyMap.put(key1, value1);
        multiKeyMap.put(key2, value2);
        assertEquals(value1, multiKeyMap.put(key1, value1), "Expected to retrieve the same value for key1.");
        assertEquals(value2, multiKeyMap.put(key2, value2), "Expected to retrieve the same value for key2.");
    }
}
