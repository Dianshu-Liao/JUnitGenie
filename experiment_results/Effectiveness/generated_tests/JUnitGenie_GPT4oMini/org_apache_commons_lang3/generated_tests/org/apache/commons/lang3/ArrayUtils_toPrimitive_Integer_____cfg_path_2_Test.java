package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import org.apache.commons.lang3.ArrayUtils;

public class ArrayUtils_toPrimitive_Integer_____cfg_path_2_Test {

    private static final int[] EMPTY_INT_ARRAY = new int[0]; // Mimicking the static empty int array, if it's defined elsewhere in the original code.

    @Test(timeout = 4000)
    public void testToPrimitiveWithValidInput() {
        Integer[] input = {1, 2, 3};
        int[] expected = {1, 2, 3};
        int[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullArray() {
        Integer[] input = null;
        int[] result;
        try {
            result = ArrayUtils.toPrimitive(input);
            assertArrayEquals(null, result);
        } catch (Exception e) {
            // Handle exception
        }
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithEmptyArray() {
        Integer[] input = {};
        int[] expected = EMPTY_INT_ARRAY;
        int[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

}