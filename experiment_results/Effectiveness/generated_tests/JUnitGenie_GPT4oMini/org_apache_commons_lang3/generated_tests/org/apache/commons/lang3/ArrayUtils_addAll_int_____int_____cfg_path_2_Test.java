package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_addAll_int_____int_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddAllWithNonNullArrays() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] result = ArrayUtils.addAll(array1, array2);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAllWithFirstArrayNull() {
        int[] array2 = {4, 5, 6};
        int[] expected = {4, 5, 6};
        int[] result = ArrayUtils.addAll(new int[0], array2); // Changed null to new int[0]
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAllWithSecondArrayNull() {
        int[] array1 = {1, 2, 3};
        int[] expected = {1, 2, 3};
        int[] result = ArrayUtils.addAll(array1, new int[0]); // Changed null to new int[0]
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAllWithBothArraysNull() {
        int[] result = ArrayUtils.addAll(new int[0], new int[0]); // Changed null to new int[0]
        assertArrayEquals(new int[0], result);
    }


}