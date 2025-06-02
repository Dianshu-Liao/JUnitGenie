package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_schubfach_DoubleToDecimal_toDecimal_double_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testToDecimal() {
        try {
            // Create an instance of DoubleToDecimal using reflection
            Class<DoubleToDecimal> clazz = DoubleToDecimal.class;
            Constructor<DoubleToDecimal> constructor = clazz.getDeclaredConstructor(); // Get the constructor
            constructor.setAccessible(true); // Make the private constructor accessible
            DoubleToDecimal instance = constructor.newInstance(); // Create an instance

            Method method = clazz.getDeclaredMethod("toDecimal", double.class);
            method.setAccessible(true); // Make the private method accessible

            // Test case for a normal value
            double normalValue = 5.5;
            int expectedNormalResult = 5; // Expected result based on the logic
            int actualNormalResult = (int) method.invoke(instance, normalValue);
            assertEquals(expectedNormalResult, actualNormalResult);

            // Test case for zero
            double zeroValue = 0.0;
            int expectedZeroResult = 0; // Expected result for zero
            int actualZeroResult = (int) method.invoke(instance, zeroValue);
            assertEquals(expectedZeroResult, actualZeroResult);

            // Test case for negative value
            double negativeValue = -3.14;
            int expectedNegativeResult = -3; // Expected result based on the logic
            int actualNegativeResult = (int) method.invoke(instance, negativeValue);
            assertEquals(expectedNegativeResult, actualNegativeResult);

            // Test case for positive infinity
            double positiveInfinity = Double.POSITIVE_INFINITY;
            int expectedPositiveInfinityResult = Integer.MAX_VALUE; // Expected result for positive infinity
            int actualPositiveInfinityResult = (int) method.invoke(instance, positiveInfinity);
            assertEquals(expectedPositiveInfinityResult, actualPositiveInfinityResult);

            // Test case for negative infinity
            double negativeInfinity = Double.NEGATIVE_INFINITY;
            int expectedNegativeInfinityResult = Integer.MIN_VALUE; // Expected result for negative infinity
            int actualNegativeInfinityResult = (int) method.invoke(instance, negativeInfinity);
            assertEquals(expectedNegativeInfinityResult, actualNegativeInfinityResult);

            // Test case for NaN
            double nanValue = Double.NaN;
            int expectedNaNResult = -1; // Expected result for NaN
            int actualNaNResult = (int) method.invoke(instance, nanValue);
            assertEquals(expectedNaNResult, actualNaNResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}