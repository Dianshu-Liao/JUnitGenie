package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_addAll_long_____long_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddAllWithBothArraysNotNull() {
        long[] array1 = {1, 2, 3};
        long[] array2 = {4, 5, 6};
        long[] expected = {1, 2, 3, 4, 5, 6};
        long[] result = ArrayUtils.addAll(array1, array2);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAllWithFirstArrayNull() {
        long[] array2 = {4, 5, 6};
        long[] expected = {4, 5, 6};
        long[] result = ArrayUtils.addAll(null, array2);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAllWithSecondArrayNull() {
        long[] array1 = {1, 2, 3};
        long[] expected = {1, 2, 3};
        long[] result = ArrayUtils.addAll(array1, null);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAllWithBothArraysNull() {
        long[] result = ArrayUtils.addAll(new long[0], new long[0]);
        assertArrayEquals(new long[0], result);
    }


}