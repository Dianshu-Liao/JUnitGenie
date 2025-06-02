package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ArrayUtils_isNotEmpty_short_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsNotEmptyWithNullArray() {
        short[] array = null; // This satisfies the constraint for isEmpty to return true
        try {
            boolean result = ArrayUtils.isNotEmpty(array);
            assertFalse(result); // Expecting false since the array is null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}