package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_swap_int_____int_int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSwapWithNonEmptyArrayAndValidOffsets() {
        int[] array = {1, 2, 3, 4, 5};
        int offset1 = 0;
        int offset2 = 1;
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);

        assertArrayEquals(new int[]{2, 1, 3, 4, 5}, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithEmptyArray() {
        int[] array = {};
        int offset1 = 0;
        int offset2 = 1;
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);

        assertArrayEquals(new int[]{}, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffset1() {
        int[] array = {1, 2, 3, 4, 5};
        int offset1 = 5; // Out of bounds
        int offset2 = 1;
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffset2() {
        int[] array = {1, 2, 3, 4, 5};
        int offset1 = 1;
        int offset2 = 5; // Out of bounds
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

}