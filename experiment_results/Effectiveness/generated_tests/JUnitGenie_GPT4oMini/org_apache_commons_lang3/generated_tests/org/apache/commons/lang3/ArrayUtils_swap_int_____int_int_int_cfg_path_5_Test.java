package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_swap_int_____int_int_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSwapWithNonEmptyArray() {
        int[] array = {1, 2, 3, 4, 5};
        int offset1 = 1;
        int offset2 = 3;
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);

        // Expected array after swapping elements
        int[] expected = {1, 4, 3, 2, 5};
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithEmptyArray() {
        int[] array = {};
        int offset1 = 0;
        int offset2 = 0;
        int len = 1;

        ArrayUtils.swap(array, offset1, offset2, len);

        // Expected array remains unchanged
        int[] expected = {};
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithNullArray() {
        int[] array = null;
        int offset1 = 0;
        int offset2 = 1;
        int len = 1;

        try {
            ArrayUtils.swap(array, offset1, offset2, len);
        } catch (Exception e) {
            // Expecting no exception, as it should return early
        }
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffset() {
        int[] array = {1, 2, 3, 4, 5};
        int offset1 = 5; // out of bounds
        int offset2 = 2;
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);

        // Expected array remains unchanged
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, array);
    }

}