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

public class MultiKeyMap_put_25_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    public void testPut_NewEntry() {
        String value = multiKeyMap.put("key1", "key2", "key3", "value1");
        assertNull(value, "Expected null for new entry");
    }

    @Test
    public void testPut_OverwriteEntry() {
        multiKeyMap.put("key1", "key2", "key3", "value1");
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "value2");
        assertEquals("value1", oldValue, "Expected to return the old value");
    }

    @Test
    public void testPut_DifferentKeys() {
        multiKeyMap.put("key1", "key2", "key3", "value1");
        String value = multiKeyMap.put("key1", "keyX", "key3", "value2");
        assertNull(value, "Expected null for new entry with different key2");
    }

    @Test
    public void testPut_NullKeys() {
        multiKeyMap.put(null, "key2", "key3", "value1");
        String value = multiKeyMap.put(null, "key2", "key3", "value2");
        assertNull(value, "Expected null for new entry with null key1");
    }

    @Test
    public void testPut_MultipleEntries() {
        multiKeyMap.put("key1", "key2", "key3", "value1");
        multiKeyMap.put("key1", "key2", "key4", "value2");
        multiKeyMap.put("key1", "key3", "key4", "value3");
        String value1 = multiKeyMap.put("key1", "key2", "key3", "value4");
        String value2 = multiKeyMap.put("key1", "key2", "key4", "value5");
        String value3 = multiKeyMap.put("key1", "key3", "key4", "value6");
        assertEquals("value1", value1, "Expected to return the old value for key1, key2, key3");
        assertEquals("value2", value2, "Expected to return the old value for key1, key2, key4");
        assertEquals("value3", value3, "Expected to return the old value for key1, key3, key4");
    }

    @Test
    public void testPut_SameKeysDifferentValues() {
        multiKeyMap.put("key1", "key2", "key3", "value1");
        multiKeyMap.put("key1", "key2", "key3", "value2");
        String oldValue = multiKeyMap.put("key1", "key2", "key3", "value3");
        assertEquals("value2", oldValue, "Expected to return the old value before the last put");
    }
}
