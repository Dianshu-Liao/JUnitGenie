package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.AbstractHashedMap;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
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
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

class AbstractHashedMap_createEntrySetIterator_11_2_Test {

    private AbstractHashedMap<String, String> abstractHashedMap;

    @BeforeEach
    void setUp() {
        abstractHashedMap = new AbstractHashedMap<String, String>() {
        };
    }

    @Test
    void testCreateEntrySetIterator_EmptyMap() {
        Iterator<Map.Entry<String, String>> iterator = invokeCreateEntrySetIterator();
        assertNotNull(iterator);
        assertFalse(iterator.hasNext(), "Iterator should be empty for an empty map");
    }

    @Test
    void testCreateEntrySetIterator_NonEmptyMap() {
        // Add entries to the map using reflection
        addEntry("key1", "value1");
        addEntry("key2", "value2");
        Iterator<Map.Entry<String, String>> iterator = invokeCreateEntrySetIterator();
        assertNotNull(iterator);
        assertTrue(iterator.hasNext(), "Iterator should have entries after adding them");
        Map.Entry<String, String> entry = iterator.next();
        assertEquals("key1", entry.getKey());
        assertEquals("value1", entry.getValue());
        entry = iterator.next();
        assertEquals("key2", entry.getKey());
        assertEquals("value2", entry.getValue());
    }

    private Iterator<Map.Entry<String, String>> invokeCreateEntrySetIterator() {
        try {
            Method method = AbstractHashedMap.class.getDeclaredMethod("createEntrySetIterator");
            method.setAccessible(true);
            return (Iterator<Map.Entry<String, String>>) method.invoke(abstractHashedMap);
        } catch (Exception e) {
            fail("Failed to invoke createEntrySetIterator: " + e.getMessage());
            // Unreachable but needed for compilation
            return null;
        }
    }

    private void addEntry(String key, String value) {
        try {
            Method putMethod = AbstractHashedMap.class.getDeclaredMethod("put", Object.class, Object.class);
            putMethod.setAccessible(true);
            putMethod.invoke(abstractHashedMap, key, value);
        } catch (Exception e) {
            fail("Failed to add entry: " + e.getMessage());
        }
    }
}
