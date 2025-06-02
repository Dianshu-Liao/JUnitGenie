package com.fasterxml.jackson.core.io.schubfach;

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
    public void setUp() {
        // Fixed the constructor access issue by using reflection
        try {
            doubleToDecimal = DoubleToDecimal.class.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            fail("Failed to create DoubleToDecimal instance: " + e.getMessage());
        }
    }

    @Test
    public void testExponent_NegativeSingleDigit() throws Exception {
        invokeExponent(-5);
        assertBytesEqual(new byte[] { 'E', '-', '5' });
    }

    @Test
    public void testExponent_SingleDigit() throws Exception {
        invokeExponent(3);
        assertBytesEqual(new byte[] { 'E', '3' });
    }

    @Test
    public void testExponent_TwoDigits() throws Exception {
        invokeExponent(23);
        assertBytesEqual(new byte[] { 'E', '2', '3' });
    }

    @Test
    public void testExponent_ThreeDigits() throws Exception {
        invokeExponent(123);
        assertBytesEqual(new byte[] { 'E', '1', '2', '3' });
    }

    @Test
    public void testExponent_ThreeDigitsGreaterThanHundred() throws Exception {
        invokeExponent(311);
        assertBytesEqual(new byte[] { 'E', '3', '1', '1' });
    }

    private void invokeExponent(int e) throws Exception {
        Method method = DoubleToDecimal.class.getDeclaredMethod("exponent", int.class);
        method.setAccessible(true);
        method.invoke(doubleToDecimal, e);
    }

    private void assertBytesEqual(byte[] expected) throws Exception {
        Field bytesField = DoubleToDecimal.class.getDeclaredField("bytes");
        bytesField.setAccessible(true);
        byte[] actual = (byte[]) bytesField.get(doubleToDecimal);
        assertArrayEquals(expected, actual);
    }
}
