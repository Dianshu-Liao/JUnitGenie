package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.AbstractHashedMap;
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

class MultiKeyMap_put_26_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    void testPutNewEntry() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        String value = "value1";
        // Put a new entry
        String oldValue = multiKeyMap.put(key1, key2, value);
        assertNull(oldValue);
        assertEquals(value, multiKeyMap.put(key1, key2, value));
    }

    @Test
    void testPutUpdateEntry() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        String initialValue = "value1";
        String updatedValue = "value2";
        // Put initial entry
        multiKeyMap.put(key1, key2, initialValue);
        // Update the existing entry
        String oldValue = multiKeyMap.put(key1, key2, updatedValue);
        assertEquals(initialValue, oldValue);
        assertEquals(updatedValue, multiKeyMap.put(key1, key2, updatedValue));
    }

    @Test
    void testPutNullKey() throws Exception {
        String key1 = null;
        String key2 = "key2";
        String value = "value1";
        // Put a new entry with a null key
        String oldValue = multiKeyMap.put(key1, key2, value);
        assertNull(oldValue);
    }

    @Test
    void testPutNullValue() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        String value = null;
        // Put a new entry with a null value
        String oldValue = multiKeyMap.put(key1, key2, value);
        assertNull(oldValue);
    }

    @Test
    void testPutWithSameKeysDifferentValues() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        String value1 = "value1";
        String value2 = "value2";
        // Put first entry
        multiKeyMap.put(key1, key2, value1);
        // Put second entry with same keys but different value
        String oldValue = multiKeyMap.put(key1, key2, value2);
        assertEquals(value1, oldValue);
        assertEquals(value2, multiKeyMap.put(key1, key2, value2));
    }

    // Utility method to invoke private methods using reflection
    private Object invokePrivateMethod(String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(multiKeyMap, args);
    }
}
