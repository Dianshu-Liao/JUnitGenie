package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_swap_double_____int_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSwap() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        int offset1 = 1;
        int offset2 = 2;
        int len = 2;

        // Expected result after swap
        double[] expected = {1.0, 3.0, 2.0, 4.0};

        // Call the swap method
        ArrayUtils.swap(array, offset1, offset2, len);

        // Assert the expected result
        assertArrayEquals(expected, array, 0.0);
    }

    @Test(timeout = 4000)
    public void testSwapWithEmptyArray() {
        double[] array = {};
        int offset1 = 0;
        int offset2 = 1;
        int len = 1;

        // Call the swap method
        ArrayUtils.swap(array, offset1, offset2, len);

        // Assert that the array remains empty
        assertArrayEquals(new double[]{}, array, 0.0);
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffsets() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        int offset1 = 4; // Out of bounds
        int offset2 = 2;
        int len = 1;

        // Call the swap method
        ArrayUtils.swap(array, offset1, offset2, len);

        // Assert that the array remains unchanged
        assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0}, array, 0.0);
    }

    @Test(timeout = 4000)
    public void testSwapWithNegativeOffsets() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        int offset1 = -1; // Negative offset
        int offset2 = 2;
        int len = 1;

        // Call the swap method
        ArrayUtils.swap(array, offset1, offset2, len);

        // Assert that the array remains unchanged
        assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0}, array, 0.0);
    }

}