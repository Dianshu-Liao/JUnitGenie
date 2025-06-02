package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_swap_boolean_____int_int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSwapWithNonEmptyArrayAndValidOffsets() {
        boolean[] array = {true, false, true, false};
        int offset1 = 0;
        int offset2 = 1;
        int len = 2;
        
        ArrayUtils.swap(array, offset1, offset2, len);
        
        assertArrayEquals(new boolean[]{false, true, true, false}, array);
    }

    @Test(timeout = 4000)
    public void testSwapWithEmptyArray() {
        boolean[] array = {};
        int offset1 = 0;
        int offset2 = 1;
        int len = 2;
        
        ArrayUtils.swap(array, offset1, offset2, len);
        
        assertArrayEquals(new boolean[]{}, array); // No change expected
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfIndexOffset() {
        boolean[] array = {true, true, false};
        int offset1 = 3; // Out of bounds
        int offset2 = 2; // In bounds
        int len = 1;
        
        ArrayUtils.swap(array, offset1, offset2, len);
        
        assertArrayEquals(new boolean[]{true, true, false}, array); // No change expected
    }

}