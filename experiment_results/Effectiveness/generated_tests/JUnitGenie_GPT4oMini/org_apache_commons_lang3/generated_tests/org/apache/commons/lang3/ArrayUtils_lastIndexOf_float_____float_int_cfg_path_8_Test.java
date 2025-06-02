package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_lastIndexOf_float_____float_int_cfg_path_8_Test {

    private static final int INDEX_NOT_FOUND = -1;

    @Test(timeout = 4000)
    public void testLastIndexOf_ValidArrayAndValue() {
        float[] array = {1.0f, 2.0f, 3.0f, 4.0f, 2.0f};
        float valueToFind = 2.0f;
        int startIndex = 4;

        try {
            int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(4, result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_EmptyArray() {
        float[] array = {};
        float valueToFind = 1.0f;
        int startIndex = 0;

        try {
            int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(INDEX_NOT_FOUND, result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_NullArray() {
        float[] array = null;
        float valueToFind = 1.0f;
        int startIndex = 0;

        try {
            int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(INDEX_NOT_FOUND, result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_StartIndexOutOfBounds() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 2.0f;
        int startIndex = 5; // Out of bounds

        try {
            int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(1, result); // Should still find the value
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testLastIndexOf_ValueNotFound() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float valueToFind = 4.0f;
        int startIndex = 2;

        try {
            int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(INDEX_NOT_FOUND, result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}