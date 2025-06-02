package org.apache.commons.collections4.queue;

import java.util.Arrays;
import java.util.Collection;
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
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import org.apache.commons.collections4.BoundedCollection;

class CircularFifoQueue_add_0_0_Test {

    private CircularFifoQueue<String> queue;

    @BeforeEach
    void setUp() {
        // Initialize with a capacity of 3
        queue = new CircularFifoQueue<>(3);
    }

    @Test
    void testAddElement() {
        assertTrue(queue.add("A"));
        assertEquals(1, queue.size());
        assertTrue(queue.add("B"));
        assertEquals(2, queue.size());
        assertTrue(queue.add("C"));
        assertEquals(3, queue.size());
    }

    @Test
    void testAddElementWhenFull() {
        queue.add("A");
        queue.add("B");
        queue.add("C");
        // This should remove "A" and add "D"
        assertTrue(queue.add("D"));
        assertEquals(3, queue.size());
        // Ensure "A" is removed
        assertThrows(NoSuchElementException.class, queue::remove);
    }

    @Test
    void testAddNullElement() {
        assertThrows(NullPointerException.class, () -> queue.add(null));
    }

    @Test
    void testAddMultipleElements() {
        Collection<String> elements = Arrays.asList("A", "B", "C", "D", "E");
        queue.addAll(elements);
        // Should only keep the last 3 elements
        assertEquals(3, queue.size());
        assertTrue(queue.contains("C"));
        assertTrue(queue.contains("D"));
        assertTrue(queue.contains("E"));
        // "A" should be removed
        assertFalse(queue.contains("A"));
    }

    @Test
    void testIsAtFullCapacity() {
        assertFalse(queue.isAtFullCapacity());
        queue.add("A");
        queue.add("B");
        queue.add("C");
        assertTrue(queue.isAtFullCapacity());
    }

    @Test
    void testRemoveElement() {
        queue.add("A");
        queue.add("B");
        assertEquals("A", queue.remove());
        assertEquals(1, queue.size());
        assertEquals("B", queue.remove());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testRemoveFromEmptyQueue() {
        assertThrows(NoSuchElementException.class, () -> queue.remove());
    }
}
