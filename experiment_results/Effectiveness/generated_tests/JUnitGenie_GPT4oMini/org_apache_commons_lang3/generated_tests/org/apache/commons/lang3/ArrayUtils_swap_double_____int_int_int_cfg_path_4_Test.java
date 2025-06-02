package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_swap_double_____int_int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSwapWithNonEmptyArray() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        int offset1 = 0;
        int offset2 = 1;
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);

        assertArrayEquals(new double[]{2.0, 1.0, 3.0, 4.0}, array, 0.0001);
    }

    @Test(timeout = 4000)
    public void testSwapWithEmptyArray() {
        double[] array = {};
        int offset1 = 0;
        int offset2 = 1;
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);

        assertArrayEquals(new double[]{}, array, 0.0001);
    }

    @Test(timeout = 4000)
    public void testSwapWithNullArray() {
        double[] array = null;
        int offset1 = 0;
        int offset2 = 1;
        int len = 2;

        try {
            ArrayUtils.swap(array, offset1, offset2, len);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffset() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        int offset1 = 4; // out of bounds
        int offset2 = 1;
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);

        assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0}, array, 0.0001);
    }

}