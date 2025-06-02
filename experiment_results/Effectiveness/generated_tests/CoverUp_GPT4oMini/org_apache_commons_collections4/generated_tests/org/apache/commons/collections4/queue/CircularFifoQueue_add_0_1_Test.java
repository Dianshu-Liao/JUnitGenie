package org.apache.commons.collections4.queue;

import org.apache.commons.collections4.queue.CircularFifoQueue;
import java.util.Arrays;
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
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import org.apache.commons.collections4.BoundedCollection;

class CircularFifoQueue_add_0_1_Test {

    private CircularFifoQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new CircularFifoQueue<>(3);
    }

    @Test
    void testAddElement() {
        assertTrue(queue.add(1));
        assertTrue(queue.add(2));
        assertTrue(queue.add(3));
        // This should remove the first element (1)
        assertTrue(queue.add(4));
        // Verify the state of the queue after adding elements
        assertEquals(3, queue.size());
        assertThrows(NoSuchElementException.class, () -> {
            queue.remove();
            queue.remove();
            queue.remove();
            // This should throw an exception
            queue.remove();
        });
    }

    @Test
    void testAddNullElement() {
        assertThrows(NullPointerException.class, () -> queue.add(null));
    }

    @Test
    void testAddAtFullCapacity() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        // This should remove the first element (1)
        assertTrue(queue.add(4));
        // Verify the queue contents
        assertEquals(3, queue.size());
        assertThrows(NoSuchElementException.class, () -> {
            queue.remove();
            queue.remove();
            queue.remove();
            // This should throw an exception
            queue.remove();
        });
    }

    @Test
    void testAddMultipleElements() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        // This should remove the first element (1)
        queue.add(4);
        // This should remove the next element (2)
        queue.add(5);
        // Verify the state of the queue
        assertEquals(3, queue.size());
        assertThrows(NoSuchElementException.class, () -> {
            queue.remove();
            queue.remove();
            queue.remove();
            // This should throw an exception
            queue.remove();
        });
    }

    @Test
    void testAddBeyondInitialCapacity() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        // This should remove 1
        queue.add(4);
        // This should remove 2
        queue.add(5);
        // This should remove 3
        queue.add(6);
        // Verify the state of the queue
        assertEquals(3, queue.size());
        assertThrows(NoSuchElementException.class, () -> {
            queue.remove();
            queue.remove();
            queue.remove();
            // This should throw an exception
            queue.remove();
        });
    }
}
