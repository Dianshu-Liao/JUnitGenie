package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_lastIndexOf_float_____float_int_cfg_path_6_Test {

    private static final int INDEX_NOT_FOUND = -1;

    @Test(timeout = 4000)
    public void testLastIndexOf_ValidInput() {
        float[] array = {1.0f, 2.0f, 3.0f, 2.0f, 4.0f};
        float valueToFind = 2.0f;
        int startIndex = 4; // Start searching from the last index

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(3, result); // The last index of 2.0f is 3
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_ValueNotFound() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f};
        float valueToFind = 5.0f;
        int startIndex = 3;

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result); // Value not found, should return -1
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_EmptyArray() {
        float[] array = {};
        float valueToFind = 1.0f;
        int startIndex = 0;

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result); // Empty array, should return -1
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NullArray() {
        float[] array = null;
        float valueToFind = 1.0f;
        int startIndex = 0;

        try {
            int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(INDEX_NOT_FOUND, result); // Null array, should return -1
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_StartIndexOutOfBounds() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 1.0f;
        int startIndex = 5; // Out of bounds

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(0, result); // Should return the first index since startIndex is out of bounds
    }

}