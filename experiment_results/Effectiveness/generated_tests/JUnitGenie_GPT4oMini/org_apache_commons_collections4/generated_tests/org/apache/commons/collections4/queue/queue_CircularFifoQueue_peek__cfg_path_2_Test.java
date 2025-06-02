package org.apache.commons.collections4.queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class queue_CircularFifoQueue_peek__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPeekWhenQueueIsEmpty() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(1); // Initialize with capacity 1 to allow for an empty state
        try {
            // The queue is empty, so peek should return null
            assertNull(queue.peek());
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }


}