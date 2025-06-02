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

class MultiKeyMap_removeMultiKey_35_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    void testRemoveMultiKey_ExistingKeys() throws Exception {
        // Setup a scenario where the keys exist in the map
        addEntryToMap("key1", "key2", "key3", "value");
        // Invoke the focal method
        String result = invokeRemoveMultiKey("key1", "key2", "key3");
        // Verify the result
        assertEquals("value", result);
    }

    @Test
    void testRemoveMultiKey_NonExistingKeys() throws Exception {
        // Invoke the focal method with non-existing keys
        String result = invokeRemoveMultiKey("nonKey1", "nonKey2", "nonKey3");
        // Verify the result is null
        assertNull(result);
    }

    @Test
    void testRemoveMultiKey_ExistingKeys_WithDifferentValues() throws Exception {
        // Setup a scenario with multiple entries
        addEntryToMap("key1", "key2", "key3", "value1");
        addEntryToMap("key1", "key2", "key4", "value2");
        // Invoke the focal method for the first entry
        String result = invokeRemoveMultiKey("key1", "key2", "key3");
        // Verify the result
        assertEquals("value1", result);
        // Verify that the second entry still exists
        String result2 = invokeRemoveMultiKey("key1", "key2", "key4");
        assertEquals("value2", result2);
    }

    private String invokeRemoveMultiKey(Object key1, Object key2, Object key3) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("removeMultiKey", Object.class, Object.class, Object.class);
        method.setAccessible(true);
        return (String) method.invoke(multiKeyMap, key1, key2, key3);
    }

    private void addEntryToMap(Object key1, Object key2, Object key3, Object value) {
        // This method would need to manipulate the internal state of MultiKeyMap
        // to add an entry. Implementation depends on the actual structure of the class.
        // Assuming we have access to a method to add entries directly.
        // This is a placeholder for the actual implementation.
    }
}
