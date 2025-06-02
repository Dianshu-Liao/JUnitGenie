package org.apache.commons.collections4.queue;

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
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import org.apache.commons.collections4.BoundedCollection;

class CircularFifoQueue_get_4_0_Test {

    private CircularFifoQueue<String> queue;

    @BeforeEach
    void setUp() {
        // Initialize with a size of 5
        queue = new CircularFifoQueue<>(5);
    }

    @Test
    void testGetValidIndex() {
        queue.add("A");
        queue.add("B");
        queue.add("C");
        assertEquals("A", queue.get(0));
        assertEquals("B", queue.get(1));
        assertEquals("C", queue.get(2));
    }

    @Test
    void testGetIndexOutOfBoundsNegative() {
        queue.add("A");
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            queue.get(-1);
        });
        assertEquals("The specified index -1 is outside the available range [0, 1)", exception.getMessage());
    }

    @Test
    void testGetIndexOutOfBoundsTooLarge() {
        queue.add("A");
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            queue.get(1);
        });
        assertEquals("The specified index 1 is outside the available range [0, 1)", exception.getMessage());
    }

    @Test
    void testGetFromEmptyQueue() {
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            queue.get(0);
        });
        assertEquals("The specified index 0 is outside the available range [0, 0)", exception.getMessage());
    }

    @Test
    void testGetAfterWrappingAround() {
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        queue.add("E");
        // Remove "A"
        queue.remove();
        // Add "F", which should overwrite "B"
        queue.add("F");
        // Should return "C"
        assertEquals("C", queue.get(1));
        // Should return "D"
        assertEquals("D", queue.get(2));
        // Should return "E"
        assertEquals("E", queue.get(3));
        // Should return "F"
        assertEquals("F", queue.get(4));
    }
}
