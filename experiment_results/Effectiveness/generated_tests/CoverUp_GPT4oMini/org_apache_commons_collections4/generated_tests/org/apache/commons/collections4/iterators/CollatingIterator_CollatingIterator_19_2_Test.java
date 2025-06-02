package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.CollatingIterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.BitSet;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.list.UnmodifiableList;

class CollatingIterator_CollatingIterator_19_2_Test {

    private CollatingIterator<Integer> collatingIterator;

    @BeforeEach
    void setUp() {
        // Initialize with a simple comparator and a capacity of 2
        collatingIterator = new CollatingIterator<>(Comparator.naturalOrder(), 2);
    }

    @Test
    void testConstructorWithValidComparatorAndCapacity() {
        assertNotNull(collatingIterator);
        assertEquals(2, collatingIterator.getIterators().size());
        assertNull(collatingIterator.getComparator());
    }

    @Test
    void testConstructorWithNullComparator() {
        CollatingIterator<Integer> iterator = new CollatingIterator<>(null, 2);
        assertNotNull(iterator);
        assertEquals(2, iterator.getIterators().size());
        assertNull(iterator.getComparator());
    }

    @Test
    void testConstructorWithZeroCapacity() {
        CollatingIterator<Integer> iterator = new CollatingIterator<>(Comparator.naturalOrder(), 0);
        assertNotNull(iterator);
        assertEquals(0, iterator.getIterators().size());
    }

    @Test
    void testConstructorWithNegativeCapacity() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CollatingIterator<>(Comparator.naturalOrder(), -1);
        });
        assertEquals("Capacity must be non-negative", exception.getMessage());
    }

    @Test
    void testSetComparator() {
        collatingIterator.setComparator(Comparator.reverseOrder());
        assertNotNull(collatingIterator.getComparator());
    }

    @Test
    void testSetComparatorWhenNotStarted() {
        collatingIterator.setComparator(Comparator.naturalOrder());
        assertEquals(Comparator.naturalOrder(), collatingIterator.getComparator());
    }
}
