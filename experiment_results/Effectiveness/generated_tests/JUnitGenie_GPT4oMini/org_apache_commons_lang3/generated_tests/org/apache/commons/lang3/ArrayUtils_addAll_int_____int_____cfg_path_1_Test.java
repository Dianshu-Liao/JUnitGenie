package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_addAll_int_____int_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddAllWithNullArray1() {
        int[] array2 = {1, 2, 3};
        int[] expected = {1, 2, 3};
        
        try {
            int[] result = ArrayUtils.addAll(null, array2);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}