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

class // Additional tests can be added here to ensure full coverage
MultiKeyMap_put_24_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    void testPutNewEntry() {
        String value = multiKeyMap.put("key1", "key2", "key3", "key4", "value1");
        assertNull(value);
    }

    @Test
    void testPutExistingEntry() {
        multiKeyMap.put("key1", "key2", "key3", "key4", "value1");
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "key4", "value2");
        assertEquals("value1", oldValue);
    }

    @Test
    void testPutWithNullKeys() {
        String value = multiKeyMap.put(null, null, null, null, "nullValue");
        assertNull(value);
        multiKeyMap.put(null, null, null, null, "anotherNullValue");
        String oldValue = multiKeyMap.put(null, null, null, null, "newNullValue");
        assertEquals("anotherNullValue", oldValue);
    }

    @Test
    void testPutWithMixedKeys() {
        multiKeyMap.put("key1", null, "key3", "key4", "value1");
        String oldValue = multiKeyMap.put("key1", null, "key3", "key4", "value2");
        assertEquals("value1", oldValue);
    }

    @Test
    void testPutMultipleEntries() {
        multiKeyMap.put("key1", "key2", "key3", "key4", "value1");
        multiKeyMap.put("key1", "key2", "key3", "key5", "value2");
        multiKeyMap.put("key1", "key2", "key4", "key4", "value3");
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "key4", "value4");
        assertEquals("value1", oldValue);
        oldValue = multiKeyMap.put("key1", "key2", "key3", "key5", "value5");
        assertEquals("value2", oldValue);
        oldValue = multiKeyMap.put("key1", "key2", "key4", "key4", "value6");
        assertEquals("value3", oldValue);
    }

    // Reflection test to access private method
    @Test
    void testHashMethod() throws Exception {
        Method hashMethod = MultiKeyMap.class.getDeclaredMethod("hash", Object.class, Object.class, Object.class, Object.class);
        hashMethod.setAccessible(true);
        int hash = (int) hashMethod.invoke(multiKeyMap, "key1", "key2", "key3", "key4");
        assertNotNull(hash);
    }
}
