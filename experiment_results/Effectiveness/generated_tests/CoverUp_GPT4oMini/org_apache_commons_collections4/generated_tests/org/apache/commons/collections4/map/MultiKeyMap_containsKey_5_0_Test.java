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

public class MultiKeyMap_containsKey_5_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    public void testContainsKeyWithNulls() {
        // Test when all keys are null
        assertFalse(multiKeyMap.containsKey(null, null, null, null));
    }

    @Test
    public void testContainsKeyWithNonExistentKeys() {
        // Test with keys that are not in the map
        assertFalse(multiKeyMap.containsKey("key1", "key2", "key3", "key4"));
    }

    @Test
    public void testContainsKeyWithExistingKeys() throws Exception {
        // Add a MultiKey entry to the map
        MultiKey multiKey = new MultiKey("key1", "key2", "key3", "key4");
        multiKeyMap.put(multiKey, "value");
        // Test with the existing keys
        assertTrue(multiKeyMap.containsKey("key1", "key2", "key3", "key4"));
    }

    @Test
    public void testContainsKeyWithDifferentOrder() throws Exception {
        // Add a MultiKey entry to the map
        MultiKey multiKey = new MultiKey("key1", "key2", "key3", "key4");
        multiKeyMap.put(multiKey, "value");
        // Test with the existing keys in a different order
        assertFalse(multiKeyMap.containsKey("key4", "key3", "key2", "key1"));
    }

    @Test
    public void testContainsKeyWithPartialKeys() throws Exception {
        // Add a MultiKey entry to the map
        MultiKey multiKey = new MultiKey("key1", "key2", "key3", "key4");
        multiKeyMap.put(multiKey, "value");
        // Test with partial keys
        assertFalse(multiKeyMap.containsKey("key1", "key2", "key3", null));
    }

    @Test
    public void testContainsKeyWithDifferentValues() throws Exception {
        // Add a MultiKey entry to the map
        MultiKey multiKey = new MultiKey("key1", "key2", "key3", "key4");
        multiKeyMap.put(multiKey, "value1");
        // Test with different values
        assertFalse(multiKeyMap.containsKey("key1", "key2", "key3", "differentValue"));
    }

    // Reflection test for private methods if needed
    @Test
    public void testHashMethod() throws Exception {
        Method hashMethod = MultiKeyMap.class.getDeclaredMethod("hash", Object.class, Object.class, Object.class, Object.class);
        hashMethod.setAccessible(true);
        int hashValue = (int) hashMethod.invoke(multiKeyMap, "key1", "key2", "key3", "key4");
        assertNotNull(hashValue);
    }
}
