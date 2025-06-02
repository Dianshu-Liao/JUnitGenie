package org.apache.commons.collections4.queue;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.junit.Test;
import static org.junit.Assert.*;

public class queue_CircularFifoQueue_add_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddWhenAtFullCapacity() {
        // Arrange
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(2);
        queue.add(new Object()); // Add first element
        queue.add(new Object()); // Add second element

        // Ensure the queue is at full capacity
        assertTrue(queue.isAtFullCapacity());

        // Act
        try {
            boolean result = queue.add(new Object()); // This should trigger removal of the oldest element

            // Assert
            assertTrue(result);
        } catch (Exception e) {
            fail("Exception should not be thrown when adding an element at full capacity");
        }
    }

    @Test(timeout = 4000)
    public void testAddWithNullElement() {
        // Arrange
        CircularFifoQueue<Object> queue = new CircularFifoQueue<>(2);

        // Act & Assert
        try {
            queue.add(null);
            fail("NullPointerException should be thrown when adding a null element");
        } catch (NullPointerException e) {
            assertEquals("element", e.getMessage());
        }
    }

}