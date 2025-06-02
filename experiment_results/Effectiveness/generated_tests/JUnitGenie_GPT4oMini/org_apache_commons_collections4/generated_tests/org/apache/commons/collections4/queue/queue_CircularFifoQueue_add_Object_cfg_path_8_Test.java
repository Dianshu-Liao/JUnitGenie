package org.apache.commons.collections4.queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.Test;
import static org.junit.Assert.*;

public class queue_CircularFifoQueue_add_Object_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testAddWhenQueueIsNotFull() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(3);
        queue.add(new Object()); // Add first element
        queue.add(new Object()); // Add second element

        // Ensure the queue is not full
        assertFalse(queue.isAtFullCapacity());
        
        // Add third element
        boolean result = queue.add(new Object());
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testAddWhenQueueIsFull() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(2);
        queue.add(new Object()); // Add first element
        queue.add(new Object()); // Add second element

        // Ensure the queue is full
        assertTrue(queue.isAtFullCapacity());

        // Add third element, which should trigger removal of the oldest element
        boolean result = queue.add(new Object());
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testAddWithNullElement() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(3);
        try {
            queue.add(null); // Attempt to add null
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            assertEquals("element", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAddWhenQueueIsEmpty() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(3);
        boolean result = queue.add(new Object()); // Add first element
        assertTrue(result);
    }

}