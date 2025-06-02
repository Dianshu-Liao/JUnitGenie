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

public class MultiKeyMap_removeMultiKey_34_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");
    }

    @Test
    public void testRemoveMultiKey_ExistingKeys() {
        String removedValue = multiKeyMap.removeMultiKey("key1", "key2");
        assertEquals("value1", removedValue);
        // Ensure the value is removed
        assertNull(multiKeyMap.removeMultiKey("key1", "key2"));
    }

    @Test
    public void testRemoveMultiKey_NonExistingKeys() {
        String removedValue = multiKeyMap.removeMultiKey("nonExistingKey1", "nonExistingKey2");
        // Should return null as the keys do not exist
        assertNull(removedValue);
    }

    @Test
    public void testRemoveMultiKey_OneKeyNull() {
        String removedValue = multiKeyMap.removeMultiKey(null, "key2");
        // Should return null as the first key is null
        assertNull(removedValue);
    }

    @Test
    public void testRemoveMultiKey_BothKeysNull() {
        String removedValue = multiKeyMap.removeMultiKey(null, null);
        // Should return null as both keys are null
        assertNull(removedValue);
    }

    @Test
    public void testRemoveMultiKey_DifferentValueSameKeys() {
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value3");
        String removedValue = multiKeyMap.removeMultiKey("key1", "key2");
        // Should return the latest value
        assertEquals("value3", removedValue);
    }
}
