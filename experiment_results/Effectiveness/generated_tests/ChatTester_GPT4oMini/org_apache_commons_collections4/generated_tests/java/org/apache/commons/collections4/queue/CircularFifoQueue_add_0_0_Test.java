package org.apache.commons.collections4.queue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
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
import java.util.Queue;
import org.apache.commons.collections4.BoundedCollection;

class CircularFifoQueue_add_0_0_Test {

    private CircularFifoQueue<String> queue;

    @BeforeEach
    void setUp() {
        // Initialize with a maximum size of 3
        queue = new CircularFifoQueue<>(3);
    }

    @Test
    void testAddElementWhenNotFull() {
        assertTrue(queue.add("A"));
        assertTrue(queue.add("B"));
        assertTrue(queue.add("C"));
        assertEquals(3, getSize());
        assertArrayEquals(new String[] { "A", "B", "C" }, getElements());
    }

    @Test
    void testAddElementWhenFull() {
        queue.add("A");
        queue.add("B");
        queue.add("C");
        // This should remove "A" and add "D"
        assertTrue(queue.add("D"));
        assertEquals(3, getSize());
        assertArrayEquals(new String[] { "B", "C", "D" }, getElements());
    }

    @Test
    void testAddNullElementThrowsException() {
        assertThrows(NullPointerException.class, () -> queue.add(null));
    }

    @Test
    void testAddMultipleElements() {
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        queue.add("E");
        assertEquals(3, getSize());
        assertArrayEquals(new String[] { "C", "D", "E" }, getElements());
    }

    @Test
    void testAddAtFullCapacity() {
        queue.add("A");
        queue.add("B");
        queue.add("C");
        // Should remove "A"
        assertTrue(queue.add("D"));
        // Should remove "B"
        assertTrue(queue.add("E"));
        assertEquals(3, getSize());
        assertArrayEquals(new String[] { "C", "D", "E" }, getElements());
    }

    // Reflection to test private methods if needed
    private Object[] getElements() {
        try {
            java.lang.reflect.Field elementsField = CircularFifoQueue.class.getDeclaredField("elements");
            elementsField.setAccessible(true);
            return (Object[]) elementsField.get(queue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getSize() {
        try {
            java.lang.reflect.Method sizeMethod = CircularFifoQueue.class.getDeclaredMethod("size");
            sizeMethod.setAccessible(true);
            return (int) sizeMethod.invoke(queue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
