package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayUtils_toPrimitive_Short_____cfg_path_1_Test {

    private static final short[] EMPTY_SHORT_ARRAY = new short[0];

    @Test(timeout = 4000)
    public void testToPrimitive_withNonNullArray() {
        Short[] input = {1, 2, 3};
        short[] expected = {1, 2, 3};
        short[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitive_withNullArray() {
        Short[] input = null;
        short[] result = ArrayUtils.toPrimitive(input);
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testToPrimitive_withEmptyArray() {
        Short[] input = {};
        short[] result = ArrayUtils.toPrimitive(input);
        assertArrayEquals(EMPTY_SHORT_ARRAY, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitive_withMixedValues() {
        Short[] input = {1, null, 3, 4};
        try {
            ArrayUtils.toPrimitive(input);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}