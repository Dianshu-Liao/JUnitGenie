package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.iterators.CollatingIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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
import java.util.Comparator;
import java.util.Objects;
import org.apache.commons.collections4.list.UnmodifiableList;

class CollatingIterator_hasNext_8_0_Test {

    private CollatingIterator<Integer> collatingIterator;

    @BeforeEach
    void setUp() {
        collatingIterator = new CollatingIterator<>();
    }

    @Test
    void testHasNextWithEmptyIterators() {
        assertFalse(collatingIterator.hasNext());
    }

    @Test
    void testHasNextWithSingleIteratorWithNoElements() {
        Iterator<Integer> emptyIterator = Collections.emptyIterator();
        collatingIterator.setIterator(0, emptyIterator);
        assertFalse(collatingIterator.hasNext());
    }

    @Test
    void testHasNextWithSingleIteratorWithElements() {
        Iterator<Integer> singleElementIterator = Arrays.asList(1).iterator();
        collatingIterator.setIterator(0, singleElementIterator);
        assertTrue(collatingIterator.hasNext());
    }

    @Test
    void testHasNextWithMultipleIterators() {
        Iterator<Integer> firstIterator = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> secondIterator = Arrays.asList(4, 5).iterator();
        collatingIterator.setIterator(0, firstIterator);
        collatingIterator.setIterator(1, secondIterator);
        assertTrue(collatingIterator.hasNext());
        // Consume all elements from first iterator
        while (firstIterator.hasNext()) {
            firstIterator.next();
        }
        // second iterator still has elements
        assertTrue(collatingIterator.hasNext());
    }

    @Test
    void testHasNextAfterAllElementsProcessed() {
        Iterator<Integer> firstIterator = Arrays.asList(1).iterator();
        collatingIterator.setIterator(0, firstIterator);
        // consume the only element
        firstIterator.next();
        assertFalse(collatingIterator.hasNext());
    }

    @Test
    void testHasNextWithNullValues() {
        Iterator<Integer> firstIterator = Arrays.asList(1, null).iterator();
        collatingIterator.setIterator(0, firstIterator);
        assertTrue(collatingIterator.hasNext());
        // consume 1
        firstIterator.next();
        // null is still a valid value
        assertTrue(collatingIterator.hasNext());
    }

    @Test
    void testHasNextWithMultipleEmptyAndNonEmptyIterators() {
        Iterator<Integer> emptyIterator = Collections.emptyIterator();
        Iterator<Integer> filledIterator = Arrays.asList(3, 4).iterator();
        collatingIterator.setIterator(0, emptyIterator);
        collatingIterator.setIterator(1, filledIterator);
        assertTrue(collatingIterator.hasNext());
    }

    @Test
    void testHasNextWithAllEmptyIterators() {
        Iterator<Integer> emptyIterator1 = Collections.emptyIterator();
        Iterator<Integer> emptyIterator2 = Collections.emptyIterator();
        collatingIterator.setIterator(0, emptyIterator1);
        collatingIterator.setIterator(1, emptyIterator2);
        assertFalse(collatingIterator.hasNext());
    }

    @Test
    void testGetIteratorIndexWithoutPreviousCall() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            collatingIterator.getIteratorIndex();
        });
        assertEquals("No value has been returned yet", exception.getMessage());
    }
}
