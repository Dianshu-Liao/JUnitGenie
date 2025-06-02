package org.apache.commons.collections4.map;

import java.lang.reflect.Constructor;
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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractHashedMap_AbstractHashedMap_46_0_Test {

    private AbstractHashedMap<Object, Object> map;

    @BeforeEach
    public void setUp() throws Exception {
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        // Initialize with a capacity of 10
        map = constructor.newInstance(10);
    }

    @Test
    public void testConstructorWithValidCapacity() {
        assertNotNull(map);
        assertEquals(0, map.size());
    }

    @Test
    public void testConstructorWithDefaultLoadFactor() throws Exception {
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class, float.class);
        constructor.setAccessible(true);
        AbstractHashedMap<Object, Object> mapWithLoadFactor = constructor.newInstance(10, 0.75f);
        assertNotNull(mapWithLoadFactor);
        assertEquals(0, mapWithLoadFactor.size());
    }

    @Test
    public void testConstructorWithExceedingCapacity() throws Exception {
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        AbstractHashedMap<Object, Object> largeMap = constructor.newInstance(Integer.MAX_VALUE);
        assertNotNull(largeMap);
        assertEquals(0, largeMap.size());
    }

    @Test
    public void testAddEntryIncreasesSize() {
        map.put("key1", "value1");
        assertEquals(1, map.size());
        map.put("key2", "value2");
        assertEquals(2, map.size());
    }

    @Test
    public void testClearResetsSize() {
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.clear();
        assertEquals(0, map.size());
    }

    @Test
    public void testEnsureCapacity() throws Exception {
        for (int i = 0; i < 20; i++) {
            map.put("key" + i, "value" + i);
        }
        assertEquals(20, map.size());
    }

    @Test
    public void testPutAndGet() {
        map.put("key1", "value1");
        assertEquals("value1", map.get("key1"));
    }

    @Test
    public void testRemove() {
        map.put("key1", "value1");
        assertEquals("value1", map.remove("key1"));
        assertNull(map.get("key1"));
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
    public void testSizeAfterRemove() {
        map.put("key1", "value1");
        map.put("key2", "value2");
        assertEquals(2, map.size());
        map.remove("key1");
        assertEquals(1, map.size());
    }

    @Test
    public void testPutSameKeyUpdatesValue() {
        map.put("key1", "value1");
        map.put("key1", "value2");
        assertEquals("value2", map.get("key1"));
    }

    @Test
    public void testRemoveNonExistentKeyReturnsNull() {
        assertNull(map.remove("nonExistentKey"));
    }

    @Test
    public void testContainsKeyOnEmptyMap() {
        assertFalse(map.containsKey("key1"));
    }
}
