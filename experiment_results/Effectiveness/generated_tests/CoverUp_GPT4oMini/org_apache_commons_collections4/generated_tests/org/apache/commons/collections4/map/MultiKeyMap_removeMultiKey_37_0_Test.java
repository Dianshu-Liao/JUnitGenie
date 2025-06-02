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

class MultiKeyMap_removeMultiKey_37_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4", "key5"), "value1");
        multiKeyMap.put(new MultiKey<>("keyA", "keyB", "keyC", "keyD", "keyE"), "value2");
    }

    @Test
    void testRemoveMultiKey_ExistingKeys() throws Exception {
        String result = invokeRemoveMultiKey("key1", "key2", "key3", "key4", "key5");
        assertEquals("value1", result);
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3", "key4", "key5")));
    }

    @Test
    void testRemoveMultiKey_NonExistingKeys() throws Exception {
        String result = invokeRemoveMultiKey("nonExistingKey1", "nonExistingKey2", "nonExistingKey3", "nonExistingKey4", "nonExistingKey5");
        assertNull(result);
    }

    @Test
    void testRemoveMultiKey_PartialMatch() throws Exception {
        String result = invokeRemoveMultiKey("key1", "key2", "key3", "key4", null);
        assertNull(result);
    }

    @Test
    void testRemoveMultiKey_AllNullKeys() throws Exception {
        String result = invokeRemoveMultiKey(null, null, null, null, null);
        assertNull(result);
    }

    private String invokeRemoveMultiKey(Object key1, Object key2, Object key3, Object key4, Object key5) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("removeMultiKey", Object.class, Object.class, Object.class, Object.class, Object.class);
        method.setAccessible(true);
        return (String) method.invoke(multiKeyMap, key1, key2, key3, key4, key5);
    }
}
