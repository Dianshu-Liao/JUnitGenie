package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_nullToEmpty_short_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNullToEmptyWithEmptyArray() {
        short[] input = new short[0]; // empty array
        short[] expected = new short[0]; // expected output is also an empty array

        short[] result = ArrayUtils.nullToEmpty(input);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testNullToEmptyWithNullArray() {
        short[] input = null; // null input
        short[] expected = new short[0]; // expected output is an empty array

        short[] result = ArrayUtils.nullToEmpty(input);
        assertArrayEquals(expected, result);
    }

}