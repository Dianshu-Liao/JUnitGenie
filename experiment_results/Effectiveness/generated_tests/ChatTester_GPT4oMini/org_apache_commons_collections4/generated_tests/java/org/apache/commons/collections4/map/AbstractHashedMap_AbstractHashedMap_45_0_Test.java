package org.apache.commons.collections4.map;

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
// Importing HashMap to fix the bug
import java.util.HashMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractHashedMap_AbstractHashedMap_45_0_Test {

    private AbstractHashedMap<Object, Object> map;

    @BeforeEach
    void setUp() {
        map = new AbstractHashedMap<>();
    }

    @Test
    void testConstructor_Default() {
        assertNotNull(map);
        assertEquals(0, map.size);
        assertEquals(AbstractHashedMap.DEFAULT_CAPACITY, map.data.length);
        assertEquals(AbstractHashedMap.DEFAULT_THRESHOLD, map.threshold);
        assertEquals(AbstractHashedMap.DEFAULT_LOAD_FACTOR, map.loadFactor);
    }

    @Test
    void testConstructor_WithInitialCapacity() {
        AbstractHashedMap<Object, Object> mapWithCapacity = new AbstractHashedMap<>(32);
        assertNotNull(mapWithCapacity);
        assertEquals(0, mapWithCapacity.size);
        assertEquals(32, mapWithCapacity.data.length);
    }

    @Test
    void testConstructor_WithInitialCapacityAndLoadFactor() {
        AbstractHashedMap<Object, Object> mapWithCapacityAndLoadFactor = new AbstractHashedMap<>(32, 0.5f);
        assertNotNull(mapWithCapacityAndLoadFactor);
        assertEquals(0, mapWithCapacityAndLoadFactor.size);
        assertEquals(32, mapWithCapacityAndLoadFactor.data.length);
        assertEquals(0.5f, mapWithCapacityAndLoadFactor.loadFactor);
    }

    @Test
    void testConstructor_WithMap() {
        // Fixed line
        Map<String, String> sampleMap = new HashMap<>();
        sampleMap.put("key1", "value1");
        sampleMap.put("key2", "value2");
        AbstractHashedMap<String, String> mapFromExisting = new AbstractHashedMap<>(sampleMap);
        assertNotNull(mapFromExisting);
        assertEquals(2, mapFromExisting.size);
        assertEquals("value1", mapFromExisting.get("key1"));
        assertEquals("value2", mapFromExisting.get("key2"));
    }
}
