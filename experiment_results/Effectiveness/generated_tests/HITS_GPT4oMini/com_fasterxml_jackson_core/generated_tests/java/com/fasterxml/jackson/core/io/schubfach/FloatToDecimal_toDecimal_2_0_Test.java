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
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.g1;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.multiplyHigh;
import static com.fasterxml.jackson.core.io.schubfach.MathUtils.pow10;
import static java.lang.Float.floatToRawIntBits;
import static java.lang.Integer.numberOfLeadingZeros;

public class FloatToDecimal_toDecimal_2_0_Test {

    private FloatToDecimal floatToDecimal;

    private Method toDecimalMethod;

    @BeforeEach
    public void setUp() throws Exception {
        floatToDecimal = FloatToDecimal.class.getDeclaredConstructor().newInstance();
        toDecimalMethod = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
        toDecimalMethod.setAccessible(true);
    }

    @Test
    public void testToDecimal_NormalValue() throws Exception {
        float input = 5.75f;
        int expected = (int) toDecimalMethod.invoke(floatToDecimal, input);
        assertEquals(expected, (int) toDecimalMethod.invoke(floatToDecimal, input));
    }

    @Test
    public void testToDecimal_SubnormalValue() throws Exception {
        float input = 1.4E-45f;
        int expected = (int) toDecimalMethod.invoke(floatToDecimal, input);
        assertEquals(expected, (int) toDecimalMethod.invoke(floatToDecimal, input));
    }

    @Test
    public void testToDecimal_PositiveZero() throws Exception {
        float input = 0.0f;
        int expected = 1;
        assertEquals(expected, (int) toDecimalMethod.invoke(floatToDecimal, input));
    }

    @Test
    public void testToDecimal_NegativeZero() throws Exception {
        float input = -0.0f;
        int expected = 2;
        assertEquals(expected, (int) toDecimalMethod.invoke(floatToDecimal, input));
    }

    @Test
    public void testToDecimal_PositiveInfinity() throws Exception {
        float input = Float.POSITIVE_INFINITY;
        int expected = 3;
        assertEquals(expected, (int) toDecimalMethod.invoke(floatToDecimal, input));
    }

    @Test
    public void testToDecimal_NegativeInfinity() throws Exception {
        float input = Float.NEGATIVE_INFINITY;
        int expected = 4;
        assertEquals(expected, (int) toDecimalMethod.invoke(floatToDecimal, input));
    }

    @Test
    public void testToDecimal_NaN() throws Exception {
        float input = Float.NaN;
        int expected = 5;
        assertEquals(expected, (int) toDecimalMethod.invoke(floatToDecimal, input));
    }

    @Test
    public void testToDecimal_ExactPowersOfTwo() throws Exception {
        float input = 16.0f;
        int expected = (int) toDecimalMethod.invoke(floatToDecimal, input);
        assertEquals(expected, (int) toDecimalMethod.invoke(floatToDecimal, input));
    }

    @Test
    public void testToDecimal_LargeNumber() throws Exception {
        float input = 1e10f;
        int expected = (int) toDecimalMethod.invoke(floatToDecimal, input);
        assertEquals(expected, (int) toDecimalMethod.invoke(floatToDecimal, input));
    }
}
