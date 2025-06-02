package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ArrayIterator;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class iterators_ArrayIterator_next__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNext() {
        // Setup: Create an array and instantiate ArrayIterator
        Object[] testArray = new Object[] { "first", "second", "third" };
        ArrayIterator iterator = new ArrayIterator(testArray, 0, testArray.length);

        // Ensure hasNext() returns true before calling next()
        assertTrue(iterator.hasNext());

        // Execute: Call next() and verify the returned value
        Object result = null;
        try {
            result = iterator.next();
        } catch (Exception e) {
            fail("next() threw an exception: " + e.getMessage());
        }

        // Verify: Check the result is as expected
        assertEquals("first", result);

        // Move to the next element
        try {
            result = iterator.next();
        } catch (Exception e) {
            fail("next() threw an exception: " + e.getMessage());
        }

        // Verify: Check the result is as expected
        assertEquals("second", result);
        
        // Move to the next element
        try {
            result = iterator.next();
        } catch (Exception e) {
            fail("next() threw an exception: " + e.getMessage());
        }

        // Verify: Check the result is as expected
        assertEquals("third", result);

        // Ensure hasNext() returns false after consuming all elements
        assertFalse(iterator.hasNext());

        // Test exception when calling next() after all elements have been consumed
        try {
            iterator.next();
            fail("Expected NoSuchElementException was not thrown");
        } catch (NoSuchElementException e) {
            // Expected exception
        } catch (Exception e) {
            fail("next() threw an unexpected exception: " + e.getMessage());
        }
    }


}