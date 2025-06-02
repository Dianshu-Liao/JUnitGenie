package com.fasterxml.jackson.core.io.schubfach;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog10pow2;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog10threeQuartersPow2;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.flog2pow10;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.g1;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.multiplyHigh;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.pow10;
import static java.lang.Float.floatToRawIntBits;
import static java.lang.Integer.numberOfLeadingZeros;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

final public class FloatToDecimal_toDecimal_2_1_Test {

    @Test
    public void testToDecimal() throws Exception {
        FloatToDecimal instance = (FloatToDecimal) FloatToDecimal.class.getDeclaredConstructor().newInstance();
        Method method = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
        method.setAccessible(true);
        // Test cases for special values
        // PLUS_ZERO
        assertEquals(0, method.invoke(instance, 0.0f));
        // MINUS_ZERO
        assertEquals(1, method.invoke(instance, -0.0f));
        // PLUS_INF
        assertEquals(3, method.invoke(instance, Float.POSITIVE_INFINITY));
        // MINUS_INF
        assertEquals(4, method.invoke(instance, Float.NEGATIVE_INFINITY));
        // NAN
        assertEquals(5, method.invoke(instance, Float.NaN));
        // Test cases for normal values
        // Normal case
        assertEquals(1, method.invoke(instance, 1.0f));
        // Normal case
        assertEquals(1, method.invoke(instance, 2.0f));
        // Normal case
        assertEquals(1, method.invoke(instance, 3.5f));
        // Normal case
        assertEquals(1, method.invoke(instance, 15.5f));
        // Normal case
        assertEquals(1, method.invoke(instance, 1234567.0f));
        // Test cases for subnormal values
        // Subnormal case
        assertEquals(1, method.invoke(instance, 1.4E-45f));
        // Subnormal case
        assertEquals(1, method.invoke(instance, 1.0E-45f));
        // Fixed line: floating point number too small
        // <Fixed Line>: floating point number too small
        // Changed from 1.0E-46f to 1.0E-45f
        assertEquals(1, method.invoke(instance, 1.0E-45f));
        // Higher subnormal case
        assertEquals(1, method.invoke(instance, 1.0E-38f));
        // Additional edge cases
        // Edge of subnormal case
        assertEquals(1, method.invoke(instance, 1.0E-39f));
        // Normal case
        assertEquals(1, method.invoke(instance, 0.5f));
        // Normal case
        assertEquals(1, method.invoke(instance, 1.5f));
    }
}
