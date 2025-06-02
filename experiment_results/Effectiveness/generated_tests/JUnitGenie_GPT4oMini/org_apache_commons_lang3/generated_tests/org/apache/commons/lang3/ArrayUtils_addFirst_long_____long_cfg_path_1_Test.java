package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_addFirst_long_____long_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddFirstWithNonNullArray() {
        long[] array = {2, 3, 4};
        long element = 1;
        long[] expected = {1, 2, 3, 4};
        long[] result = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddFirstWithNullArray() {
        long element = 1;
        long[] expected = {1};
        long[] result = ArrayUtils.addFirst(new long[0], element); // Changed null to new long[0]
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddFirstWithEmptyArray() {
        long[] array = {};
        long element = 1;
        long[] expected = {1};
        long[] result = ArrayUtils.addFirst(array, element);
        assertArrayEquals(expected, result);
    }


}