package com.fasterxml.jackson.core.io.schubfach;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class io_schubfach_FloatToDecimal_toDecimal_float_cfg_path_29_Test {

    @Test(timeout = 4000)
    public void testToDecimalNormalValue() {
        testToDecimal(3.14f, 314);
    }

    @Test(timeout = 4000)
    public void testToDecimalSubnormalValue() {
        testToDecimal(1.4E-45f, 0);
    }

    @Test(timeout = 4000)
    public void testToDecimalZero() {
        testToDecimal(0.0f, 0);
    }

    @Test(timeout = 4000)
    public void testToDecimalNaN() {
        testToDecimal(Float.NaN, -1);
    }

    @Test(timeout = 4000)
    public void testToDecimalInfinity() {
        testToDecimal(Float.POSITIVE_INFINITY, Integer.MAX_VALUE);
    }

    private void testToDecimal(float input, int expected) {
        try {
            // Assuming FloatToDecimal has a public static method toDecimal
            Method toDecimalMethod = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
            toDecimalMethod.setAccessible(true);

            // Invoke the static method directly
            Integer actual = (Integer) toDecimalMethod.invoke(null, input);
            assertEquals(expected, actual.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}