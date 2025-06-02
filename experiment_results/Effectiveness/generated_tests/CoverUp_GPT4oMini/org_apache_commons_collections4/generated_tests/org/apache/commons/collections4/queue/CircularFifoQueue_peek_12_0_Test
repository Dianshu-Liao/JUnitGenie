package org.apache.commons.collections4.queue;

import org.apache.commons.collections4.queue.CircularFifoQueue;
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

    private CircularFifoQueue<String> queue;

    @BeforeEach
    public void setUp() {
        queue = new CircularFifoQueue<>(3);
    }

    @Test
    public void testPeekWhenEmpty() {
        assertNull(queue.peek(), "Peek should return null when the queue is empty");
    }

    @Test
    public void testPeekWhenNotEmpty() {
        queue.add("first");
        assertEquals("first", queue.peek(), "Peek should return the first element when the queue is not empty");
    }

    @Test
    public void testPeekAfterAddingMultipleElements() {
        queue.add("first");
        queue.add("second");
        queue.add("third");
        assertEquals("first", queue.peek(), "Peek should return the first element in the queue");
    }

    @Test
    public void testPeekAfterRemovingElement() {
        queue.add("first");
        queue.add("second");
        queue.add("third");
        // removes "first"
        queue.remove();
        assertEquals("second", queue.peek(), "Peek should return the new first element after removal");
    }

    @Test
    public void testPeekWithFullQueue() {
        queue.add("first");
        queue.add("second");
        queue.add("third");
        // This will overwrite "first"
        queue.add("fourth");
        assertEquals("second", queue.peek(), "Peek should return the new first element after the queue is full");
    }
}
