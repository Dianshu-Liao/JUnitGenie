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

public class MultiKeyMap_put_23_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    public void testPutNewEntry() {
        String value = multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value1");
        assertNull(value, "Expected null for new entry");
    }

    @Test
    public void testPutOverwriteEntry() {
        multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value1");
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value2");
        assertEquals("value1", oldValue, "Expected old value to be returned");
        assertEquals("value2", multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value2"), "value2");
    }

    @Test
    public void testPutDifferentKeys() {
        multiKeyMap.put("key1", "key2", "key3", "key4", "key5", "value1");
        String value = multiKeyMap.put("key6", "key7", "key8", "key9", "key10", "value2");
        assertNull(value, "Expected null for new entry with different keys");
    }

    @Test
    public void testPutWithNullKeys() {
        multiKeyMap.put(null, "key2", "key3", "key4", "key5", "value1");
        String oldValue = multiKeyMap.put(null, "key2", "key3", "key4", "key5", "value2");
        assertEquals("value1", oldValue, "Expected old value to be returned when key is null");
        assertEquals("value2", multiKeyMap.put(null, "key2", "key3", "key4", "key5", "value2"), "value2");
    }

    @Test
    public void testPutWithAllNullKeys() {
        String value = multiKeyMap.put(null, null, null, null, null, "value1");
        assertNull(value, "Expected null for new entry with all null keys");
        String oldValue = multiKeyMap.put(null, null, null, null, null, "value2");
        assertEquals("value1", oldValue, "Expected old value to be returned when all keys are null");
    }

    @Test
    public void testPutWithMixedNullKeys() {
        multiKeyMap.put("key1", null, "key3", null, "key5", "value1");
        String oldValue = multiKeyMap.put("key1", null, "key3", null, "key5", "value2");
        assertEquals("value1", oldValue, "Expected old value to be returned when some keys are null");
        assertEquals("value2", multiKeyMap.put("key1", null, "key3", null, "key5", "value2"), "value2");
    }
}
