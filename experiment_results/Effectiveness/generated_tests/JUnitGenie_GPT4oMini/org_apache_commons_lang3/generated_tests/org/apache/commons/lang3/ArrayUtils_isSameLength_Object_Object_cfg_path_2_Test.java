package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ArrayUtils_isSameLength_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsSameLengthWithEqualLengthArrays() {
        // Prepare test data
        Object array1 = new int[]{1, 2, 3};
        Object array2 = new int[]{4, 5, 6};

        // Execute the method under test
        boolean result = ArrayUtils.isSameLength(array1, array2);

        // Assert the expected outcome
        assertTrue("Expected the arrays to be of the same length", result);
    }

    @Test(timeout = 4000)
    public void testIsSameLengthWithDifferentLengthArrays() {
        // Prepare test data
        Object array1 = new int[]{1, 2, 3};
        Object array2 = new int[]{4, 5};

        // Execute the method under test
        boolean result = ArrayUtils.isSameLength(array1, array2);

        // Assert the expected outcome
        assertTrue("Expected the arrays to be of different lengths", !result);
    }

    @Test(timeout = 4000)
    public void testIsSameLengthWithNullArray() {
        // Prepare test data
        Object array1 = null;
        Object array2 = new int[]{1, 2, 3};

        // Execute the method under test, handle the exception
        try {
            ArrayUtils.isSameLength(array1, array2);
            assertTrue("Expected an exception due to null array1", false);
        } catch (NullPointerException npe) {
            // Expected behavior
        }
    }

}