package org.apache.commons.collections4.queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class queue_CircularFifoQueue_get_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetThrowsNoSuchElementExceptionForNegativeIndex() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(5);
        try {
            queue.get(-1);
            fail("Expected NoSuchElementException for negative index");
        } catch (NoSuchElementException e) {
            assertEquals("The specified index -1 is outside the available range [0, 0)", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetThrowsNoSuchElementExceptionForIndexGreaterThanSize() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(5);
        queue.add(new Object()); // Add one element to the queue
        try {
            queue.get(1); // Index 1 is out of bounds
            fail("Expected NoSuchElementException for index greater than size");
        } catch (NoSuchElementException e) {
            assertEquals("The specified index 1 is outside the available range [0, 1)", e.getMessage());
        }
    }

}