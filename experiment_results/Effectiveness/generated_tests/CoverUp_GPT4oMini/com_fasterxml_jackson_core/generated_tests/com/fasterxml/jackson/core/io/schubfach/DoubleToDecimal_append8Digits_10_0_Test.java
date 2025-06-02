package com.fasterxml.jackson.core.io.schubfach;

import java.lang.reflect.Field;
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

public class DoubleToDecimal_append8Digits_10_0_Test {

    private DoubleToDecimal doubleToDecimal;

    @BeforeEach
    public void setUp() throws Exception {
        // Use reflection to access the private constructor
        Constructor<DoubleToDecimal> constructor = DoubleToDecimal.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        doubleToDecimal = constructor.newInstance();
    }

    @Test
    public void testAppend8Digits() throws Exception {
        // Test with a variety of inputs
        // Test with zero
        invokeAppend8Digits(0);
        assertArrayEquals(new byte[] { '0', '0', '0', '0', '0', '0', '0', '0' }, getBytes());
        // Test with a positive number
        invokeAppend8Digits(12345678);
        assertArrayEquals(new byte[] { '1', '2', '3', '4', '5', '6', '7', '8' }, getBytes());
        // Test with a different positive number
        invokeAppend8Digits(87654321);
        assertArrayEquals(new byte[] { '8', '7', '6', '5', '4', '3', '2', '1' }, getBytes());
        // Test with max integer value
        invokeAppend8Digits(Integer.MAX_VALUE);
        assertArrayEquals(new byte[] { '9', '9', '9', '9', '9', '9', '9', '9' }, getBytes());
        // Test with min integer value
        invokeAppend8Digits(Integer.MIN_VALUE);
        assertArrayEquals(new byte[] { '0', '0', '0', '0', '0', '0', '0', '0' }, getBytes());
    }

    private void invokeAppend8Digits(int m) throws Exception {
        Method method = DoubleToDecimal.class.getDeclaredMethod("append8Digits", int.class);
        method.setAccessible(true);
        method.invoke(doubleToDecimal, m);
    }

    private byte[] getBytes() throws Exception {
        Field bytesField = DoubleToDecimal.class.getDeclaredField("bytes");
        bytesField.setAccessible(true);
        return (byte[]) bytesField.get(doubleToDecimal);
    }
}
