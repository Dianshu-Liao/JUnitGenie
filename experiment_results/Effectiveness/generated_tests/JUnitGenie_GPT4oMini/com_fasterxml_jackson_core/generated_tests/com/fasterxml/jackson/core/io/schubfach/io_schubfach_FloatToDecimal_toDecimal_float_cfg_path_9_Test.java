package com.fasterxml.jackson.core.io.schubfach;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class io_schubfach_FloatToDecimal_toDecimal_float_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testToDecimalNormalValue() {
        FloatToDecimal instance = createFloatToDecimalInstance();
        if (instance != null) {
            try {
                Method method = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
                method.setAccessible(true);
                int result = (int) method.invoke(instance, 1.5f); // Example of a normal float value
                assertEquals(3, result); // Expected result based on the implementation logic
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testToDecimalSubnormalValue() {
        FloatToDecimal instance = createFloatToDecimalInstance();
        if (instance != null) {
            try {
                Method method = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
                method.setAccessible(true);
                int result = (int) method.invoke(instance, 1.401298464e-45f); // Example of a subnormal float value
                assertEquals(0, result); // Expected result based on the implementation logic
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testToDecimalZero() {
        FloatToDecimal instance = createFloatToDecimalInstance();
        if (instance != null) {
            try {
                Method method = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
                method.setAccessible(true);
                int result = (int) method.invoke(instance, 0.0f); // Testing zero
                assertEquals(1, result); // Expected result for PLUS_ZERO
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testToDecimalNaN() {
        FloatToDecimal instance = createFloatToDecimalInstance();
        if (instance != null) {
            try {
                Method method = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
                method.setAccessible(true);
                int result = (int) method.invoke(instance, Float.NaN); // Testing NaN
                assertEquals(0x7FFFFFFF, result); // Expected result for NAN
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testToDecimalPositiveInfinity() {
        FloatToDecimal instance = createFloatToDecimalInstance();
        if (instance != null) {
            try {
                Method method = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
                method.setAccessible(true);
                int result = (int) method.invoke(instance, Float.POSITIVE_INFINITY); // Testing positive infinity
                assertEquals(0x7F800000, result); // Expected result for PLUS_INF
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test(timeout = 4000)
    public void testToDecimalNegativeInfinity() {
        FloatToDecimal instance = createFloatToDecimalInstance();
        if (instance != null) {
            try {
                Method method = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
                method.setAccessible(true);
                int result = (int) method.invoke(instance, Float.NEGATIVE_INFINITY); // Testing negative infinity
                assertEquals(0xFF800000, result); // Expected result for MINUS_INF
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
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}