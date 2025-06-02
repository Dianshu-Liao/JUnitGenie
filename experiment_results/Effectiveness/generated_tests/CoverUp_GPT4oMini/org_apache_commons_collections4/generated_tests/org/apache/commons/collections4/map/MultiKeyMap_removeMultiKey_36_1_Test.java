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

class MultiKeyMap_removeMultiKey_36_1_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        // Adding some data for testing
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        multiKeyMap.put(new MultiKey<>("key5", "key6", "key7", "key8"), "value2");
    }

    @Test
    void testRemoveMultiKey_ExistingKeys() throws Exception {
        // Test removing an existing multi-key
        String removedValue = invokeRemoveMultiKey("key1", "key2", "key3", "key4");
        assertEquals("value1", removedValue);
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3", "key4")));
    }

    @Test
    void testRemoveMultiKey_NonExistingKeys() throws Exception {
        // Test removing a non-existing multi-key
        String removedValue = invokeRemoveMultiKey("nonExistingKey1", "nonExistingKey2", "nonExistingKey3", "nonExistingKey4");
        assertNull(removedValue);
    }

    @Test
    void testRemoveMultiKey_ExistingKeys_SecondEntry() throws Exception {
        // Test removing the second multi-key
        String removedValue = invokeRemoveMultiKey("key5", "key6", "key7", "key8");
        assertEquals("value2", removedValue);
        assertNull(multiKeyMap.get(new MultiKey<>("key5", "key6", "key7", "key8")));
    }

    @Test
    void testRemoveMultiKey_WithNullKeys() throws Exception {
        // Test removing with null keys
        multiKeyMap.put(new MultiKey<>(null, null, null, null), "value3");
        String removedValue = invokeRemoveMultiKey(null, null, null, null);
        assertEquals("value3", removedValue);
        assertNull(multiKeyMap.get(new MultiKey<>(null, null, null, null)));
    }

    private String invokeRemoveMultiKey(Object key1, Object key2, Object key3, Object key4) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("removeMultiKey", Object.class, Object.class, Object.class, Object.class);
        method.setAccessible(true);
        return (String) method.invoke(multiKeyMap, key1, key2, key3, key4);
    }
}
