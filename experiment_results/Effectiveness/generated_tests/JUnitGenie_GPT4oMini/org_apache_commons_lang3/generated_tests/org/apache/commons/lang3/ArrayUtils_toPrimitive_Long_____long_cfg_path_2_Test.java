package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toPrimitive_Long_____long_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToPrimitiveWithNonNullValues() {
        Long[] input = {1L, 2L, 3L};
        long valueForNull = 0L;
        long[] expected = {1L, 2L, 3L};
        long[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullValues() {
        Long[] input = {1L, null, 3L};
        long valueForNull = 0L;
        long[] expected = {1L, 0L, 3L};
        long[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithEmptyArray() {
        Long[] input = {};
        long valueForNull = 0L;
        long[] expected = {};
        long[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullArray() {
        Long[] input = null;
        long valueForNull = 0L;
        long[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(null, result);
    }

}