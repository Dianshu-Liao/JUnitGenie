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

class AbstractHashedMap_createEntrySetIterator_11_1_Test {

    private AbstractHashedMap<String, String> abstractHashedMap;

    @BeforeEach
    void setUp() {
        abstractHashedMap = new AbstractHashedMap<String, String>() {
        };
    }

    @Test
    void testCreateEntrySetIterator_EmptyMap_ReturnsEmptyIterator() {
        Iterator<Map.Entry<String, String>> iterator = invokeCreateEntrySetIterator();
        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
    }

    @Test
    void testCreateEntrySetIterator_NonEmptyMap_ReturnsIterator() {
        // Prepare the map with a single entry
        abstractHashedMap.put("key1", "value1");
        Iterator<Map.Entry<String, String>> iterator = invokeCreateEntrySetIterator();
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        Map.Entry<String, String> entry = iterator.next();
        assertEquals("key1", entry.getKey());
        assertEquals("value1", entry.getValue());
    }

    private Iterator<Map.Entry<String, String>> invokeCreateEntrySetIterator() {
        try {
            Method method = AbstractHashedMap.class.getDeclaredMethod("createEntrySetIterator");
            method.setAccessible(true);
            return (Iterator<Map.Entry<String, String>>) method.invoke(abstractHashedMap);
        } catch (Exception e) {
            fail("Reflection invocation failed: " + e.getMessage());
            // This line will never be reached due to fail()
            return null;
        }
    }
}
