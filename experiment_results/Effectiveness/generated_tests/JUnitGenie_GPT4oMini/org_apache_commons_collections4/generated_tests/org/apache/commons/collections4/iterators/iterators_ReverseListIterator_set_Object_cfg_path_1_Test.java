package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ReverseListIterator;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class iterators_ReverseListIterator_set_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetWithValidUpdate() {
        // Create a list and add elements
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3)); // Changed to ArrayList
        ReverseListIterator<Integer> iterator = new ReverseListIterator<>(list);
        
        // Move the iterator to a valid position
        iterator.previous(); // Now it points to 3
        iterator.previous(); // Now it points to 2
        
        // Set a new value at the current position
        iterator.set(10);

        // Verify the update
        assertEquals(new Integer(10), list.get(1)); // The second element should be updated to 10
    }

    @Test(timeout = 4000)
    public void testSetWithInvalidUpdate() {
        // Create a list and add elements
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3)); // Changed to ArrayList
        ReverseListIterator<Integer> iterator = new ReverseListIterator<>(list);

        try {
            // Attempt to set an element without moving the iterator
            iterator.set(10);
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            assertEquals("Cannot set to list until next() or previous() called", e.getMessage());
        }
    }


}