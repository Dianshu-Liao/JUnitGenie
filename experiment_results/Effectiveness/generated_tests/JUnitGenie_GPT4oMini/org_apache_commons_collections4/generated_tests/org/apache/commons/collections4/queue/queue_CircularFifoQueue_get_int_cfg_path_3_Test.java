package org.apache.commons.collections4.queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class queue_CircularFifoQueue_get_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetValidIndex() {
        CircularFifoQueue<Integer> queue = new CircularFifoQueue<>(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        
        // Valid index
        assertEquals(Integer.valueOf(1), queue.get(0));
        assertEquals(Integer.valueOf(2), queue.get(1));
        assertEquals(Integer.valueOf(3), queue.get(2));
        assertEquals(Integer.valueOf(4), queue.get(3));
        assertEquals(Integer.valueOf(5), queue.get(4));
    }

    @Test(timeout = 4000)
    public void testGetIndexOutOfBounds() {
        CircularFifoQueue<Integer> queue = new CircularFifoQueue<>(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        
        try {
            // Invalid index (negative)
            queue.get(-1);
            fail("Expected NoSuchElementException for negative index");
        } catch (NoSuchElementException e) {
            // Expected exception
        }

        try {
            // Invalid index (greater than size)
            queue.get(5);
            fail("Expected NoSuchElementException for index equal to size");
        } catch (NoSuchElementException e) {
            // Expected exception
        }
    }

}