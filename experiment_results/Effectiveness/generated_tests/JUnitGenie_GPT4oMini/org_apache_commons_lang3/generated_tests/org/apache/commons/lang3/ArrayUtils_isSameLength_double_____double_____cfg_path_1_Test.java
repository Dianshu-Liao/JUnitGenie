package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class ArrayUtils_isSameLength_double_____double_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsSameLength_DifferentLengths() {
        double[] array1 = new double[]{1.0, 2.0, 3.0};
        double[] array2 = new double[]{1.0, 2.0};

        try {
            boolean result = ArrayUtils.isSameLength(array1, array2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}