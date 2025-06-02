package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_nullToEmpty_short_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNullToEmpty_withNullArray() {
        short[] input = null;
        short[] expected = ArrayUtils.EMPTY_SHORT_ARRAY;
        short[] result = ArrayUtils.nullToEmpty(input);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNullToEmpty_withEmptyArray() {
        short[] input = new short[0];
        short[] expected = ArrayUtils.EMPTY_SHORT_ARRAY;
        short[] result = ArrayUtils.nullToEmpty(input);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNullToEmpty_withNonEmptyArray() {
        short[] input = new short[]{1, 2, 3};
        short[] expected = input;
        short[] result = ArrayUtils.nullToEmpty(input);
        assertArrayEquals(expected, result);
    }

}