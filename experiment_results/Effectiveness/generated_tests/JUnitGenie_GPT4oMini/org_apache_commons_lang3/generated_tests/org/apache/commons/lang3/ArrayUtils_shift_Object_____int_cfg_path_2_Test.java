package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.fail;

public class ArrayUtils_shift_Object_____int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testShiftWithNullArray() {
        try {
            Object[] array = null;
            int offset = 1;
            ArrayUtils.shift(array, offset);
            // If we reach here, the method executed without throwing an exception, which is expected.
        } catch (Exception e) {
            // If an exception is thrown, we fail the test as we do not expect any exceptions.
            fail("Expected no exception but got: " + e.getMessage());
        }
    }


}