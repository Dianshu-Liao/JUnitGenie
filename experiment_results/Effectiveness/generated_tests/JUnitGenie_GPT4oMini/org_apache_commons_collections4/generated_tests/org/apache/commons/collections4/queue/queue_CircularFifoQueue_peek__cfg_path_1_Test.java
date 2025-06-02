package org.apache.commons.collections4.queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class queue_CircularFifoQueue_peek__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPeekWhenQueueIsEmpty() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(1); // Create a queue with size 1
        // Call the peek method
        Object result = queue.peek();
        // Assert that the result is null when the queue is empty
        assertNull(result);
    }


}