package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.CollatingIterator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
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

class CollatingIterator_CollatingIterator_21_1_Test {

    private Comparator<Integer> comparator;

    private Iterator<Integer> iterator1;

    private Iterator<Integer> iterator2;

    private CollatingIterator<Integer> collatingIterator;

    @BeforeEach
    void setUp() {
        comparator = Integer::compareTo;
        iterator1 = Arrays.asList(1, 3, 5).iterator();
        iterator2 = Arrays.asList(2, 4, 6).iterator();
    }

    @Test
    void testCollatingIteratorWithMultipleIterators() {
        collatingIterator = new CollatingIterator<>(comparator, new Iterator[] { iterator1, iterator2 });
        assertNotNull(collatingIterator.getIterators());
        assertEquals(2, collatingIterator.getIterators().size());
        assertEquals(comparator, collatingIterator.getComparator());
    }

    @Test
    void testCollatingIteratorWithEmptyIteratorArray() {
        collatingIterator = new CollatingIterator<>(comparator, new Iterator[] {});
        assertNotNull(collatingIterator.getIterators());
        assertEquals(0, collatingIterator.getIterators().size());
    }

    @Test
    void testCollatingIteratorWithNullComparator() {
        collatingIterator = new CollatingIterator<>(null, new Iterator[] { iterator1, iterator2 });
        assertNull(collatingIterator.getComparator());
    }

    @Test
    void testCollatingIteratorWithNullIterator() {
        assertThrows(NullPointerException.class, () -> {
            new CollatingIterator<>(comparator, new Iterator[] { null });
        });
    }

    @Test
    void testCollatingIteratorWithSingleIterator() {
        collatingIterator = new CollatingIterator<>(comparator, new Iterator[] { iterator1 });
        assertEquals(1, collatingIterator.getIterators().size());
        assertEquals(iterator1, collatingIterator.getIterators().get(0));
    }

    @Test
    void testCollatingIteratorWithTwoIterators() {
        collatingIterator = new CollatingIterator<>(comparator, new Iterator[] { iterator1, iterator2 });
        assertEquals(2, collatingIterator.getIterators().size());
        assertEquals(iterator1, collatingIterator.getIterators().get(0));
        assertEquals(iterator2, collatingIterator.getIterators().get(1));
    }
}
