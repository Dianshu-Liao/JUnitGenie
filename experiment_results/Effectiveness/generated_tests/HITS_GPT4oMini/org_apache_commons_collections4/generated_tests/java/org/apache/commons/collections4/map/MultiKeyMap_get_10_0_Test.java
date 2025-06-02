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

public class MultiKeyMap_get_10_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");
    }

    @Test
    public void testGet_ExistingKeys_ReturnsValue() {
        String value = multiKeyMap.get("key1", "key2");
        assertEquals("value1", value);
    }

    @Test
    public void testGet_NonExistingKeys_ReturnsNull() {
        String value = multiKeyMap.get("nonExistingKey1", "nonExistingKey2");
        assertNull(value);
    }

    @Test
    public void testGet_ExistingKeyWithDifferentSecondKey_ReturnsNull() {
        String value = multiKeyMap.get("key1", "wrongKey");
        assertNull(value);
    }

    @Test
    public void testGet_NullKeys_ReturnsNull() {
        String value = multiKeyMap.get(null, null);
        assertNull(value);
    }

    @Test
    public void testGet_OneNullKey_ReturnsNull() {
        String value = multiKeyMap.get("key1", null);
        assertNull(value);
    }

    @Test
    public void testGet_EmptyMap_ReturnsNull() {
        MultiKeyMap<String, String> emptyMap = new MultiKeyMap<>();
        String value = emptyMap.get("key1", "key2");
        assertNull(value);
    }

    @Test
    public void testGet_SameKeysDifferentOrder_ReturnsValue() {
        String value1 = multiKeyMap.get("key1", "key2");
        // Assuming MultiKey handles order
        String value2 = multiKeyMap.get("key2", "key1");
        assertEquals("value1", value1);
        assertNull(value2);
    }
}
