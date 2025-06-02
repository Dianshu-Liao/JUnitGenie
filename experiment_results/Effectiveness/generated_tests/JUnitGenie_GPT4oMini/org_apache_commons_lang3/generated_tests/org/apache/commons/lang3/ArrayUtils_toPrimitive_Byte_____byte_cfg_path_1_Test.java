package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toPrimitive_Byte_____byte_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToPrimitiveWithValidInput() {
        Byte[] input = {1, 2, null, 4};
        byte valueForNull = 0;
        byte[] expected = {1, 2, 0, 4};
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
        Byte[] input = {};
        byte valueForNull = 0;
        byte[] expected = ArrayUtils.EMPTY_BYTE_ARRAY; // Assuming EMPTY_BYTE_ARRAY is defined in ArrayUtils
        byte[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithAllNulls() {
        Byte[] input = {null, null, null};
        byte valueForNull = 5;
        byte[] expected = {5, 5, 5};
        byte[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithNoNulls() {
        Byte[] input = {10, 20, 30};
        byte valueForNull = 0;
        byte[] expected = {10, 20, 30};
        byte[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

}