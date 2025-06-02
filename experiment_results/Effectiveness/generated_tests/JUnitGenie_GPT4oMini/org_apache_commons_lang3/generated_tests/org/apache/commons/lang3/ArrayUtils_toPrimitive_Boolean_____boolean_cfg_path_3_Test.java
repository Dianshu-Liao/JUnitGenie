package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toPrimitive_Boolean_____boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToPrimitiveWithNonNullArray() {
        Boolean[] inputArray = {true, null, false};
        boolean valueForNull = true;
        boolean[] expectedResult = {true, true, false};
        boolean[] actualResult = ArrayUtils.toPrimitive(inputArray, valueForNull);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullArray() {
        Boolean[] inputArray = null;
        boolean valueForNull = false;
        boolean[] actualResult = ArrayUtils.toPrimitive(inputArray, valueForNull);
        assertArrayEquals(null, actualResult);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithEmptyArray() {
        Boolean[] inputArray = {};
        boolean valueForNull = false;
        boolean[] expectedResult = ArrayUtils.EMPTY_BOOLEAN_ARRAY;
        boolean[] actualResult = ArrayUtils.toPrimitive(inputArray, valueForNull);
        assertArrayEquals(expectedResult, actualResult);
    }

}