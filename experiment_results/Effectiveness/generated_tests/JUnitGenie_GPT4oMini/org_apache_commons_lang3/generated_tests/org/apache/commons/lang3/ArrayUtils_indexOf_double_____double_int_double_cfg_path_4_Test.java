package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_indexOf_double_____double_int_double_cfg_path_4_Test {

    private static final int INDEX_NOT_FOUND = -1; // Assuming this is the constant used in the focal method

    @Test(timeout = 4000)
    public void testIndexOfWithEmptyArray() {
        double[] array = new double[0]; // Constraint: non-null and length must be 0
        double valueToFind = 1.0;
        int startIndex = 0; // Constraint: non-negative integer
        double tolerance = 0.1;

        try {
            int result = ArrayUtils.indexOf(array, valueToFind, startIndex, tolerance);
            assertEquals(INDEX_NOT_FOUND, result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}