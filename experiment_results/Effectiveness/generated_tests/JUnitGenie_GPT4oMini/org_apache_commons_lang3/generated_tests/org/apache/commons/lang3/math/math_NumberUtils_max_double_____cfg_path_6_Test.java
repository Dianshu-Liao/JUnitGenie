package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class math_NumberUtils_max_double_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testMaxWithValidArray() {
        double[] array = {1.0, 2.0, 3.0, 4.0};
        double result = NumberUtils.max(array);
        assertEquals(4.0, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testMaxWithNaN() {
        double[] array = {1.0, Double.NaN, 3.0};
        double result = NumberUtils.max(array);
        assertEquals(Double.NaN, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testMaxWithSingleElement() {
        double[] array = {5.0};
        double result = NumberUtils.max(array);
        assertEquals(5.0, result, 0.001);
    }

    @Test(timeout = 4000)
    public void testMaxWithEmptyArray() {
        double[] array = {};
        try {
            NumberUtils.max(array);
        } catch (IllegalArgumentException e) {
            // Expected exception for empty array
        }
    }

}