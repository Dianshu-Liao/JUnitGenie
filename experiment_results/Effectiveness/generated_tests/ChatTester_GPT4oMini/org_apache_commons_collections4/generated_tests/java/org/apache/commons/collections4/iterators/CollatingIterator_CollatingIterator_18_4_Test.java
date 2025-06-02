package org.apache.commons.collections4.iterators;

import java.util.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.list.UnmodifiableList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CollatingIterator_CollatingIterator_18_4_Test {

    private Comparator<Integer> comparator;

    private Collection<Iterator<Integer>> iterators;

    @BeforeEach
    void setUp() {
        comparator = Integer::compareTo;
        iterators = new ArrayList<>();
    }

    @Test
    void testCollatingIteratorWithEmptyCollection() {
        CollatingIterator collatingIterator = new CollatingIterator(comparator, iterators);
        assertFalse(collatingIterator.hasNext());
    }

    @Test
    void testCollatingIteratorWithSingleIterator() {
        iterators.add(Arrays.asList(1, 2, 3).iterator());
        CollatingIterator collatingIterator = new CollatingIterator(comparator, iterators);
        assertTrue(collatingIterator.hasNext());
        assertEquals(1, collatingIterator.next());
        assertEquals(2, collatingIterator.next());
        assertEquals(3, collatingIterator.next());
        assertFalse(collatingIterator.hasNext());
    }

    @Test
    void testCollatingIteratorWithMultipleIterators() {
        iterators.add(Arrays.asList(1, 4).iterator());
        iterators.add(Arrays.asList(2, 5).iterator());
        iterators.add(Arrays.asList(3, 6).iterator());
        CollatingIterator collatingIterator = new CollatingIterator(comparator, iterators);
        List<Integer> result = new ArrayList<>();
        while (collatingIterator.hasNext()) {
            // Cast to Integer
            result.add((Integer) collatingIterator.next());
        }
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    void testCollatingIteratorWithNullIterator() {
        iterators.add(null);
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new CollatingIterator(comparator, iterators);
        });
        assertNotNull(exception);
    }

    @Test
    void testCollatingIteratorWithEmptyAndNonEmptyIterators() {
        iterators.add(Arrays.asList(2, 3).iterator());
        // Fixed Buggy Line: Cast empty iterator to Iterator<Object> and then to Iterator<Integer>
        iterators.add((Iterator<Integer>) (Iterator<?>) Collections.emptyList().iterator());
        iterators.add(Arrays.asList(1, 4).iterator());
        CollatingIterator collatingIterator = new CollatingIterator(comparator, iterators);
        List<Integer> result = new ArrayList<>();
        while (collatingIterator.hasNext()) {
            // Cast to Integer
            result.add((Integer) collatingIterator.next());
        }
        assertEquals(Arrays.asList(1, 2, 3, 4), result);
    }
}
