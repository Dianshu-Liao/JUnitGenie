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

public class MultiKeyMap_containsKey_4_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    public void testContainsKey_ExistingKeys_ReturnsTrue() throws Exception {
        // Assuming we have a way to populate the MultiKeyMap with keys
        addTestKeysToMap("key1", "key2", "key3");
        // Invoke the focal method using reflection
        Method containsKeyMethod = MultiKeyMap.class.getDeclaredMethod("containsKey", Object.class, Object.class, Object.class);
        containsKeyMethod.setAccessible(true);
        boolean result = (Boolean) containsKeyMethod.invoke(multiKeyMap, "key1", "key2", "key3");
        assertTrue(result);
    }

    @Test
    public void testContainsKey_NonExistingKeys_ReturnsFalse() throws Exception {
        // Invoke the focal method using reflection
        Method containsKeyMethod = MultiKeyMap.class.getDeclaredMethod("containsKey", Object.class, Object.class, Object.class);
        containsKeyMethod.setAccessible(true);
        boolean result = (Boolean) containsKeyMethod.invoke(multiKeyMap, "nonExistingKey1", "nonExistingKey2", "nonExistingKey3");
        assertFalse(result);
    }

    @Test
    public void testContainsKey_EmptyMap_ReturnsFalse() throws Exception {
        // Invoke the focal method using reflection
        Method containsKeyMethod = MultiKeyMap.class.getDeclaredMethod("containsKey", Object.class, Object.class, Object.class);
        containsKeyMethod.setAccessible(true);
        boolean result = (Boolean) containsKeyMethod.invoke(multiKeyMap, "key1", "key2", "key3");
        assertFalse(result);
    }

    @Test
    public void testContainsKey_PartialMatch_ReturnsFalse() throws Exception {
        // Assuming we have a way to populate the MultiKeyMap with keys
        addTestKeysToMap("key1", "key2", "key3");
        // Invoke the focal method using reflection
        Method containsKeyMethod = MultiKeyMap.class.getDeclaredMethod("containsKey", Object.class, Object.class, Object.class);
        containsKeyMethod.setAccessible(true);
        boolean result = (Boolean) containsKeyMethod.invoke(multiKeyMap, "key1", "differentKey", "key3");
        assertFalse(result);
    }

    @Test
    public void testContainsKey_NullKeys_ReturnsFalse() throws Exception {
        // Invoke the focal method using reflection
        Method containsKeyMethod = MultiKeyMap.class.getDeclaredMethod("containsKey", Object.class, Object.class, Object.class);
        containsKeyMethod.setAccessible(true);
        boolean result = (Boolean) containsKeyMethod.invoke(multiKeyMap, null, null, null);
        assertFalse(result);
    }

    private void addTestKeysToMap(Object key1, Object key2, Object key3) {
        // Implementation for adding keys to the MultiKeyMap for testing purposes
        // This method should be defined based on how the MultiKeyMap is expected to store keys
    }
}
