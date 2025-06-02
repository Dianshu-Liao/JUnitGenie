package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtils_shift_short_____int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testShiftWithNonNullArray() {
        short[] array = new short[]{1, 2, 3, 4, 5};
        int offset = 2;

        try {
            ArrayUtils.shift(array, offset);
            // Additional assertions can be added here to verify the expected outcome
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testShiftWithNullArray() {
        short[] array = null;
        int offset = 2;

        try {
            ArrayUtils.shift(array, offset);
            // Since the method should return without throwing an exception, we can assert here
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}