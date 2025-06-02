package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_lastIndexOf_double_____double_int_cfg_path_8_Test {

    private static final int INDEX_NOT_FOUND = -1; // Assuming a constant for the test

    @Test(timeout = 4000)
    public void testLastIndexOf() {
        double[] array = {1.0, 2.0, 3.0, 2.0, 4.0}; // Ensure the array is not null and has elements
        double valueToFind = 2.0;
        int startIndex = 4; // Starting index within bounds

        // Testing the last index of 2.0 in the array
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(3, result); // Should return the last index of 2.0
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_withEmptyArray() {
        double[] array = {}; // Empty array
        double valueToFind = 2.0;
        int startIndex = 0;

        // Testing with an empty array should return INDEX_NOT_FOUND
        try {
            int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(INDEX_NOT_FOUND, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for empty array");
        }
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_withNegativeStartIndex() {
        double[] array = {1.0, 2.0, 3.0, 2.0, 4.0};
        double valueToFind = 2.0;
        int startIndex = -1; // Invalid start index

        // Testing with a negative start index should return INDEX_NOT_FOUND
        try {
            int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(INDEX_NOT_FOUND, result);
        } catch (Exception e) {
            fail("Exception should not be thrown for negative start index");
        }
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_startIndexOutOfBound() {
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 2.0;
        int startIndex = 5; // Out of bound start index

        // Testing start index out of bounds should equal last index
        try {
            int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(1, result); // Should return the last index of 2.0
        } catch (Exception e) {
            fail("Exception should not be thrown for out of bounds start index");
        }
    }

}