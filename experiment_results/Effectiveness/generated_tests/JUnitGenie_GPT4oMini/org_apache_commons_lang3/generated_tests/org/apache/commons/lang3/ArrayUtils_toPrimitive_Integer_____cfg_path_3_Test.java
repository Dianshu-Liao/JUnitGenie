package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toPrimitive_Integer_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToPrimitiveWithNonEmptyArray() {
        Integer[] input = {1, 2, 3};
        int[] expected = {1, 2, 3};
        int[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullArray() {
        Integer[] input = null;
        int[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithEmptyArray() {
        Integer[] input = {};
        int[] expected = ArrayUtils.EMPTY_INT_ARRAY;
        int[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

}