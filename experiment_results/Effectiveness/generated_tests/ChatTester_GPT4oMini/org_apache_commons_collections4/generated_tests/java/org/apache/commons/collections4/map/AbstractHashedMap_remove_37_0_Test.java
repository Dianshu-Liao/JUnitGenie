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
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

class AbstractHashedMap_remove_37_0_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    void setUp() {
        map = new AbstractHashedMap<>(16, 0.75f);
    }

    @Test
    void testRemoveExistingKey() throws Exception {
        // Setup: Add an entry to the map
        String key = "key1";
        String value = "value1";
        // Assuming an `add` method exists for setup
        invokeAddMethod(map, key, value);
        // Execute: Remove the entry
        String removedValue = map.remove(key);
        // Verify: The value should be the same as added
        assertEquals(value, removedValue);
        // Verify: The entry should no longer exist
        assertNull(map.remove(key));
    }

    @Test
    void testRemoveNonExistingKey() {
        // Execute: Attempt to remove a non-existing key
        String removedValue = map.remove("non_existing_key");
        // Verify: The return value should be null
        assertNull(removedValue);
    }

    @Test
    void testRemoveNullKey() {
        // Execute: Attempt to remove a null key
        String removedValue = map.remove(null);
        // Verify: The return value should be null
        assertNull(removedValue);
    }

    @Test
    void testRemoveKeyWithCollision() throws Exception {
        // Setup: Add entries that will collide
        String key1 = "key1";
        String value1 = "value1";
        // Assume this collides with key1
        String key2 = "key2";
        String value2 = "value2";
        invokeAddMethod(map, key1, value1);
        invokeAddMethod(map, key2, value2);
        // Execute: Remove the first entry
        String removedValue = map.remove(key1);
        // Verify: The value should be the same as added
        assertEquals(value1, removedValue);
        // Verify: The first entry should no longer exist
        assertNull(map.remove(key1));
        // Verify: The second entry should still exist
        assertEquals(value2, map.remove(key2));
    }

    // Helper method to invoke private methods (like add)
    private void invokeAddMethod(AbstractHashedMap map, String key, String value) throws Exception {
        java.lang.reflect.Method method = AbstractHashedMap.class.getDeclaredMethod("add", Object.class, Object.class);
        method.setAccessible(true);
        method.invoke(map, key, value);
    }
}
