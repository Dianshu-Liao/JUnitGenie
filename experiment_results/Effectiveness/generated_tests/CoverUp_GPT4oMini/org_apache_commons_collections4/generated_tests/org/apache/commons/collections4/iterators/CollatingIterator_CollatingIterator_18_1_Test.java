package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.CollatingIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.BitSet;
import java.util.Objects;
import org.apache.commons.collections4.list.UnmodifiableList;

class CollatingIterator_CollatingIterator_18_1_Test {

    private Comparator<Integer> comparator;

    private List<Iterator<? extends Integer>> iterators;

    @BeforeEach
    void setUp() {
        comparator = Integer::compareTo;
        iterators = new ArrayList<>();
    }

    @Test
    void testCollatingIteratorWithEmptyCollection() {
        CollatingIterator<Integer> collatingIterator = new CollatingIterator<>(comparator, iterators);
        assertNotNull(collatingIterator);
        assertEquals(0, collatingIterator.getIterators().size());
    }

    @Test
    void testCollatingIteratorWithSingleIterator() {
        Iterator<Integer> singleIterator = Arrays.asList(1, 2, 3).iterator();
        iterators.add(singleIterator);
        CollatingIterator<Integer> collatingIterator = new CollatingIterator<>(comparator, iterators);
        assertNotNull(collatingIterator);
        assertEquals(1, collatingIterator.getIterators().size());
        assertEquals(singleIterator, collatingIterator.getIterators().get(0));
    }

    @Test
    void testCollatingIteratorWithMultipleIterators() {
        Iterator<Integer> firstIterator = Arrays.asList(1, 4, 7).iterator();
        Iterator<Integer> secondIterator = Arrays.asList(2, 5, 8).iterator();
        Iterator<Integer> thirdIterator = Arrays.asList(3, 6, 9).iterator();
        iterators.add(firstIterator);
        iterators.add(secondIterator);
        iterators.add(thirdIterator);
        CollatingIterator<Integer> collatingIterator = new CollatingIterator<>(comparator, iterators);
        assertNotNull(collatingIterator);
        assertEquals(3, collatingIterator.getIterators().size());
        assertEquals(firstIterator, collatingIterator.getIterators().get(0));
        assertEquals(secondIterator, collatingIterator.getIterators().get(1));
        assertEquals(thirdIterator, collatingIterator.getIterators().get(2));
    }

    @Test
    void testCollatingIteratorWithNullComparator() {
        assertThrows(NullPointerException.class, () -> {
            new CollatingIterator<>(null, iterators);
        });
    }

    @Test
    void testCollatingIteratorWithNullIteratorInCollection() {
        iterators.add(null);
        assertThrows(NullPointerException.class, () -> {
            new CollatingIterator<>(comparator, iterators);
        });
    }
}
