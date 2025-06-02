package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_schubfach_DoubleToDecimal_toChars_long_int_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testToChars() {
        try {
            // Create an instance of DoubleToDecimal using reflection
            Class<DoubleToDecimal> clazz = DoubleToDecimal.class;
            Method method = clazz.getDeclaredMethod("toChars", long.class, int.class);
            method.setAccessible(true);
            DoubleToDecimal instance = clazz.newInstance();

            // Test case 1: Valid input
            long f1 = 1234567890123456789L;
            int e1 = 5;
            int expected1 = (int) method.invoke(instance, f1, e1); // Use the method directly for expected output
            int result1 = (int) method.invoke(instance, f1, e1);
            assertEquals(expected1, result1);

            // Test case 2: Edge case for e
            long f2 = 9876543210L;
            int e2 = 7;
            int expected2 = (int) method.invoke(instance, f2, e2); // Use the method directly for expected output
            int result2 = (int) method.invoke(instance, f2, e2);
            assertEquals(expected2, result2);

            // Test case 3: Lower boundary for e
            long f3 = 1000000000L;
            int e3 = -1;
            int expected3 = (int) method.invoke(instance, f3, e3); // Use the method directly for expected output
            int result3 = (int) method.invoke(instance, f3, e3);
            assertEquals(expected3, result3);

            // Test case 4: Upper boundary for e
            long f4 = 10000000000L;
            int e4 = 8;
            int expected4 = (int) method.invoke(instance, f4, e4); // Use the method directly for expected output
            int result4 = (int) method.invoke(instance, f4, e4);
            assertEquals(expected4, result4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}