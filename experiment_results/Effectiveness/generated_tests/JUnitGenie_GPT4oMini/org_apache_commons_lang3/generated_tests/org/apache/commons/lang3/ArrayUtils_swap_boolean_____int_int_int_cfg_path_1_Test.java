package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_swap_boolean_____int_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSwapWithEmptyArray() {
        boolean[] array = new boolean[0]; // empty array
        int offset1 = 0;
        int offset2 = 0;
        int len = 1; // length to swap

        // Call the swap method
        ArrayUtils.swap(array, offset1, offset2, len);

        // Assert that the array remains unchanged
        boolean[] expected = new boolean[0];
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithValidParameters() {
        boolean[] array = {true, false, true, false};
        int offset1 = 1;
        int offset2 = 2;
        int len = 1; // length to swap

        // Call the swap method
        ArrayUtils.swap(array, offset1, offset2, len);

        // Assert that the elements at offset1 and offset2 are swapped
        boolean[] expected = {true, true, false, false};
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffset1() {
        boolean[] array = {true, false, true, false};
        int offset1 = 4; // out of bounds
        int offset2 = 2;
        int len = 1; // length to swap

        // Call the swap method
        ArrayUtils.swap(array, offset1, offset2, len);

        // Assert that the array remains unchanged
        boolean[] expected = {true, false, true, false};
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffset2() {
        boolean[] array = {true, false, true, false};
        int offset1 = 1;
        int offset2 = 4; // out of bounds
        int len = 1; // length to swap

        // Call the swap method
        ArrayUtils.swap(array, offset1, offset2, len);

        // Assert that the array remains unchanged
        boolean[] expected = {true, false, true, false};
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithNegativeOffset1() {
        boolean[] array = {true, false, true, false};
        int offset1 = -1; // negative offset
        int offset2 = 2;
        int len = 1; // length to swap

        // Call the swap method
        ArrayUtils.swap(array, offset1, offset2, len);

        // Assert that the array remains unchanged
        boolean[] expected = {true, false, true, false};
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithNegativeOffset2() {
        boolean[] array = {true, false, true, false};
        int offset1 = 1;
        int offset2 = -1; // negative offset
        int len = 1; // length to swap

        // Call the swap method
        ArrayUtils.swap(array, offset1, offset2, len);

        // Assert that the array remains unchanged
        boolean[] expected = {true, false, true, false};
        assertArrayEquals(expected, array);
    }

}