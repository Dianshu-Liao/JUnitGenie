package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_lastIndexOf_float_____float_int_cfg_path_1_Test {

    private static final int INDEX_NOT_FOUND = -1; // Assuming this is the constant used in the focal method

    @Test(timeout = 4000)
    public void testLastIndexOf_ValidInput() {
        float[] array = {1.0f, 2.0f, 3.0f, 2.0f, 4.0f};
        float valueToFind = 2.0f;
        int startIndex = 4; // Start searching from the end of the array
        int expectedIndex = 3; // The last index of value 2.0f
        int actualIndex = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_ValueNotFound() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f};
        float valueToFind = 5.0f;
        int startIndex = 3; // Start searching from the end of the array
        int expectedIndex = INDEX_NOT_FOUND; // Value not found
        int actualIndex = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_EmptyArray() {
        float[] array = {};
        float valueToFind = 1.0f;
        int startIndex = 0; // Start index
        int expectedIndex = INDEX_NOT_FOUND; // Should return INDEX_NOT_FOUND
        int actualIndex = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NullArray() {
        float[] array = null;
        float valueToFind = 1.0f;
        int startIndex = 0; // Start index
        int expectedIndex = INDEX_NOT_FOUND; // Should return INDEX_NOT_FOUND
        int actualIndex = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(expectedIndex, actualIndex);
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_StartIndexOutOfBounds() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 1.0f;
        int startIndex = 5; // Out of bounds
        int expectedIndex = 0; // Should return the first index
        int actualIndex = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(expectedIndex, actualIndex);
    }

}