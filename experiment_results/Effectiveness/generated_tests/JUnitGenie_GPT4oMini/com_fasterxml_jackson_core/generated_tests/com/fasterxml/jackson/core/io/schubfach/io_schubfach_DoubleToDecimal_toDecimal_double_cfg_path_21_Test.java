package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_schubfach_DoubleToDecimal_toDecimal_double_cfg_path_21_Test {

    @Test(timeout = 4000)
    public void testToDecimal() {
        try {
            // Create an instance of DoubleToDecimal using reflection
            Class<DoubleToDecimal> clazz = DoubleToDecimal.class;
            Constructor<DoubleToDecimal> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            DoubleToDecimal instance = constructor.newInstance();

            // Prepare the input value for the test
            double inputValue = 45.0;

            // Access the private method 'toDecimal' using reflection
            Method toDecimalMethod = clazz.getDeclaredMethod("toDecimal", double.class);
            toDecimalMethod.setAccessible(true);

            // Call the method and capture the result
            int result = (int) toDecimalMethod.invoke(instance, inputValue);

            // Assert the expected output
            assertEquals(45, result); // Assuming the expected output for input 45.0 is 45

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}