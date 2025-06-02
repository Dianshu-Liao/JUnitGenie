package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.ArrayIterator;
import org.junit.Test;
import static org.junit.Assert.*;

public class iterators_ArrayIterator__init__Object_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testArrayIterator_ValidParameters() {
        Object array = new Object[5];
        int startIndex = 0;
        int endIndex = 4;

        ArrayIterator iterator = new ArrayIterator(array, startIndex, endIndex);
        assertNotNull(iterator);
    }

    @Test(timeout = 4000)
    public void testArrayIterator_EndIndexLessThanStartIndex() {
        Object array = new Object[5];
        int startIndex = 2;
        int endIndex = 1;

        try {
            new ArrayIterator(array, startIndex, endIndex);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("End index must not be less than start index.", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testArrayIterator_StartIndexOutOfBounds() {
        Object array = new Object[5];
        int startIndex = 6; // Out of bounds
        int endIndex = 4;

        try {
            new ArrayIterator(array, startIndex, endIndex);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("start index out of bounds", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testArrayIterator_EndIndexOutOfBounds() {
        Object array = new Object[5];
        int startIndex = 0;
        int endIndex = 6; // Out of bounds

        try {
            new ArrayIterator(array, startIndex, endIndex);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("end index out of bounds", e.getMessage());
        }
    }

}