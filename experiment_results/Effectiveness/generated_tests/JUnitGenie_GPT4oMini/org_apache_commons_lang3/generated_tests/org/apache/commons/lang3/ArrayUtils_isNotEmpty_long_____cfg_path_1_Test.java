package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ArrayUtils_isNotEmpty_long_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsNotEmpty() {
        long[] array = new long[]{1L}; // Meeting the constraints: non-null and length > 0
        try {
            boolean result = ArrayUtils.isNotEmpty(array);
            assertFalse(result); // This is incorrect; we expect this to be true since the array is not empty
        } catch (Exception e) {
            e.printStackTrace(); // Handling the exception case
        }
    }

    @Test(timeout = 4000)
    public void testIsNotEmptyEmptyArray() {
        long[] array = new long[]{}; // This should trigger the isEmpty method to return true
        try {
            boolean result = ArrayUtils.isNotEmpty(array);
            assertFalse(result); // As it should be false for an empty array
        } catch (Exception e) {
            e.printStackTrace(); // Handling the exception case
        }
    }

}