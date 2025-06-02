package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_removeElements_long_____long_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testRemoveElementsWithNullArray() {
        long[] array = null;
        long[] values = {1, 2, 3};
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyArray() {
        long[] array = new long[0];
        long[] values = {1, 2, 3};
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(new long[0], result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithEmptyValues() {
        long[] array = {1, 2, 3, 4};
        long[] values = new long[0];
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(new long[]{1, 2, 3, 4}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithValuesPresent() {
        long[] array = {1, 2, 3, 4, 5};
        long[] values = {2, 4};
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(new long[]{1, 3, 5}, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithAllValuesPresent() {
        long[] array = {1, 2, 3};
        long[] values = {1, 2, 3};
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(new long[0], result);
    }

    @Test(timeout = 4000)
    public void testRemoveElementsWithNoValuesPresent() {
        long[] array = {1, 2, 3};
        long[] values = {4, 5};
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(new long[]{1, 2, 3}, result);
    }

}