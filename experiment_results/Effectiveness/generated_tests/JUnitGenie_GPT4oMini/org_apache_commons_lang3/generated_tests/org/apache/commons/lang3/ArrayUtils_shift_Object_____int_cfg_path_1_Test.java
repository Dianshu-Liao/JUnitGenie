package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtils_shift_Object_____int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testShiftWithValidArrayAndOffset() {
        Object[] array = new Object[]{1, 2, 3, 4, 5};
        int offset = 2;

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
        Object[] array = null;
        int offset = 2;

        try {
            ArrayUtils.shift(array, offset);
            // Since the array is null, we expect no exception and no changes
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}