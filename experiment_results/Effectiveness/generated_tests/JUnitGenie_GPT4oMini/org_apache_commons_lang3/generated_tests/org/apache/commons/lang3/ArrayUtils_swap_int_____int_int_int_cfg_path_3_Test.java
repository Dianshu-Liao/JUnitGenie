package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_swap_int_____int_int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSwapWithValidParameters() {
        int[] array = {1, 2, 3, 4, 5};
        int offset1 = 1;
        int offset2 = 3;
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);

        assertArrayEquals(new int[]{1, 4, 3, 2, 5}, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithEmptyArray() {
        int[] array = {};
        int offset1 = 0;
        int offset2 = 1;
        int len = 1;

        try {
            ArrayUtils.swap(array, offset1, offset2, len);
        } catch (Exception e) {
            fail("Exception should not be thrown for empty array");
        }
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
            fail("Exception should not be thrown for null array");
        }
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffset1() {
        int[] array = {1, 2, 3, 4, 5};
        int offset1 = 5; // out of bounds
        int offset2 = 1;
        int len = 2;

        try {
            ArrayUtils.swap(array, offset1, offset2, len);
        } catch (Exception e) {
            fail("Exception should not be thrown for out of bounds offset1");
        }
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffset2() {
        int[] array = {1, 2, 3, 4, 5};
        int offset1 = 1;
        int offset2 = 5; // out of bounds
        int len = 2;

        try {
            ArrayUtils.swap(array, offset1, offset2, len);
        } catch (Exception e) {
            fail("Exception should not be thrown for out of bounds offset2");
        }
    }

}