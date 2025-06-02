package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_schubfach_DoubleToDecimal_toDecimal_double_cfg_path_18_Test {

    @Test(timeout = 4000)
    public void testToDecimal() {
        try {
            // Create an instance of DoubleToDecimal using reflection
            Class<DoubleToDecimal> clazz = DoubleToDecimal.class;
            Method method = clazz.getDeclaredMethod("toDecimal", double.class);
            method.setAccessible(true);
            DoubleToDecimal instance = clazz.getDeclaredConstructor().newInstance(); // Use getDeclaredConstructor().newInstance()

            // Test case for a normal value
            double normalValue = 5.5; // Example normal value
            int expectedNormalResult = 5; // Expected result for the normal value
            int actualNormalResult = (int) method.invoke(instance, normalValue);
            assertEquals(expectedNormalResult, actualNormalResult);

            // Test case for a subnormal value
            double subnormalValue = 1.0E-300; // Example subnormal value
            int expectedSubnormalResult = 0; // Expected result for the subnormal value
            int actualSubnormalResult = (int) method.invoke(instance, subnormalValue);
            assertEquals(expectedSubnormalResult, actualSubnormalResult);

            // Test case for zero
            double zeroValue = 0.0; // Example zero value
            int expectedZeroResult = 0; // Expected result for zero
            int actualZeroResult = (int) method.invoke(instance, zeroValue);
            assertEquals(expectedZeroResult, actualZeroResult);

            // Test case for positive infinity
            double positiveInfinity = Double.POSITIVE_INFINITY; // Example positive infinity
            int expectedPositiveInfinityResult = Integer.MAX_VALUE; // Expected result for positive infinity
            int actualPositiveInfinityResult = (int) method.invoke(instance, positiveInfinity);
            assertEquals(expectedPositiveInfinityResult, actualPositiveInfinityResult);

            // Test case for negative infinity
            double negativeInfinity = Double.NEGATIVE_INFINITY; // Example negative infinity
            int expectedNegativeInfinityResult = Integer.MIN_VALUE; // Expected result for negative infinity
            int actualNegativeInfinityResult = (int) method.invoke(instance, negativeInfinity);
            assertEquals(expectedNegativeInfinityResult, actualNegativeInfinityResult);

            // Test case for NaN
            double nanValue = Double.NaN; // Example NaN value
            int expectedNaNResult = -1; // Expected result for NaN
            int actualNaNResult = (int) method.invoke(instance, nanValue);
            assertEquals(expectedNaNResult, actualNaNResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}