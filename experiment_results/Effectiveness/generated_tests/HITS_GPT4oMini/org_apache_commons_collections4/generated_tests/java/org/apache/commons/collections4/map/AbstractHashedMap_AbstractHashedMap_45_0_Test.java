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

class AbstractHashedMap_AbstractHashedMap_45_0_Test {

    private AbstractHashedMap<Integer, String> map;

    @BeforeEach
    void setUp() {
        map = new AbstractHashedMap<>(16, 0.75f, 12);
    }

    @Test
    void testDefaultConstructor() {
        AbstractHashedMap<Integer, String> defaultMap = new AbstractHashedMap<>();
        assertNotNull(defaultMap);
    }

    @Test
    void testConstructorWithInitialCapacity() {
        AbstractHashedMap<Integer, String> mapWithCapacity = new AbstractHashedMap<>(32);
        assertNotNull(mapWithCapacity);
    }

    @Test
    void testConstructorWithInitialCapacityAndLoadFactor() {
        AbstractHashedMap<Integer, String> mapWithCapacityAndLoadFactor = new AbstractHashedMap<>(32, 0.5f);
        assertNotNull(mapWithCapacityAndLoadFactor);
    }

    @Test
    void testConstructorWithMap() {
        Map<Integer, String> initialMap = new HashMap<>();
        initialMap.put(1, "One");
        initialMap.put(2, "Two");
        AbstractHashedMap<Integer, String> mapFromExisting = new AbstractHashedMap<>(initialMap);
        assertEquals(2, mapFromExisting.size());
    }

    @Test
    void testSize() {
        assertEquals(0, map.size());
        map.put(1, "One");
        assertEquals(1, map.size());
    }

    @Test
    void testThreshold() {
        assertEquals(12, map.threshold);
    }

    @Test
    void testLoadFactor() {
        assertEquals(0.75f, map.loadFactor);
    }

    @Test
    void testModCount() {
        assertEquals(0, map.modCount);
        map.put(1, "One");
        assertEquals(1, map.modCount);
    }

    @Test
    void testPutAndGet() {
        map.put(1, "One");
        assertEquals("One", map.get(1));
    }

    @Test
    void testPutNullValue() {
        map.put(1, null);
        assertNull(map.get(1));
    }

    @Test
    void testGetNonExistentKey() {
        assertNull(map.get(999));
    }

    @Test
    void testRemove() {
        map.put(1, "One");
        assertEquals("One", map.remove(1));
        assertNull(map.get(1));
    }

    @Test
    void testRemoveNonExistentKey() {
        assertNull(map.remove(999));
    }

    @Test
    void testClear() {
        map.put(1, "One");
        map.clear();
        assertEquals(0, map.size());
    }

    @Test
    void testIteration() {
        map.put(1, "One");
        map.put(2, "Two");
        int count = 0;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            count++;
        }
        assertEquals(2, count);
    }
}
