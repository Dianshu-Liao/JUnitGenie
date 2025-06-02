package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_swap_boolean_____int_int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSwapWithValidParameters() {
        boolean[] array = {true, false, true, false};
        int offset1 = 0;
        int offset2 = 2;
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);

        assertArrayEquals(new boolean[]{true, false, false, true}, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithEmptyArray() {
        boolean[] array = {};
        int offset1 = 0;
        int offset2 = 1;
        int len = 1;

        ArrayUtils.swap(array, offset1, offset2, len);
        
        // The array should remain unchanged
        assertArrayEquals(new boolean[]{}, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffset1() {
        boolean[] array = {true, false, true, false};
        int offset1 = 4; // Out of bounds
        int offset2 = 1;
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);
        
        // The array should remain unchanged
        assertArrayEquals(new boolean[]{true, false, true, false}, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffset2() {
        boolean[] array = {true, false, true, false};
        int offset1 = 1;
        int offset2 = 4; // Out of bounds
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);
        
        // The array should remain unchanged
        assertArrayEquals(new boolean[]{true, false, true, false}, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithNegativeOffset1() {
        boolean[] array = {true, false, true, false};
        int offset1 = -1; // Negative offset
        int offset2 = 1;
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);
        
        // The array should remain unchanged
        assertArrayEquals(new boolean[]{true, false, true, false}, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithNegativeOffset2() {
        boolean[] array = {true, false, true, false};
        int offset1 = 1;
        int offset2 = -1; // Negative offset
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);
        
        // The array should remain unchanged
        assertArrayEquals(new boolean[]{true, false, true, false}, array);
    }

}