package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_long_____long_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        long[] array = new long[0]; // Non-null long array with length 0
        long[] values = {1, 2, 3};
        long[] expected = new long[0]; // Expected result is also an empty array

        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        long[] array = {1, 2, 3, 4};
        long[] values = new long[0]; // Non-null long array with length 0
        long[] expected = {1, 2, 3, 4}; // Expected result is the same as the input array

        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithValuesPresent() {
        long[] array = {1, 2, 3, 4, 5};
        long[] values = {2, 4}; // Values to remove
        long[] expected = {1, 3, 5}; // Expected result after removal

        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllValuesPresent() {
        long[] array = {1, 2, 3};
        long[] values = {1, 2, 3}; // All values to remove
        long[] expected = new long[0]; // Expected result is an empty array

        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoValuesPresent() {
        long[] array = {1, 2, 3};
        long[] values = {4, 5}; // No values to remove
        long[] expected = {1, 2, 3}; // Expected result is the same as the input array

        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

}