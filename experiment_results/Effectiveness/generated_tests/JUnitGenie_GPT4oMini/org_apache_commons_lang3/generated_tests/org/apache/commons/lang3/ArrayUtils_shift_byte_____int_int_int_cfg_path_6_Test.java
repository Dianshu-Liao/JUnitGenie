package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_shift_byte_____int_int_int_cfg_path_6_Test {

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
    public void testShiftWithInvalidParameters() {
        byte[] array = null;
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;
        int offset = 2;

        // Call the method under test
        try {
            ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        } catch (Exception e) {
            fail("Exception should not be thrown for null array");
        }

        // Test with startIndexInclusive out of bounds
        array = new byte[]{1, 2, 3, 4, 5};
        startIndexInclusive = 5; // out of bounds
        endIndexExclusive = 5;

        // Call the method under test
        try {
            ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        } catch (Exception e) {
            fail("Exception should not be thrown for out of bounds startIndexInclusive");
        }

        // Test with endIndexExclusive <= 0
        startIndexInclusive = 0;
        endIndexExclusive = 0; // invalid
        try {
            ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        } catch (Exception e) {
            fail("Exception should not be thrown for endIndexExclusive <= 0");
        }
    }

}