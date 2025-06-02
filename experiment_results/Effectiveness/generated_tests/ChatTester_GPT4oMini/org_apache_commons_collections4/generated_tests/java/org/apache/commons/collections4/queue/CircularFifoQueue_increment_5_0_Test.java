package org.apache.commons.collections4.queue;

import java.lang.reflect.Method;
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

public class CircularFifoQueue_increment_5_0_Test {

    private CircularFifoQueue<Integer> queue;

    @BeforeEach
    public void setUp() {
        // Initialize the CircularFifoQueue with a max size of 5
        queue = new CircularFifoQueue<>(5);
    }

    @Test
    public void testIncrementWithinBounds() throws Exception {
        // Use reflection to access the private increment method
        Method incrementMethod = CircularFifoQueue.class.getDeclaredMethod("increment", int.class);
        incrementMethod.setAccessible(true);
        // Test incrementing a value within bounds
        int result = (int) incrementMethod.invoke(queue, 2);
        assertEquals(3, result);
    }

    @Test
    public void testIncrementAtMaxElements() throws Exception {
        // Use reflection to access the private increment method
        Method incrementMethod = CircularFifoQueue.class.getDeclaredMethod("increment", int.class);
        incrementMethod.setAccessible(true);
        // Test incrementing at the maxElements boundary
        int result = (int) incrementMethod.invoke(queue, 4);
        assertEquals(0, result);
    }

    @Test
    public void testIncrementAtZeroIndex() throws Exception {
        // Use reflection to access the private increment method
        Method incrementMethod = CircularFifoQueue.class.getDeclaredMethod("increment", int.class);
        incrementMethod.setAccessible(true);
        // Test incrementing from zero index
        int result = (int) incrementMethod.invoke(queue, 0);
        assertEquals(1, result);
    }

    @Test
    public void testIncrementAtNegativeIndex() throws Exception {
        // Use reflection to access the private increment method
        Method incrementMethod = CircularFifoQueue.class.getDeclaredMethod("increment", int.class);
        incrementMethod.setAccessible(true);
        // Test incrementing a negative index, assuming it wraps to 0
        int result = (int) incrementMethod.invoke(queue, -1);
        // Assuming negative indices wrap to 0
        assertEquals(0, result);
    }
}
