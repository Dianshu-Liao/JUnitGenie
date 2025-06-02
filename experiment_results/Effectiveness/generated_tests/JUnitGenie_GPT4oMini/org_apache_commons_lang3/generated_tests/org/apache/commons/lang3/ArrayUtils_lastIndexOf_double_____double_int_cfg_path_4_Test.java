package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayUtils_lastIndexOf_double_____double_int_cfg_path_4_Test {

    private static final int INDEX_NOT_FOUND = -1;

    @Test(timeout = 4000)
    public void testLastIndexOfWithNullArray() {
        double[] array = null;
        double valueToFind = 1.0;
        int startIndex = 0;

        try {
            int result = ArrayUtils.lastIndexOf(array, valueToFind, startIndex);
            assertEquals(INDEX_NOT_FOUND, result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}