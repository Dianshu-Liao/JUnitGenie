package com.fasterxml.jackson.core.io.schubfach;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
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

public class DoubleToDecimal_lowDigits_9_1_Test {

    private DoubleToDecimal doubleToDecimal;

    @BeforeEach
    public void setUp() throws Exception {
        Constructor<DoubleToDecimal> constructor = DoubleToDecimal.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        doubleToDecimal = constructor.newInstance();
    }

    @Test
    public void testLowDigitsNonZero() throws Exception {
        // Arrange
        int input = 12345678;
        // Act
        invokeLowDigits(input);
        // Assert
        // Check the state of the bytes array after calling lowDigits
        byte[] expectedBytes = "12345678".getBytes();
        assertArrayEquals(expectedBytes, getBytes());
    }

    @Test
    public void testLowDigitsZero() throws Exception {
        // Arrange
        int input = 0;
        // Act
        invokeLowDigits(input);
        // Assert
        // Check the state of the bytes array after calling lowDigits
        byte[] expectedBytes = new byte[] {};
        assertArrayEquals(expectedBytes, getBytes());
    }

    private void invokeLowDigits(int l) throws Exception {
        Method method = DoubleToDecimal.class.getDeclaredMethod("lowDigits", int.class);
        method.setAccessible(true);
        method.invoke(doubleToDecimal, l);
    }

    private byte[] getBytes() throws Exception {
        java.lang.reflect.Field field = DoubleToDecimal.class.getDeclaredField("bytes");
        field.setAccessible(true);
        return (byte[]) field.get(doubleToDecimal);
    }
}
