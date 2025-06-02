package org.apache.commons.collections4.map;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class AbstractHashedMap_AbstractHashedMap_45_0_Test {

    private AbstractHashedMap<String, String> map;

    @BeforeEach
    public void setUp() throws Exception {
        // Using reflection to create an instance of AbstractHashedMap
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        map = constructor.newInstance();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(map);
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    public void testConstructorWithInitialCapacity() throws Exception {
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        AbstractHashedMap<String, String> mapWithCapacity = constructor.newInstance(32);
        assertNotNull(mapWithCapacity);
        assertEquals(0, mapWithCapacity.size());
        assertTrue(mapWithCapacity.isEmpty());
    }

    @Test
    public void testConstructorWithInitialCapacityAndLoadFactor() throws Exception {
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class, float.class);
        constructor.setAccessible(true);
        AbstractHashedMap<String, String> mapWithCapacityAndLoadFactor = constructor.newInstance(32, 0.75f);
        assertNotNull(mapWithCapacityAndLoadFactor);
        assertEquals(0, mapWithCapacityAndLoadFactor.size());
        assertTrue(mapWithCapacityAndLoadFactor.isEmpty());
    }

    @Test
    public void testConstructorWithMap() throws Exception {
        Map<String, String> initialMap = new HashMap<>();
        initialMap.put("key1", "value1");
        initialMap.put("key2", "value2");
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(Map.class);
        constructor.setAccessible(true);
        AbstractHashedMap<String, String> mapWithInitialMap = constructor.newInstance(initialMap);
        assertNotNull(mapWithInitialMap);
        assertEquals(2, mapWithInitialMap.size());
        assertFalse(mapWithInitialMap.isEmpty());
        assertEquals("value1", mapWithInitialMap.get("key1"));
        assertEquals("value2", mapWithInitialMap.get("key2"));
    }
}
