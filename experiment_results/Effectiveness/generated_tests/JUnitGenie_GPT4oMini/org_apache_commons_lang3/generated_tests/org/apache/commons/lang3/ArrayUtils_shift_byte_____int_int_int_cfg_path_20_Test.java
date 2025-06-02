package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_shift_byte_____int_int_int_cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testShift() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 1;
        int endIndexExclusive = 4;
        int offset = 2;

        // Expected result after shifting
        byte[] expected = {1, 4, 5, 2, 3};

        // Perform the shift operation
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);

        // Assert the result
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testShiftWithNegativeOffset() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 1;
        int endIndexExclusive = 4;
        int offset = -1;

        // Expected result after shifting
        byte[] expected = {1, 2, 5, 3, 4};

        // Perform the shift operation
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);

        // Assert the result
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testShiftWithNullArray() {
        byte[] array = null;
        int startIndexInclusive = 0;
        int endIndexExclusive = 1;
        int offset = 1;

        // Perform the shift operation
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        // No exception should be thrown, and method should return without modifying the array
    }

    @Test(timeout = 4000)
    public void testShiftWithOutOfBoundsStartIndex() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 5; // Out of bounds
        int endIndexExclusive = 5;
        int offset = 1;

        // Perform the shift operation
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        // No exception should be thrown, and method should return without modifying the array
        assertArrayEquals(new byte[]{1, 2, 3, 4, 5}, array);
    }

    @Test(timeout = 4000)
    public void testShiftWithEndIndexLessThanOrEqualToZero() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 0;
        int endIndexExclusive = 0; // Invalid end index
        int offset = 1;

        // Perform the shift operation
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        // No exception should be thrown, and method should return without modifying the array
        assertArrayEquals(new byte[]{1, 2, 3, 4, 5}, array);
    }

}