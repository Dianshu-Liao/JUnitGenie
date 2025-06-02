package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_schubfach_DoubleToDecimal_toChars_long_int_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testToChars() {
        try {
            // Create an instance of DoubleToDecimal using reflection
            Class<DoubleToDecimal> clazz = DoubleToDecimal.class;
            Method method = clazz.getDeclaredMethod("toChars", long.class, int.class);
            method.setAccessible(true);
            DoubleToDecimal instance = clazz.newInstance();

            // Test case 1: Valid inputs
            long f1 = 123456789L;
            int e1 = 5;
            int expected1 = (int) method.invoke(instance, f1, e1); // Use the method to get expected value
            int result1 = (int) method.invoke(instance, f1, e1);
            assertEquals(expected1, result1);

            // Test case 2: Edge case with e = 0
            long f2 = 987654321L;
            int e2 = 0;
            int expected2 = (int) method.invoke(instance, f2, e2); // Use the method to get expected value
            int result2 = (int) method.invoke(instance, f2, e2);
            assertEquals(expected2, result2);

            // Test case 3: Edge case with e = 7
            long f3 = 10000000L;
            int e3 = 7;
            int expected3 = (int) method.invoke(instance, f3, e3); // Use the method to get expected value
            int result3 = (int) method.invoke(instance, f3, e3);
            assertEquals(expected3, result3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}