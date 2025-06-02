package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.CollatingIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Comparator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.apache.commons.collections4.list.UnmodifiableList;

class CollatingIterator_CollatingIterator_16_0_Test {

    private CollatingIterator<Integer> collatingIterator;

    @BeforeEach
    void setUp() {
        collatingIterator = new CollatingIterator<>(Integer::compareTo);
    }

    @Test
    void testEmptyIterators() {
        assertFalse(collatingIterator.hasNext());
        assertThrows(NoSuchElementException.class, collatingIterator::next);
    }

    @Test
    void testSingleIterator() {
        collatingIterator.addIterator(Arrays.asList(1, 3, 5).iterator());
        assertTrue(collatingIterator.hasNext());
        assertEquals(1, collatingIterator.next());
        assertEquals(3, collatingIterator.next());
        assertEquals(5, collatingIterator.next());
        assertFalse(collatingIterator.hasNext());
        assertThrows(NoSuchElementException.class, collatingIterator::next);
    }

    @Test
    void testMultipleIterators() {
        collatingIterator.addIterator(Arrays.asList(1, 4).iterator());
        collatingIterator.addIterator(Arrays.asList(2, 3).iterator());
        assertTrue(collatingIterator.hasNext());
        assertEquals(1, collatingIterator.next());
        assertEquals(2, collatingIterator.next());
        assertEquals(3, collatingIterator.next());
        assertEquals(4, collatingIterator.next());
        assertFalse(collatingIterator.hasNext());
        assertThrows(NoSuchElementException.class, collatingIterator::next);
    }

    @Test
    void testRemove() {
        collatingIterator.addIterator(Arrays.asList(1, 2, 3).iterator());
        // returns 1
        collatingIterator.next();
        // should remove 1
        collatingIterator.remove();
        // should return 2
        assertEquals(2, collatingIterator.next());
        // should return 3
        assertEquals(3, collatingIterator.next());
        assertFalse(collatingIterator.hasNext());
        assertThrows(NoSuchElementException.class, collatingIterator::next);
    }

    @Test
    void testSetComparator() {
        collatingIterator.addIterator(Arrays.asList(5, 1, 3).iterator());
        collatingIterator.setComparator(Collections.reverseOrder());
        assertTrue(collatingIterator.hasNext());
        assertEquals(5, collatingIterator.next());
        assertEquals(3, collatingIterator.next());
        assertEquals(1, collatingIterator.next());
        assertFalse(collatingIterator.hasNext());
    }

    @Test
    void testGetIteratorIndex() {
        collatingIterator.addIterator(Arrays.asList(1, 2).iterator());
        // returns 1
        collatingIterator.next();
        assertEquals(0, collatingIterator.getIteratorIndex());
        // returns 2
        collatingIterator.next();
        assertEquals(1, collatingIterator.getIteratorIndex());
    }

    @Test
    void testIllegalStateExceptionOnGetIteratorIndex() {
        assertThrows(IllegalStateException.class, collatingIterator::getIteratorIndex);
    }
}
