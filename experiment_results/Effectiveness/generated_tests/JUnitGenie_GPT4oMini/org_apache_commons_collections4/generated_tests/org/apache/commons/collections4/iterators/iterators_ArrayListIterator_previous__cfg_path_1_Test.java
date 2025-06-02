package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class iterators_ArrayListIterator_previous__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPrevious() {
        // Setup: Create an array and instantiate ArrayListIterator
        Object[] array = {1, 2, 3};
        ArrayListIterator<Object> iterator = new ArrayListIterator<>(array, 1); // Start at index 1

        // Ensure the iterator has a previous element
        assertTrue(iterator.hasPrevious());

        // Execute the focal method
        Object result = null;
        try {
            result = iterator.previous();
        } catch (NoSuchElementException e) {
            fail("NoSuchElementException should not be thrown when hasPrevious() is true.");
        }

        // Verify the result
        assertEquals(1, result); // The previous element to index 1 is 1
    }

    @Test(timeout = 4000)
    public void testPreviousThrowsException() {
        // Setup: Create an array and instantiate ArrayListIterator
        Object[] array = {1, 2, 3};
        ArrayListIterator<Object> iterator = new ArrayListIterator<>(array, 0); // Start at index 0

        // Ensure the iterator does not have a previous element
        assertFalse(iterator.hasPrevious());

        // Execute the focal method and expect an exception
        try {
            iterator.previous();
            fail("Expected NoSuchElementException to be thrown.");
        } catch (NoSuchElementException e) {
            // Exception is expected, test passes
        }
    }


}