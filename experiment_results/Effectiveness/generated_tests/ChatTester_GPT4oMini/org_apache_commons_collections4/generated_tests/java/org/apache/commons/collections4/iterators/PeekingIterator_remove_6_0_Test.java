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

class PeekingIterator_remove_6_0_Test {

    private PeekingIterator<Integer> peekingIterator;

    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator = list.iterator();
        peekingIterator = new PeekingIterator<>(iterator);
    }

    @Test
    void testRemoveWithoutPeekOrElement() {
        // Initially, we should be able to call remove without any exception
        // Should not throw an exception
        peekingIterator.remove();
    }

    @Test
    void testRemoveAfterPeek() {
        // Simulate calling peek
        peekingIterator.peek();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            // Should throw IllegalStateException
            peekingIterator.remove();
        });
        assertEquals("peek() or element() called before remove()", exception.getMessage());
    }

    @Test
    void testRemoveAfterElement() {
        // Simulate calling element
        peekingIterator.element();
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            // Should throw IllegalStateException
            peekingIterator.remove();
        });
        assertEquals("peek() or element() called before remove()", exception.getMessage());
    }

    @Test
    void testRemoveAfterValidRemove() {
        // Simulate valid sequence: call remove first
        // Should not throw an exception
        peekingIterator.remove();
        // Further calls should still be valid
        // Should still not throw an exception
        peekingIterator.remove();
    }
}
