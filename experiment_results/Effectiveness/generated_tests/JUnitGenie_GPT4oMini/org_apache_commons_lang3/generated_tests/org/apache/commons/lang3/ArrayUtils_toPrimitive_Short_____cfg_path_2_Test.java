package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toPrimitive_Short_____cfg_path_2_Test {

    private static final short[] EMPTY_SHORT_ARRAY = new short[0];

    @Test(timeout = 4000)
    public void testToPrimitiveWithNonEmptyArray() {
        Short[] input = {1, 2, 3};
        short[] expected = {1, 2, 3};
        short[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithEmptyArray() {
        Short[] input = {};
        short[] expected = EMPTY_SHORT_ARRAY;
        short[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullArray() {
        Short[] input = null;
        short[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(null, result);
    }

}