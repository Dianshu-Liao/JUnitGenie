package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ArrayUtils_isSorted_double_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testIsSortedWithNullArray() {
        // Given a null array
        double[] array = null;

        // When calling isSorted
        boolean result;
        try {
            result = ArrayUtils.isSorted(array);
        } catch (Exception e) {
            // Handle the exception if thrown
            throw new RuntimeException("Exception thrown during isSorted execution", e);
        }

        // Then the result should be true
        assertTrue(result);
    }

}