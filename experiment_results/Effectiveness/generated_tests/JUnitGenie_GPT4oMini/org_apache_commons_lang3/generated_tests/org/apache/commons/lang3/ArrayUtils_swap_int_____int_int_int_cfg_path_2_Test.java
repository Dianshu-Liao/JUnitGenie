package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_swap_int_____int_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSwap() {
        int[] array = {1, 2, 3, 4, 5};
        int offset1 = 1; // valid offset
        int offset2 = 3; // valid offset
        int len = 2; // valid length

        // Perform the swap
        ArrayUtils.swap(array, offset1, offset2, len);

        // Expected result after swap
        int[] expected = {1, 4, 3, 2, 5};
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithEmptyArray() {
        int[] array = {}; // empty array
        int offset1 = 0;
        int offset2 = 0;
        int len = 1;

        // Perform the swap
        ArrayUtils.swap(array, offset1, offset2, len);

        // Expected result is still an empty array
        int[] expected = {};
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffset() {
        int[] array = {1, 2, 3, 4, 5};
        int offset1 = 5; // out of bounds
        int offset2 = 3; // valid offset
        int len = 1;

        // Perform the swap
        ArrayUtils.swap(array, offset1, offset2, len);

        // Expected result should be unchanged
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithNegativeOffset() {
        int[] array = {1, 2, 3, 4, 5};
        int offset1 = -1; // negative offset
        int offset2 = 2; // valid offset
        int len = 1;

        // Perform the swap
        ArrayUtils.swap(array, offset1, offset2, len);

        // Expected result should be unchanged
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, array);
    }

}