package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_shift_byte_____int_int_int_cfg_path_7_Test {

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

        // Assert the expected outcome
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

        // Assert the expected outcome
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

        // Assert the expected outcome
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testShiftWithSingleElement() {
        byte[] array = {1};
        int startIndexInclusive = 0;
        int endIndexExclusive = 1;
        int offset = 1;

        // Expected result after shifting (no change)
        byte[] expected = {1};

        // Call the method under test
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);

        // Assert the expected outcome
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testShiftWithNullArray() {
        byte[] array = null;
        int startIndexInclusive = 0;
        int endIndexExclusive = 0;
        int offset = 1;

        // Call the method under test
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);

        // No assertion needed, method should handle null without exception
    }

    @Test(timeout = 4000)
    public void testShiftWithInvalidIndices() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 5; // Invalid index
        int endIndexExclusive = 5;
        int offset = 1;

        // Call the method under test
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);

        // No assertion needed, method should handle invalid indices without exception
    }

}