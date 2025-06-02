package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class math_NumberUtils_max_double_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testMaxWithValidArray() {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        double result = NumberUtils.max(array);
        assertEquals(5.0, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testMaxWithSingleElementArray() {
        double[] array = {42.0};
        double result = NumberUtils.max(array);
        assertEquals(42.0, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testMaxWithNegativeValues() {
        double[] array = {-1.0, -2.0, -3.0};
        double result = NumberUtils.max(array);
        assertEquals(-1.0, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testMaxWithNaNValue() {
        double[] array = {1.0, Double.NaN, 3.0};
        double result = NumberUtils.max(array);
        assertEquals(Double.NaN, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testMaxWithEmptyArray() {
        double[] array = {};
        try {
            NumberUtils.max(array);
        } catch (Exception e) {
            // Handle the exception as needed
        }
    }

    @Test(timeout = 4000)
    public void testMaxWithNullArray() {
        double[] array = null;
        try {
            NumberUtils.max(array);
        } catch (Exception e) {
            // Handle the exception as needed
        }
    }

}