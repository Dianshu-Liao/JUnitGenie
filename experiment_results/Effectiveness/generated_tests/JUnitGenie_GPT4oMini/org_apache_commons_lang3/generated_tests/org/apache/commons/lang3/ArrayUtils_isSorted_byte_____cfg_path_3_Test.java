package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ArrayUtils_isSorted_byte_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsSortedWithSortedArray() {
        byte[] sortedArray = {1, 2, 3, 4, 5};
        boolean result = ArrayUtils.isSorted(sortedArray);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithUnsortedArray() {
        byte[] unsortedArray = {5, 3, 4, 1, 2};
        boolean result = ArrayUtils.isSorted(unsortedArray);
        assertTrue(!result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithEmptyArray() {
        byte[] emptyArray = {};
        boolean result = ArrayUtils.isSorted(emptyArray);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithSingleElementArray() {
        byte[] singleElementArray = {1};
        boolean result = ArrayUtils.isSorted(singleElementArray);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithTwoElementSortedArray() {
        byte[] twoElementSortedArray = {1, 2};
        boolean result = ArrayUtils.isSorted(twoElementSortedArray);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithTwoElementUnsortedArray() {
        byte[] twoElementUnsortedArray = {2, 1};
        boolean result = ArrayUtils.isSorted(twoElementUnsortedArray);
        assertTrue(!result);
    }

}