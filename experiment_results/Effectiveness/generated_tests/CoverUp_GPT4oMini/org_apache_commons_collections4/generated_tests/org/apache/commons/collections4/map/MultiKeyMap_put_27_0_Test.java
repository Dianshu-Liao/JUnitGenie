package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;
import java.lang.reflect.Method;
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

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    void testPutWithValidKeyAndValue() {
        MultiKey<String> key = new MultiKey<>("key1", "key2");
        String value = "value1";
        String result = multiKeyMap.put(key, value);
        // No previous value, should return null
        assertNull(result);
        // Value should be stored
        assertEquals(value, multiKeyMap.get(key));
    }

    @Test
    void testPutWithDuplicateKey() {
        MultiKey<String> key = new MultiKey<>("key1", "key2");
        String value1 = "value1";
        String value2 = "value2";
        multiKeyMap.put(key, value1);
        String result = multiKeyMap.put(key, value2);
        // Should return the previous value
        assertEquals(value1, result);
        // New value should be stored
        assertEquals(value2, multiKeyMap.get(key));
    }

    @Test
    void testPutWithNullKey() {
        MultiKey<String> key = null;
        String value = "value1";
        Exception exception = assertThrows(NullPointerException.class, () -> {
            multiKeyMap.put(key, value);
        });
        assertEquals("Key cannot be null", exception.getMessage());
    }

    @Test
    void testPutWithNullValue() {
        MultiKey<String> key = new MultiKey<>("key1", "key2");
        String value = null;
        String result = multiKeyMap.put(key, value);
        // No previous value, should return null
        assertNull(result);
        // Value should be null
        assertNull(multiKeyMap.get(key));
    }

    // Reflection test for private method checkKey
    @Test
    void testPutInvokesCheckKey() throws Exception {
        MultiKey<String> key = new MultiKey<>("key1", "key2");
        Method checkKeyMethod = MultiKeyMap.class.getDeclaredMethod("checkKey", MultiKey.class);
        checkKeyMethod.setAccessible(true);
        // Assuming checkKey throws an exception for invalid keys
        assertThrows(IllegalArgumentException.class, () -> {
            // Invoking with null key
            checkKeyMethod.invoke(multiKeyMap, null);
        });
    }
}
