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

public class CircularFifoQueue_peek_12_0_Test {

    private CircularFifoQueue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new CircularFifoQueue<>(3);
    }

    @Test
    public void testPeekWhenQueueIsEmpty() {
        assertNull(queue.peek(), "Peek should return null when the queue is empty");
    }

    @Test
    public void testPeekWhenQueueHasElements() {
        queue.add(1);
        queue.add(2);
        assertEquals(1, queue.peek(), "Peek should return the first element in the queue");
    }

    @Test
    public void testPeekDoesNotRemoveElement() {
        queue.add(1);
        queue.add(2);
        assertEquals(1, queue.peek(), "Peek should return the first element");
        assertEquals(2, queue.peek(), "Peek should still return the first element after calling it again");
    }

    @Test
    public void testPeekWhenQueueIsFull() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        assertEquals(1, queue.peek(), "Peek should return the first element even when the queue is full");
    }

    @Test
    public void testPeekAfterAddingAndRemoving() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        // Removes 1
        queue.remove();
        assertEquals(2, queue.peek(), "Peek should return the new first element after removing the old one");
    }
}
