package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_nullToEmpty_double_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testNullToEmptyWithNullArray() {
        double[] result = ArrayUtils.nullToEmpty((double[]) null);
        assertArrayEquals(new double[]{}, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testNullToEmptyWithEmptyArray() {
        double[] result = ArrayUtils.nullToEmpty(new double[0]);
        assertArrayEquals(new double[]{}, result, 0.0);
    }

    @Test(timeout = 4000)
    public void testNullToEmptyWithNonEmptyArray() {
        double[] input = new double[]{1.0, 2.0, 3.0};
        double[] result = ArrayUtils.nullToEmpty(input);
        assertArrayEquals(input, result, 0.0);
    }


}