package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ArrayUtils_isSorted_byte_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testIsSorted_withValidArray() {
        byte[] sortedArray = {1, 2, 3, 4, 5};
        assertTrue(ArrayUtils.isSorted(sortedArray));
    }

    @Test(timeout = 4000)
    public void testIsSorted_withUnsortedArray() {
        byte[] unsortedArray = {5, 3, 1};
        assertTrue(!ArrayUtils.isSorted(unsortedArray));
    }

    @Test(timeout = 4000)
    public void testIsSorted_withSingleElement() {
        byte[] singleElementArray = {5};
        assertTrue(ArrayUtils.isSorted(singleElementArray));
    }

    @Test(timeout = 4000)
    public void testIsSorted_withEmptyArray() {
        byte[] emptyArray = {};
        assertTrue(ArrayUtils.isSorted(emptyArray));
    }

    @Test(timeout = 4000)
    public void testIsSorted_withNullArray() {
        try {
            ArrayUtils.isSorted((byte[]) null); // Cast to byte[] to resolve ambiguity
        } catch (Exception e) {
            // Expected behavior, as null is not a valid input
        }
    }


}