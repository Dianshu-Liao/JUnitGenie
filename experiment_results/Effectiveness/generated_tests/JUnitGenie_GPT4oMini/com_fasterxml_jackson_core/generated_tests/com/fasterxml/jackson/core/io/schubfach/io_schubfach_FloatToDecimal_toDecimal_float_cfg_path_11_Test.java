package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_schubfach_FloatToDecimal_toDecimal_float_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testToDecimalNormalValue() {
        FloatToDecimal instance = createFloatToDecimalInstance();
        float input = 1.5f; // Example of a normal float value
        if (instance != null) {
            try {
                Method method = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
                method.setAccessible(true);
                int result = (int) method.invoke(instance, input);
                assertEquals(3, result); // Expected output for 1.5f
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testToDecimalSubnormalValue() {
        FloatToDecimal instance = createFloatToDecimalInstance();
        float input = 1.401298E-45f; // Example of a subnormal float value
        if (instance != null) {
            try {
                Method method = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
                method.setAccessible(true);
                int result = (int) method.invoke(instance, input);
                assertEquals(0, result); // Expected output for subnormal value
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testToDecimalZero() {
        FloatToDecimal instance = createFloatToDecimalInstance();
        float input = 0.0f; // Example of zero
        if (instance != null) {
            try {
                Method method = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
                method.setAccessible(true);
                int result = (int) method.invoke(instance, input);
                assertEquals(1, result); // Expected output for PLUS_ZERO
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testToDecimalNaN() {
        FloatToDecimal instance = createFloatToDecimalInstance();
        float input = Float.NaN; // Example of NaN
        if (instance != null) {
            try {
                Method method = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
                method.setAccessible(true);
                int result = (int) method.invoke(instance, input);
                assertEquals(0x7FFFFFFF, result); // Expected output for NAN
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testToDecimalPositiveInfinity() {
        FloatToDecimal instance = createFloatToDecimalInstance();
        float input = Float.POSITIVE_INFINITY; // Example of positive infinity
        if (instance != null) {
            try {
                Method method = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
                method.setAccessible(true);
                int result = (int) method.invoke(instance, input);
                assertEquals(0x7F800000, result); // Expected output for PLUS_INF
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testToDecimalNegativeInfinity() {
        FloatToDecimal instance = createFloatToDecimalInstance();
        float input = Float.NEGATIVE_INFINITY; // Example of negative infinity
        if (instance != null) {
            try {
                Method method = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
                method.setAccessible(true);
                int result = (int) method.invoke(instance, input);
                assertEquals(0xFF800000, result); // Expected output for MINUS_INF
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private FloatToDecimal createFloatToDecimalInstance() {
        try {
            // Use reflection to access the private constructor
            Method method = FloatToDecimal.class.getDeclaredMethod("createInstance");
            method.setAccessible(true);
            return (FloatToDecimal) method.invoke(null);
        } catch (NoSuchMethodException e) {
            System.err.println("No such method: createInstance");
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}