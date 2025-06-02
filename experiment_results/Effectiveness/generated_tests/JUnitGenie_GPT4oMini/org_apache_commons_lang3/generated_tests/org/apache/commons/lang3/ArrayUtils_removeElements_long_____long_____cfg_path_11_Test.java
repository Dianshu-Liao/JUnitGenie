package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class ArrayUtils_removeElements_long_____long_____cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testRemoveElements_withNullArray() {
        long[] result = ArrayUtils.removeElements((long[]) null, 1, 2, 3);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_withEmptyArray() {
        long[] result = ArrayUtils.removeElements(new long[0], 1, 2, 3);
        assertArrayEquals(new long[0], result);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_removeExactlyOnce() {
        long[] inputArray = {1, 2, 3, 4, 5};
        long[] valuesToRemove = {2};
        long[] expected = {1, 3, 4, 5};
        long[] result = ArrayUtils.removeElements(inputArray, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_multipleRemovals() {
        long[] inputArray = {1, 2, 3, 2, 4, 2};
        long[] valuesToRemove = {2};
        long[] expected = {1, 3, 4};
        long[] result = ArrayUtils.removeElements(inputArray, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_removeAll() {
        long[] inputArray = {1, 2, 3};
        long[] valuesToRemove = {1, 2, 3};
        long[] expected = new long[0]; // should return empty array
        long[] result = ArrayUtils.removeElements(inputArray, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_noElementsToRemove() {
        long[] inputArray = {1, 2, 3};
        long[] valuesToRemove = {};
        long[] expected = {1, 2, 3}; // should return original array
        long[] result = ArrayUtils.removeElements(inputArray, valuesToRemove);
        assertArrayEquals(expected, result);
    }


}