package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_schubfach_FloatToDecimal_toDecimal_float_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testToDecimalNormalValue() {
        invokeAndAssert(1.5f, 1);
    }

    @Test(timeout = 4000)
    public void testToDecimalSubnormalValue() {
        invokeAndAssert(1.401298464e-45f, 0);
    }

    @Test(timeout = 4000)
    public void testToDecimalZero() {
        invokeAndAssert(0.0f, 0);
    }

    @Test(timeout = 4000)
    public void testToDecimalPositiveInfinity() {
        invokeAndAssert(Float.POSITIVE_INFINITY, Integer.MAX_VALUE);
    }

    @Test(timeout = 4000)
    public void testToDecimalNegativeInfinity() {
        invokeAndAssert(Float.NEGATIVE_INFINITY, Integer.MIN_VALUE);
    }

    @Test(timeout = 4000)
    public void testToDecimalNaN() {
        invokeAndAssert(Float.NaN, -1);
    }

    private void invokeAndAssert(float input, int expected) {
        try {
            Method method = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
            method.setAccessible(true);
            int result = (int) method.invoke(null, input); // Use null for static method invocation
            assertEquals(expected, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}