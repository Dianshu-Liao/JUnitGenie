package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_lastIndexOf_float_____float_int_cfg_path_3_Test {

    private static final int INDEX_NOT_FOUND = -1; // Assuming this is the constant used in the method

    @Test(timeout = 4000)
    public void testLastIndexOf_EmptyArray() {
        float[] array = new float[0]; // Empty array
        float valueToFind = 1.0f;
        int startIndex = 0;

        try {
            int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(INDEX_NOT_FOUND, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}