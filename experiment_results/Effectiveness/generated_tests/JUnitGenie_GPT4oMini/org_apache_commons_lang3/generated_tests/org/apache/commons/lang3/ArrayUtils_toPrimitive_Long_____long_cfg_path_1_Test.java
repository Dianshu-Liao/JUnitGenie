package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toPrimitive_Long_____long_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToPrimitiveWithEmptyArray() {
        Long[] inputArray = {};
        long valueForNull = 0L;
        long[] expectedOutput = ArrayUtils.EMPTY_LONG_ARRAY;

        long[] actualOutput = ArrayUtils.toPrimitive(inputArray, valueForNull);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullArray() {
        Long[] inputArray = null;
        long valueForNull = 0L;

        long[] actualOutput = ArrayUtils.toPrimitive(inputArray, valueForNull);
        assertArrayEquals(null, actualOutput);
    }

}