package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import java.util.Objects;

public class PeekingIterator_remove_6_0_Test {

    private PeekingIterator<Integer> peekingIterator;

    private Iterator<Integer> mockIterator;

    @BeforeEach
    public void setUp() {
        mockIterator = mock(Iterator.class);
        peekingIterator = new PeekingIterator<>(mockIterator);
    }

    @Test
    public void testRemove_WhenSlotFilled_ShouldThrowIllegalStateException() {
        // Arrange
        // Simulate that the slot is filled by calling a method that would fill the slot
        // For the purpose of this test, we will assume the slot is filled
        // Assuming peek() fills the slot
        peekingIterator.peek();
        // Act & Assert
        assertThrows(IllegalStateException.class, () -> {
            peekingIterator.remove();
        });
    }

    @Test
    public void testRemove_WhenSlotNotFilled_ShouldCallIteratorRemove() {
        // Arrange
        when(mockIterator.hasNext()).thenReturn(true);
        when(mockIterator.next()).thenReturn(1);
        // Move to the next element to simulate usage
        peekingIterator.next();
        // Act
        peekingIterator.remove();
        // Assert
        // Verify that the remove method of the iterator was called
        verify(mockIterator).remove();
    }
}
