package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_nullToEmpty_byte_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNullToEmpty_withNonEmptyArray() {
        byte[] inputArray = new byte[]{1, 2, 3}; // Non-null, non-empty array
        byte[] expectedOutput = new byte[]{1, 2, 3};
        byte[] actualOutput = ArrayUtils.nullToEmpty(inputArray);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testNullToEmpty_withEmptyArray() {
        byte[] inputArray = new byte[0]; // Non-null, empty array
        byte[] expectedOutput = ArrayUtils.EMPTY_BYTE_ARRAY; // Assuming EMPTY_BYTE_ARRAY is defined in ArrayUtils
        byte[] actualOutput = ArrayUtils.nullToEmpty(inputArray);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testNullToEmpty_withNullArray() {
        byte[] inputArray = null; // Null array
        byte[] expectedOutput = ArrayUtils.EMPTY_BYTE_ARRAY; // Assuming EMPTY_BYTE_ARRAY is defined in ArrayUtils
        byte[] actualOutput = ArrayUtils.nullToEmpty(inputArray);
        assertArrayEquals(expectedOutput, actualOutput);
    }

}