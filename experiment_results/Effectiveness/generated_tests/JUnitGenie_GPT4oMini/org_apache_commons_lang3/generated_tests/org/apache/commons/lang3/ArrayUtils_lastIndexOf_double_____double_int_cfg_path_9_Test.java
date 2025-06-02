package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_lastIndexOf_double_____double_int_cfg_path_9_Test {

    private static final int INDEX_NOT_FOUND = -1;

    @Test(timeout = 4000)
    public void testLastIndexOf_NonEmptyArray_ValidStartIndex() {
        double[] array = {1.0, 2.0, 3.0, 2.0, 4.0};
        double valueToFind = 2.0;
        int startIndex = 4; // Valid start index

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(3, result); // The last index of 2.0 is 3
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_EmptyArray() {
        double[] array = {};
        double valueToFind = 2.0;
        int startIndex = 0; // Start index

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result); // Should return INDEX_NOT_FOUND
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NullArray() {
        double[] array = null;
        double valueToFind = 2.0;
        int startIndex = 0; // Start index

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result); // Should return INDEX_NOT_FOUND
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_StartIndexNegative() {
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 2.0;
        int startIndex = -1; // Invalid start index

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result); // Should return INDEX_NOT_FOUND
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_StartIndexOutOfBounds() {
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 2.0;
        int startIndex = 5; // Out of bounds start index

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(1, result); // Should return the last index of 2.0 which is 1
    }

}