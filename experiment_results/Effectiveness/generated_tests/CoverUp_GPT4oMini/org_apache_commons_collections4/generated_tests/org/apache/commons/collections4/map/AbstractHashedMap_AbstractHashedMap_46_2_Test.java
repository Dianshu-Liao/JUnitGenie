package org.apache.commons.collections4.map;

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

public class AbstractHashedMap_AbstractHashedMap_46_2_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    public void setUp() {
        // Using the focal method
        map = new AbstractHashedMap<>(16);
    }

    @Test
    public void testInitialCapacity() {
        // Verify the initial capacity is set correctly
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    public void testAddEntryIncreasesSize() {
        map.put("key1", "value1");
        assertEquals(1, map.size());
        assertFalse(map.isEmpty());
    }

    @Test
    public void testPutAndGet() {
        map.put("key1", "value1");
        assertEquals("value1", map.get("key1"));
        // Non-existent key
        assertNull(map.get("key2"));
    }

    @Test
    public void testPutUpdatesValue() {
        map.put("key1", "value1");
        map.put("key1", "value2");
        assertEquals("value2", map.get("key1"));
    }

    @Test
    public void testSizeAfterClear() {
        map.put("key1", "value1");
        map.clear();
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    public void testContainsKey() {
        map.put("key1", "value1");
        assertTrue(map.containsKey("key1"));
        assertFalse(map.containsKey("key2"));
    }

    @Test
    public void testContainsValue() {
        map.put("key1", "value1");
        assertTrue(map.containsValue("value1"));
        assertFalse(map.containsValue("value2"));
    }

    @Test
    public void testRemove() {
        map.put("key1", "value1");
        assertEquals("value1", map.remove("key1"));
        assertNull(map.get("key1"));
        assertEquals(0, map.size());
    }

    @Test
    public void testHashCodeAndEquals() {
        AbstractHashedMap<String, String> anotherMap = new AbstractHashedMap<>(16);
        map.put("key1", "value1");
        anotherMap.put("key1", "value1");
        assertEquals(map.hashCode(), anotherMap.hashCode());
        assertTrue(map.equals(anotherMap));
    }

    @Test
    public void testPutAll() {
        AbstractHashedMap<String, String> anotherMap = new AbstractHashedMap<>(16);
        anotherMap.put("key1", "value1");
        anotherMap.put("key2", "value2");
        map.putAll(anotherMap);
        assertEquals(2, map.size());
        assertEquals("value1", map.get("key1"));
        assertEquals("value2", map.get("key2"));
    }
}
