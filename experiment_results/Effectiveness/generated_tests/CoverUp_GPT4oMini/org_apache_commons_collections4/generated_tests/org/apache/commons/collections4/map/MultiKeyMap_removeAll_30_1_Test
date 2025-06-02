package org.apache.commons.collections4.map;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;
import java.lang.reflect.Method;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MultiKeyMap_removeAll_30_1_Test {

    private MultiKeyMap<String, String> multiKeyMap;

    @BeforeEach
    void setUp() {
        multiKeyMap = new MultiKeyMap<>();
    }

    @Test
    void testRemoveAll_KeyExists() throws Exception {
        // Setup
        multiKeyMap.put(new MultiKey<>(new String[] { "key1" }), "value1");
        multiKeyMap.put(new MultiKey<>(new String[] { "key2" }), "value2");
        multiKeyMap.put(new MultiKey<>(new String[] { "key1", "key3" }), "value3");
        // Act
        boolean modified = invokeRemoveAll("key1");
        // Assert
        assertTrue(modified);
        assertFalse(multiKeyMap.containsKey(new MultiKey<>(new String[] { "key1" })));
        assertFalse(multiKeyMap.containsKey(new MultiKey<>(new String[] { "key1", "key3" })));
        assertTrue(multiKeyMap.containsKey(new MultiKey<>(new String[] { "key2" })));
    }

    @Test
    void testRemoveAll_KeyDoesNotExist() throws Exception {
        // Setup
        multiKeyMap.put(new MultiKey<>(new String[] { "key2" }), "value2");
        // Act
        boolean modified = invokeRemoveAll("key1");
        // Assert
        assertFalse(modified);
        assertTrue(multiKeyMap.containsKey(new MultiKey<>(new String[] { "key2" })));
    }

    @Test
    void testRemoveAll_EmptyMap() throws Exception {
        // Act
        boolean modified = invokeRemoveAll("key1");
        // Assert
        assertFalse(modified);
    }

    @Test
    void testRemoveAll_NullKey() throws Exception {
        // Setup
        multiKeyMap.put(new MultiKey<>(new String[] { "key1" }), "value1");
        multiKeyMap.put(new MultiKey<>(new String[] { null }), "value2");
        // Act
        boolean modified = invokeRemoveAll(null);
        // Assert
        assertTrue(modified);
        assertFalse(multiKeyMap.containsKey(new MultiKey<>(new String[] { null })));
        assertTrue(multiKeyMap.containsKey(new MultiKey<>(new String[] { "key1" })));
    }

    private boolean invokeRemoveAll(Object key) throws Exception {
        Method removeAllMethod = MultiKeyMap.class.getDeclaredMethod("removeAll", Object.class);
        removeAllMethod.setAccessible(true);
        return (boolean) removeAllMethod.invoke(multiKeyMap, key);
    }
}
