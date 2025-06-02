package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtils_addAll_int_____int_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAddAll_withNonNullArray1_andArray2() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] result = ArrayUtils.addAll(array1, array2);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAll_withNonNullArray1_andEmptyArray2() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {};
        int[] expected = {1, 2, 3};
        int[] result = ArrayUtils.addAll(array1, array2);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAll_withNullArray1_andNonNullArray2() {
        int[] array1 = null;
        int[] array2 = {4, 5, 6};
        int[] expected = {4, 5, 6};
        int[] result = ArrayUtils.addAll(array1, array2);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAll_withNullArray1_andEmptyArray2() {
        int[] array1 = null;
        int[] array2 = {};
        int[] expected = {};
        int[] result = ArrayUtils.addAll(array1, array2);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAll_withNonNullArray1_andNullArray2() {
        int[] array1 = {1, 2, 3};
        int[] array2 = null;
        int[] expected = {1, 2, 3};
        int[] result = ArrayUtils.addAll(array1, array2);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAll_withNullArrays() {
        int[] array1 = null;
        int[] array2 = null;
        int[] expected = {};
        int[] result = ArrayUtils.addAll(array1, array2);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddAll_withNonNullArray1_andNullArray2_withClone() {
        int[] array1 = {1, 2, 3};
        int[] array2 = null;
        try {
            ArrayUtils.addAll(array1, array2);
        } catch (Exception e) {
            // Handle exception as needed
        }
    }

}