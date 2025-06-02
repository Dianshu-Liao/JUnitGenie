package org.apache.commons.lang3;
import static org.apache.commons.lang3.ArrayUtils.isSorted;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ArrayUtils_isSorted_long_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testIsSortedWithArrayLengthLessThanTwo() {
        // Test input with length less than 2
        long[] array1 = {}; // empty array
        long[] array2 = {1}; // single element array

        // Since both arrays have a length less than 2, they should be considered sorted
        try {
            assertTrue(isSorted(array1));
            assertTrue(isSorted(array2));
        } catch (Exception e) {
            // Handling the exception, in case one of the methods throw an unexpected exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsSortedWithSortedArray() {
        // Test input with a sorted array
        long[] sortedArray = {1, 2, 3, 4, 5};

        // The sorted array should return true
        try {
            assertTrue(isSorted(sortedArray));
        } catch (Exception e) {
            // Handling the exception
            e.printStackTrace();
        }
    }

}