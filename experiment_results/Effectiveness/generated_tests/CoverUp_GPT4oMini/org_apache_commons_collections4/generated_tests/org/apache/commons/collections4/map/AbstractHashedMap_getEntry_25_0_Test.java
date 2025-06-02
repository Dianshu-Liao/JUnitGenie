package org.apache.commons.collections4.map;

import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

@ExtendWith(MockitoExtension.class)
class AbstractHashedMap_getEntry_25_0_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    void setUp() {
        map = new AbstractHashedMap<String, String>(16, 0.75f) {

            @Override
            protected HashEntry<String, String> getEntry(Object key) {
                return super.getEntry(key);
            }
        };
    }

    @Test
    void testGetEntryReturnsNullForNonExistentKey() throws Exception {
        // Arrange
        String nonExistentKey = "nonExistentKey";
        // Act
        HashEntry<String, String> entry = invokeGetEntry(nonExistentKey);
        // Assert
        assertNull(entry);
    }

    @Test
    void testGetEntryReturnsEntryForExistingKey() throws Exception {
        // Arrange
        String existingKey = "existingKey";
        String value = "value";
        map.put(existingKey, value);
        // Act
        HashEntry<String, String> entry = invokeGetEntry(existingKey);
        // Assert
        assertNotNull(entry);
        assertEquals(existingKey, entry.key);
        assertEquals(value, entry.value);
    }

    @Test
    void testGetEntryHandlesNullKey() throws Exception {
        // Arrange
        String nullKey = null;
        map.put(nullKey, "nullValue");
        // Act
        HashEntry<String, String> entry = invokeGetEntry(nullKey);
        // Assert
        assertNotNull(entry);
        assertEquals("nullValue", entry.value);
    }

    private HashEntry<String, String> invokeGetEntry(Object key) throws Exception {
        Method method = AbstractHashedMap.class.getDeclaredMethod("getEntry", Object.class);
        method.setAccessible(true);
        return (HashEntry<String, String>) method.invoke(map, key);
    }

    // Assuming HashEntry is a nested class within AbstractHashedMap
    static class HashEntry<K, V> {

        final K key;

        final V value;

        final int hashCode;

        HashEntry<K, V> next;

        HashEntry(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }
    }
}
