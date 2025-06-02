package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_char_____char_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRemoveElements() {
        // Test case where array contains elements to be removed
        char[] array = {'a', 'b', 'c', 'd'};
        char[] values = {'b', 'd'};
        char[] expected = {'a', 'c'};
        char[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);

        // Test case where array is empty
        char[] emptyArray = {};
        char[] resultEmpty = ArrayUtils.removeElements(emptyArray, values);
        assertArrayEquals(emptyArray, resultEmpty);

        // Test case where values to remove are empty
        char[] resultNoValues = ArrayUtils.removeElements(array, new char[]{});
        assertArrayEquals(array, resultNoValues);

        // Test case where array is null
        char[] resultNullArray = ArrayUtils.removeElements(null, values);
        assertArrayEquals(null, resultNullArray);

        // Test case where values to remove are null
        char[] resultNullValues = ArrayUtils.removeElements(array, null);
        assertArrayEquals(array, resultNullValues);
    }

}