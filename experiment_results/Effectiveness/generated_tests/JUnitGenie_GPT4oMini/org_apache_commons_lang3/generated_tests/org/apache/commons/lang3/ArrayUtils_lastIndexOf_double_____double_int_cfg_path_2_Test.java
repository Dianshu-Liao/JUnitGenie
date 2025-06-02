package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_lastIndexOf_double_____double_int_cfg_path_2_Test {

    private static final int INDEX_NOT_FOUND = -1;

    @Test(timeout = 4000)
    public void testLastIndexOf_ValidInput() {
        double[] array = {1.0, 2.0, 3.0, 2.0, 4.0};
        double valueToFind = 2.0;
        int startIndex = 4; // Start searching from the end of the array
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(3, result); // The last index of 2.0 is 3
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_ValueNotFound() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double valueToFind = 5.0;
        int startIndex = 3; // Start searching from the end of the array
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result); // Value not found
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_EmptyArray() {
        double[] array = {};
        double valueToFind = 1.0;
        int startIndex = 0; // Start index
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result); // Should return INDEX_NOT_FOUND for empty array
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NullArray() {
        double[] array = null;
        double valueToFind = 1.0;
        int startIndex = 0; // Start index
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result); // Should return INDEX_NOT_FOUND for null array
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_StartIndexOutOfBounds() {
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 1.0;
        int startIndex = 5; // Out of bounds
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(0, result); // Should return 0, the index of the first occurrence
    }

}