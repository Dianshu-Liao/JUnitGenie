package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toPrimitive_Integer_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToPrimitive_withValidArray() {
        Integer[] input = {1, 2, 3};
        int[] expected = {1, 2, 3};
        int[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitive_withNullArray() {
        Integer[] input = null;
        int[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitive_withEmptyArray() {
        Integer[] input = {};
        int[] expected = ArrayUtils.EMPTY_INT_ARRAY; // Assuming EMPTY_INT_ARRAY is defined in ArrayUtils
        int[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitive_withArrayContainingNull() {
        Integer[] input = {1, null, 3};
        try {
            ArrayUtils.toPrimitive(input);
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}