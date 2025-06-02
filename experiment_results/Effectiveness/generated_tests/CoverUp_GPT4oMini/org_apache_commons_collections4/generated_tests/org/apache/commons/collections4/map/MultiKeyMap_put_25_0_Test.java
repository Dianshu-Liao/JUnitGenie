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

class MultiKeyMap_put_25_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    void testPutNewEntry() {
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "value1");
        assertNull(oldValue);
        assertEquals("value1", multiKeyMap.put("key1", "key2", "key3", "value1"));
    }

    @Test
    void testPutOverwriteEntry() {
        multiKeyMap.put("key1", "key2", "key3", "value1");
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "value2");
        assertEquals("value1", oldValue);
        assertEquals("value2", multiKeyMap.put("key1", "key2", "key3", "value2"));
    }

    @Test
    void testPutWithNullKey() {
        multiKeyMap.put(null, "key2", "key3", "value1");
        String oldValue = multiKeyMap.put(null, "key2", "key3", "value2");
        assertEquals("value1", oldValue);
        assertEquals("value2", multiKeyMap.put(null, "key2", "key3", "value2"));
    }

    @Test
    void testPutWithDifferentKeys() {
        multiKeyMap.put("key1", "key2", "key3", "value1");
        String oldValue = multiKeyMap.put("key1", "key4", "key3", "value2");
        assertNull(oldValue);
        assertEquals("value1", multiKeyMap.put("key1", "key2", "key3", "value1"));
    }

    @Test
    void testPutMultipleEntries() {
        multiKeyMap.put("key1", "key2", "key3", "value1");
        multiKeyMap.put("key1", "key2", "key4", "value2");
        multiKeyMap.put("key2", "key3", "key1", "value3");
        assertEquals("value1", multiKeyMap.put("key1", "key2", "key3", "value1"));
        assertEquals("value2", multiKeyMap.put("key1", "key2", "key4", "value2"));
        assertEquals("value3", multiKeyMap.put("key2", "key3", "key1", "value3"));
    }

    private Object invokePrivateMethod(String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(multiKeyMap, args);
    }
}
