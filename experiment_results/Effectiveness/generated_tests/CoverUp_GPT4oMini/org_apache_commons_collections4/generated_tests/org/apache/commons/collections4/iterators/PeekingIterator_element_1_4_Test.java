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
import java.util.Objects;

class PeekingIterator_element_1_4_Test {

    private PeekingIterator<Integer> peekingIterator;

    @BeforeEach
    void setUp() {
        // Initialize with an iterator over a sample array
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        peekingIterator = new PeekingIterator<>(iterator);
    }

    @Test
    void testElementReturnsFirstElement() {
        assertEquals(1, peekingIterator.element());
    }

    @Test
    void testElementReturnsSecondElementAfterFill() {
        // Fill the slot with the first element
        peekingIterator.element();
        // Should still return the first element
        assertEquals(1, peekingIterator.element());
    }

    @Test
    void testElementThrowsNoSuchElementExceptionWhenExhausted() {
        // Exhaust the iterator
        // Fill with 1
        peekingIterator.element();
        // Fill with 2
        peekingIterator.element();
        // Fill with 3
        peekingIterator.element();
        assertThrows(NoSuchElementException.class, () -> peekingIterator.element());
    }

    @Test
    void testElementReturnsNullWhenExhausted() {
        // Exhaust the iterator
        // Fill with 1
        peekingIterator.element();
        // Fill with 2
        peekingIterator.element();
        // Fill with 3
        peekingIterator.element();
        assertThrows(NoSuchElementException.class, () -> peekingIterator.element());
    }

    @Test
    void testElementIsNotCalledBeforeFill() {
        // First call fills the slot
        assertEquals(1, peekingIterator.element());
        // Second call returns the same element
        assertEquals(1, peekingIterator.element());
    }

    @Test
    void testElementMultipleCalls() {
        assertEquals(1, peekingIterator.element());
        assertEquals(1, peekingIterator.element());
        assertEquals(1, peekingIterator.element());
    }

    @Test
    void testElementAfterExhaustion() {
        // Fill the iterator
        // Fill with 1
        peekingIterator.element();
        // Fill with 2
        peekingIterator.element();
        // Fill with 3
        peekingIterator.element();
        assertThrows(NoSuchElementException.class, () -> peekingIterator.element());
    }
}
