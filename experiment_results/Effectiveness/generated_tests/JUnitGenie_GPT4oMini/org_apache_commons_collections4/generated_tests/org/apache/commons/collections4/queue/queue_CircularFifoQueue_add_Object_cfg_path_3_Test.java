package org.apache.commons.collections4.queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.Test;
import static org.junit.Assert.*;

public class queue_CircularFifoQueue_add_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAddElementWhenNotFull() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(5);
        assertTrue(queue.add(new Object()));
        assertTrue(queue.add(new Object()));
        assertTrue(queue.add(new Object()));
        assertTrue(queue.add(new Object()));
        assertTrue(queue.add(new Object()));
    }

    @Test(timeout = 4000)
    public void testAddElementWhenFull() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(3);
        queue.add(new Object());
        queue.add(new Object());
        queue.add(new Object());
        
        // At this point, the queue is full, adding another element should remove the oldest
        assertTrue(queue.add(new Object()));
    }

    @Test(timeout = 4000)
    public void testAddNullElement() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(5);
        try {
            queue.add(null);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            assertEquals("element", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAddElementWithFullCapacity() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(2);
        queue.add(new Object());
        queue.add(new Object());
        
        // The queue is now full, adding another element should remove the oldest
        assertTrue(queue.add(new Object()));
    }

}