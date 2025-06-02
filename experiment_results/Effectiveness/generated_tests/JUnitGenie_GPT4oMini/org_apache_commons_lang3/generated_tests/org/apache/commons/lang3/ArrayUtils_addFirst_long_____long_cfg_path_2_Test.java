package org.apache.commons.lang3;
import static org.junit.Assert.assertArrayEquals;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class ArrayUtils_addFirst_long_____long_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddFirst_NullArray() {
        long[] result = ArrayUtils.addFirst(new long[0], 5L); // Changed null to an empty long array
        long[] expected = {5L};
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testAddFirst_ValidArray() {
        long[] array = {2L, 3L};
        long element = 1L;
        long[] result = ArrayUtils.addFirst(array, element);
        long[] expected = {1L, 2L, 3L};
        assertArrayEquals(expected, result);
    }


}