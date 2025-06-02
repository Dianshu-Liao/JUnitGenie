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

public class AbstractHashedMap_AbstractHashedMap_46_0_Test {

    private AbstractHashedMap<?, ?> map;

    @BeforeEach
    public void setUp() {
        // Initialize the map with default capacity
        map = new AbstractHashedMap<>(AbstractHashedMap.DEFAULT_CAPACITY);
    }

    @Test
    public void testConstructorWithDefaultLoadFactor() {
        AbstractHashedMap<?, ?> mapWithLoadFactor = new AbstractHashedMap<>(16, 0.75f);
        assertEquals(16, mapWithLoadFactor.data.length);
    }

    @Test
    public void testConstructorWithInitialCapacity() {
        AbstractHashedMap<?, ?> mapWithCapacity = new AbstractHashedMap<>(32);
        assertEquals(32, mapWithCapacity.data.length);
    }

    @Test
    public void testConstructorWithInitialCapacityAndLoadFactor() {
        AbstractHashedMap<?, ?> mapWithCapacityAndLoadFactor = new AbstractHashedMap<>(32, 0.5f);
        assertEquals(32, mapWithCapacityAndLoadFactor.data.length);
    }

    @Test
    public void testConstructorWithInitialCapacityLoadFactorAndThreshold() {
        AbstractHashedMap<?, ?> mapWithAllParams = new AbstractHashedMap<>(32, 0.5f, 20);
        assertEquals(32, mapWithAllParams.data.length);
        assertEquals(20, mapWithAllParams.threshold);
    }

    @Test
    public void testConstructorWithMap() {
        // Assuming we have a concrete implementation of AbstractHashedMap to test with
        // This test is a placeholder as we need a concrete implementation
        // Map<String, String> initialMap = new HashMap<>();
        // initialMap.put("key", "value");
        // AbstractHashedMap<String, String> mapWithExistingMap = new AbstractHashedMap<>(initialMap);
        // assertEquals(1, mapWithExistingMap.size());
    }

    @Test
    public void testConstructorWithInvalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AbstractHashedMap<>(-1);
        });
    }

    @Test
    public void testConstructorWithInvalidLoadFactor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AbstractHashedMap<>(16, 0);
        });
    }

    @Test
    public void testConstructorWithInvalidThreshold() {
        assertThrows(IllegalArgumentException.class, () -> {
            new AbstractHashedMap<>(16, 0.75f, -1);
        });
    }
}
