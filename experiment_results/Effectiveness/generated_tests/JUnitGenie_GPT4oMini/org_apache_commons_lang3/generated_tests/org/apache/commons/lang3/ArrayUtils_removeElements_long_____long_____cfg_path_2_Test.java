package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_removeElements_long_____long_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveElements_EmptyArray() {
        long[] array = new long[0];
        long[] values = {1, 2, 3};
        long[] expected = new long[0];
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testRemoveElements_EmptyValues() {
        long[] array = {1, 2, 3};
        long[] values = new long[0];
        long[] expected = {1, 2, 3};
        long[] result = ArrayUtils.removeElements(array, values);
        assertArrayEquals(expected, result);
    }

}