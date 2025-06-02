package org.apache.commons.collections4.queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class queue_CircularFifoQueue_increment_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIncrement() {
        try {
            // Create an instance of CircularFifoQueue with a specific maxElements value
            CircularFifoQueue queue = new CircularFifoQueue(5);
            // Access the private method increment using reflection
            Method incrementMethod = CircularFifoQueue.class.getDeclaredMethod("increment", int.class);
            incrementMethod.setAccessible(true);

            // Test case where index is less than maxElements
            int result1 = (int) incrementMethod.invoke(queue, 3);
            assertEquals(4, result1); // Expecting index to increment to 4

            // Test case where index is equal to maxElements - 1
            int result2 = (int) incrementMethod.invoke(queue, 4);
            assertEquals(0, result2); // Expecting index to wrap around to 0

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}