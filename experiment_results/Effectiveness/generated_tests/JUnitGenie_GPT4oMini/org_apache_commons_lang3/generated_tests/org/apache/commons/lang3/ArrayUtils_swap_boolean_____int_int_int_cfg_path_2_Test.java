package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_swap_boolean_____int_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSwap() {
        boolean[] array = {true, false, true, false};
        int offset1 = 0;
        int offset2 = 2;
        int len = 2;

        // Expected outcome after swap
        boolean[] expected = {true, false, true, false};
        ArrayUtils.swap(array, offset1, offset2, len);
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithEmptyArray() {
        boolean[] array = {};
        int offset1 = 0;
        int offset2 = 0;
        int len = 1;

        // No change expected as the array is empty
        ArrayUtils.swap(array, offset1, offset2, len);
        assertArrayEquals(new boolean[]{}, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithNullArray() {
        boolean[] array = null;
        int offset1 = 0;
        int offset2 = 0;
        int len = 1;

        // No change expected as the array is null
        ArrayUtils.swap(array, offset1, offset2, len);
        // Since the method does not throw an exception, we can just check that it does not crash
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffset1() {
        boolean[] array = {true, false, true, false};
        int offset1 = 5; // Out of bounds
        int offset2 = 1;
        int len = 2;

        // No change expected as offset1 is out of bounds
        ArrayUtils.swap(array, offset1, offset2, len);
        boolean[] expected = {true, false, true, false};
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffset2() {
        boolean[] array = {true, false, true, false};
        int offset1 = 1;
        int offset2 = 5; // Out of bounds
        int len = 2;

        // No change expected as offset2 is out of bounds
        ArrayUtils.swap(array, offset1, offset2, len);
        boolean[] expected = {true, false, true, false};
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithNegativeOffset1() {
        boolean[] array = {true, false, true, false};
        int offset1 = -1; // Negative offset
        int offset2 = 1;
        int len = 2;

        // No change expected as offset1 is negative
        ArrayUtils.swap(array, offset1, offset2, len);
        boolean[] expected = {true, false, true, false};
        assertArrayEquals(expected, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithNegativeOffset2() {
        boolean[] array = {true, false, true, false};
        int offset1 = 1;
        int offset2 = -1; // Negative offset
        int len = 2;

        // No change expected as offset2 is negative
        ArrayUtils.swap(array, offset1, offset2, len);
        boolean[] expected = {true, false, true, false};
        assertArrayEquals(expected, array);
    }

}