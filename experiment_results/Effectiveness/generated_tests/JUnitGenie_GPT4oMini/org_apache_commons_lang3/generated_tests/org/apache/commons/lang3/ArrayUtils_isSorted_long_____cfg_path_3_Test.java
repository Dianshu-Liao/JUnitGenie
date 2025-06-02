package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArrayUtils_isSorted_long_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsSortedWithSortedArray() {
        long[] sortedArray = {1L, 2L, 3L, 4L, 5L};
        assertTrue(ArrayUtils.isSorted(sortedArray));
    }

    @Test(timeout = 4000)
    public void testIsSortedWithUnsortedArray() {
        long[] unsortedArray = {5L, 3L, 4L, 1L, 2L};
        assertFalse(ArrayUtils.isSorted(unsortedArray));
    }

    @Test(timeout = 4000)
    public void testIsSortedWithSingleElementArray() {
        long[] singleElementArray = {1L};
        assertTrue(ArrayUtils.isSorted(singleElementArray));
    }

    @Test(timeout = 4000)
    public void testIsSortedWithEmptyArray() {
        long[] emptyArray = {};
        assertTrue(ArrayUtils.isSorted(emptyArray));
    }

    @Test(timeout = 4000)
    public void testIsSortedWithTwoElementSortedArray() {
        long[] twoElementSortedArray = {1L, 2L};
        assertTrue(ArrayUtils.isSorted(twoElementSortedArray));
    }

    @Test(timeout = 4000)
    public void testIsSortedWithTwoElementUnsortedArray() {
        long[] twoElementUnsortedArray = {2L, 1L};
        assertFalse(ArrayUtils.isSorted(twoElementUnsortedArray));
    }

}