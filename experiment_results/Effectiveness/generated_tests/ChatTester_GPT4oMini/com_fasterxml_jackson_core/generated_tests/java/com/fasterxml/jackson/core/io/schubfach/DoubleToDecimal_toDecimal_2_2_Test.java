package com.fasterxml.jackson.core.io.schubfach;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog10pow2;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog10threeQuartersPow2;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog2pow10;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.g0;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.g1;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.multiplyHigh;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.pow10;
import static java.lang.Double.doubleToRawLongBits;
import static java.lang.Long.numberOfLeadingZeros;

final public class DoubleToDecimal_toDecimal_2_2_Test {

    @Test
    public void testToDecimalNormalValue() throws Exception {
        DoubleToDecimal instance = (DoubleToDecimal) DoubleToDecimal.class.getDeclaredConstructor().newInstance();
        Method method = DoubleToDecimal.class.getDeclaredMethod("toDecimal", double.class);
        method.setAccessible(true);
        int result = (int) method.invoke(instance, 1.5);
        // Assuming the expected return value for 1.5
        assertEquals(0, result);
    }

    @Test
    public void testToDecimalSubnormalValue() throws Exception {
        DoubleToDecimal instance = (DoubleToDecimal) DoubleToDecimal.class.getDeclaredConstructor().newInstance();
        Method method = DoubleToDecimal.class.getDeclaredMethod("toDecimal", double.class);
        method.setAccessible(true);
        int result = (int) method.invoke(instance, 1.0e-300);
        // Assuming the expected return value for subnormal value
        assertEquals(0, result);
    }

    @Test
    public void testToDecimalZero() throws Exception {
        DoubleToDecimal instance = (DoubleToDecimal) DoubleToDecimal.class.getDeclaredConstructor().newInstance();
        Method method = DoubleToDecimal.class.getDeclaredMethod("toDecimal", double.class);
        method.setAccessible(true);
        int result = (int) method.invoke(instance, 0.0);
        // PLUS_ZERO
        assertEquals(1, result);
    }

    @Test
    public void testToDecimalNegativeZero() throws Exception {
        DoubleToDecimal instance = (DoubleToDecimal) DoubleToDecimal.class.getDeclaredConstructor().newInstance();
        Method method = DoubleToDecimal.class.getDeclaredMethod("toDecimal", double.class);
        method.setAccessible(true);
        int result = (int) method.invoke(instance, -0.0);
        // MINUS_ZERO
        assertEquals(2, result);
    }

    @Test
    public void testToDecimalInfinity() throws Exception {
        DoubleToDecimal instance = (DoubleToDecimal) DoubleToDecimal.class.getDeclaredConstructor().newInstance();
        Method method = DoubleToDecimal.class.getDeclaredMethod("toDecimal", double.class);
        method.setAccessible(true);
        int result = (int) method.invoke(instance, Double.POSITIVE_INFINITY);
        // PLUS_INF
        assertEquals(3, result);
    }

    @Test
    public void testToDecimalNegativeInfinity() throws Exception {
        DoubleToDecimal instance = (DoubleToDecimal) DoubleToDecimal.class.getDeclaredConstructor().newInstance();
        Method method = DoubleToDecimal.class.getDeclaredMethod("toDecimal", double.class);
        method.setAccessible(true);
        int result = (int) method.invoke(instance, Double.NEGATIVE_INFINITY);
        // MINUS_INF
        assertEquals(4, result);
    }

    @Test
    public void testToDecimalNaN() throws Exception {
        DoubleToDecimal instance = (DoubleToDecimal) DoubleToDecimal.class.getDeclaredConstructor().newInstance();
        Method method = DoubleToDecimal.class.getDeclaredMethod("toDecimal", double.class);
        method.setAccessible(true);
        int result = (int) method.invoke(instance, Double.NaN);
        // NAN
        assertEquals(5, result);
    }

    @Test
    public void testToDecimalLargeNormalValue() throws Exception {
        DoubleToDecimal instance = (DoubleToDecimal) DoubleToDecimal.class.getDeclaredConstructor().newInstance();
        Method method = DoubleToDecimal.class.getDeclaredMethod("toDecimal", double.class);
        method.setAccessible(true);
        int result = (int) method.invoke(instance, 1.0e10);
        // Assuming the expected return value for large normal value
        assertEquals(0, result);
    }

    @Test
    public void testToDecimalSmallNormalValue() throws Exception {
        DoubleToDecimal instance = (DoubleToDecimal) DoubleToDecimal.class.getDeclaredConstructor().newInstance();
        Method method = DoubleToDecimal.class.getDeclaredMethod("toDecimal", double.class);
        method.setAccessible(true);
        int result = (int) method.invoke(instance, 2.5e-10);
        // Assuming the expected return value for small normal value
        assertEquals(0, result);
    }
}
