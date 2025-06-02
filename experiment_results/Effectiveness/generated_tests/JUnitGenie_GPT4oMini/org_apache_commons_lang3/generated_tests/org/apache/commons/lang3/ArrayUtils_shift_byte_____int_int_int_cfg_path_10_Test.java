package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_shift_byte_____int_int_int_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testShift() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 1; // valid index
        int endIndexExclusive = 4; // valid index
        int offset = 1; // valid offset

        // Expected outcome after shifting
        byte[] expected = {1, 4, 5, 2, 3};

        // Call the method under test
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);

        // Assert the expected outcome
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testShiftWithNegativeOffset() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 1; // valid index
        int endIndexExclusive = 4; // valid index
        int offset = -1; // negative offset

        // Expected outcome after shifting
        byte[] expected = {1, 2, 3, 5, 4};

        // Call the method under test
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);

        // Assert the expected outcome
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testShiftWithInvalidArray() {
        byte[] array = null;
        int startIndexInclusive = 0; // valid index
        int endIndexExclusive = 5; // valid index
        int offset = 1; // valid offset

        // Call the method under test
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);

        // No exception should be thrown and method should return
    }

    @Test(timeout = 4000)
    public void testShiftWithOutOfBoundsStartIndex() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 5; // out of bounds
        int endIndexExclusive = 5; // valid index
        int offset = 1; // valid offset

        // Call the method under test
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);

        // No exception should be thrown and method should return
    }

    @Test(timeout = 4000)
    public void testShiftWithEndIndexLessThanOrEqualToZero() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 0; // valid index
        int endIndexExclusive = 0; // invalid index
        int offset = 1; // valid offset

        // Call the method under test
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);

        // No exception should be thrown and method should return
    }

}