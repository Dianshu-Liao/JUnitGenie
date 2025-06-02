package org.apache.commons.collections4.iterators;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.FilterListIterator;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;

class FilterListIterator_hasNext_5_0_Test {

    private FilterListIterator<Integer> filterListIterator;

    private ListIterator<Integer> listIterator;

    private Predicate<Integer> predicate;

    @BeforeEach
    void setUp() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        listIterator = list.listIterator();
        // Predicate to filter even numbers
        predicate = (Integer i) -> i % 2 == 0;
        filterListIterator = new FilterListIterator<>(listIterator, predicate);
    }

    @Test
    void testHasNextWhenNextObjectIsSet() {
        assertTrue(filterListIterator.hasNext(), "Expected hasNext() to return true when next object is set.");
    }

    @Test
    void testHasNextWhenNoNextObject() {
        // Move the iterator to the end
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        assertFalse(filterListIterator.hasNext(), "Expected hasNext() to return false when there are no more elements.");
    }

    @Test
    void testHasNextWithNoPredicate() {
        filterListIterator.setPredicate(null);
        assertThrows(NullPointerException.class, filterListIterator::hasNext, "Expected hasNext() to throw NullPointerException with null predicate.");
    }

    @Test
    void testHasNextWhenIteratorIsNull() {
        filterListIterator.setListIterator(null);
        assertFalse(filterListIterator.hasNext(), "Expected hasNext() to return false when iterator is null.");
    }

    @Test
    void testHasNextWithMultipleCalls() {
        assertTrue(filterListIterator.hasNext(), "Expected hasNext() to return true on first call.");
        assertTrue(filterListIterator.hasNext(), "Expected hasNext() to return true on second call.");
        // Move to next valid object
        filterListIterator.next();
        assertTrue(filterListIterator.hasNext(), "Expected hasNext() to return true after calling next() once.");
    }

    @Test
    void testHasNextWithNoMatchingElements() {
        List<Integer> list = Arrays.asList(1, 3, 5);
        listIterator = list.listIterator();
        filterListIterator.setListIterator(listIterator);
        assertFalse(filterListIterator.hasNext(), "Expected hasNext() to return false when there are no matching elements.");
    }
}
