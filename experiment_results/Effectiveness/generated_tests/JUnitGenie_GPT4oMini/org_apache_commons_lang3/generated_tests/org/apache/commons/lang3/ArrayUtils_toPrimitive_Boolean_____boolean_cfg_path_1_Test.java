package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toPrimitive_Boolean_____boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToPrimitiveWithValidInput() {
        Boolean[] input = {true, null, false};
        boolean valueForNull = true;
        boolean[] expected = {true, true, false};
        boolean[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullArray() {
        Boolean[] input = null;
        boolean valueForNull = true;
        boolean[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithEmptyArray() {
        Boolean[] input = {};
        boolean valueForNull = true;
        boolean[] expected = ArrayUtils.EMPTY_BOOLEAN_ARRAY;
        boolean[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithAllNulls() {
        Boolean[] input = {null, null, null};
        boolean valueForNull = false;
        boolean[] expected = {false, false, false};
        boolean[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithMixedValues() {
        Boolean[] input = {null, true, false, null};
        boolean valueForNull = true;
        boolean[] expected = {true, true, false, true};
        boolean[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

}