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

public class AbstractHashedMap_getEntry_25_2_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    public void setUp() throws Exception {
        map = new AbstractHashedMap<>(16);
        // Add entries to the map for testing
        invokePut("key1", "value1");
        invokePut("key2", "value2");
        invokePut(null, "valueForNull");
    }

    @Test
    public void testGetEntryWithExistingKey() throws Exception {
        HashEntry<String, String> entry = invokeGetEntry("key1");
        assertNotNull(entry);
        assertEquals("key1", entry.key);
        assertEquals("value1", entry.value);
    }

    @Test
    public void testGetEntryWithNonExistingKey() throws Exception {
        HashEntry<String, String> entry = invokeGetEntry("nonExistingKey");
        assertNull(entry);
    }

    @Test
    public void testGetEntryWithNullKey() throws Exception {
        HashEntry<String, String> entry = invokeGetEntry(null);
        assertNotNull(entry);
        assertEquals(AbstractHashedMap.NULL, entry.key);
        assertEquals("valueForNull", entry.value);
    }

    private HashEntry<String, String> invokeGetEntry(Object key) throws Exception {
        Method method = AbstractHashedMap.class.getDeclaredMethod("getEntry", Object.class);
        method.setAccessible(true);
        return (HashEntry<String, String>) method.invoke(map, key);
    }

    private void invokePut(String key, String value) throws Exception {
        Method method = AbstractHashedMap.class.getDeclaredMethod("put", Object.class, Object.class);
        method.setAccessible(true);
        method.invoke(map, key, value);
    }

    // Inner class to simulate HashEntry
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
