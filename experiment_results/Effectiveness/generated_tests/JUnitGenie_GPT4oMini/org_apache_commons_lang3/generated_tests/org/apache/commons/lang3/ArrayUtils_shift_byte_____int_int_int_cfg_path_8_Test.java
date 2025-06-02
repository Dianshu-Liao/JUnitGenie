package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_shift_byte_____int_int_int_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testShift() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;
        int offset = 2;

        // Expected result after shifting
        byte[] expected = {3, 4, 5, 1, 2};

        // Call the method under test
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);

        // Assert the result
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testShiftWithNegativeOffset() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;
        int offset = -1;

        // Expected result after shifting
        byte[] expected = {5, 1, 2, 3, 4};

        // Call the method under test
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);

        // Assert the result
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testShiftWithNoShift() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;
        int offset = 0;

        // Expected result after shifting (no change)
        byte[] expected = {1, 2, 3, 4, 5};

        // Call the method under test
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);

        // Assert the result
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testShiftWithInvalidParameters() {
        byte[] array = null;
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;
        int offset = 2;

        // Call the method under test with null array
        try {
            ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        } catch (Exception e) {
            fail("Should not throw an exception for null array");
        }

        // Test with startIndexInclusive out of bounds
        array = new byte[]{1, 2, 3, 4, 5};
        startIndexInclusive = 6; // out of bounds
        try {
            ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        } catch (Exception e) {
            fail("Should not throw an exception for out of bounds startIndexInclusive");
        }

        // Test with endIndexExclusive less than or equal to 0
        endIndexExclusive = 0; // invalid
        try {
            ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        } catch (Exception e) {
            fail("Should not throw an exception for invalid endIndexExclusive");
        }
    }

}