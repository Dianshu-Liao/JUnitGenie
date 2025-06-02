package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ArrayUtils_isSorted_double_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsSortedWithSortedArray() {
        double[] sortedArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        assertTrue(ArrayUtils.isSorted(sortedArray));
    }

    @Test(timeout = 4000)
    public void testIsSortedWithUnsortedArray() {
        double[] unsortedArray = {5.0, 3.0, 4.0, 1.0, 2.0};
        assertFalse(ArrayUtils.isSorted(unsortedArray));
    }

    @Test(timeout = 4000)
    public void testIsSortedWithSingleElementArray() {
        double[] singleElementArray = {1.0};
        assertTrue(ArrayUtils.isSorted(singleElementArray));
    }

    @Test(timeout = 4000)
    public void testIsSortedWithEmptyArray() {
        double[] emptyArray = {};
        assertTrue(ArrayUtils.isSorted(emptyArray));
    }

}