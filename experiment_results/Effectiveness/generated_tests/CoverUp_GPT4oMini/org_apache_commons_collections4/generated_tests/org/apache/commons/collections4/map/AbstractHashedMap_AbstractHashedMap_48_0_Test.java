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

class AbstractHashedMap_AbstractHashedMap_48_0_Test {

    private AbstractHashedMap<Integer, String> map;

    @BeforeEach
    void setUp() {
        // Using reflection to access the protected constructor
        try {
            Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class, float.class, int.class);
            constructor.setAccessible(true);
            map = constructor.newInstance(16, 0.75f, 12);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testConstructorWithValidParameters() {
        assertNotNull(map);
    }

    @Test
    void testConstructorWithNegativeInitialCapacity() {
        assertThrows(IllegalArgumentException.class, () -> {
            Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class, float.class, int.class);
            constructor.setAccessible(true);
            constructor.newInstance(-1, 0.75f, 12);
        });
    }

    @Test
    void testConstructorWithZeroLoadFactor() {
        assertThrows(IllegalArgumentException.class, () -> {
            Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class, float.class, int.class);
            constructor.setAccessible(true);
            constructor.newInstance(16, 0.0f, 12);
        });
    }

    @Test
    void testConstructorWithNaNLoadFactor() {
        assertThrows(IllegalArgumentException.class, () -> {
            Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class, float.class, int.class);
            constructor.setAccessible(true);
            constructor.newInstance(16, Float.NaN, 12);
        });
    }

    @Test
    void testConstructorWithValidParametersThreshold() {
        AbstractHashedMap<Integer, String> mapWithValidThreshold = null;
        try {
            Constructor<AbstractHashedMap> constructor = AbstractHashedMap.class.getDeclaredConstructor(int.class, float.class, int.class);
            constructor.setAccessible(true);
            mapWithValidThreshold = constructor.newInstance(16, 0.75f, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(mapWithValidThreshold);
    }
}
