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

public class MultiKeyMap_get_13_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        // Populate the MultiKeyMap with some test data
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4", "key5"), "value1");
        multiKeyMap.put(new MultiKey<>("keyA", "keyB", "keyC", "keyD", "keyE"), "value2");
        multiKeyMap.put(new MultiKey<>(null, "key2", "key3", "key4", "key5"), "value3");
    }

    @Test
    public void testGet_ExistingKeys() {
        String result = multiKeyMap.get("key1", "key2", "key3", "key4", "key5");
        assertEquals("value1", result);
    }

    @Test
    public void testGet_NonExistingKeys() {
        String result = multiKeyMap.get("nonexistentKey1", "nonexistentKey2", "nonexistentKey3", "nonexistentKey4", "nonexistentKey5");
        assertNull(result);
    }

    @Test
    public void testGet_NullKey() {
        String result = multiKeyMap.get(null, "key2", "key3", "key4", "key5");
        assertEquals("value3", result);
    }

    @Test
    public void testGet_EmptyKeys() {
        String result = multiKeyMap.get("", "", "", "", "");
        assertNull(result);
    }

    @Test
    public void testGet_PartialMatch() {
        String result = multiKeyMap.get("key1", "key2", null, "key4", "key5");
        assertNull(result);
    }

    @Test
    public void testGet_AllNullKeys() {
        String result = multiKeyMap.get(null, null, null, null, null);
        assertNull(result);
    }
}
