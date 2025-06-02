package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_lastIndexOf_float_____float_int_cfg_path_9_Test {

    private static final int INDEX_NOT_FOUND = -1;

    @Test(timeout = 4000)
    public void testLastIndexOf_withNonEmptyArrayAndValidStartIndex() {
        float[] array = {1.0f, 2.0f, 3.0f, 2.0f, 1.0f};
        float valueToFind = 2.0f;
        int startIndex = 4; // Valid start index

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(3, result); // The last index of 2.0f is 3
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_withEmptyArray() {
        float[] array = {};
        float valueToFind = 2.0f;
        int startIndex = 0; // Valid start index

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result); // Should return INDEX_NOT_FOUND
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_withNullArray() {
        float[] array = null;
        float valueToFind = 2.0f;
        int startIndex = 0; // Valid start index

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result); // Should return INDEX_NOT_FOUND
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_withNegativeStartIndex() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 2.0f;
        int startIndex = -1; // Invalid start index

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(INDEX_NOT_FOUND, result); // Should return INDEX_NOT_FOUND
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_withStartIndexGreaterThanArrayLength() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 1.0f;
        int startIndex = 5; // Start index greater than array length

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        assertEquals(0, result); // Should return 0, the index of the first occurrence
    }

}