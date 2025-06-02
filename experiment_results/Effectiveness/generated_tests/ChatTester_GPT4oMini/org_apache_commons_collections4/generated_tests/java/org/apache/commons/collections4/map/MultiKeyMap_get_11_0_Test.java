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

public class MultiKeyMap_get_11_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        // Populate the map for testing
        try {
            Method putMethod = MultiKeyMap.class.getDeclaredMethod("put", Object.class, Object.class, Object.class, Object.class);
            putMethod.setAccessible(true);
            putMethod.invoke(multiKeyMap, "key1", "key2", "key3", "value");
            putMethod.invoke(multiKeyMap, "key4", "key5", "key6", "anotherValue");
        } catch (Exception e) {
            fail("Failed to set up test data: " + e.getMessage());
        }
    }

    @Test
    public void testGetReturnsValueWhenKeyExists() {
        String value = multiKeyMap.get("key1", "key2", "key3");
        assertNotNull(value);
        assertEquals("value", value);
    }

    @Test
    public void testGetReturnsNullWhenKeyDoesNotExist() {
        String value = multiKeyMap.get("nonExistentKey1", "nonExistentKey2", "nonExistentKey3");
        assertNull(value);
    }

    @Test
    public void testGetHandlesNullKeys() {
        String value = multiKeyMap.get(null, null, null);
        // Adjust based on expected behavior with null keys
        assertNull(value);
    }

    @Test
    public void testGetHandlesPartialKeys() {
        String value = multiKeyMap.get("key1", null, "key3");
        // Adjust based on expected behavior with partial keys
        assertNull(value);
    }

    @Test
    public void testGetHandlesDifferentHashCodes() {
        String value = multiKeyMap.get("key4", "key5", "key6");
        assertNotNull(value);
        assertEquals("anotherValue", value);
    }

    @Test
    public void testGetHandlesSameHashCodeDifferentKeys() {
        // Assuming that the map can handle different keys that produce the same hash code
        String value = multiKeyMap.get("key1", "key2", "differentKey");
        // Adjust based on expected behavior
        assertNull(value);
    }
}
