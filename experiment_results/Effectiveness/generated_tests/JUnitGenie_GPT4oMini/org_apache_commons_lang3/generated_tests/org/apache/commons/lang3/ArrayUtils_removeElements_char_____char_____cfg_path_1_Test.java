package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_char_____char_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testRemoveElementsWithNonEmptyArrayAndValues() {
        char[] array = {'a', 'b', 'c', 'd'};
        char[] values = {'b', 'd'};
        char[] expected = {'a', 'c'};
        char[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        char[] array = {'a', 'b', 'c', 'd'};
        char[] values = {};
        char[] expected = {'a', 'b', 'c', 'd'};
        char[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        char[] array = {};
        char[] values = {'b', 'd'};
        char[] expected = {};
        char[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNullArray() {
        char[] values = {'b', 'd'};
        try {
            ArrayUtils.removeElements(null, values);
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNullValues() {
        char[] array = {'a', 'b', 'c', 'd'};
        try {
            ArrayUtils.removeElements(array, null);
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}