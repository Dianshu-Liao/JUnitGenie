package org.apache.commons.lang3;
import static org.junit.Assert.assertEquals;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtils_lastIndexOf_double_____double_int_cfg_path_1_Test {

    private static final int INDEX_NOT_FOUND = -1;

    @Test(timeout = 4000)
    public void testLastIndexOf_withValidParameters_returnsCorrectIndex() {
        double[] array = {1.1, 2.2, 3.3, 2.2, 4.4};
        double valueToFind = 2.2;
        int startIndex = 4;
        int expectedResult = 3;
        int actualResult = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(expectedResult, actualResult);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_withEmptyArray_returnsIndexNotFound() {
        double[] array = {};
        double valueToFind = 2.2;
        int startIndex = 0;
        try {
            int actualResult = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(INDEX_NOT_FOUND, actualResult);
        } catch (Exception e) {
            // Handle exception if necessary, although in this case it shouldn't throw
        }
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_withNullArray_returnsIndexNotFound() {
        double[] array = null;
        double valueToFind = 2.2;
        int startIndex = 0;
        try {
            int actualResult = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(INDEX_NOT_FOUND, actualResult);
        } catch (Exception e) {
            // Handle exception if necessary, although in this case it shouldn't throw
        }
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_withStartIndexLessThanZero_returnsIndexNotFound() {
        double[] array = {1.1, 2.2, 3.3};
        double valueToFind = 2.2;
        int startIndex = -1;
        try {
            int actualResult = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(INDEX_NOT_FOUND, actualResult);
        } catch (Exception e) {
            // Handle exception if necessary, although in this case it shouldn't throw
        }
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_withStartIndexGreaterThanArrayLength_returnsLastIndex() {
        double[] array = {1.1, 2.2, 3.3};
        double valueToFind = 1.1;
        int startIndex = 5; // Greater than array length
        int expectedResult = 0; // Index of 1.1
        int actualResult = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(expectedResult, actualResult);
    }

}