package org.apache.commons.collections4.map;

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

public class AbstractHashedMap_AbstractHashedMap_49_0_Test {

    private AbstractHashedMap<String, String> abstractHashedMap;

    @BeforeEach
    public void setUp() {
        // Create a sample map to initialize AbstractHashedMap
        Map<String, String> sampleMap = new HashMap<>();
        sampleMap.put("key1", "value1");
        sampleMap.put("key2", "value2");
        abstractHashedMap = new AbstractHashedMap<>(sampleMap);
    }

    @Test
    public void testConstructorWithMap() {
        assertNotNull(abstractHashedMap);
        assertEquals(2, abstractHashedMap.size());
    }

    @Test
    public void testConstructorWithEmptyMap() {
        AbstractHashedMap<String, String> emptyMap = new AbstractHashedMap<>(new HashMap<>());
        assertNotNull(emptyMap);
        assertEquals(0, emptyMap.size());
    }

    @Test
    public void testConstructorWithInitialCapacity() {
        AbstractHashedMap<String, String> mapWithCapacity = new AbstractHashedMap<>(10);
        assertNotNull(mapWithCapacity);
    }

    @Test
    public void testConstructorWithInitialCapacityAndLoadFactor() {
        AbstractHashedMap<String, String> mapWithCapacityAndLoadFactor = new AbstractHashedMap<>(10, 0.75f);
        assertNotNull(mapWithCapacityAndLoadFactor);
    }

    @Test
    public void testConstructorWithNegativeInitialCapacity() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new AbstractHashedMap<>(-1);
        });
        assertEquals("Initial capacity must be a non negative number", exception.getMessage());
    }

    @Test
    public void testConstructorWithZeroLoadFactor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new AbstractHashedMap<>(10, 0.0f);
        });
        assertEquals("Load factor must be greater than 0", exception.getMessage());
    }

    @Test
    public void testConstructorWithNaNLoadFactor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new AbstractHashedMap<>(10, Float.NaN);
        });
        assertEquals("Load factor must be greater than 0", exception.getMessage());
    }

    @Test
    public void testPutAll() {
        Map<String, String> newMap = new HashMap<>();
        newMap.put("key3", "value3");
        abstractHashedMap.putAll(newMap);
        assertEquals(3, abstractHashedMap.size());
        assertEquals("value3", abstractHashedMap.get("key3"));
    }

    @Test
    public void testSize() {
        assertEquals(2, abstractHashedMap.size());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(abstractHashedMap.isEmpty());
        AbstractHashedMap<String, String> emptyMap = new AbstractHashedMap<>(new HashMap<>());
        assertTrue(emptyMap.isEmpty());
    }
}
