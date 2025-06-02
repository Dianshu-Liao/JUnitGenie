package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_lastIndexOf_float_____float_int_cfg_path_7_Test {

    private static final int INDEX_NOT_FOUND = -1; // Assuming it's defined as such in your context

    @Test(timeout = 4000)
    public void testLastIndexOf_valueFound() {
        float[] array = {1.0f, 2.0f, 3.0f, 2.0f, 5.0f};
        float valueToFind = 2.0f;
        int startIndex = 4; // Start searching from the last index 4
        
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        
        assertEquals(3, result); // 2.0 is found at index 3
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_valueNotFound() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f};
        float valueToFind = 5.0f;
        int startIndex = 3; // Start searching from index 3

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        
        assertEquals(INDEX_NOT_FOUND, result); // 5.0 is not found, should return INDEX_NOT_FOUND
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_emptyArray() {
        float[] array = {};
        float valueToFind = 1.0f;
        int startIndex = 0;

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);

        assertEquals(INDEX_NOT_FOUND, result); // Empty array should return INDEX_NOT_FOUND
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_negativeStartIndex() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 1.0f;
        int startIndex = -1; // Invalid start index

        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
        
        assertEquals(INDEX_NOT_FOUND, result); // Negative start index should return INDEX_NOT_FOUND
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_startIndexOutOfBound() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 1.0f;
        int startIndex = 10; // Start index out of bounds
        
        int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);

        assertEquals(0, result); // Should search from the last valid index, finding 1.0f at index 0
    }

}