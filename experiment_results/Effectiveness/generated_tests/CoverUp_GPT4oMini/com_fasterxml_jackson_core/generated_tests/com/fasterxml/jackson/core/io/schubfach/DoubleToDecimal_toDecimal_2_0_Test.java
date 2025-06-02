package com.fasterxml.jackson.core.io.schubfach;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DoubleToDecimal_toDecimal_2_0_Test {

    private DoubleToDecimal doubleToDecimal;

    @BeforeEach
    public void setUp() throws Exception {
        Constructor<DoubleToDecimal> constructor = DoubleToDecimal.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        doubleToDecimal = constructor.newInstance();
    }

    @Test
    public void testToDecimalPlusZero() throws Exception {
        assertEquals(1, invokeToDecimal(0.0));
    }

    @Test
    public void testToDecimalMinusZero() throws Exception {
        assertEquals(2, invokeToDecimal(-0.0));
    }

    @Test
    public void testToDecimalPlusInfinity() throws Exception {
        assertEquals(3, invokeToDecimal(Double.POSITIVE_INFINITY));
    }

    @Test
    public void testToDecimalMinusInfinity() throws Exception {
        assertEquals(4, invokeToDecimal(Double.NEGATIVE_INFINITY));
    }

    @Test
    public void testToDecimalNaN() throws Exception {
        assertEquals(5, invokeToDecimal(Double.NaN));
    }

    @Test
    public void testToDecimalNormalValue() throws Exception {
        assertEquals(1, invokeToDecimal(1.0));
        assertEquals(1, invokeToDecimal(2.0));
        assertEquals(1, invokeToDecimal(3.0));
    }

    @Test
    public void testToDecimalSubnormalValue() throws Exception {
        assertEquals(1, invokeToDecimal(1.0e-300));
        assertEquals(1, invokeToDecimal(1.0e-200));
    }

    private int invokeToDecimal(double value) throws Exception {
        Method method = DoubleToDecimal.class.getDeclaredMethod("toDecimal", double.class);
        method.setAccessible(true);
        return (int) method.invoke(doubleToDecimal, value);
    }
}
