package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_schubfach_DoubleToDecimal_toDecimal_double_cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testToDecimal() {
        try {
            // Create an instance of DoubleToDecimal using reflection
            Class<DoubleToDecimal> clazz = DoubleToDecimal.class;
            Method method = clazz.getDeclaredMethod("toDecimal", double.class);
            method.setAccessible(true);
            DoubleToDecimal instance = clazz.getDeclaredConstructor().newInstance(); // Use getDeclaredConstructor().newInstance()

            // Test input that satisfies the conditions for the CFG path
            double input = 45.0; // This value is chosen to ensure the path is executed
            int expectedOutput = 0; // Replace with the expected output based on the input

            // Invoke the private method
            int result = (int) method.invoke(instance, input);
            assertEquals(expectedOutput, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}