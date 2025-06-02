package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ArrayUtils_isSorted_byte_____cfg_path_1_Test {

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
    public void testIsSortedWithEqualElements() {
        byte[] equalArray = {2, 2, 2, 2};
        boolean result = ArrayUtils.isSorted(equalArray);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsSortedWithArrayLengthLessThanTwo() {
        byte[] singleElementArray = {1};
        boolean result = ArrayUtils.isSorted(singleElementArray);
        assertTrue(result);
        
        byte[] emptyArray = {};
        result = ArrayUtils.isSorted(emptyArray);
        assertTrue(result);
    }

}