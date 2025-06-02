package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_swap_int_____int_int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSwap() {
        int[] array = {1, 2, 3, 4, 5};
        int offset1 = 1;
        int offset2 = 3;
        int len = 2;

        // Expected outcome after swap
        int[] expected = {1, 4, 3, 2, 5};

        // Perform the swap
        ArrayUtils.swap(array, offset1, offset2, len);

        // Assert the result
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithEmptyArray() {
        int[] array = {};
        int offset1 = 0;
        int offset2 = 1;
        int len = 1;

        // Perform the swap
        ArrayUtils.swap(array, offset1, offset2, len);

        // Assert that the array remains empty
        assertArrayEquals(new int[]{}, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffset() {
        int[] array = {1, 2, 3, 4, 5};
        int offset1 = 5; // Out of bounds
        int offset2 = 1;
        int len = 2;

        // Perform the swap
        ArrayUtils.swap(array, offset1, offset2, len);

        // Assert that the array remains unchanged
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithNegativeOffset() {
        int[] array = {1, 2, 3, 4, 5};
        int offset1 = -1; // Negative offset
        int offset2 = 1;
        int len = 2;

        // Perform the swap
        ArrayUtils.swap(array, offset1, offset2, len);

        // Assert that the array remains unchanged
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithZeroLength() {
        int[] array = {1, 2, 3, 4, 5};
        int offset1 = 1;
        int offset2 = 2;
        int len = 0; // Length is zero

        // Perform the swap
        ArrayUtils.swap(array, offset1, offset2, len);

        // Assert that the array remains unchanged
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

}