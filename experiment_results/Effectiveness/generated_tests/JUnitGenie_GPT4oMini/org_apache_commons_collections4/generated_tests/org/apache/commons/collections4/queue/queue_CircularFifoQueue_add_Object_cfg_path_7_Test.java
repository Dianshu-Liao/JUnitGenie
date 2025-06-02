package org.apache.commons.collections4.queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.Test;
import static org.junit.Assert.*;

public class queue_CircularFifoQueue_add_Object_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testAddElementWhenNotFull() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(3);
        queue.add(new Object()); // Add first element
        queue.add(new Object()); // Add second element
        assertTrue(queue.add(new Object())); // Add third element, should return true
    }

    @Test(timeout = 4000)
    public void testAddElementWhenFull() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(2);
        queue.add(new Object()); // Add first element
        queue.add(new Object()); // Add second element
        // At this point, the queue is full, so the next add should remove the oldest element
        assertTrue(queue.add(new Object())); // Should return true after removing the oldest element
    }

    @Test(timeout = 4000)
    public void testAddNullElement() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(3);
        try {
            queue.add(null); // This should throw a NullPointerException
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            assertEquals("element", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAddElementWhenQueueIsEmpty() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(2);
        assertTrue(queue.add(new Object())); // Adding to an empty queue should return true
    }

}