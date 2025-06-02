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

class AbstractHashedMap_getEntry_25_1_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    void setUp() {
        map = new AbstractHashedMap<>(16, 0.75f);
    }

    @Test
    void testGetEntryWithExistingKey() throws Exception {
        invokePutMethod(map, "key1", "value1");
        HashEntry<String, String> entry = invokeGetEntry(map, "key1");
        assertNotNull(entry);
        assertEquals("key1", entry.key);
        assertEquals("value1", entry.value);
    }

    @Test
    void testGetEntryWithNonExistingKey() throws Exception {
        HashEntry<String, String> entry = invokeGetEntry(map, "nonExistingKey");
        assertNull(entry);
    }

    @Test
    void testGetEntryWithNullKey() throws Exception {
        invokePutMethod(map, null, "nullValue");
        HashEntry<String, String> entry = invokeGetEntry(map, null);
        assertNotNull(entry);
        assertEquals(AbstractHashedMap.NULL, entry.key);
        assertEquals("nullValue", entry.value);
    }

    private HashEntry<String, String> invokeGetEntry(AbstractHashedMap<String, String> map, Object key) throws Exception {
        Method method = AbstractHashedMap.class.getDeclaredMethod("getEntry", Object.class);
        method.setAccessible(true);
        return (HashEntry<String, String>) method.invoke(map, key);
    }

    private void invokePutMethod(AbstractHashedMap<String, String> map, String key, String value) throws Exception {
        Method putMethod = AbstractHashedMap.class.getDeclaredMethod("put", Object.class, Object.class);
        putMethod.setAccessible(true);
        putMethod.invoke(map, key, value);
    }

    private static class HashEntry<K, V> {

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
