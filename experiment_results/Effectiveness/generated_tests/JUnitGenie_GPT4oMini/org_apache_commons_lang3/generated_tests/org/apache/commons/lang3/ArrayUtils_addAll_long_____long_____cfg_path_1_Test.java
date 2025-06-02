package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_addAll_long_____long_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddAll_WithArray1Null() {
        long[] array2 = {1L, 2L, 3L}; // Sample second array

        try {
            long[] result = ArrayUtils.addAll(null, array2);
            long[] expected = {1L, 2L, 3L}; // Expected result when array1 is null
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if needed, although it should not occur in this case
            e.printStackTrace();
        }
    }

}