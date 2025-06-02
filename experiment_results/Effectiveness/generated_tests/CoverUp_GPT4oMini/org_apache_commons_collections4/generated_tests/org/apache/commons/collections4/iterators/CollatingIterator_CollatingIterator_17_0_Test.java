package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.CollatingIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.list.UnmodifiableList;

class CollatingIterator_CollatingIterator_17_0_Test {

    private CollatingIterator<Integer> collatingIterator;

    @BeforeEach
    void setUp() {
        collatingIterator = new CollatingIterator<>(Integer::compareTo);
    }

    @Test
    void testConstructorWithComparator() {
        Comparator<Integer> comparator = Integer::compareTo;
        CollatingIterator<Integer> iterator = new CollatingIterator<>(comparator);
        assertNotNull(iterator);
        assertEquals(comparator, iterator.getComparator());
    }

    @Test
    void testAddIterator() {
        Iterator<Integer> iterator1 = Arrays.asList(1, 3, 5).iterator();
        Iterator<Integer> iterator2 = Arrays.asList(2, 4, 6).iterator();
        collatingIterator.addIterator(iterator1);
        collatingIterator.addIterator(iterator2);
        assertEquals(2, collatingIterator.getIterators().size());
    }

    @Test
    void testHasNext() {
        Iterator<Integer> iterator1 = Arrays.asList(1, 3).iterator();
        Iterator<Integer> iterator2 = Arrays.asList(2, 4).iterator();
        collatingIterator.addIterator(iterator1);
        collatingIterator.addIterator(iterator2);
        assertTrue(collatingIterator.hasNext());
    }

    @Test
    void testNext() {
        Iterator<Integer> iterator1 = Arrays.asList(1, 3).iterator();
        Iterator<Integer> iterator2 = Arrays.asList(2, 4).iterator();
        collatingIterator.addIterator(iterator1);
        collatingIterator.addIterator(iterator2);
        assertEquals(1, collatingIterator.next());
        assertEquals(2, collatingIterator.next());
    }

    @Test
    void testNextThrowsNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> collatingIterator.next());
    }

    @Test
    void testRemove() {
        Iterator<Integer> iterator1 = Arrays.asList(1, 3).iterator();
        collatingIterator.addIterator(iterator1);
        // Initialize the iterator state
        collatingIterator.hasNext();
        // Move to the first element
        collatingIterator.next();
        // Remove the last returned element
        collatingIterator.remove();
        // Check if the element is removed
        assertFalse(iterator1.hasNext());
    }

    @Test
    void testGetIteratorIndexThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> collatingIterator.getIteratorIndex());
    }

    @Test
    void testSetComparator() {
        Comparator<Integer> comparator = Integer::compareTo;
        collatingIterator.setComparator(comparator);
        assertEquals(comparator, collatingIterator.getComparator());
    }
}
