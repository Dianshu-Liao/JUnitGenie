package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_schubfach_DoubleToDecimal_toDecimal_double_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testToDecimal() {
        try {
            // Create an instance of DoubleToDecimal using reflection
            Class<DoubleToDecimal> clazz = DoubleToDecimal.class;
            Method method = clazz.getDeclaredMethod("toDecimal", double.class);
            method.setAccessible(true);
            DoubleToDecimal instance = clazz.getDeclaredConstructor().newInstance(); // Use getDeclaredConstructor().newInstance()

            // Test case for a normal value
            double input = 5.5;
            int expectedOutput = 5; // Expected output based on the logic of the method
            int actualOutput = (int) method.invoke(instance, input);
            assertEquals(expectedOutput, actualOutput);

            // Test case for a subnormal value
            input = 0.0000000000000001;
            expectedOutput = 0; // Expected output based on the logic of the method
            actualOutput = (int) method.invoke(instance, input);
            assertEquals(expectedOutput, actualOutput);

            // Test case for zero
            input = 0.0;
            expectedOutput = 0; // Expected output based on the logic of the method
            actualOutput = (int) method.invoke(instance, input);
            assertEquals(expectedOutput, actualOutput);

            // Test case for positive infinity
            input = Double.POSITIVE_INFINITY;
            expectedOutput = Integer.MAX_VALUE; // Expected output based on the logic of the method
            actualOutput = (int) method.invoke(instance, input);
            assertEquals(expectedOutput, actualOutput);

            // Test case for negative infinity
            input = Double.NEGATIVE_INFINITY;
            expectedOutput = Integer.MIN_VALUE; // Expected output based on the logic of the method
            actualOutput = (int) method.invoke(instance, input);
            assertEquals(expectedOutput, actualOutput);

            // Test case for NaN
            input = Double.NaN;
            expectedOutput = -1; // Expected output based on the logic of the method
            actualOutput = (int) method.invoke(instance, input);
            assertEquals(expectedOutput, actualOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}