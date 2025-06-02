package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;
import java.lang.reflect.Field;
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

public class MultiKeyMap_removeMultiKey_35_0_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    public void setUp() {
        multiKeyMap = new MultiKeyMap<>();
        // Add test data
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value1");
        multiKeyMap.put(new MultiKey<>("key4", "key5", "key6"), "value2");
    }

    @Test
    public void testRemoveMultiKey_ExistingKeys() throws Exception {
        String removedValue = invokeRemoveMultiKey("key1", "key2", "key3");
        assertEquals("value1", removedValue);
        // Verify that the value is removed
        assertNull(invokeRemoveMultiKey("key1", "key2", "key3"));
    }

    @Test
    public void testRemoveMultiKey_NonExistingKeys() throws Exception {
        String removedValue = invokeRemoveMultiKey("nonExistingKey1", "nonExistingKey2", "nonExistingKey3");
        assertNull(removedValue);
    }

    @Test
    public void testRemoveMultiKey_AnotherExistingKeys() throws Exception {
        String removedValue = invokeRemoveMultiKey("key4", "key5", "key6");
        assertEquals("value2", removedValue);
        // Verify that the value is removed
        assertNull(invokeRemoveMultiKey("key4", "key5", "key6"));
    }

    private String invokeRemoveMultiKey(Object key1, Object key2, Object key3) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod("removeMultiKey", Object.class, Object.class, Object.class);
        method.setAccessible(true);
        return (String) method.invoke(multiKeyMap, key1, key2, key3);
    }
}
