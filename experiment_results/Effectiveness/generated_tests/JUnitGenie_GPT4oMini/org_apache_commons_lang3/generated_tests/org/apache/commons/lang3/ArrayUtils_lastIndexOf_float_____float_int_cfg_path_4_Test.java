package org.apache.commons.lang3;
import static org.junit.Assert.assertEquals;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtils_lastIndexOf_float_____float_int_cfg_path_4_Test {

    private static final int INDEX_NOT_FOUND = -1;

    @Test(timeout = 4000)
    public void testLastIndexOf_ValidInput() {
        float[] array = {1.0f, 2.0f, 3.0f, 2.0f, 4.0f};
        float valueToFind = 2.0f;
        int startIndex = 4; // Last index of the array

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);

        assertEquals(3, result); // Expect the last index of value 2.0f is 3
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_ValueNotFound() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f};
        float valueToFind = 5.0f;
        int startIndex = 3; // Last index of the array

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);

        assertEquals(INDEX_NOT_FOUND, result); // Expect -1 as value 5.0f is not in the array
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_StartIndexOutOfBounds() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 2.0f;
        int startIndex = 5; // Greater than the last index

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);

        assertEquals(1, result); // Expect the last index of value 2.0f is 1
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_EmptyArray() {
        float[] array = {};
        float valueToFind = 2.0f;
        int startIndex = 0;

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);

        assertEquals(INDEX_NOT_FOUND, result); // Expect -1 as the array is empty
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NullArray() {
        float[] array = null;
        float valueToFind = 2.0f;
        int startIndex = 0;

        try {
            ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        } catch (Exception e) {
            // Handle the exception if needed
        }
        // No assertion required, as we're only testing that it doesn't throw an unexpected exception
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NegativeStartIndex() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 2.0f;
        int startIndex = -1; // Invalid start index

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);

        assertEquals(INDEX_NOT_FOUND, result); // Expect -1 as the start index is invalid
    }

}