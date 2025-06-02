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

class AbstractHashedMap_AbstractHashedMap_48_0_Test {

    @Test
    void testConstructorWithValidParameters() {
        int initialCapacity = 16;
        float loadFactor = 0.75f;
        int threshold = 12;
        AbstractHashedMap<Object, Object> map = new AbstractHashedMap<>(initialCapacity, loadFactor, threshold);
        assertEquals(loadFactor, map.loadFactor);
        assertEquals(threshold, map.threshold);
        assertEquals(0, map.size);
    }

    @Test
    void testConstructorWithNegativeInitialCapacity() {
        int initialCapacity = -1;
        float loadFactor = 0.75f;
        int threshold = 12;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new AbstractHashedMap<>(initialCapacity, loadFactor, threshold);
        });
        assertEquals("Initial capacity must be a non negative number", exception.getMessage());
    }

    @Test
    void testConstructorWithZeroLoadFactor() {
        int initialCapacity = 16;
        float loadFactor = 0.0f;
        int threshold = 12;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new AbstractHashedMap<>(initialCapacity, loadFactor, threshold);
        });
        assertEquals("Load factor must be greater than 0", exception.getMessage());
    }

    @Test
    void testConstructorWithNaNLoadFactor() {
        int initialCapacity = 16;
        float loadFactor = Float.NaN;
        int threshold = 12;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new AbstractHashedMap<>(initialCapacity, loadFactor, threshold);
        });
        assertEquals("Load factor must be greater than 0", exception.getMessage());
    }
}
