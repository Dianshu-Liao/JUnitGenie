package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ArrayUtils_isNotEmpty_float_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsNotEmpty_WithNonEmptyArray() {
        // Prepare a non-empty array
        float[] array = new float[]{1.0f, 2.0f, 3.0f};
        
        // Invoke the focal method
        boolean result = ArrayUtils.isNotEmpty(array);
        
        // Verify the result
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsNotEmpty_WithEmptyArray() {
        try {
            // Prepare an empty array
            float[] array = new float[]{};

            // This should call isEmpty and thus return false
            boolean result = ArrayUtils.isNotEmpty(array);

            // Verify the result
            assertTrue(!result);
        } catch (Exception e) {
            // Handle any exceptions that may arise
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsNotEmpty_WithNullArray() {
        try {
            // Prepare a null array
            float[] array = null;

            // Try calling isNotEmpty with null should return false
            boolean result = ArrayUtils.isNotEmpty(array);

            // Verify the result
            assertTrue(!result);
        } catch (Exception e) {
            // Handle any exceptions that may arise
            e.printStackTrace();
        }
    }

}