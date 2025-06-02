package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ArrayUtils_isNotEmpty_long_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsNotEmptyWithEmptyArray() {
        long[] array = new long[0]; // This satisfies the constraint of being a non-null array with length 0
        try {
            boolean result = ArrayUtils.isNotEmpty(array);
            assertFalse(result); // Since the array is empty, isNotEmpty should return false
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}