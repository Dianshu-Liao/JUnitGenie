package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_subarray_long_____int_int_cfg_path_2_Test {

    private static final long[] EMPTY_LONG_ARRAY = new long[0];

    @Test(timeout = 4000)
    public void testSubarrayValidInput() {
        long[] array = {1L, 2L, 3L, 4L, 5L};
        int startIndexInclusive = 1; // valid non-negative index
        int endIndexExclusive = 4; // valid index within bounds

        long[] result = ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
        long[] expected = {2L, 3L, 4L};
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubarrayWithNullArray() {
        long[] result = ArrayUtils.subarray(new long[0], 0, 0); // Use an empty long array instead of null
        assertArrayEquals(EMPTY_LONG_ARRAY, result);
    }

    @Test(timeout = 4000)
    public void testSubarrayWithNegativeStartIndex() {
        long[] array = {1L, 2L, 3L, 4L, 5L};
        int startIndexInclusive = -1; // invalid index
        int endIndexExclusive = 5; // valid index

        long[] result = ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
        long[] expected = EMPTY_LONG_ARRAY; // should return empty array
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubarrayWithZeroSize() {
        long[] array = {1L, 2L, 3L, 4L, 5L};
        int startIndexInclusive = 3; // valid index
        int endIndexExclusive = 3; // same index, resulting in zero size

        long[] result = ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
        long[] expected = EMPTY_LONG_ARRAY; // should return empty array
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testSubarrayWithOutOfBoundsEndIndex() {
        long[] array = {1L, 2L, 3L, 4L, 5L};
        int startIndexInclusive = 1; // valid index
        int endIndexExclusive = 10; // out of bounds

        long[] result = ArrayUtils.subarray(array, startIndexInclusive, endIndexExclusive);
        long[] expected = {2L, 3L, 4L, 5L}; // should return the rest of the array
        assertArrayEquals(expected, result);
    }


}