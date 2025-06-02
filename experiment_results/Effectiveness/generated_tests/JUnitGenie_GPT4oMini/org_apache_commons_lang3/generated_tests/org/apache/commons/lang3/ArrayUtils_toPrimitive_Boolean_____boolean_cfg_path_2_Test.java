package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_toPrimitive_Boolean_____boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToPrimitiveWithNonNullArray() {
        Boolean[] input = {true, null, false};
        boolean valueForNull = false;
        boolean[] expected = {true, false, false};
        boolean[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithNullArray() {
        Boolean[] input = null;
        boolean valueForNull = false;
        boolean[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithEmptyArray() {
        Boolean[] input = {};
        boolean valueForNull = false;
        boolean[] expected = new boolean[0];
        boolean[] result = ArrayUtils.toPrimitive(input, valueForNull);
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testToPrimitiveWithAllNulls() {
        Boolean[] input = {null, null, null};
        boolean valueForNull = true;
        boolean[] expected = {true, true, true};
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