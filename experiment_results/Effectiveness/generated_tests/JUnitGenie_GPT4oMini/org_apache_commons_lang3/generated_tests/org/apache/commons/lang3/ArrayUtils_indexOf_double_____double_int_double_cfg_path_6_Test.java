package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_indexOf_double_____double_int_double_cfg_path_6_Test {

    private static final int INDEX_NOT_FOUND = -1;

    @Test(timeout = 4000)
    public void testIndexOfWithEmptyArray() {
        double[] array = null; // Testing with null array
        double valueToFind = 5.0;
        int startIndex = 0;
        double tolerance = 0.1;

        try {
            int result = ArrayUtils.indexOf(array, valueToFind, startIndex, tolerance);
            assertEquals(INDEX_NOT_FOUND, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIndexOfWithZeroLengthArray() {
        double[] array = new double[0]; // Testing with an empty array
        double valueToFind = 5.0;
        int startIndex = 0;
        double tolerance = 0.1;

        try {
            int result = ArrayUtils.indexOf(array, valueToFind, startIndex, tolerance);
            assertEquals(INDEX_NOT_FOUND, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIndexOfWithValidParameters() {
        double[] array = {1.0, 2.0, 5.0, 7.0}; // Non-empty array
        double valueToFind = 5.0;
        int startIndex = 0;
        double tolerance = 0.1;

        try {
            int result = ArrayUtils.indexOf(array, valueToFind, startIndex, tolerance);
            assertEquals(2, result); // Expecting index 2 for value 5.0
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testIndexOfWithTolerance() {
        double[] array = {1.0, 2.0, 5.1, 7.0}; // Non-empty array
        double valueToFind = 5.0;
        int startIndex = 0;
        double tolerance = 0.2;

        try {
            int result = ArrayUtils.indexOf(array, valueToFind, startIndex, tolerance);
            assertEquals(2, result); // Expecting index 2 for value 5.1 within tolerance
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}