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

class MultiKeyMap_removeMultiKey_35_1_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value1");
        multiKeyMap.put(new MultiKey<>("key4", "key5", "key6"), "value2");
    }

    @Test
    void testRemoveMultiKey_existingKeys() throws Exception {
        String removedValue = invokeRemoveMultiKey("key1", "key2", "key3");
        assertEquals("value1", removedValue);
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3")));
    }

    @Test
    void testRemoveMultiKey_nonExistingKeys() throws Exception {
        String removedValue = invokeRemoveMultiKey("nonExistingKey1", "nonExistingKey2", "nonExistingKey3");
        assertNull(removedValue);
    }

    @Test
    void testRemoveMultiKey_nullKeys() throws Exception {
        String removedValue = invokeRemoveMultiKey(null, null, null);
        assertNull(removedValue);
    }

    @Test
    void testRemoveMultiKey_partialKeys() throws Exception {
        String removedValue = invokeRemoveMultiKey("key1", null, "key3");
        assertEquals("value1", removedValue);
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3")));
    }

    private String invokeRemoveMultiKey(Object key1, Object key2, Object key3) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("removeMultiKey", Object.class, Object.class, Object.class);
        method.setAccessible(true);
        return (String) method.invoke(multiKeyMap, key1, key2, key3);
    }
}
