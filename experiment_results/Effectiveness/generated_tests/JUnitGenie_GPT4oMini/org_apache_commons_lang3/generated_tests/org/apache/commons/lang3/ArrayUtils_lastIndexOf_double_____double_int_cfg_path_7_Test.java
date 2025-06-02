package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_lastIndexOf_double_____double_int_cfg_path_7_Test {

    private static final int INDEX_NOT_FOUND = -1; // Assuming this is the constant used in the method

    @Test(timeout = 4000)
    public void testLastIndexOf_ValidInput() {
        double[] array = {1.0, 2.0, 3.0, 2.0, 4.0};
        double valueToFind = 2.0;
        int startIndex = 4;
        int expectedIndex = 3; // The last index of 2.0 in the array
        int actualIndex = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_ValueNotFound() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double valueToFind = 5.0;
        int startIndex = 3;
        int expectedIndex = INDEX_NOT_FOUND;
        int actualIndex = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_EmptyArray() {
        double[] array = {};
        double valueToFind = 1.0;
        int startIndex = 0;
        int expectedIndex = INDEX_NOT_FOUND;
        int actualIndex = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NullArray() {
        double[] array = null;
        double valueToFind = 1.0;
        int startIndex = 0;
        int expectedIndex = INDEX_NOT_FOUND;
        int actualIndex = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_StartIndexOutOfBounds() {
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 1.0;
        int startIndex = 5; // Out of bounds
        int expectedIndex = 0; // Should return the first index
        int actualIndex = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(expectedIndex, actualIndex);
    }

}