package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_shift_float_____int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testShiftWithValidParameters() {
        float[] array = {1.0f, 2.0f, 3.0f};
        int offset = 1;

        try {
            ArrayUtils.shift(array, offset);
            // Verify the expected outcome after the shift operation
            assertArrayEquals(new float[]{0.0f, 1.0f, 2.0f}, array, 0.0f);
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid parameters");
        }
    }

    @Test(timeout = 4000)
    public void testShiftWithNullArray() {
        float[] array = null;
        int offset = 1;

        try {
            ArrayUtils.shift(array, offset);
            // Since the array is null, we expect no exception and no change
            assertNull(array);
        } catch (Exception e) {
            fail("Exception should not have been thrown for null array");
        }
    }

    @Test(timeout = 4000)
    public void testShiftWithEmptyArray() {
        float[] array = {};
        int offset = 1;

        try {
            ArrayUtils.shift(array, offset);
            // Verify that the empty array remains unchanged
            assertArrayEquals(new float[]{}, array, 0.0f);
        } catch (Exception e) {
            fail("Exception should not have been thrown for empty array");
        }
    }

}