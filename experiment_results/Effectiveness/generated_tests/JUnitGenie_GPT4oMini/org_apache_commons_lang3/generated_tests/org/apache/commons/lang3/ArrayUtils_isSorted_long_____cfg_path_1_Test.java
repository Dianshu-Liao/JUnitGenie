package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ArrayUtils_isSorted_long_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsSortedWithSortedArray() {
        long[] sortedArray = {1L, 2L, 3L, 4L, 5L};
        boolean result = ArrayUtils.isSorted(sortedArray);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithUnsortedArray() {
        long[] unsortedArray = {5L, 3L, 4L, 1L, 2L};
        boolean result = ArrayUtils.isSorted(unsortedArray);
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithSingleElementArray() {
        long[] singleElementArray = {1L};
        boolean result = ArrayUtils.isSorted(singleElementArray);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithEmptyArray() {
        long[] emptyArray = {};
        boolean result = ArrayUtils.isSorted(emptyArray);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithTwoElementSortedArray() {
        long[] twoElementSortedArray = {1L, 2L};
        boolean result = ArrayUtils.isSorted(twoElementSortedArray);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithTwoElementUnsortedArray() {
        long[] twoElementUnsortedArray = {2L, 1L};
        boolean result = ArrayUtils.isSorted(twoElementUnsortedArray);
        assertTrue(!result);
    }

}