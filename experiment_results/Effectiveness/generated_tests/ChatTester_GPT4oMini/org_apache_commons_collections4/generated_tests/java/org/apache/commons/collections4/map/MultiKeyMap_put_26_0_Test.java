package org.apache.commons.collections4.map;

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
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.AbstractHashedMap.HashEntry;

public class MultiKeyMap_put_26_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    public void testPut_NewEntry() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        String value = "value1";
        // Invoke the put method
        Method putMethod = MultiKeyMap.class.getDeclaredMethod("put", Object.class, Object.class, Object.class);
        putMethod.setAccessible(true);
        String result = (String) putMethod.invoke(multiKeyMap, key1, key2, value);
        assertNull(result, "Expected null for new entry");
    }

    @Test
    public void testPut_UpdateExistingEntry() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        String value1 = "value1";
        String value2 = "value2";
        // Add initial entry
        Method putMethod = MultiKeyMap.class.getDeclaredMethod("put", Object.class, Object.class, Object.class);
        putMethod.setAccessible(true);
        putMethod.invoke(multiKeyMap, key1, key2, value1);
        // Update the existing entry
        String result = (String) putMethod.invoke(multiKeyMap, key1, key2, value2);
        assertEquals(value1, result, "Expected old value to be returned");
    }

    @Test
    public void testPut_DifferentKeys() throws Exception {
        String key1a = "key1";
        String key2a = "key2";
        String key1b = "key3";
        String key2b = "key4";
        String value1 = "value1";
        String value2 = "value2";
        // Add first entry
        Method putMethod = MultiKeyMap.class.getDeclaredMethod("put", Object.class, Object.class, Object.class);
        putMethod.setAccessible(true);
        putMethod.invoke(multiKeyMap, key1a, key2a, value1);
        // Add second entry with different keys
        String result = (String) putMethod.invoke(multiKeyMap, key1b, key2b, value2);
        assertNull(result, "Expected null for new entry with different keys");
    }

    @Test
    public void testPut_SameKeysDifferentValues() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        String value1 = "value1";
        String value2 = "value2";
        // Add initial entry
        Method putMethod = MultiKeyMap.class.getDeclaredMethod("put", Object.class, Object.class, Object.class);
        putMethod.setAccessible(true);
        putMethod.invoke(multiKeyMap, key1, key2, value1);
        // Update the existing entry with a different value
        String result = (String) putMethod.invoke(multiKeyMap, key1, key2, value2);
        assertEquals(value1, result, "Expected old value to be returned when updating with a new value");
    }

    @Test
    public void testPut_NullValues() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        // Test inserting null value
        Method putMethod = MultiKeyMap.class.getDeclaredMethod("put", Object.class, Object.class, Object.class);
        putMethod.setAccessible(true);
        String result = (String) putMethod.invoke(multiKeyMap, key1, key2, null);
        assertNull(result, "Expected null for new entry with null value");
    }
}
