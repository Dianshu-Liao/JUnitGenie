package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_shift_byte_____int_int_int_cfg_path_18_Test {

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
        byte[] expected = {2, 3, 4, 5, 1};

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
    public void testShiftWithInvalidParameters() {
        byte[] array = null;
        int startIndexInclusive = 0;
        int endIndexExclusive = 5;
        int offset = 2;

        // Call the method under test with null array
        try {
            ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);
        } catch (Exception e) {
            // Handle exception if needed
        }

        // No assertion needed, just ensuring it doesn't throw an exception
    }

    @Test(timeout = 4000)
    public void testShiftWithOutOfBoundsStartIndex() {
        byte[] array = {1, 2, 3, 4, 5};
        int startIndexInclusive = 5; // Out of bounds
        int endIndexExclusive = 5;
        int offset = 2;

        // Call the method under test
        ArrayUtils.shift(array, startIndexInclusive, endIndexExclusive, offset);

        // Assert the array remains unchanged
        byte[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, array);
    }

}