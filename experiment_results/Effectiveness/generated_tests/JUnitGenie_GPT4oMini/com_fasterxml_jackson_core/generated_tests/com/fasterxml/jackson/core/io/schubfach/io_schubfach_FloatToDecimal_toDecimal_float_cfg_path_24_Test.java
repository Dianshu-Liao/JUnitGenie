package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_schubfach_FloatToDecimal_toDecimal_float_cfg_path_24_Test {

    @Test(timeout = 4000)
    public void testToDecimal() {
        try {
            // Create an instance of FloatToDecimal using reflection
            Constructor<FloatToDecimal> constructor = FloatToDecimal.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            FloatToDecimal floatToDecimal = constructor.newInstance();

            // Access the private method 'toDecimal' using reflection
            Method toDecimalMethod = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
            toDecimalMethod.setAccessible(true);

            // Test case 1: Normal value
            float input1 = 1.5f; // Example of a normal float value
            int expectedOutput1 = 3; // Expected output based on the logic
            int actualOutput1 = (int) toDecimalMethod.invoke(floatToDecimal, input1);
            assertEquals(expectedOutput1, actualOutput1);

            // Test case 2: Subnormal value
            float input2 = 1.401298464e-45f; // Example of a subnormal float value
            int expectedOutput2 = 0; // Expected output based on the logic
            int actualOutput2 = (int) toDecimalMethod.invoke(floatToDecimal, input2);
            assertEquals(expectedOutput2, actualOutput2);

            // Test case 3: Zero
            float input3 = 0.0f; // Example of zero
            int expectedOutput3 = FloatToDecimal.class.getDeclaredField("PLUS_ZERO").getInt(null); // Accessing the private static field
            int actualOutput3 = (int) toDecimalMethod.invoke(floatToDecimal, input3);
            assertEquals(expectedOutput3, actualOutput3);

            // Test case 4: Positive Infinity
            float input4 = Float.POSITIVE_INFINITY; // Example of positive infinity
            int expectedOutput4 = FloatToDecimal.class.getDeclaredField("PLUS_INF").getInt(null); // Accessing the private static field
            int actualOutput4 = (int) toDecimalMethod.invoke(floatToDecimal, input4);
            assertEquals(expectedOutput4, actualOutput4);

            // Test case 5: Negative Infinity
            float input5 = Float.NEGATIVE_INFINITY; // Example of negative infinity
            int expectedOutput5 = FloatToDecimal.class.getDeclaredField("MINUS_INF").getInt(null); // Accessing the private static field
            int actualOutput5 = (int) toDecimalMethod.invoke(floatToDecimal, input5);
            assertEquals(expectedOutput5, actualOutput5);

            // Test case 6: NaN
            float input6 = Float.NaN; // Example of NaN
            int expectedOutput6 = FloatToDecimal.class.getDeclaredField("NAN").getInt(null); // Accessing the private static field
            int actualOutput6 = (int) toDecimalMethod.invoke(floatToDecimal, input6);
            assertEquals(expectedOutput6, actualOutput6);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}