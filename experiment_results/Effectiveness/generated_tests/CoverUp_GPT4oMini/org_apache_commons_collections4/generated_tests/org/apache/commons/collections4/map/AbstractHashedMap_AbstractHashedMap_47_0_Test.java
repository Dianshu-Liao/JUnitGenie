package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.AbstractHashedMap;
import java.lang.reflect.Constructor;
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

class AbstractHashedMap_AbstractHashedMap_47_0_Test {

    private AbstractHashedMap<?, ?> map;

    @BeforeEach
    void setUp() {
        // No initialization needed for the test cases as we are testing the constructor directly
    }

    @Test
    void testConstructorWithValidParameters() throws Exception {
        // Test with valid initial capacity and load factor
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class, float.class);
        constructor.setAccessible(true);
        map = constructor.newInstance(16, 0.75f);
        assertNotNull(map);
        assertEquals(0.75f, map.loadFactor);
        assertEquals(16, map.data.length);
    }

    @Test
    void testConstructorWithNegativeInitialCapacity() throws Exception {
        // Test with negative initial capacity
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class, float.class);
        constructor.setAccessible(true);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            constructor.newInstance(-1, 0.75f);
        });
        assertEquals("Initial capacity must be a non negative number", thrown.getMessage());
    }

    @Test
    void testConstructorWithZeroLoadFactor() throws Exception {
        // Test with zero load factor
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class, float.class);
        constructor.setAccessible(true);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            constructor.newInstance(16, 0.0f);
        });
        assertEquals("Load factor must be greater than 0", thrown.getMessage());
    }

    @Test
    void testConstructorWithNaNLoadFactor() throws Exception {
        // Test with NaN load factor
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class, float.class);
        constructor.setAccessible(true);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            constructor.newInstance(16, Float.NaN);
        });
        assertEquals("Load factor must be greater than 0", thrown.getMessage());
    }

    @Test
    void testConstructorWithValidParametersAndCalculateNewCapacity() throws Exception {
        // Test with initial capacity that requires resizing
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class, float.class);
        constructor.setAccessible(true);
        map = constructor.newInstance(20, 0.75f);
        assertNotNull(map);
        assertEquals(0.75f, map.loadFactor);
        // 32 is the next power of 2 greater than 20
        assertEquals(32, map.data.length);
    }
}
