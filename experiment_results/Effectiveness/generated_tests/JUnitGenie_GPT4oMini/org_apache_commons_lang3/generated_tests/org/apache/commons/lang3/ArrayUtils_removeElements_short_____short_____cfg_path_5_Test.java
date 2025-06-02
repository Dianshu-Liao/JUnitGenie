package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_short_____short_____cfg_path_5_Test {

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
        // Test case where the input array is empty
        short[] array = {};
        short[] valuesToRemove = {1, 2};
        short[] expected = {};
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        // Test case where the values to remove are empty
        short[] array = {1, 2, 3};
        short[] valuesToRemove = {};
        short[] expected = {1, 2, 3};
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoMatches() {
        // Test case where no elements match for removal
        short[] array = {1, 2, 3};
        short[] valuesToRemove = {4, 5};
        short[] expected = {1, 2, 3};
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllMatches() {
        // Test case where all elements are removed
        short[] array = {1, 2, 3};
        short[] valuesToRemove = {1, 2, 3};
        short[] expected = {};
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithDuplicates() {
        // Test case where there are duplicates in the array
        short[] array = {1, 2, 2, 3, 4};
        short[] valuesToRemove = {2};
        short[] expected = {1, 3, 4};
        short[] result = ArrayUtils.removeElements(array, valuesToRemove);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithMutableInt() {
        // Test case to ensure MutableInt decrement works correctly
        MutableInt mutableInt = new MutableInt(2);
        mutableInt.decrementAndGet(); // Should be 1 after this
        assertArrayEquals(new short[]{1, 2}, ArrayUtils.removeElements(new short[]{1, 2, 3}, new short[]{3}));
    }

}