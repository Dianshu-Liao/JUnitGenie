package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_nullToEmpty_byte_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNullToEmpty_withNonEmptyArray() {
        byte[] inputArray = new byte[]{1, 2, 3};
        byte[] expectedOutput = inputArray;
        byte[] actualOutput = ArrayUtils.nullToEmpty(inputArray);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testNullToEmpty_withNullArray() {
        byte[] inputArray = null;
        byte[] expectedOutput = ArrayUtils.EMPTY_BYTE_ARRAY;
        byte[] actualOutput = ArrayUtils.nullToEmpty(inputArray);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testNullToEmpty_withEmptyArray() {
        byte[] inputArray = new byte[]{};
        byte[] expectedOutput = ArrayUtils.EMPTY_BYTE_ARRAY;
        byte[] actualOutput = ArrayUtils.nullToEmpty(inputArray);
        assertArrayEquals(expectedOutput, actualOutput);
    }

}