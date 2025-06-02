package com.fasterxml.jackson.core.io.schubfach;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_schubfach_DoubleToDecimal_toDecimal_double_cfg_path_28_Test {

    @Test(timeout = 4000)
    public void testToDecimalNormalValue() {
        testToDecimal(7.0, 7);
    }

    @Test(timeout = 4000)
    public void testToDecimalSubnormalValue() {
        testToDecimal(1.0e-300, 0);
    }

    @Test(timeout = 4000)
    public void testToDecimalZero() {
        testToDecimal(0.0, 0);
    }

    @Test(timeout = 4000)
    public void testToDecimalNegativeValue() {
        testToDecimal(-5.0, -5);
    }

    private void testToDecimal(double input, int expectedOutput) {
        try {
            // Create an instance of the DoubleToDecimal class
            Class<?> clazz = Class.forName("com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal");
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // Access the private method 'toDecimal'
            Method method = clazz.getDeclaredMethod("toDecimal", double.class);
            method.setAccessible(true);

            // Invoke the method and assert the result
            int result = (int) method.invoke(instance, input);
            assertEquals(expectedOutput, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}