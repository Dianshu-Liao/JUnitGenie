package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toPrimitive_Byte_____byte_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToPrimitiveWithValidInput() {
        Byte[] input = new Byte[]{1, 2, null, 4};
        byte valueForNull = 0;
        byte[] expected = new byte[]{1, 2, 0, 4};
        byte[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullArray() {
        Byte[] input = null;
        byte valueForNull = 0;
        byte[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithEmptyArray() {
        Byte[] input = new Byte[]{};
        byte valueForNull = 0;
        byte[] expected = new byte[0];
        byte[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithAllNulls() {
        Byte[] input = new Byte[]{null, null, null};
        byte valueForNull = 5;
        byte[] expected = new byte[]{5, 5, 5};
        byte[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithMixedValues() {
        Byte[] input = new Byte[]{null, 3, null, 7};
        byte valueForNull = 9;
        byte[] expected = new byte[]{9, 3, 9, 7};
        byte[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

}