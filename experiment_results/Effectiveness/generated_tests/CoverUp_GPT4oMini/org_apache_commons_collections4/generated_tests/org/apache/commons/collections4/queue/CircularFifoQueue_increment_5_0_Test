package org.apache.commons.collections4.queue;

import java.lang.reflect.Method;
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

public class CircularFifoQueue_increment_5_0_Test {

    private CircularFifoQueue<Integer> queue;

    @BeforeEach
    public void setUp() {
        // Initialize with a capacity of 5
        queue = new CircularFifoQueue<>(5);
    }

    @Test
    public void testIncrementWithinBounds() throws Exception {
        // Accessing the private method increment using reflection
        Method method = CircularFifoQueue.class.getDeclaredMethod("increment", int.class);
        method.setAccessible(true);
        // Test incrementing a valid index
        int result = (int) method.invoke(queue, 3);
        assertEquals(4, result);
        // Test incrementing at the boundary
        result = (int) method.invoke(queue, 4);
        assertEquals(0, result);
    }

    @Test
    public void testIncrementAtMaxElements() throws Exception {
        // Accessing the private method increment using reflection
        Method method = CircularFifoQueue.class.getDeclaredMethod("increment", int.class);
        method.setAccessible(true);
        // Test incrementing at the maximum index
        int result = (int) method.invoke(queue, 5);
        assertEquals(0, result);
    }

    @Test
    public void testAddAndCheckIncrement() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        // Now the queue is full, and the next addition will remove the oldest element
        queue.add(6);
        // Check the elements after adding 6
        // Last added
        assertEquals(6, queue.get(4));
        // First element after 1 was removed
        assertEquals(2, queue.get(0));
    }

    @Test
    public void testGetWithInvalidIndex() {
        assertThrows(NoSuchElementException.class, () -> {
            // Should throw as queue is empty
            queue.get(0);
        });
        queue.add(1);
        assertThrows(NoSuchElementException.class, () -> {
            // Should throw as index is out of bounds
            queue.get(1);
        });
    }

    @Test
    public void testClear() {
        queue.add(1);
        queue.add(2);
        queue.clear();
        // Queue should be empty
        assertEquals(0, queue.size());
        assertThrows(NoSuchElementException.class, () -> {
            // Should throw as queue is empty
            queue.element();
        });
    }
}
