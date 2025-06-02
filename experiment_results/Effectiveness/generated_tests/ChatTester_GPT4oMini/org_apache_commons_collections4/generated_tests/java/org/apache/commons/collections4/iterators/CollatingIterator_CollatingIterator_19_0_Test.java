package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.list.UnmodifiableList;

public class CollatingIterator_CollatingIterator_19_0_Test {

    private CollatingIterator collatingIterator;

    @BeforeEach
    public void setUp() {
        // Initialize a Comparator for testing
        // A simple comparator that always returns 0
        Comparator<Object> comparator = (o1, o2) -> 0;
        // Initial capacity for iterators
        int initialCapacity = 10;
        collatingIterator = new CollatingIterator(comparator, initialCapacity);
    }

    @Test
    public void testCollatingIteratorInitialization() {
        // Verify that the collatingIterator is not null
        assertNotNull(collatingIterator);
    }

    @Test
    public void testCollatingIteratorWithDifferentComparators() {
        // Test with a different comparator
        Comparator<String> stringComparator = String::compareTo;
        CollatingIterator stringCollatingIterator = new CollatingIterator(stringComparator, 5);
        // Verify that the new instance is not null
        assertNotNull(stringCollatingIterator);
    }

    @Test
    public void testCollatingIteratorWithEmptyIteratorList() {
        // Test with an empty iterator list
        Comparator<Integer> integerComparator = Integer::compareTo;
        CollatingIterator emptyIteratorCollatingIterator = new CollatingIterator(integerComparator, 0);
        // Verify that the new instance is not null
        assertNotNull(emptyIteratorCollatingIterator);
    }

    @Test
    public void testCollatingIteratorWithInitialCapacity() {
        // Create a CollatingIterator with a specific initial capacity
        int initialCapacity = 5;
        Comparator<String> stringComparator = String::compareTo;
        CollatingIterator collatingIteratorWithCapacity = new CollatingIterator(stringComparator, initialCapacity);
        // Verify that the collatingIterator is not null
        assertNotNull(collatingIteratorWithCapacity);
        // Check if the iterators list is initialized correctly
        List<Iterator<? extends String>> iterators = collatingIteratorWithCapacity.getIterators();
        assertNotNull(iterators);
        assertEquals(initialCapacity, iterators.size(), "The size of iterators should match the initial capacity");
    }
}
