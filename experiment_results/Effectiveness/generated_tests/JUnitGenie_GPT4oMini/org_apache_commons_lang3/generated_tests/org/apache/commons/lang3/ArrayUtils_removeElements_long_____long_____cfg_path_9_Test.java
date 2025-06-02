package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_long_____long_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        long[] array = null;
        long[] values = {1, 2, 3};
        long[] expected = null; // Expecting null since the input array is null
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        long[] array = {1, 2, 3, 4};
        long[] values = {};
        long[] expected = {1, 2, 3, 4}; // Expecting the same array since values are empty
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithSingleValue() {
        long[] array = {1, 2, 3, 4};
        long[] values = {2};
        long[] expected = {1, 3, 4}; // Expecting 2 to be removed
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithMultipleValues() {
        long[] array = {1, 2, 3, 4, 2};
        long[] values = {2, 3};
        long[] expected = {1, 4}; // Expecting both 2 and 3 to be removed
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatchingValues() {
        long[] array = {1, 2, 3, 4};
        long[] values = {5, 6};
        long[] expected = {1, 2, 3, 4}; // Expecting the same array since no values match
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

}