package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.AbstractHashedMap;
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

class MultiKeyMap_put_23_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    void testPutNewEntry() {
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value1");
        assertNull(oldValue);
        assertEquals("value1", multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value1"));
    }

    @Test
    void testPutUpdateEntry() {
        multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value1");
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value2");
        assertEquals("value1", oldValue);
    }

    @Test
    void testPutWithNullKeys() {
        multiKeyMap.put(null, "key2", null, "key4", "key5", "value1");
        String oldValue = multiKeyMap.put(null, "key2", null, "key4", "key5", "value2");
        assertEquals("value1", oldValue);
    }

    @Test
    void testPutWithDuplicateKeys() {
        multiKeyMap.put("key1", "key1", "key1", "key1", "key1", "value1");
        String oldValue = multiKeyMap.put("key1", "key1", "key1", "key1", "key1", "value2");
        assertEquals("value1", oldValue);
    }

    @Test
    void testPutDifferentKeys() {
        multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value1");
        multiKeyMap.put("key6", "key7", "key8", "key9", "key10", "value2");
        assertEquals("value1", multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value1"));
        assertNull(multiKeyMap.put("key6", "key7", "key8", "key9", "key10", "value2"));
    }

    @Test
    void testPutWithCollision() {
        multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value1");
        // Assuming that the hash function causes a collision with different keys
        // This is a hypothetical case; actual collision would depend on hash implementation.
        multiKeyMap.put("key1", "key2", "key3", "key4", "key6", "value2");
        assertEquals("value1", multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value1"));
    }
}
