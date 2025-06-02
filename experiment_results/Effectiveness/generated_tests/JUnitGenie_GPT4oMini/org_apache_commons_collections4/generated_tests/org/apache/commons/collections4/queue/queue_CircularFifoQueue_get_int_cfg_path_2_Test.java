package org.apache.commons.collections4.queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class queue_CircularFifoQueue_get_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetThrowsNoSuchElementExceptionWhenIndexIsNegative() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(5);
        try {
            queue.get(-1);
            fail("Expected NoSuchElementException for negative index");
        } catch (NoSuchElementException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testGetThrowsNoSuchElementExceptionWhenIndexIsOutOfBounds() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(5);
        queue.add("Element1");
        queue.add("Element2");
        queue.add("Element3");
        queue.add("Element4");
        queue.add("Element5");
        
        try {
            queue.get(5); // Index is out of bounds
            fail("Expected NoSuchElementException for out of bounds index");
        } catch (NoSuchElementException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testGetReturnsElementWhenIndexIsValid() {
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(5);
        queue.add("Element1");
        queue.add("Element2");
        queue.add("Element3");
        
        Object result = queue.get(1); // Valid index
        assertEquals("Element2", result);
    }

}