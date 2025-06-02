package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtils_shift_double_____int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testShiftWithNullArray() {
        double[] array = null;
        int offset = 2;

        try {
            ArrayUtils.shift(array, offset);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}