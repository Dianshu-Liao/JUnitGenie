package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class SkippingIterator_init_0_0_Test {

    private SkippingIterator<Integer> skippingIterator;

    @BeforeEach
    void setUp() {
        // Set up a basic iterator with a sample data set
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3, 4, 5).iterator();
        // Skip first 2 elements
        skippingIterator = new SkippingIterator<>(iterator, 2);
    }

    @Test
    void testInit_WithValidOffset() {
        // After initialization, the iterator should skip the first 2 elements
        assertTrue(skippingIterator.hasNext(), "Iterator should have next element after skipping");
        assertEquals(3, skippingIterator.next(), "First element after skipping should be 3");
        assertEquals(4, skippingIterator.next(), "Second element after skipping should be 4");
        assertEquals(5, skippingIterator.next(), "Third element after skipping should be 5");
        assertFalse(skippingIterator.hasNext(), "Iterator should not have more elements after 5");
    }

    @Test
    void testInit_WithZeroOffset() {
        // With an offset of 0, the iterator should not skip any elements
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        SkippingIterator<Integer> skippingIteratorZeroOffset = new SkippingIterator<>(iterator, 0);
        assertTrue(skippingIteratorZeroOffset.hasNext(), "Iterator should have next element");
        assertEquals(1, skippingIteratorZeroOffset.next(), "First element should be 1");
        assertEquals(2, skippingIteratorZeroOffset.next(), "Second element should be 2");
        assertEquals(3, skippingIteratorZeroOffset.next(), "Third element should be 3");
        assertFalse(skippingIteratorZeroOffset.hasNext(), "Iterator should not have more elements after 3");
    }

    @Test
    void testInit_WithOffsetGreaterThanElements() {
        // With an offset greater than the number of elements, the iterator should have no elements left
        Iterator<Integer> iterator = Arrays.asList(1, 2).iterator();
        SkippingIterator<Integer> skippingIteratorLargeOffset = new SkippingIterator<>(iterator, 5);
        assertFalse(skippingIteratorLargeOffset.hasNext(), "Iterator should not have any elements left");
    }

    @Test
    void testInit_WithNegativeOffset_ShouldThrowException() {
        // Negative offset should throw IllegalArgumentException
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new SkippingIterator<>(Arrays.asList(1, 2, 3).iterator(), -1);
        });
        assertEquals("Offset parameter must not be negative.", exception.getMessage());
    }

    @Test
    void testNext_WhenNoMoreElements_ShouldThrowException() {
        // Test behavior when calling next() without more elements
        SkippingIterator<Integer> emptySkippingIterator = new SkippingIterator<>(Arrays.asList(1, 2).iterator(), 2);
        // Skip first 2 elements
        emptySkippingIterator.next();
        // This should not throw
        emptySkippingIterator.next();
        assertThrows(NoSuchElementException.class, emptySkippingIterator::next, "Should throw NoSuchElementException when no more elements");
    }
}
