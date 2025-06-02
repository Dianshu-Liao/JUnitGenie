package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ArrayUtils_isNotEmpty_float_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsNotEmpty_withNonEmptyArray() {
        float[] array = {1.0f}; // Non-empty array
        try {
            boolean result = ArrayUtils.isNotEmpty(array);
            assertFalse(result); // This should be false since isEmpty should return false
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsNotEmpty_withEmptyArray() {
        float[] array = {}; // Empty array
        try {
            boolean result = ArrayUtils.isNotEmpty(array);
            assertFalse(result); // This should be false since isEmpty should return true
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIsNotEmpty_withNullArray() {
        float[] array = null; // Null array
        try {
            boolean result = ArrayUtils.isNotEmpty(array);
            assertFalse(result); // This should be false since isEmpty should return true
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}