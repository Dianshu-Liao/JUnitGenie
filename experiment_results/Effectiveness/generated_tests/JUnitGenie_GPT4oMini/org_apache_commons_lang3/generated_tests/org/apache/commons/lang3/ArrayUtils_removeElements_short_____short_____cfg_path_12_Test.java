package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_short_____short_____cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArrayAndValues() {
        short[] array = null; // This will ensure isEmpty(array) returns true
        short[] values = new short[] {}; // This will ensure isEmpty(values) returns true
        short[] expected = null; // Expected result is null since the input array is null
        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNonEmptyArrayAndEmptyValues() {
        short[] array = new short[] {1, 2, 3, 4};
        short[] values = new short[] {}; // This will ensure isEmpty(values) returns true
        short[] expected = new short[] {1, 2, 3, 4}; // Expected result is the same as input array
        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithValuesPresentInArray() {
        short[] array = new short[] {1, 2, 3, 4, 5};
        short[] values = new short[] {2, 4}; // Values to remove
        short[] expected = new short[] {1, 3, 5}; // Expected result after removal
        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithValuesNotPresentInArray() {
        short[] array = new short[] {1, 2, 3, 4, 5};
        short[] values = new short[] {6, 7}; // Values to remove that are not in the array
        short[] expected = new short[] {1, 2, 3, 4, 5}; // Expected result is the same as input array
        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllValuesPresentInArray() {
        short[] array = new short[] {1, 2, 3, 4};
        short[] values = new short[] {1, 2, 3, 4}; // All values to remove
        short[] expected = new short[] {}; // Expected result is an empty array
        short[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

}