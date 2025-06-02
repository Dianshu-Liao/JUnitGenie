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
        // Initialize with a size of 5
        queue = new CircularFifoQueue<>(5);
    }

    private int invokeIncrement(int index) throws Exception {
        Method incrementMethod = CircularFifoQueue.class.getDeclaredMethod("increment", int.class);
        incrementMethod.setAccessible(true);
        return (int) incrementMethod.invoke(queue, index);
    }

    @Test
    public void testIncrementWithinBounds() throws Exception {
        // Test incrementing a value within the bounds of the queue
        int initialIndex = 2;
        int expectedIndex = 3;
        int newIndex = invokeIncrement(initialIndex);
        assertEquals(expectedIndex, newIndex, "The incremented index should be 3.");
    }

    @Test
    public void testIncrementAtMaxIndex() throws Exception {
        // Test incrementing the max index, which should wrap around to 0
        int initialIndex = 4;
        int expectedIndex = 0;
        int newIndex = invokeIncrement(initialIndex);
        assertEquals(expectedIndex, newIndex, "The incremented index should wrap around to 0.");
    }

    @Test
    public void testIncrementAtNegativeIndex() throws Exception {
        // Test incrementing a negative index (should not normally occur, but let's handle it)
        int initialIndex = -1;
        // Assuming negative values wrap around to 0
        int expectedIndex = 0;
        int newIndex = invokeIncrement(initialIndex);
        assertEquals(expectedIndex, newIndex, "The incremented index from -1 should be 0.");
    }

    @Test
    public void testIncrementAtZeroIndex() throws Exception {
        // Test incrementing from index 0
        int initialIndex = 0;
        int expectedIndex = 1;
        int newIndex = invokeIncrement(initialIndex);
        assertEquals(expectedIndex, newIndex, "The incremented index from 0 should be 1.");
    }
}
