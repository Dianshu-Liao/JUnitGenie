package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ArrayUtils_isSameLength_double_____double_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsSameLength_DifferentLengths() {
        double[] array1 = new double[3]; // Length 3
        double[] array2 = new double[5]; // Length 5

        try {
            boolean result = ArrayUtils.isSameLength(array1, array2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}