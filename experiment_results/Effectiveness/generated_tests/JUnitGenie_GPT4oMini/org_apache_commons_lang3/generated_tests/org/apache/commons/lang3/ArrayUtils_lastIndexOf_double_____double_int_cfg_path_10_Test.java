package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_lastIndexOf_double_____double_int_cfg_path_10_Test {

    private static final int INDEX_NOT_FOUND = -1; // Assuming this constant is defined as per the method's logic

    @Test(timeout = 4000)
    public void testLastIndexOf_ArrayIsEmpty() {
        double[] array = null; // Test with null array
        double valueToFind = 1.0;
        int startIndex = 0;

        try {
            int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(INDEX_NOT_FOUND, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_ArrayIsEmptyWithZeroLength() {
        double[] array = new double[0]; // Test with empty array
        double valueToFind = 1.0;
        int startIndex = 0;

        try {
            int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(INDEX_NOT_FOUND, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}