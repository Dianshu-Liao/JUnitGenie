package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_char_____char_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveElements_EmptyArrayAndValues() {
        char[] array = null;
        char[] values = null;
        char[] expected = null;

        try {
            char[] result = ArrayUtils.removeElements(array, values);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testRemoveElements_EmptyArray() {
        char[] array = new char[0];
        char[] values = {'a', 'b'};
        char[] expected = new char[0];

        try {
            char[] result = ArrayUtils.removeElements(array, values);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testRemoveElements_EmptyValues() {
        char[] array = {'a', 'b', 'c'};
        char[] values = new char[0];
        char[] expected = {'a', 'b', 'c'};

        try {
            char[] result = ArrayUtils.removeElements(array, values);
            assertArrayEquals(expected, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}