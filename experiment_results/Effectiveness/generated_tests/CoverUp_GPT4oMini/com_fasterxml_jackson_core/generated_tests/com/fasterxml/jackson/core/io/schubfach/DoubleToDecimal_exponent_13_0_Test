package com.fasterxml.jackson.core.io.schubfach;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
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

public class DoubleToDecimal_exponent_13_0_Test {

    private DoubleToDecimal doubleToDecimal;

    @BeforeEach
    public void setUp() throws Exception {
        // Use reflection to access the private constructor
        Constructor<DoubleToDecimal> constructor = DoubleToDecimal.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        doubleToDecimal = constructor.newInstance();
    }

    @Test
    public void testExponent_NegativeSingleDigit() throws Exception {
        invokeExponentMethod(-5);
        assertArrayEquals(new byte[] { 'E', '-', '5' }, getBytes());
    }

    @Test
    public void testExponent_SingleDigit() throws Exception {
        invokeExponentMethod(3);
        assertArrayEquals(new byte[] { 'E', '3' }, getBytes());
    }

    @Test
    public void testExponent_TwoDigits() throws Exception {
        invokeExponentMethod(12);
        assertArrayEquals(new byte[] { 'E', '1', '2' }, getBytes());
    }

    @Test
    public void testExponent_ThreeDigits() throws Exception {
        invokeExponentMethod(123);
        assertArrayEquals(new byte[] { 'E', '1', '2', '3' }, getBytes());
    }

    @Test
    public void testExponent_ThreeDigitsWithNegative() throws Exception {
        invokeExponentMethod(-123);
        assertArrayEquals(new byte[] { 'E', '-', '1', '2', '3' }, getBytes());
    }

    private void invokeExponentMethod(int e) throws Exception {
        Method exponentMethod = DoubleToDecimal.class.getDeclaredMethod("exponent", int.class);
        exponentMethod.setAccessible(true);
        exponentMethod.invoke(doubleToDecimal, e);
    }

    private byte[] getBytes() throws Exception {
        Field bytesField = DoubleToDecimal.class.getDeclaredField("bytes");
        bytesField.setAccessible(true);
        return (byte[]) bytesField.get(doubleToDecimal);
    }
}
