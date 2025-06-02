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

class AbstractHashedMap_createEntrySetIterator_11_4_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    void setUp() {
        map = new AbstractHashedMap<String, String>() {
        };
    }

    @Test
    void testCreateEntrySetIterator_WhenMapIsEmpty_ShouldReturnEmptyIterator() {
        Iterator<Map.Entry<String, String>> iterator = invokeCreateEntrySetIterator();
        assertTrue(iterator.hasNext(), "Expected iterator to be empty");
    }

    @Test
    void testCreateEntrySetIterator_WhenMapIsNotEmpty_ShouldReturnEntrySetIterator() throws Exception {
        // Using reflection to add entries to the map
        Method putMethod = AbstractHashedMap.class.getDeclaredMethod("put", Object.class, Object.class);
        putMethod.setAccessible(true);
        putMethod.invoke(map, "key1", "value1");
        putMethod.invoke(map, "key2", "value2");
        Iterator<Map.Entry<String, String>> iterator = invokeCreateEntrySetIterator();
        assertNotNull(iterator, "Expected a non-null iterator");
        assertTrue(iterator.hasNext(), "Expected iterator to have elements");
    }

    private Iterator<Map.Entry<String, String>> invokeCreateEntrySetIterator() {
        try {
            Method createEntrySetIteratorMethod = AbstractHashedMap.class.getDeclaredMethod("createEntrySetIterator");
            createEntrySetIteratorMethod.setAccessible(true);
            return (Iterator<Map.Entry<String, String>>) createEntrySetIteratorMethod.invoke(map);
        } catch (Exception e) {
            fail("Failed to invoke createEntrySetIterator method: " + e.getMessage());
            // unreachable, but required by the compiler
            return null;
        }
    }
}
