package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class io_schubfach_FloatToDecimal_toChars_int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToChars() {
        try {
            // Create an instance of FloatToDecimal using reflection
            Class<?> clazz = FloatToDecimal.class;
            Method method = clazz.getDeclaredMethod("toChars", int.class, int.class);
            method.setAccessible(true); // Make the private method accessible

            // Create an instance of FloatToDecimal
            Object floatToDecimalInstance = clazz.getDeclaredConstructor().newInstance();

            // Test case 1: Valid inputs
            int f1 = 12345678; // Example valid input
            int e1 = 5; // Example valid exponent
            int expected1 = 12346000; // Example expected output
            int result1 = (int) method.invoke(floatToDecimalInstance, f1, e1);
            assertEquals(expected1, result1);

            // Test case 2: Edge case with f being a power of 10
            int f2 = 10000000; // Example valid input
            int e2 = 7; // Example valid exponent
            int expected2 = 10000000; // Example expected output
            int result2 = (int) method.invoke(floatToDecimalInstance, f2, e2);
            assertEquals(expected2, result2);

            // Test case 3: Edge case with negative exponent
            int f3 = 12345678; // Example valid input
            int e3 = -1; // Example valid exponent
            int expected3 = 1234567; // Example expected output
            int result3 = (int) method.invoke(floatToDecimalInstance, f3, e3);
            assertEquals(expected3, result3);

            // Test case 4: Edge case with zero exponent
            int f4 = 12345678; // Example valid input
            int e4 = 0; // Example valid exponent
            int expected4 = 12345678; // Example expected output
            int result4 = (int) method.invoke(floatToDecimalInstance, f4, e4);
            assertEquals(expected4, result4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}