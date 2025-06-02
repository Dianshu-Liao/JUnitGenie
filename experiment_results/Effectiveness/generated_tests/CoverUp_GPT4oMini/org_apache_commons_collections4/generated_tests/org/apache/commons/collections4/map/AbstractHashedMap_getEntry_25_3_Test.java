package org.apache.commons.collections4.map;

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

public class AbstractHashedMap_getEntry_25_3_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    public void setUp() {
        map = new AbstractHashedMap<String, String>(16, 0.75f) {
        };
        // Manually add entries to the map for testing
        try {
            Field dataField = AbstractHashedMap.class.getDeclaredField("data");
            dataField.setAccessible(true);
            HashEntry<String, String>[] data = (HashEntry<String, String>[]) new HashEntry[16];
            data[0] = new HashEntry<>("key1", "value1", "key1".hashCode(), null);
            data[1] = new HashEntry<>("key2", "value2", "key2".hashCode(), data[0]);
            dataField.set(map, data);
        } catch (Exception e) {
            fail("Setup failed due to reflection error: " + e.getMessage());
        }
    }

    @Test
    public void testGetEntryExistingKey() {
        HashEntry<String, String> entry = invokeGetEntry("key1");
        assertNotNull(entry);
        assertEquals("value1", entry.value);
    }

    @Test
    public void testGetEntryNonExistingKey() {
        HashEntry<String, String> entry = invokeGetEntry("nonExistingKey");
        assertNull(entry);
    }

    @Test
    public void testGetEntryNullKey() {
        HashEntry<String, String> entry = invokeGetEntry(null);
        assertNull(entry);
    }

    private HashEntry<String, String> invokeGetEntry(Object key) {
        try {
            Method method = AbstractHashedMap.class.getDeclaredMethod("getEntry", Object.class);
            method.setAccessible(true);
            return (HashEntry<String, String>) method.invoke(map, key);
        } catch (Exception e) {
            fail("Invocation failed due to reflection error: " + e.getMessage());
            // This will never be reached, fail will throw an exception
            return null;
        }
    }

    private static class HashEntry<K, V> {

        final K key;

        V value;

        final int hashCode;

        HashEntry<K, V> next;

        HashEntry(K key, V value, int hashCode, HashEntry<K, V> next) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
            this.next = next;
        }
    }
}
