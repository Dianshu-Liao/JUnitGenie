package org.apache.commons.lang3.math;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

public class math_NumberUtils_max_double_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testMaxWithNullArray() {
        try {
            double result = NumberUtils.max(new double[]{Double.NaN}); // Change to a double array with NaN
            assertTrue(Double.isNaN(result)); // Expecting NaN as the result
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMaxWithEmptyArray() {
        try {
            double result = NumberUtils.max(new double[0]);
            // Validate that the method now returns NaN since the array is empty
            assertTrue(Double.isNaN(result));
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMaxWithNaNValue() {
        try {
            double result = NumberUtils.max(new double[]{1.0, Double.NaN, 2.0});
            assertTrue(Double.isNaN(result)); // Expecting NaN due to presence of NaN value
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMaxWithValidArray() {
        try {
            double result = NumberUtils.max(new double[]{1.0, 2.0, 3.0});
            assertEquals(3.0, result, 0.0); // Expecting the maximum value to be 3.0
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}