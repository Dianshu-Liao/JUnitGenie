package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
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

class MultiKeyMap_removeAll_31_1_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap();
    }

    @Test
    void testRemoveAll_ExistingKeys() {
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value3");
        boolean modified = multiKeyMap.removeAll("key1", "key2");
        assertTrue(modified);
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2")));
        assertNotNull(multiKeyMap.get(new MultiKey<>("key3", "key4")));
        assertNotNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3")));
    }

    @Test
    void testRemoveAll_NonExistingKeys() {
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value2");
        boolean modified = multiKeyMap.removeAll("key1", "key2");
        assertFalse(modified);
        assertNotNull(multiKeyMap.get(new MultiKey<>("key3", "key4")));
    }

    @Test
    void testRemoveAll_MultipleEntries() {
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value2");
        multiKeyMap.put(new MultiKey<>("key3", "key4"), "value3");
        boolean modified = multiKeyMap.removeAll("key1", "key2");
        assertTrue(modified);
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2")));
        assertNotNull(multiKeyMap.get(new MultiKey<>("key3", "key4")));
    }

    @Test
    void testRemoveAll_EmptyMap() {
        boolean modified = multiKeyMap.removeAll("key1", "key2");
        assertFalse(modified);
    }

    @Test
    void testRemoveAll_SingleEntry() {
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        boolean modified = multiKeyMap.removeAll("key1", "notKey");
        assertFalse(modified);
        assertNotNull(multiKeyMap.get(new MultiKey<>("key1", "key2")));
    }

    @Test
    void testRemoveAll_KeysWithDifferentSizes() {
        multiKeyMap.put(new MultiKey<>("key1", "key2"), "value1");
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value2");
        boolean modified = multiKeyMap.removeAll("key1", "key2");
        assertTrue(modified);
        assertNull(multiKeyMap.get(new MultiKey<>("key1", "key2")));
        assertNotNull(multiKeyMap.get(new MultiKey<>("key1", "key2", "key3")));
    }

    // Reflection test for private methods if needed
    private Object invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod(methodName, Object.class, Object.class);
        method.setAccessible(true);
        return method.invoke(multiKeyMap, args);
    }
}
