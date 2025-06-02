package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_lastIndexOf_float_____float_int_cfg_path_2_Test {

    private static final int INDEX_NOT_FOUND = -1;

    @Test(timeout = 4000)
    public void testLastIndexOf_ValidInput() {
        float[] array = {1.0f, 2.0f, 3.0f, 2.0f, 1.0f};
        float valueToFind = 2.0f;
        int startIndex = 4; // Start searching from the end of the array
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(3, result); // The last index of 2.0f is 3
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_ValueNotFound() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 4.0f;
        int startIndex = 2; // Start searching from the end of the array
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result); // Value not found, should return -1
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_EmptyArray() {
        float[] array = {};
        float valueToFind = 1.0f;
        int startIndex = 0; // Start index
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result); // Empty array, should return -1
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NullArray() {
        float[] array = null;
        float valueToFind = 1.0f;
        int startIndex = 0; // Start index
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result); // Null array, should return -1
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_StartIndexOutOfBounds() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 2.0f;
        int startIndex = 5; // Out of bounds
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(1, result); // Should return the last index of 2.0f which is 1
    }

}