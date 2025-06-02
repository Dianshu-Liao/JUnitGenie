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

public class MultiKeyMap_removeMultiKey_36_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        multiKeyMap.put(new MultiKey<>("keyA", "keyB", "keyC", "keyD"), "value2");
    }

    @Test
    public void testRemoveMultiKey_ExistingKeys() {
        String result = multiKeyMap.removeMultiKey("key1", "key2", "key3", "key4");
        assertEquals("value1", result);
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3", "key4")));
    }

    @Test
    public void testRemoveMultiKey_NonExistingKeys() {
        String result = multiKeyMap.removeMultiKey("nonKey1", "nonKey2", "nonKey3", "nonKey4");
        assertNull(result);
    }

    @Test
    public void testRemoveMultiKey_PartialMatch() {
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        String result = multiKeyMap.removeMultiKey("key1", "key2", "key3", null);
        assertNull(result);
    }

    @Test
    public void testRemoveMultiKey_EmptyMap() {
        MultiKeyMap<String, String> emptyMap = new MultiKeyMap<>();
        String result = emptyMap.removeMultiKey("key1", "key2", "key3", "key4");
        assertNull(result);
    }

    @Test
    public void testRemoveMultiKey_SameKeysDifferentValues() {
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value1");
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3", "key4"), "value3");
        String result = multiKeyMap.removeMultiKey("key1", "key2", "key3", "key4");
        assertEquals("value3", result);
    }

    @Test
    public void testRemoveMultiKey_NullKeys() {
        multiKeyMap.put(new MultiKey<>(null, null, null, null), "valueNull");
        String result = multiKeyMap.removeMultiKey(null, null, null, null);
        assertEquals("valueNull", result);
        assertNull(multiKeyMap.get(new MultiKey<>(null, null, null, null)));
    }
}
