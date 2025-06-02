package org.apache.commons.collections4.queue;

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

public class CircularFifoQueue_get_4_0_Test {

    private CircularFifoQueue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new CircularFifoQueue<>(5);
    }

    @Test
    public void testGetValidIndex() {
        queue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(1, queue.get(0));
        assertEquals(3, queue.get(2));
        assertEquals(5, queue.get(4));
    }

    @Test
    public void testGetIndexOutOfBoundsNegative() {
        queue.addAll(Arrays.asList(1, 2, 3));
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            queue.get(-1);
        });
        assertEquals("The specified index -1 is outside the available range [0, 3)", exception.getMessage());
    }

    @Test
    public void testGetIndexOutOfBoundsPositive() {
        queue.addAll(Arrays.asList(1, 2, 3));
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            queue.get(3);
        });
        assertEquals("The specified index 3 is outside the available range [0, 3)", exception.getMessage());
    }

    @Test
    public void testGetEmptyQueue() {
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            queue.get(0);
        });
        assertEquals("The specified index 0 is outside the available range [0, 0)", exception.getMessage());
    }

    @Test
    public void testGetAfterWrapAround() {
        queue.addAll(Arrays.asList(1, 2, 3, 4, 5));
        // Access the first element
        queue.get(0);
        // Access the second element
        queue.get(1);
        // Access the third element
        queue.get(2);
        // Access the fourth element
        queue.get(3);
        // Access the fifth element
        queue.get(4);
        // This will remove the first element (1)
        queue.add(6);
        // Now the first element should be 2
        assertEquals(2, queue.get(0));
        // Second element should still be 3
        assertEquals(3, queue.get(1));
        // Third element should still be 4
        assertEquals(4, queue.get(2));
        // Fourth element should still be 5
        assertEquals(5, queue.get(3));
        // Fifth element should be the new one (6)
        assertEquals(6, queue.get(4));
    }
}
