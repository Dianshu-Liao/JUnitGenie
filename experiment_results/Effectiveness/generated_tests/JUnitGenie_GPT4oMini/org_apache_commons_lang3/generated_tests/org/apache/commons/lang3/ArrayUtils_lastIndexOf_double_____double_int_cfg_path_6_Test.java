package org.apache.commons.lang3;
import static org.junit.Assert.assertEquals;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtils_lastIndexOf_double_____double_int_cfg_path_6_Test {

    private static final int INDEX_NOT_FOUND = -1;

    @Test(timeout = 4000)
    public void testLastIndexOf_Found() {
        double[] array = {1.0, 2.0, 3.0, 2.0, 4.0};
        double valueToFind = 2.0;
        int startIndex = 4;
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(3, result);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NotFound() {
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 4.0;
        int startIndex = 2;
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_EmptyArray() {
        double[] array = {};
        double valueToFind = 1.0;
        int startIndex = 0;
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NullArray() {
        double[] array = null;
        double valueToFind = 1.0;
        int startIndex = 0;
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_StartIndexOutOfBounds() {
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 2.0;
        int startIndex = 5; // Out of bounds
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(1, result); // Should return the last index of 2.0
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NegativeStartIndex() {
        double[] array = {1.0, 2.0, 3.0};
        double valueToFind = 2.0;
        int startIndex = -1; // Invalid index
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result); // Should result in not found
    }

}