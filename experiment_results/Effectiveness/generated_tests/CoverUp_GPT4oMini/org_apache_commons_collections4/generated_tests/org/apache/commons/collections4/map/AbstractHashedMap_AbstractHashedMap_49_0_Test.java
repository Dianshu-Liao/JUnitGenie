package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.AbstractHashedMap;
import java.util.HashMap;
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
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

class AbstractHashedMap_AbstractHashedMap_49_0_Test {

    private AbstractHashedMap<String, String> abstractHashedMap;

    @BeforeEach
    void setUp() {
        // Setup can be empty as we are testing the constructor directly
    }

    @Test
    void testConstructorWithEmptyMap() {
        Map<String, String> emptyMap = new HashMap<>();
        abstractHashedMap = new AbstractHashedMap<>(emptyMap);
        assertNotNull(abstractHashedMap);
        assertEquals(0, abstractHashedMap.size());
    }

    @Test
    void testConstructorWithSingleEntryMap() {
        Map<String, String> singleEntryMap = new HashMap<>();
        singleEntryMap.put("key1", "value1");
        abstractHashedMap = new AbstractHashedMap<>(singleEntryMap);
        assertNotNull(abstractHashedMap);
        assertEquals(1, abstractHashedMap.size());
        assertEquals("value1", abstractHashedMap.get("key1"));
    }

    @Test
    void testConstructorWithMultipleEntriesMap() {
        Map<String, String> multipleEntriesMap = new HashMap<>();
        multipleEntriesMap.put("key1", "value1");
        multipleEntriesMap.put("key2", "value2");
        abstractHashedMap = new AbstractHashedMap<>(multipleEntriesMap);
        assertNotNull(abstractHashedMap);
        assertEquals(2, abstractHashedMap.size());
        assertEquals("value1", abstractHashedMap.get("key1"));
        assertEquals("value2", abstractHashedMap.get("key2"));
    }

    @Test
    void testConstructorWithNullMap() {
        assertThrows(NullPointerException.class, () -> {
            abstractHashedMap = new AbstractHashedMap<>(null);
        });
    }

    @Test
    void testConstructorWithLargeMap() {
        Map<String, String> largeMap = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            largeMap.put("key" + i, "value" + i);
        }
        abstractHashedMap = new AbstractHashedMap<>(largeMap);
        assertNotNull(abstractHashedMap);
        assertEquals(100, abstractHashedMap.size());
        for (int i = 0; i < 100; i++) {
            assertEquals("value" + i, abstractHashedMap.get("key" + i));
        }
    }

    @Test
    void testConstructorWithMapContainingNullKey() {
        Map<String, String> mapWithNullKey = new HashMap<>();
        mapWithNullKey.put(null, "value1");
        abstractHashedMap = new AbstractHashedMap<>(mapWithNullKey);
        assertNotNull(abstractHashedMap);
        assertEquals(1, abstractHashedMap.size());
        assertEquals("value1", abstractHashedMap.get(null));
    }

    @Test
    void testConstructorWithMapContainingNullValue() {
        Map<String, String> mapWithNullValue = new HashMap<>();
        mapWithNullValue.put("key1", null);
        abstractHashedMap = new AbstractHashedMap<>(mapWithNullValue);
        assertNotNull(abstractHashedMap);
        assertEquals(1, abstractHashedMap.size());
        assertNull(abstractHashedMap.get("key1"));
    }
}
