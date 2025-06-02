package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_indexOf_double_____double_int_double_cfg_path_7_Test {

    private static final int INDEX_NOT_FOUND = -1;

    @Test(timeout = 4000)
    public void testIndexOf_EmptyArray() {
        double[] array = new double[0]; // Empty array
        double valueToFind = 1.0;
        int startIndex = 0;
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