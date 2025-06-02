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

public class MultiKeyMap_get_10_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");
    }

    @Test
    public void testGetExistingKeys() {
        String result = multiKeyMap.get("key1", "key2");
        assertEquals("value1", result);
    }

    @Test
    public void testGetNonExistingKeys() {
        String result = multiKeyMap.get("nonExistingKey1", "nonExistingKey2");
        assertNull(result);
    }

    @Test
    public void testGetWithNullKeys() {
        String result = multiKeyMap.get(null, "key2");
        assertNull(result);
    }

    @Test
    public void testGetWithMixedNullKeys() {
        String result = multiKeyMap.get("key1", null);
        assertNull(result);
    }

    @Test
    public void testGetWithBothNullKeys() {
        String result = multiKeyMap.get(null, null);
        assertNull(result);
    }

    @Test
    public void testGetWithDifferentTypeKeys() {
        String result = multiKeyMap.get(1, 2);
        assertNull(result);
    }

    @Test
    public void testGetWithSameHashCodeDifferentValues() {
        multiKeyMap.put(new MultiKey<>("key1", "key3"), "value3");
        String result = multiKeyMap.get("key1", "key3");
        assertEquals("value3", result);
    }

    // Reflection test for private method
    @Test
    public void testPrivateMethodHash() throws Exception {
        Method hashMethod = MultiKeyMap.class.getDeclaredMethod("hash", Object.class, Object.class);
        hashMethod.setAccessible(true);
        int hash1 = (int) hashMethod.invoke(multiKeyMap, "key1", "key2");
        int hash2 = (int) hashMethod.invoke(multiKeyMap, "key3", "key4");
        assertEquals(hash1, multiKeyMap.hash("key1", "key2"));
        assertEquals(hash2, multiKeyMap.hash("key3", "key4"));
    }
}
