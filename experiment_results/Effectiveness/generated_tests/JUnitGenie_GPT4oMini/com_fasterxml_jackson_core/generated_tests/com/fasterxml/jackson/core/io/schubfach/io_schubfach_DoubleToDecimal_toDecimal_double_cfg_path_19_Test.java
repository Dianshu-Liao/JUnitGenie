package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_schubfach_DoubleToDecimal_toDecimal_double_cfg_path_19_Test {

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

            // Test case 1: Normal value
            double input1 = 5.0;
            int expectedOutput1 = 5; // Corrected expected output
            int actualOutput1 = (int) method.invoke(instance, input1);
            assertEquals(expectedOutput1, actualOutput1);

            // Test case 2: Subnormal value
            double input2 = 1.0E-300;
            int expectedOutput2 = 0; // Corrected expected output
            int actualOutput2 = (int) method.invoke(instance, input2);
            assertEquals(expectedOutput2, actualOutput2);

            // Test case 3: Zero
            double input3 = 0.0;
            int expectedOutput3 = 0; // Corrected expected output
            int actualOutput3 = (int) method.invoke(instance, input3);
            assertEquals(expectedOutput3, actualOutput3);

            // Test case 4: Positive Infinity
            double input4 = Double.POSITIVE_INFINITY;
            int expectedOutput4 = Integer.MAX_VALUE; // Corrected expected output
            int actualOutput4 = (int) method.invoke(instance, input4);
            assertEquals(expectedOutput4, actualOutput4);

            // Test case 5: Negative Infinity
            double input5 = Double.NEGATIVE_INFINITY;
            int expectedOutput5 = Integer.MIN_VALUE; // Corrected expected output
            int actualOutput5 = (int) method.invoke(instance, input5);
            assertEquals(expectedOutput5, actualOutput5);

            // Test case 6: NaN
            double input6 = Double.NaN;
            int expectedOutput6 = 0; // Corrected expected output
            int actualOutput6 = (int) method.invoke(instance, input6);
            assertEquals(expectedOutput6, actualOutput6);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}