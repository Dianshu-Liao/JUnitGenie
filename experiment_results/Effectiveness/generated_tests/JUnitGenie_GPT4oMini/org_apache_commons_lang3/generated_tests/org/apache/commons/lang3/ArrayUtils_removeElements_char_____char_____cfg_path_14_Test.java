package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_char_____char_____cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testRemoveElementsWithNonEmptyArrayAndEmptyValues() {
        char[] array = {'a', 'b', 'c'};
        char[] values = {}; // empty array
        char[] expected = {'a', 'b', 'c'}; // no elements to remove
        char[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNonEmptyArrayAndNullValues() {
        char[] array = {'a', 'b', 'c'};
        char[] values = null; // null values
        char[] expected = {'a', 'b', 'c'}; // no elements to remove
        char[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNonEmptyArrayAndValuesToRemove() {
        char[] array = {'a', 'b', 'c', 'd'};
        char[] values = {'b', 'd'}; // elements to remove
        char[] expected = {'a', 'c'}; // expected result after removal
        char[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllElementsRemoved() {
        char[] array = {'a', 'b', 'c'};
        char[] values = {'a', 'b', 'c'}; // all elements to remove
        char[] expected = {}; // expected result is an empty array
        char[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        char[] array = {}; // empty array
        char[] values = {'a', 'b'}; // values to remove
        char[] expected = {}; // expected result is an empty array
        char[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

}