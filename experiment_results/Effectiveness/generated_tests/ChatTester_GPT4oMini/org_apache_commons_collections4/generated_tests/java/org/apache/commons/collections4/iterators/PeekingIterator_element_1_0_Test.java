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

public class // Additional tests can be added to cover more edge cases if necessary
PeekingIterator_element_1_0_Test {

    private PeekingIterator<Integer> peekingIterator;

    private Iterator<Integer> mockIterator;

    @BeforeEach
    public void setUp() {
        mockIterator = Mockito.mock(Iterator.class);
        peekingIterator = new PeekingIterator<>(mockIterator);
    }

    @Test
    public void testElementWhenNotExhausted() {
        // Arrange
        Mockito.when(mockIterator.hasNext()).thenReturn(true);
        Mockito.when(mockIterator.next()).thenReturn(1);
        // Act
        Integer result = peekingIterator.element();
        // Assert
        assertEquals(1, result);
        Mockito.verify(mockIterator).hasNext();
        // next should not be called
        Mockito.verify(mockIterator, Mockito.never()).next();
    }

    @Test
    public void testElementWhenExhausted() {
        // Arrange
        Mockito.when(mockIterator.hasNext()).thenReturn(false);
        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> peekingIterator.element());
        Mockito.verify(mockIterator).hasNext();
    }

    @Test
    public void testElementAfterExhaustion() {
        // Arrange
        Mockito.when(mockIterator.hasNext()).thenReturn(true, false);
        Mockito.when(mockIterator.next()).thenReturn(2);
        // Act
        Integer firstCall = peekingIterator.element();
        // Assert
        assertEquals(2, firstCall);
        // Act & Assert for exhaustion
        assertThrows(NoSuchElementException.class, () -> peekingIterator.element());
        Mockito.verify(mockIterator, Mockito.times(2)).hasNext();
        Mockito.verify(mockIterator, Mockito.times(1)).next();
    }

    @Test
    public void testElementWithMultipleCalls() {
        // Arrange
        Mockito.when(mockIterator.hasNext()).thenReturn(true);
        Mockito.when(mockIterator.next()).thenReturn(3);
        // Act
        Integer firstCall = peekingIterator.element();
        Integer secondCall = peekingIterator.element();
        // Assert
        assertEquals(3, firstCall);
        assertEquals(3, secondCall);
        Mockito.verify(mockIterator).hasNext();
        // next should not be called
        Mockito.verify(mockIterator, Mockito.never()).next();
    }
}
