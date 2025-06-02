package org.apache.commons.collections4.map;

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

public class AbstractHashedMap_getEntry_25_1_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    public void setUp() {
        map = new AbstractHashedMap<>(16, 0.75f);
    }

    @Test
    public void testGetEntryReturnsNullForNonExistingKey() throws Exception {
        Method getEntryMethod = AbstractHashedMap.class.getDeclaredMethod("getEntry", Object.class);
        getEntryMethod.setAccessible(true);
        HashEntry<String, String> entry = (HashEntry<String, String>) getEntryMethod.invoke(map, "nonExistingKey");
        assertNull(entry);
    }

    @Test
    public void testGetEntryReturnsCorrectEntryForExistingKey() throws Exception {
        addEntryToMap("existingKey", "value");
        Method getEntryMethod = AbstractHashedMap.class.getDeclaredMethod("getEntry", Object.class);
        getEntryMethod.setAccessible(true);
        HashEntry<String, String> entry = (HashEntry<String, String>) getEntryMethod.invoke(map, "existingKey");
        assertNotNull(entry);
        assertEquals("existingKey", entry.key);
        assertEquals("value", entry.value);
    }

    @Test
    public void testGetEntryHandlesCollision() throws Exception {
        addEntryToMap("key1", "value1");
        // key2 collides with key1
        addEntryToMap("key2", "value2");
        Method getEntryMethod = AbstractHashedMap.class.getDeclaredMethod("getEntry", Object.class);
        getEntryMethod.setAccessible(true);
        HashEntry<String, String> entry1 = (HashEntry<String, String>) getEntryMethod.invoke(map, "key1");
        HashEntry<String, String> entry2 = (HashEntry<String, String>) getEntryMethod.invoke(map, "key2");
        assertNotNull(entry1);
        assertNotNull(entry2);
        assertEquals("value1", entry1.value);
        assertEquals("value2", entry2.value);
    }

    // Helper method to simulate adding entries to the map
    private void addEntryToMap(String key, String value) {
        try {
            Method putMethod = AbstractHashedMap.class.getDeclaredMethod("put", Object.class, Object.class);
            putMethod.setAccessible(true);
            putMethod.invoke(map, key, value);
        } catch (Exception e) {
            fail("Failed to add entry to map: " + e.getMessage());
        }
    }

    // Define the HashEntry class as a static inner class for testing purposes
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
