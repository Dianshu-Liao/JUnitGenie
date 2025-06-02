package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_short_____short_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        short[] array = null;
        short[] values = {1, 2, 3};
        short[] expected = null; // Expecting null since the input array is null
        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        short[] array = {1, 2, 3, 4};
        short[] values = {};
        short[] expected = {1, 2, 3, 4}; // Expecting the original array since values are empty
        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatches() {
        short[] array = {1, 2, 3, 4};
        short[] values = {5, 6};
        short[] expected = {1, 2, 3, 4}; // Expecting the original array since there are no matches
        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithSomeMatches() {
        short[] array = {1, 2, 3, 4, 2};
        short[] values = {2, 3};
        short[] expected = {1, 4}; // Expecting the array with 2 and 3 removed
        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllMatches() {
        short[] array = {1, 2, 2, 3};
        short[] values = {1, 2, 3};
        short[] expected = {}; // Expecting an empty array since all elements are removed
        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

}