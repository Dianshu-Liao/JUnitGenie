package org.apache.commons.collections4.queue;

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
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import org.apache.commons.collections4.BoundedCollection;

class CircularFifoQueue_peek_12_0_Test {

    private CircularFifoQueue<String> queue;

    @BeforeEach
    void setUp() {
        // Initialize with a size of 3
        queue = new CircularFifoQueue<>(3);
    }

    @Test
    void testPeekWhenQueueIsEmpty() {
        assertNull(queue.peek(), "Peek should return null when the queue is empty.");
    }

    @Test
    void testPeekWhenQueueHasElements() {
        // Assuming there is an add method to add elements to the queue
        queue.add("first");
        queue.add("second");
        // Peek should return the first element without removing it
        assertEquals("first", queue.peek(), "Peek should return the first element.");
        assertEquals(2, queue.size(), "Queue size should remain the same after peek.");
    }

    @Test
    void testPeekAfterAddingAndRemovingElements() {
        queue.add("first");
        queue.add("second");
        // Remove "first"
        queue.remove();
        // Peek should return "second" now
        assertEquals("second", queue.peek(), "Peek should return the new front element after one removal.");
    }

    @Test
    void testPeekWithFullQueue() {
        queue.add("first");
        queue.add("second");
        queue.add("third");
        // Now the queue is full, let's peek
        assertEquals("first", queue.peek(), "Peek should return the first element even when the queue is full.");
    }

    // Reflection test for private methods can be added if needed
    // Example: testing a private method that might be used in peek()
    // Use reflection to access private methods if necessary for deeper testing
    // Helper methods for adding and removing elements (if not available)
    private void add(String element) {
        // This method should be implemented to add elements to the queue
    }

    private String remove() {
        // This method should be implemented to remove elements from the queue
        // Placeholder
        return null;
    }
}
