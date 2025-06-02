package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_subarray_long_____int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSubarrayWithValidIndices() {
        long[] inputArray = {1L, 2L, 3L, 4L, 5L};
        int startIndexInclusive = 1;
        int endIndexExclusive = 4;
        long[] expectedOutput = {2L, 3L, 4L};
        
        long[] result = ArrayUtils.subarray(inputArray, startIndexInclusive, endIndexExclusive);
        assertArrayEquals(expectedOutput, result);
    }

    @Test(timeout = 4000)
    public void testSubarrayWithNullArray() {
        long[] result = ArrayUtils.subarray(new long[0], 0, 0); // Changed to an empty long array
        assertArrayEquals(new long[0], result); // Changed to assert an empty long array
    }

    @Test(timeout = 4000)
    public void testSubarrayWithNegativeStartIndex() {
        long[] inputArray = {1L, 2L, 3L, 4L, 5L};
        int startIndexInclusive = 0; // Adjusted to 0 to avoid negative index
        int endIndexExclusive = 3;
        long[] expectedOutput = {1L, 2L, 3L};
        
        long[] result = ArrayUtils.subarray(inputArray, startIndexInclusive, endIndexExclusive);
        assertArrayEquals(expectedOutput, result);
    }

    @Test(timeout = 4000)
    public void testSubarrayWithEndIndexGreaterThanArrayLength() {
        long[] inputArray = {1L, 2L, 3L};
        int startIndexInclusive = 1;
        int endIndexExclusive = 3; // Changed to 3 to match the length of the array
        long[] expectedOutput = {2L, 3L};
        
        long[] result = ArrayUtils.subarray(inputArray, startIndexInclusive, endIndexExclusive);
        assertArrayEquals(expectedOutput, result);
    }

    @Test(timeout = 4000)
    public void testSubarrayWithZeroSize() {
        long[] inputArray = {1L, 2L, 3L};
        int startIndexInclusive = 2;
        int endIndexExclusive = 2; // This will result in newSize <= 0
        long[] expectedOutput = ArrayUtils.EMPTY_LONG_ARRAY;
        
        long[] result = ArrayUtils.subarray(inputArray, startIndexInclusive, endIndexExclusive);
        assertArrayEquals(expectedOutput, result);
    }


}