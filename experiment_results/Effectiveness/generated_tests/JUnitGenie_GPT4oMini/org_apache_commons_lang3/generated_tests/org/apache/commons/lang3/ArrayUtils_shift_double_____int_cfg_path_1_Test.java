package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtils_shift_double_____int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testShiftWithValidArray() {
        double[] array = {1.0, 2.0, 3.0};
        int offset = 1;

        try {
            ArrayUtils.shift(array, offset);
            // Additional assertions can be added here to verify the state of the array after the shift
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testShiftWithNullArray() {
        double[] array = null;
        int offset = 1;

        try {
            ArrayUtils.shift(array, offset);
            // Since the method should not throw an exception, we can assert that no exception occurred
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}