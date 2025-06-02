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

class MultiKeyMap_containsKey_4_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    void testContainsKey_WithNullKeys() {
        // Assuming that the map is empty initially
        assertFalse(multiKeyMap.containsKey(null, null, null));
    }

    @Test
    void testContainsKey_WithNonExistentKeys() {
        assertFalse(multiKeyMap.containsKey("key1", "key2", "key3"));
    }

    @Test
    void testContainsKey_WithExistentKeys() {
        // Add a MultiKey to the map
        MultiKey multiKey = new MultiKey("key1", "key2", "key3");
        multiKeyMap.put(multiKey, "value");
        assertTrue(multiKeyMap.containsKey("key1", "key2", "key3"));
    }

    @Test
    void testContainsKey_WithPartialKeys() {
        // Add a MultiKey to the map
        MultiKey multiKey = new MultiKey("key1", "key2", "key3");
        multiKeyMap.put(multiKey, "value");
        // Test with partial keys
        assertFalse(multiKeyMap.containsKey("key1", "key2", null));
        assertFalse(multiKeyMap.containsKey(null, "key2", "key3"));
        assertFalse(multiKeyMap.containsKey("key1", null, "key3"));
    }

    @Test
    void testContainsKey_WithDifferentHashCodes() {
        // Add a MultiKey with a specific hash code
        MultiKey multiKey = new MultiKey("key1", "key2", "key3");
        multiKeyMap.put(multiKey, "value");
        // Test with different keys that would generate a different hash code
        assertFalse(multiKeyMap.containsKey("differentKey1", "differentKey2", "differentKey3"));
    }

    @Test
    void testContainsKey_WithSameHashCodeDifferentValues() {
        // Add a MultiKey to the map
        MultiKey multiKey = new MultiKey("key1", "key2", "key3");
        multiKeyMap.put(multiKey, "value");
        // Test with keys that have the same hash code but are different
        assertFalse(multiKeyMap.containsKey("key1", "key2", "differentValue"));
    }

    private boolean invokeContainsKey(Object key1, Object key2, Object key3) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("containsKey", Object.class, Object.class, Object.class);
        method.setAccessible(true);
        return (boolean) method.invoke(multiKeyMap, key1, key2, key3);
    }
}
