package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import java.util.Objects;

public class PeekingIterator_peek_5_0_Test {

    private PeekingIterator<Integer> peekingIterator;

    @BeforeEach
    public void setUp() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator = list.iterator();
        peekingIterator = new PeekingIterator<>(iterator);
    }

    @Test
    public void testPeekFirstElement() {
        assertEquals(1, peekingIterator.peek());
    }

    @Test
    public void testPeekDoesNotAdvanceIterator() {
        peekingIterator.peek();
        assertEquals(1, peekingIterator.peek());
    }

    @Test
    public void testPeekSecondElement() {
        // Advance to first element
        peekingIterator.peek();
        // Move to second element
        peekingIterator.next();
        assertEquals(2, peekingIterator.peek());
    }

    @Test
    public void testPeekAfterExhaustion() {
        // Advance to first element
        peekingIterator.peek();
        // Move to second element
        peekingIterator.next();
        // Move to third element
        peekingIterator.next();
        // Exhaust the iterator
        peekingIterator.next();
        assertNull(peekingIterator.peek());
    }

    @Test
    public void testPeekOnEmptyIterator() {
        Iterator<Integer> emptyIterator = Collections.<Integer>emptyList().iterator();
        PeekingIterator<Integer> emptyPeekingIterator = new PeekingIterator<>(emptyIterator);
        assertNull(emptyPeekingIterator.peek());
    }
}
