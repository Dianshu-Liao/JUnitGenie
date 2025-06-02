package com.fasterxml.jackson.core.io.schubfach;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

    @BeforeEach
    public void setUp() throws Exception {
        // Use reflection to access the private constructor
        Constructor<FloatToDecimal> constructor = FloatToDecimal.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        floatToDecimal = constructor.newInstance();
    }

    @Test
    public void testToDecimal_Zero() throws Exception {
        assertEquals(1, invokeToDecimal(0.0f));
        assertEquals(2, invokeToDecimal(-0.0f));
    }

    @Test
    public void testToDecimal_Infinity() throws Exception {
        assertEquals(3, invokeToDecimal(Float.POSITIVE_INFINITY));
        assertEquals(4, invokeToDecimal(Float.NEGATIVE_INFINITY));
    }

    @Test
    public void testToDecimal_NaN() throws Exception {
        assertEquals(5, invokeToDecimal(Float.NaN));
    }

    @Test
    public void testToDecimal_NormalValues() throws Exception {
        assertEquals(1, invokeToDecimal(1.0f));
        assertEquals(1, invokeToDecimal(-1.0f));
        assertEquals(1, invokeToDecimal(2.0f));
        assertEquals(1, invokeToDecimal(-2.0f));
    }

    @Test
    public void testToDecimal_SubnormalValues() throws Exception {
        assertEquals(1, invokeToDecimal(Float.MIN_VALUE));
        assertEquals(2, invokeToDecimal(-Float.MIN_VALUE));
    }

    private int invokeToDecimal(float value) throws Exception {
        Method method = FloatToDecimal.class.getDeclaredMethod("toDecimal", float.class);
        method.setAccessible(true);
        return (int) method.invoke(floatToDecimal, value);
    }
}
