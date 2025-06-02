package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_swap_double_____int_int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSwapWithEmptyArray() {
        double[] array = new double[0]; // Non-null array of type double with length 0
        int offset1 = 0;
        int offset2 = 1;
        int len = 1;

        // Since the array is empty, we expect no changes to occur
        ArrayUtils.swap(array, offset1, offset2, len);
        
        // Verify that the array is still empty
        assertEquals(0, array.length);
    }

    @Test(timeout = 4000)
    public void testSwapWithValidOffsets() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        int offset1 = 0;
        int offset2 = 1;
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);
        
        // Verify that the elements at offset1 and offset2 have been swapped
        assertEquals(2.0, array[0], 0.001);
        assertEquals(1.0, array[1], 0.001);
        assertEquals(3.0, array[2], 0.001);
        assertEquals(4.0, array[3], 0.001);
    }

    @Test(timeout = 4000)
    public void testSwapWithOutOfBoundsOffsets() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        int offset1 = 4; // Out of bounds
        int offset2 = 1;
        int len = 2;

        ArrayUtils.swap(array, offset1, offset2, len);
        
        // Verify that the array remains unchanged
        assertEquals(1.0, array[0], 0.001);
        assertEquals(2.0, array[1], 0.001);
        assertEquals(3.0, array[2], 0.001);
        assertEquals(4.0, array[3], 0.001);
    }

}