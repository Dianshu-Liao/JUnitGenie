package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_swap_double_____int_int_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSwapWithEmptyArray() {
        double[] array = new double[0]; // Empty array
        int offset1 = 0;
        int offset2 = 0;
        int len = 1;

        // Since the array is empty, we expect no exception and no changes to the array
        try {
            ArrayUtils.swap(array, offset1, offset2, len);
            assertArrayEquals(new double[0], array, 0.0); // The array should still be empty
        } catch (Exception e) {
            fail("Exception should not be thrown for empty array");
        }
    }


}