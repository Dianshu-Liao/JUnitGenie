package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ArrayIterator;
import org.junit.Test;
import static org.junit.Assert.*;

public class iterators_ArrayIterator__init__Object_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testArrayIteratorValidParameters() {
        Object array = new Object[5]; // Create an array of 5 objects
        int startIndex = 0;
        int endIndex = 4;

        try {
            ArrayIterator iterator = new ArrayIterator(array, startIndex, endIndex);
            assertNotNull(iterator);
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid parameters: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testArrayIteratorEndIndexLessThanStartIndex() {
        Object array = new Object[5]; // Create an array of 5 objects
        int startIndex = 1;
        int endIndex = 0;

        try {
            new ArrayIterator(array, startIndex, endIndex);
            fail("IllegalArgumentException should have been thrown when endIndex < startIndex");
        } catch (IllegalArgumentException e) {
            assertEquals("End index must not be less than start index.", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception type thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testArrayIteratorStartIndexOutOfBounds() {
        Object array = new Object[5]; // Create an array of 5 objects
        int startIndex = 5; // Out of bounds
        int endIndex = 4;

        try {
            new ArrayIterator(array, startIndex, endIndex);
            fail("IllegalArgumentException should have been thrown for startIndex out of bounds");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("start"));
        } catch (Exception e) {
            fail("Unexpected exception type thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testArrayIteratorEndIndexOutOfBounds() {
        Object array = new Object[5]; // Create an array of 5 objects
        int startIndex = 0;
        int endIndex = 6; // Out of bounds

        try {
            new ArrayIterator(array, startIndex, endIndex);
            fail("IllegalArgumentException should have been thrown for endIndex out of bounds");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("end"));
        } catch (Exception e) {
            fail("Unexpected exception type thrown: " + e.getMessage());
        }
    }

}