package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toPrimitive_Long_____long_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testToPrimitive_withValidArray() {
        Long[] inputArray = {1L, 2L, null, 4L};
        long valueForNull = 0L;
        long[] expectedResult = {1L, 2L, 0L, 4L};
        long[] actualResult = ArrayUtils.toPrimitive(inputArray, valueForNull);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(timeout = 4000)
    public void testToPrimitive_withNullArray() {
        Long[] inputArray = null;
        long valueForNull = 0L;
        long[] actualResult = ArrayUtils.toPrimitive(inputArray, valueForNull);
        assertArrayEquals(null, actualResult);
    }

    @Test(timeout = 4000)
    public void testToPrimitive_withEmptyArray() {
        Long[] inputArray = {};
        long valueForNull = 0L;
        long[] expectedResult = ArrayUtils.EMPTY_LONG_ARRAY; // Assuming EMPTY_LONG_ARRAY is a static final field in ArrayUtils
        long[] actualResult = ArrayUtils.toPrimitive(inputArray, valueForNull);
        assertArrayEquals(expectedResult, actualResult);
    }

}