package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import java.util.Objects;

class PeekingIterator_peek_5_1_Test {

    private PeekingIterator<Integer> peekingIterator;

    private Iterator<Integer> mockIterator;

    @BeforeEach
    void setUp() {
        mockIterator = Mockito.mock(Iterator.class);
    }

    @Test
    void testPeekWhenIteratorHasNext() {
        // Arrange
        Mockito.when(mockIterator.hasNext()).thenReturn(true);
        Mockito.when(mockIterator.next()).thenReturn(1);
        peekingIterator = new PeekingIterator<>(mockIterator);
        // Act
        Integer result = peekingIterator.peek();
        // Assert
        assertEquals(1, result);
        Mockito.verify(mockIterator, Mockito.times(1)).hasNext();
        Mockito.verify(mockIterator, Mockito.times(0)).next();
    }

    @Test
    void testPeekWhenIteratorIsExhausted() {
        // Arrange
        Mockito.when(mockIterator.hasNext()).thenReturn(false);
        peekingIterator = new PeekingIterator<>(mockIterator);
        // Act
        Integer result = peekingIterator.peek();
        // Assert
        assertNull(result);
        Mockito.verify(mockIterator, Mockito.times(1)).hasNext();
        Mockito.verify(mockIterator, Mockito.times(0)).next();
    }

    @Test
    void testPeekAfterExhaustion() {
        // Arrange
        Mockito.when(mockIterator.hasNext()).thenReturn(true, false);
        Mockito.when(mockIterator.next()).thenReturn(1);
        peekingIterator = new PeekingIterator<>(mockIterator);
        // Fill the slot first
        peekingIterator.peek();
        // Act
        // Call peek again after the first call
        Integer result = peekingIterator.peek();
        // Assert
        assertEquals(1, result);
        Mockito.verify(mockIterator, Mockito.times(2)).hasNext();
        Mockito.verify(mockIterator, Mockito.times(1)).next();
    }

    @Test
    void testPeekMultipleCalls() {
        // Arrange
        Mockito.when(mockIterator.hasNext()).thenReturn(true);
        Mockito.when(mockIterator.next()).thenReturn(2);
        peekingIterator = new PeekingIterator<>(mockIterator);
        // Act
        // First call
        Integer firstPeek = peekingIterator.peek();
        // Second call
        Integer secondPeek = peekingIterator.peek();
        // Assert
        assertEquals(2, firstPeek);
        assertEquals(2, secondPeek);
        Mockito.verify(mockIterator, Mockito.times(1)).hasNext();
        Mockito.verify(mockIterator, Mockito.times(0)).next();
    }

    @Test
    void testPeekAfterNext() {
        // Arrange
        Mockito.when(mockIterator.hasNext()).thenReturn(true, false);
        Mockito.when(mockIterator.next()).thenReturn(3);
        peekingIterator = new PeekingIterator<>(mockIterator);
        // Fill the slot first
        peekingIterator.peek();
        // Act
        // Call peek again
        peekingIterator.peek();
        // Advance the iterator
        Integer nextElement = mockIterator.next();
        // Assert
        assertEquals(3, nextElement);
        // Now it should be exhausted
        assertNull(peekingIterator.peek());
        Mockito.verify(mockIterator, Mockito.times(2)).hasNext();
        Mockito.verify(mockIterator, Mockito.times(1)).next();
    }
}
