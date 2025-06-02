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

public class MultiKeyMap_put_25_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    public void testPutNewEntry() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String value = "value1";
        String result = invokePut(key1, key2, key3, value);
        assertNull(result, "Expected null when adding new entry");
        // Verify that the entry is correctly added
        assertEquals(value, multiKeyMap.get(key1, key2, key3));
    }

    @Test
    public void testPutUpdateExistingEntry() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String initialValue = "value1";
        String newValue = "value2";
        // Add initial entry
        invokePut(key1, key2, key3, initialValue);
        // Update entry
        String result = invokePut(key1, key2, key3, newValue);
        assertEquals(initialValue, result, "Expected old value to be returned");
        assertEquals(newValue, multiKeyMap.get(key1, key2, key3), "Expected updated value to be returned");
    }

    @Test
    public void testPutWithDifferentKeys() throws Exception {
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String value1 = "value1";
        String value2 = "value2";
        invokePut(key1, key2, key3, value1);
        invokePut("key4", "key5", "key6", value2);
        assertEquals(value1, multiKeyMap.get(key1, key2, key3), "Expected value1 for key1, key2, key3");
        assertEquals(value2, multiKeyMap.get("key4", "key5", "key6"), "Expected value2 for key4, key5, key6");
    }

    private String invokePut(String key1, String key2, String key3, String value) throws Exception {
        Method putMethod = MultiKeyMap.class.getDeclaredMethod("put", Object.class, Object.class, Object.class, Object.class);
        putMethod.setAccessible(true);
        return (String) putMethod.invoke(multiKeyMap, key1, key2, key3, value);
    }
}
