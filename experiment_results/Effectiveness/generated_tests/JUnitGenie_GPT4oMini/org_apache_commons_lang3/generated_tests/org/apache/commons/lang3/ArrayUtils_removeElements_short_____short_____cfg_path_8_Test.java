package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_short_____short_____cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Test case where elements are removed successfully
        short[] array = {1, 2, 3, 4, 5};
        short[] valuesToRemove = {2, 4};
        short[] expected = {1, 3, 5};
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        // Test case where the array is empty
        short[] array = {};
        short[] valuesToRemove = {1, 2};
        short[] expected = {};
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        // Test case where values to remove are empty
        short[] array = {1, 2, 3};
        short[] valuesToRemove = {};
        short[] expected = {1, 2, 3};
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatchingValues() {
        // Test case where no values match
        short[] array = {1, 2, 3};
        short[] valuesToRemove = {4, 5};
        short[] expected = {1, 2, 3};
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllMatchingValues() {
        // Test case where all values match
        short[] array = {1, 2, 3};
        short[] valuesToRemove = {1, 2, 3};
        short[] expected = {};
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithSingleValue() {
        // Test case where a single value is removed
        short[] array = {1, 2, 3};
        short[] valuesToRemove = {2};
        short[] expected = {1, 3};
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

}