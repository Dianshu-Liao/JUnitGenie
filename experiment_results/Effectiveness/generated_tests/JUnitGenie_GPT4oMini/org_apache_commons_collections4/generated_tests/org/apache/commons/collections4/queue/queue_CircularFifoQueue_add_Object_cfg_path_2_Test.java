package org.apache.commons.collections4.queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.Test;
import static org.junit.Assert.*;

public class queue_CircularFifoQueue_add_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddElementWhenNotFull() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(5);
        assertTrue(queue.add(new Object()));
    }

    @Test(timeout = 4000)
    public void testAddElementWhenFull() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(2);
        queue.add(new Object());
        queue.add(new Object());
        
        // At this point, the queue is full, so adding another element should remove the oldest one
        try {
            assertTrue(queue.add(new Object()));
        } catch (Exception e) {
            fail("Exception should not be thrown when adding an element to a full queue");
        }
    }

    @Test(timeout = 4000)
    public void testAddNullElement() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(5);
        try {
            queue.add(null);
            fail("NullPointerException should be thrown when adding a null element");
        } catch (NullPointerException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception type thrown");
        }
    }

}