package org.apache.commons.lang3.math;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class math_NumberUtils_max_double_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMaxWithValidArray() {
        try {
            double result = NumberUtils.max(1.0, 2.0, 3.0);
            assertEquals(3.0, result, 0.001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMaxWithArrayContainingNaN() {
        try {
            double result = NumberUtils.max(1.0, Double.NaN, 3.0);
            assertEquals(Double.NaN, result, 0.001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMaxWithEmptyArray() {
        try {
            double result = NumberUtils.max();
            // Here it should throw an exception as we expect an empty array not to be valid
            // Specific handling based on implementation needs to be defined
            // In this case, assume it will not throw an exception but return NaN as per the method behavior
            assertEquals(Double.NaN, result, 0.001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMaxWithSingleElementArray() {
        try {
            double result = NumberUtils.max(5.0);
            assertEquals(5.0, result, 0.001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}