package org.apache.commons.collections4.queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.Test;
import static org.junit.Assert.*;

public class queue_CircularFifoQueue_add_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testAddElementWhenNotFull() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(3);
        assertTrue(queue.add(new Object()));
        assertTrue(queue.add(new Object()));
        assertTrue(queue.add(new Object()));
    }

    @Test(timeout = 4000)
    public void testAddElementWhenFull() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(2);
        queue.add(new Object());
        queue.add(new Object());
        
        // The queue is full, so the next add should remove the oldest element
        assertTrue(queue.add(new Object()));
    }

    @Test(timeout = 4000)
    public void testAddNullElement() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(3);
        try {
            queue.add(null);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            assertEquals("element", e.getMessage());
        }
    }

}