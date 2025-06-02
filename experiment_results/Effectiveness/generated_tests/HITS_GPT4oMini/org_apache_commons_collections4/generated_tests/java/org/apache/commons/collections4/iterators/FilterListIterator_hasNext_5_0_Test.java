package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Predicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;

public class FilterListIterator_hasNext_5_0_Test {

    private List<String> items;

    private ListIterator<String> listIterator;

    private Predicate<String> predicate;

    private FilterListIterator filterListIterator;

    @BeforeEach
    public void setUp() {
        items = Arrays.asList("apple", "banana", "cherry", "date");
        listIterator = items.listIterator();
        predicate = mock(Predicate.class);
        filterListIterator = new FilterListIterator(listIterator, predicate);
    }

    @Test
    public void testHasNext_WithMatchingElements() {
        when(predicate.test("apple")).thenReturn(true);
        assertTrue(filterListIterator.hasNext(), "Should have next element matching the predicate");
    }

    @Test
    public void testHasNext_WithNoMatchingElements() {
        when(predicate.test(anyString())).thenReturn(false);
        assertFalse(filterListIterator.hasNext(), "Should not have next element matching the predicate");
    }

    @Test
    public void testHasNext_AfterFiltering() {
        when(predicate.test("apple")).thenReturn(false);
        when(predicate.test("banana")).thenReturn(true);
        // Move to next
        filterListIterator.hasNext();
        assertTrue(filterListIterator.hasNext(), "Should have next element after filtering");
    }

    @Test
    public void testHasNext_WithEmptyIterator() {
        List<String> emptyItems = Arrays.asList();
        listIterator = emptyItems.listIterator();
        filterListIterator = new FilterListIterator(listIterator, predicate);
        assertFalse(filterListIterator.hasNext(), "Should not have next element in an empty iterator");
    }

    @Test
    public void testHasNext_WithAllElementsFilteredOut() {
        when(predicate.test(anyString())).thenReturn(false);
        assertFalse(filterListIterator.hasNext(), "Should not have next element when all are filtered out");
    }

    @Test
    public void testHasNext_WhenIteratorIsNull() {
        filterListIterator.setListIterator(null);
        assertFalse(filterListIterator.hasNext(), "Should not have next element when iterator is null");
    }

    @Test
    public void testHasNext_WithPreviousObjectSet() {
        when(predicate.test("apple")).thenReturn(true);
        // Move to next
        filterListIterator.hasNext();
        // Call again to set previous
        filterListIterator.hasNext();
        assertTrue(filterListIterator.hasNext(), "Should have next element even after previous object is set");
    }

    @Test
    public void testHasNext_WhenPredicateIsNull() {
        filterListIterator.setPredicate(null);
        assertFalse(filterListIterator.hasNext(), "Should not have next element when predicate is null");
    }
}
