package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class math_NumberUtils_max_double_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMaxWithValidDoubles() {
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        double result = NumberUtils.max(array);
        assertEquals(5.0, result, 0.01);
    }

    @Test(timeout = 4000)
    public void testMaxWithNan() {
        double[] array = {1.0, Double.NaN, 3.0};
        double result = NumberUtils.max(array);
        assertEquals(Double.NaN, result, 0.01);
    }

    @Test(timeout = 4000)
    public void testMaxWithEmptyArray() {
        double[] array = {};
        try {
            NumberUtils.max(array); // This should call validateArray and throw an exception
        } catch (Exception e) {
            // Handle possible exceptions for empty array input
            // You can add specific assertions based on expected behavior
        }
    }

    @Test(timeout = 4000)
    public void testMaxWithNullArray() {
        double[] array = null;
        try {
            NumberUtils.max(array); // This should call validateArray and throw an exception
        } catch (Exception e) {
            // Handle possible exceptions for null input
            // Assure that the exception is as expected
        }
    }

}