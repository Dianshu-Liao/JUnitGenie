package org.apache.commons.collections4.iterators;

import java.util.Arrays;
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

public class PeekingIterator_peek_5_1_Test {

    private PeekingIterator<Integer> peekingIterator;

    private Iterator<Integer> mockIterator;

    @BeforeEach
    public void setUp() {
        mockIterator = mock(Iterator.class);
    }

    @Test
    public void testPeekWhenIteratorHasNext() {
        // Arrange
        when(mockIterator.hasNext()).thenReturn(true);
        when(mockIterator.next()).thenReturn(1);
        peekingIterator = new PeekingIterator<>(mockIterator);
        // Act
        Integer result = peekingIterator.peek();
        // Assert
        assertEquals(1, result);
        verify(mockIterator).hasNext();
        verify(mockIterator).next();
    }

    @Test
    public void testPeekWhenIteratorIsExhausted() {
        // Arrange
        when(mockIterator.hasNext()).thenReturn(false);
        peekingIterator = new PeekingIterator<>(mockIterator);
        // Act
        Integer result = peekingIterator.peek();
        // Assert
        assertNull(result);
        verify(mockIterator).hasNext();
        verify(mockIterator, never()).next();
    }

    @Test
    public void testPeekMultipleCalls() {
        // Arrange
        when(mockIterator.hasNext()).thenReturn(true).thenReturn(false);
        when(mockIterator.next()).thenReturn(2);
        peekingIterator = new PeekingIterator<>(mockIterator);
        // Act
        Integer firstPeek = peekingIterator.peek();
        Integer secondPeek = peekingIterator.peek();
        // Assert
        assertEquals(2, firstPeek);
        assertEquals(2, secondPeek);
        verify(mockIterator, times(1)).hasNext();
        verify(mockIterator, times(1)).next();
    }

    @Test
    public void testPeekAfterExhaustion() {
        // Arrange
        when(mockIterator.hasNext()).thenReturn(true).thenReturn(false);
        when(mockIterator.next()).thenReturn(3);
        peekingIterator = new PeekingIterator<>(mockIterator);
        // Act
        // First call to fill the slot
        peekingIterator.peek();
        // Call to check the slot
        peekingIterator.peek();
        // Should still return the same value
        Integer result = peekingIterator.peek();
        // Assert
        assertEquals(3, result);
        verify(mockIterator, times(1)).hasNext();
        verify(mockIterator, times(1)).next();
    }
}
