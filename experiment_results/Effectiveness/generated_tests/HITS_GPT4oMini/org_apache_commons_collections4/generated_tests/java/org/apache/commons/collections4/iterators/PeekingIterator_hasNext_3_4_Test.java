package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import java.util.Objects;

public class PeekingIterator_hasNext_3_4_Test {

    private PeekingIterator<Integer> peekingIterator;

    @BeforeEach
    public void setUp() {
        // Initialize the PeekingIterator with a non-exhausted iterator
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        peekingIterator = new PeekingIterator<>(iterator);
    }

    @Test
    public void testHasNext_WhenNotExhausted_ShouldReturnTrue() {
        // Test hasNext when the iterator is not exhausted
        assertTrue(peekingIterator.hasNext());
    }

    @Test
    public void testHasNext_WhenExhausted_ShouldReturnFalse() {
        // Exhaust the iterator
        while (peekingIterator.hasNext()) {
            peekingIterator.next();
        }
        // Now the iterator should be exhausted
        assertFalse(peekingIterator.hasNext());
    }

    @Test
    public void testHasNext_WhenSlotFilled_ShouldReturnTrue() {
        // Since we cannot access slotFilled directly, we will simulate this by calling next() to fill the slot
        // Move to the first element
        peekingIterator.next();
        // Now hasNext should return true
        assertTrue(peekingIterator.hasNext());
    }

    @Test
    public void testHasNext_WhenExhaustedAndSlotNotFilled_ShouldReturnFalse() {
        // Exhaust the iterator
        while (peekingIterator.hasNext()) {
            peekingIterator.next();
        }
        // Now the iterator should be exhausted
        assertFalse(peekingIterator.hasNext());
    }
}
