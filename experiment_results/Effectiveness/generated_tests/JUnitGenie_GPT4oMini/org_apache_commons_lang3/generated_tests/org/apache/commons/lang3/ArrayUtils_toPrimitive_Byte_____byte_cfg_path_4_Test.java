package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toPrimitive_Byte_____byte_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testToPrimitiveWithEmptyArray() {
        Byte[] inputArray = new Byte[0];
        byte valueForNull = 0;
        byte[] expectedOutput = ArrayUtils.EMPTY_BYTE_ARRAY;

        byte[] result = ArrayUtils.toPrimitive(inputArray, valueForNull);
        assertArrayEquals(expectedOutput, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullArray() {
        Byte[] inputArray = null;
        byte valueForNull = 0;

        byte[] result = ArrayUtils.toPrimitive(inputArray, valueForNull);
        assertArrayEquals(null, result);
    }

}