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

class MultiKeyMap_get_12_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value");
    }

    @Test
    void testGetWithMatchingKeys() throws Exception {
        String value = invokeGet("key1", "key2", "key3", "key4");
        assertEquals("value", value);
    }

    @Test
    void testGetWithNonMatchingKeys() throws Exception {
        String value = invokeGet("wrongKey1", "key2", "key3", "key4");
        assertNull(value);
    }

    @Test
    void testGetWithNullKeys() throws Exception {
        String value = invokeGet(null, null, null, null);
        assertNull(value);
    }

    @Test
    void testGetWithPartialMatchingKeys() throws Exception {
        String value = invokeGet("key1", "wrongKey2", "key3", "key4");
        assertNull(value);
    }

    private String invokeGet(Object key1, Object key2, Object key3, Object key4) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("get", Object.class, Object.class, Object.class, Object.class);
        method.setAccessible(true);
        return (String) method.invoke(multiKeyMap, key1, key2, key3, key4);
    }
}
