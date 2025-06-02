package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_nullToEmpty_double_____cfg_path_2_Test {

    private static final double[] EMPTY_DOUBLE_ARRAY = new double[0];

    @Test(timeout = 4000)
    public void testNullToEmpty_withNullArray() {
        double[] result = ArrayUtils.nullToEmpty((double[]) null);
        assertArrayEquals(EMPTY_DOUBLE_ARRAY, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testNullToEmpty_withEmptyArray() {
        double[] result = ArrayUtils.nullToEmpty(new double[0]);
        assertArrayEquals(EMPTY_DOUBLE_ARRAY, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testNullToEmpty_withNonEmptyArray() {
        double[] inputArray = new double[]{1.0, 2.0, 3.0};
        double[] result = ArrayUtils.nullToEmpty(inputArray);
        assertArrayEquals(inputArray, result, 0.0);
    }


}