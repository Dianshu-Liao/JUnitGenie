package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_addAll_long_____long_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAddAll_withNonNullArray1_andNullArray2() {
        long[] array1 = {1L, 2L, 3L};
        long[] array2 = null;

        long[] result = ArrayUtils.addAll(array1, array2);
        long[] expected = {1L, 2L, 3L};

        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAll_withNullArray1_andNonNullArray2() {
        long[] array1 = null;
        long[] array2 = {4L, 5L, 6L};

        long[] result = ArrayUtils.addAll(array1, array2);
        long[] expected = {4L, 5L, 6L};

        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAll_withNonNullArray1_andNonNullArray2() {
        long[] array1 = {1L, 2L, 3L};
        long[] array2 = {4L, 5L, 6L};

        long[] result = ArrayUtils.addAll(array1, array2);
        long[] expected = {1L, 2L, 3L, 4L, 5L, 6L};

        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAll_withBothArraysNull() {
        long[] array1 = null;
        long[] array2 = null;

        long[] result = ArrayUtils.addAll(array1, array2);
        long[] expected = new long[0]; // Expecting an empty array

        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAll_withEmptyArray1_andNonEmptyArray2() {
        long[] array1 = {};
        long[] array2 = {7L, 8L};

        long[] result = ArrayUtils.addAll(array1, array2);
        long[] expected = {7L, 8L};

        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAll_withNonEmptyArray1_andEmptyArray2() {
        long[] array1 = {9L, 10L};
        long[] array2 = {};

        long[] result = ArrayUtils.addAll(array1, array2);
        long[] expected = {9L, 10L};

        assertArrayEquals(expected, result);
    }

}