package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_nullToEmpty_char_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNullToEmptyWithNullArray() {
        char[] input = null;
        char[] expected = ArrayUtils.EMPTY_CHAR_ARRAY;
        char[] result = ArrayUtils.nullToEmpty(input);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNullToEmptyWithEmptyArray() {
        char[] input = new char[0];
        char[] expected = ArrayUtils.EMPTY_CHAR_ARRAY;
        char[] result = ArrayUtils.nullToEmpty(input);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNullToEmptyWithNonEmptyArray() {
        char[] input = new char[] {'a', 'b', 'c'};
        char[] expected = input;
        char[] result = ArrayUtils.nullToEmpty(input);
        assertArrayEquals(expected, result);
    }

}