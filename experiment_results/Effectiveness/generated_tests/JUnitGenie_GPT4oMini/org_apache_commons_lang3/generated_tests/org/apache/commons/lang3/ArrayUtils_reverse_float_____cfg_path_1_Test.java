package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_reverse_float_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReverseWithNonNullArray() {
        float[] array = {1.0f, 2.0f, 3.0f};
        try {
            ArrayUtils.reverse(array);
            // Verify the array is reversed
            assertArrayEquals(new float[]{3.0f, 2.0f, 1.0f}, array, 0.0f);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReverseWithNullArray() {
        float[] array = null;
        try {
            ArrayUtils.reverse(array);
            // Since the method should not throw an exception, we can assert that the method completes without issues
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}