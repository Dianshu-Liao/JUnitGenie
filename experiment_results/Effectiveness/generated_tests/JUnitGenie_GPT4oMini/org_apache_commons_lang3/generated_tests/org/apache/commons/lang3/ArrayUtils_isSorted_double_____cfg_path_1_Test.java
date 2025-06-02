package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ArrayUtils_isSorted_double_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsSortedWithSortedArray() {
        double[] sortedArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        boolean result = ArrayUtils.isSorted(sortedArray);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithUnsortedArray() {
        double[] unsortedArray = {5.0, 3.0, 4.0, 1.0, 2.0};
        boolean result = ArrayUtils.isSorted(unsortedArray);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithEmptyArray() {
        double[] emptyArray = {};
        boolean result = ArrayUtils.isSorted(emptyArray);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithSingleElementArray() {
        double[] singleElementArray = {1.0};
        boolean result = ArrayUtils.isSorted(singleElementArray);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithTwoElementSortedArray() {
        double[] twoElementSortedArray = {1.0, 2.0};
        boolean result = ArrayUtils.isSorted(twoElementSortedArray);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithTwoElementUnsortedArray() {
        double[] twoElementUnsortedArray = {2.0, 1.0};
        boolean result = ArrayUtils.isSorted(twoElementUnsortedArray);
        assertFalse(result);
    }

}