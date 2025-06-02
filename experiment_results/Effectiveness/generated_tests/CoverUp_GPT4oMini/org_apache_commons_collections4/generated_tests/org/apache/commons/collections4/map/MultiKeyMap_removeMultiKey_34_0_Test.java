package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
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

class MultiKeyMap_removeMultiKey_34_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");
    }

    @Test
    void testRemoveMultiKey_ExistingKeys() throws Exception {
        String value = invokeRemoveMultiKey("key1", "key2");
        assertEquals("value1", value);
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2")));
    }

    @Test
    void testRemoveMultiKey_NonExistingKeys() throws Exception {
        String value = invokeRemoveMultiKey("nonExistingKey1", "nonExistingKey2");
        assertNull(value);
    }

    @Test
    void testRemoveMultiKey_NullKeys() throws Exception {
        String value = invokeRemoveMultiKey(null, null);
        assertNull(value);
    }

    @Test
    void testRemoveMultiKey_OnlyOneKeyExists() throws Exception {
        String value = invokeRemoveMultiKey("key1", "nonExistingKey");
        assertNull(value);
        assertNotNull(multiKeyMap.get(new MultiKey<>("key1", "key2")));
    }

    private String invokeRemoveMultiKey(Object key1, Object key2) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("removeMultiKey", Object.class, Object.class);
        method.setAccessible(true);
        return (String) method.invoke(multiKeyMap, key1, key2);
    }
}
