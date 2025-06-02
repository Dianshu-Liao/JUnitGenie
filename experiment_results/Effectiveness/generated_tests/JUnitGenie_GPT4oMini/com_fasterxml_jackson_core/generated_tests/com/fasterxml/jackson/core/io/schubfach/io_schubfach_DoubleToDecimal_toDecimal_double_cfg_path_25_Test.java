package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_schubfach_DoubleToDecimal_toDecimal_double_cfg_path_25_Test {

    @Test(timeout = 4000)
    public void testToDecimal() {
        try {
            // Create an instance of DoubleToDecimal using reflection
            Class<DoubleToDecimal> clazz = DoubleToDecimal.class;
            Method method = clazz.getDeclaredMethod("toDecimal", double.class);
            method.setAccessible(true);
            DoubleToDecimal instance = clazz.getDeclaredConstructor().newInstance(); // Use getDeclaredConstructor().newInstance()

            // Test case 1: Normal value
            double input1 = 1.5; // Example input
            int expectedOutput1 = 3; // Expected output for 1.5
            int actualOutput1 = (int) method.invoke(instance, input1);
            assertEquals(expectedOutput1, actualOutput1);

            // Test case 2: Subnormal value
            double input2 = 0.0000000000000001; // Example subnormal input
            int expectedOutput2 = 0; // Expected output for subnormal value
            int actualOutput2 = (int) method.invoke(instance, input2);
            assertEquals(expectedOutput2, actualOutput2);

            // Test case 3: Zero
            double input3 = 0.0; // Example input
            int expectedOutput3 = 1; // Expected output for zero
            int actualOutput3 = (int) method.invoke(instance, input3);
            assertEquals(expectedOutput3, actualOutput3);

            // Test case 4: Positive infinity
            double input4 = Double.POSITIVE_INFINITY; // Example input
            int expectedOutput4 = 2; // Expected output for positive infinity
            int actualOutput4 = (int) method.invoke(instance, input4);
            assertEquals(expectedOutput4, actualOutput4);

            // Test case 5: Negative infinity
            double input5 = Double.NEGATIVE_INFINITY; // Example input
            int expectedOutput5 = 3; // Expected output for negative infinity
            int actualOutput5 = (int) method.invoke(instance, input5);
            assertEquals(expectedOutput5, actualOutput5);

            // Test case 6: NaN
            double input6 = Double.NaN; // Example input
            int expectedOutput6 = 4; // Expected output for NaN
            int actualOutput6 = (int) method.invoke(instance, input6);
            assertEquals(expectedOutput6, actualOutput6);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}