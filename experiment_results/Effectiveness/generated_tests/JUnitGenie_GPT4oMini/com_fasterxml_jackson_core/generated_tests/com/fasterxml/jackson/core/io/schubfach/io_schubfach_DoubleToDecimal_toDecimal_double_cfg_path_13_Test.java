package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_schubfach_DoubleToDecimal_toDecimal_double_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testToDecimal_NormalValue() {
        testToDecimal(1.5, 768);
    }

    @Test(timeout = 4000)
    public void testToDecimal_SubnormalValue() {
        testToDecimal(0.0000000000000001, 0);
    }

    @Test(timeout = 4000)
    public void testToDecimal_PositiveInfinity() {
        testToDecimal(Double.POSITIVE_INFINITY, Integer.MAX_VALUE);
    }

    @Test(timeout = 4000)
    public void testToDecimal_NegativeInfinity() {
        testToDecimal(Double.NEGATIVE_INFINITY, Integer.MIN_VALUE);
    }

    @Test(timeout = 4000)
    public void testToDecimal_NaN() {
        testToDecimal(Double.NaN, -1);
    }

    private void testToDecimal(double input, int expected) {
        try {
            // Use reflection to access the private constructor
            Constructor<DoubleToDecimal> constructor = DoubleToDecimal.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            DoubleToDecimal doubleToDecimal = constructor.newInstance();

            Method method = DoubleToDecimal.class.getDeclaredMethod("toDecimal", double.class);
            method.setAccessible(true);
            int actual = (int) method.invoke(doubleToDecimal, input);
            assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}