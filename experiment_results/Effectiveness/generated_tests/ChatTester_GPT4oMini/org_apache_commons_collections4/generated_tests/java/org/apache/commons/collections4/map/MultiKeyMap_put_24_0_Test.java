package org.apache.commons.collections4.map;

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
import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.AbstractHashedMap.HashEntry;

class MultiKeyMap_put_24_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    void testPut_NewEntry() {
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String value = "value1";
        String result = multiKeyMap.put(key1, key2, key3, key4, value);
        assertNull(result, "Expected null when adding a new entry");
    }

    @Test
    void testPut_UpdateExistingEntry() {
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String value1 = "value1";
        String value2 = "value2";
        // First put
        multiKeyMap.put(key1, key2, key3, key4, value1);
        // Second put to update
        String result = multiKeyMap.put(key1, key2, key3, key4, value2);
        assertEquals(value1, result, "Expected to return old value when updating an existing entry");
    }

    @Test
    void testPut_SameKeysDifferentValues() {
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String value1 = "value1";
        String value2 = "value2";
        String value3 = "value3";
        multiKeyMap.put(key1, key2, key3, key4, value1);
        multiKeyMap.put(key1, key2, key3, key4, value2);
        String result = multiKeyMap.put(key1, key2, key3, key4, value3);
        assertEquals(value2, result, "Expected to return old value when updating an existing entry");
    }

    @Test
    void testPut_DifferentKeys() {
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";
        String value1 = "value1";
        String value2 = "value2";
        multiKeyMap.put(key1, key2, key3, key4, value1);
        String result = multiKeyMap.put("differentKey1", "differentKey2", "differentKey3", "differentKey4", value2);
        assertNull(result, "Expected null when adding a new entry with different keys");
    }
}
