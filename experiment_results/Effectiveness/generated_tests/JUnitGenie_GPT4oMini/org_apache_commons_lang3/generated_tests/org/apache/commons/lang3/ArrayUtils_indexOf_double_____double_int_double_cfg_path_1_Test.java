package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_indexOf_double_____double_int_double_cfg_path_1_Test {

    private static final int INDEX_NOT_FOUND = -1;

    @Test(timeout = 4000)
    public void testIndexOf_EmptyArray() {
        double[] emptyArray = new double[0];
        double valueToFind = 5.0;
        int startIndex = 0;
        double tolerance = 0.1;

        try {
            int result = ArrayUtils.indexOf(emptyArray, valueToFind, startIndex, tolerance);
            assertEquals(INDEX_NOT_FOUND, result);
        } catch (Exception e) {
            // Handle exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIndexOf_NullArray() {
        double[] nullArray = null;
        double valueToFind = 5.0;
        int startIndex = 0;
        double tolerance = 0.1;

        try {
            int result = ArrayUtils.indexOf(nullArray, valueToFind, startIndex, tolerance);
            assertEquals(INDEX_NOT_FOUND, result);
        } catch (Exception e) {
            // Handle exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIndexOf_FoundWithinTolerance() {
        double[] array = {1.0, 2.0, 5.05, 3.0, 7.0};
        double valueToFind = 5.0;
        int startIndex = 0;
        double tolerance = 0.1;

        try {
            int result = ArrayUtils.indexOf(array, valueToFind, startIndex, tolerance);
            assertEquals(2, result); // Found at index 2
        } catch (Exception e) {
            // Handle exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIndexOf_NotFound() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double valueToFind = 5.0;
        int startIndex = 0;
        double tolerance = 0.1;

        try {
            int result = ArrayUtils.indexOf(array, valueToFind, startIndex, tolerance);
            assertEquals(INDEX_NOT_FOUND, result); // Not found
        } catch (Exception e) {
            // Handle exception if it occurs
            e.printStackTrace();
        }
    }

}