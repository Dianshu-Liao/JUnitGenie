package org.apache.commons.collections4.queue;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import org.apache.commons.collections4.BoundedCollection;

class CircularFifoQueue_get_4_0_Test {

    private CircularFifoQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        // Initialize the queue with a size of 5
        queue = new CircularFifoQueue<>(5);
    }

    @Test
    void testGetValidIndex() {
        // Fill the queue
        queue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        // Test valid indices
        assertEquals(1, queue.get(0));
        assertEquals(2, queue.get(1));
        assertEquals(3, queue.get(2));
        assertEquals(4, queue.get(3));
        assertEquals(5, queue.get(4));
    }

    @Test
    void testGetIndexOutOfBoundsNegative() {
        // Fill the queue
        queue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        // Test negative index
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            queue.get(-1);
        });
        assertEquals("The specified index -1 is outside the available range [0, 5)", exception.getMessage());
    }

    @Test
    void testGetIndexOutOfBoundsTooHigh() {
        // Fill the queue
        queue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        // Test index greater than size
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            queue.get(5);
        });
        assertEquals("The specified index 5 is outside the available range [0, 5)", exception.getMessage());
    }

    @Test
    void testGetEmptyQueue() {
        // Test getting from an empty queue
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            queue.get(0);
        });
        assertEquals("The specified index 0 is outside the available range [0, 0)", exception.getMessage());
    }

    @Test
    void testGetAfterWrapAround() {
        // Fill the queue and wrap around
        queue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        // Should access 1
        queue.get(0);
        // Should access 2
        queue.get(1);
        // Should access 3
        queue.get(2);
        // Should access 4
        queue.get(3);
        // Should access 5
        queue.get(4);
        // Now remove some elements to create wrap around
        queue.remove();
        queue.remove();
        // Add new elements
        queue.add(6);
        queue.add(7);
        // Test the elements after wrap around
        // The first element after removals
        assertEquals(3, queue.get(0));
        // The second element after removals
        assertEquals(4, queue.get(1));
        // The third element after removals
        assertEquals(5, queue.get(2));
        // The first new element
        assertEquals(6, queue.get(3));
        // The second new element
        assertEquals(7, queue.get(4));
    }
}
