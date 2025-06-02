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

class MultiKeyMap_removeAll_32_0_Test {

    private MultiKeyMap multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap();
        // Adding test data to the MultiKeyMap
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value1");
        multiKeyMap.put(new MultiKey<>("key4", "key5", "key6"), "value2");
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value3");
        multiKeyMap.put(new MultiKey<>("key7", "key8", "key9"), "value4");
    }

    @Test
    void testRemoveAll_KeysPresent() {
        boolean modified = multiKeyMap.removeAll("key1", "key2", "key3");
        assertTrue(modified);
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key1", "key2", "key3")));
    }

    @Test
    void testRemoveAll_KeysNotPresent() {
        boolean modified = multiKeyMap.removeAll("nonexistent1", "nonexistent2", "nonexistent3");
        assertFalse(modified);
    }

    @Test
    void testRemoveAll_ThreeKeysWithDifferentValues() {
        boolean modified = multiKeyMap.removeAll("key4", "key5", "key6");
        assertTrue(modified);
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key4", "key5", "key6")));
    }

    @Test
    void testRemoveAll_OnlyThreeKeys() {
        boolean modified = multiKeyMap.removeAll("key1", "key2", "key3");
        assertTrue(modified);
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key1", "key2", "key3")));
    }

    @Test
    void testRemoveAll_MultipleKeys() {
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value5");
        multiKeyMap.put(new MultiKey<>("key1", "key2", "key3"), "value6");
        boolean modified = multiKeyMap.removeAll("key1", "key2", "key3");
        assertTrue(modified);
        assertFalse(multiKeyMap.containsKey(new MultiKey<>("key1", "key2", "key3")));
    }

    @Test
    void testRemoveAll_EmptyMap() {
        MultiKeyMap emptyMap = new MultiKeyMap();
        boolean modified = emptyMap.removeAll("key1", "key2", "key3");
        assertFalse(modified);
    }

    // Reflection test to invoke private method if necessary
    private Object invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = MultiKeyMap.class.getDeclaredMethod(methodName, Object.class, Object.class, Object.class);
        method.setAccessible(true);
        return method.invoke(multiKeyMap, args);
    }
}
