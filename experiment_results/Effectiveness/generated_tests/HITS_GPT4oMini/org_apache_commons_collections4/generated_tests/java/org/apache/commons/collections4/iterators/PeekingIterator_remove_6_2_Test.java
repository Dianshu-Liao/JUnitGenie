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

public class PeekingIterator_remove_6_2_Test {

    private PeekingIterator<Integer> peekingIterator;

    private List<Integer> elements;

    @BeforeEach
    public void setUp() {
        elements = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator = elements.iterator();
        peekingIterator = new PeekingIterator<>(iterator);
    }

    @Test
    public void testRemoveWithoutPeekOrElement() {
        // Arrange
        // Move to the first element
        peekingIterator.next();
        // Act
        // Remove the current element (1)
        peekingIterator.remove();
        // Assert
        assertFalse(peekingIterator.hasNext());
    }

    @Test
    public void testRemoveAfterPeek() {
        // Arrange
        // Move to the first element
        peekingIterator.next();
        // Act
        // Peek at the current element (1)
        peekingIterator.peek();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            // Attempt to remove after peek
            peekingIterator.remove();
        });
        // Assert
        assertEquals("peek() or element() called before remove()", exception.getMessage());
    }

    @Test
    public void testRemoveAfterElement() {
        // Arrange
        // Move to the first element
        peekingIterator.next();
        // Act
        // Move to the second element
        peekingIterator.next();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            // Attempt to remove after calling next
            peekingIterator.remove();
        });
        // Assert
        assertEquals("peek() or element() called before remove()", exception.getMessage());
    }

    @Test
    public void testRemoveWhenSlotFilled() {
        // Arrange
        // Move to the first element
        peekingIterator.next();
        // Fill the slot
        peekingIterator.peek();
        // Act
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            // Attempt to remove when slot is filled
            peekingIterator.remove();
        });
        // Assert
        assertEquals("peek() or element() called before remove()", exception.getMessage());
    }

    @Test
    public void testRemoveWithoutNextCall() {
        // Arrange
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            // Attempt to remove without calling next
            peekingIterator.remove();
        });
        // Assert
        assertEquals("peek() or element() called before remove()", exception.getMessage());
    }
}
