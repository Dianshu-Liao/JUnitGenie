package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
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

class MultiKeyMap_put_24_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    void testPutNewEntry() {
        String value = multiKeyMap.put("key1", "key2", "key3", "key4", "value1");
        assertNull(value, "Expected null for new entry");
    }

    @Test
    void testPutUpdateEntry() {
        multiKeyMap.put("key1", "key2", "key3", "key4", "value1");
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "key4", "value2");
        assertEquals("value1", oldValue, "Expected old value to be returned");
        assertEquals("value2", multiKeyMap.put("key1", "key2", "key3", "key4", "value2"), "Expected updated value");
    }

    @Test
    void testPutWithNullKeys() {
        String value = multiKeyMap.put(null, null, null, null, "value1");
        assertNull(value, "Expected null for new entry with null keys");
        assertEquals("value1", multiKeyMap.put(null, null, null, null, "value2"), "Expected updated value for null keys");
    }

    @Test
    void testPutDifferentKeys() {
        multiKeyMap.put("key1", "key2", "key3", "key4", "value1");
        multiKeyMap.put("key5", "key6", "key7", "key8", "value2");
        assertEquals("value1", multiKeyMap.put("key1", "key2", "key3", "key4", "value3"), "Expected old value to be returned");
        assertEquals("value2", multiKeyMap.put("key5", "key6", "key7", "key8", "value4"), "Expected old value to be returned");
    }

    @Test
    void testPutSameKeysDifferentValues() {
        multiKeyMap.put("key1", "key2", "key3", "key4", "value1");
        multiKeyMap.put("key1", "key2", "key3", "key4", "value2");
        assertEquals("value1", multiKeyMap.put("key1", "key2", "key3", "key4", "value3"), "Expected old value to be returned");
        assertEquals("value3", multiKeyMap.put("key1", "key2", "key3", "key4", "value3"), "Expected updated value to be returned");
    }

    @Test
    void testPutMultipleEntries() {
        multiKeyMap.put("key1", "key2", "key3", "key4", "value1");
        multiKeyMap.put("key1", "key2", "key5", "key6", "value2");
        multiKeyMap.put("key7", "key8", "key9", "key10", "value3");
        assertEquals("value1", multiKeyMap.put("key1", "key2", "key3", "key4", "value4"), "Expected old value to be returned");
        assertEquals("value2", multiKeyMap.put("key1", "key2", "key5", "key6", "value5"), "Expected old value to be returned");
        assertEquals("value3", multiKeyMap.put("key7", "key8", "key9", "key10", "value6"), "Expected old value to be returned");
    }
}
