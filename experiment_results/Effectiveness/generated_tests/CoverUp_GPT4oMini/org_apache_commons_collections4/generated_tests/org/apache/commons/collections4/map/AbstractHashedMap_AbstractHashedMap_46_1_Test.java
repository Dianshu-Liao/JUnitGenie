package org.apache.commons.collections4.map;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

class AbstractHashedMap_AbstractHashedMap_46_1_Test {

    private AbstractHashedMap<?, ?> abstractHashedMap;

    @BeforeEach
    void setUp() {
        // No initialization needed in this case for the test
    }

    @Test
    void testConstructorWithValidCapacity() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Arrange
        int initialCapacity = 32;
        // Act
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        abstractHashedMap = constructor.newInstance(initialCapacity);
        // Assert
        assertNotNull(abstractHashedMap);
        assertEquals(0, abstractHashedMap.size());
        // Default capacity should be 16 if not overridden
        assertEquals(16, abstractHashedMap.data.length);
    }

    @Test
    void testConstructorWithZeroCapacity() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Arrange
        int initialCapacity = 0;
        // Act
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        abstractHashedMap = constructor.newInstance(initialCapacity);
        // Assert
        assertNotNull(abstractHashedMap);
        assertEquals(0, abstractHashedMap.size());
        // Default capacity should be 16 if not overridden
        assertEquals(16, abstractHashedMap.data.length);
    }

    @Test
    void testConstructorWithNegativeCapacity() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Arrange
        int initialCapacity = -5;
        // Act
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        abstractHashedMap = constructor.newInstance(initialCapacity);
        // Assert
        assertNotNull(abstractHashedMap);
        assertEquals(0, abstractHashedMap.size());
        // Default capacity should be 16 if not overridden
        assertEquals(16, abstractHashedMap.data.length);
    }

    @Test
    void testConstructorWithLargeCapacity() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Arrange
        int initialCapacity = 100000;
        // Act
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        abstractHashedMap = constructor.newInstance(initialCapacity);
        // Assert
        assertNotNull(abstractHashedMap);
        assertEquals(0, abstractHashedMap.size());
        // Capacity should be at least the initial capacity
        assertTrue(abstractHashedMap.data.length >= initialCapacity);
    }

    @Test
    void testConstructorWithMaximumCapacity() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Arrange
        int initialCapacity = Integer.MAX_VALUE;
        // Act
        Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        abstractHashedMap = constructor.newInstance(initialCapacity);
        // Assert
        assertNotNull(abstractHashedMap);
        assertEquals(0, abstractHashedMap.size());
        // Should not exceed maximum capacity
        assertEquals(1 << 30, abstractHashedMap.data.length);
    }
}
