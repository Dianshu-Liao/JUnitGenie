package com.fasterxml.jackson.core.io.schubfach;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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

public class DoubleToDecimal_exponent_13_0_Test {

    @Test
    public void testExponent() throws Exception {
        // Access the private constructor using reflection
        Constructor<DoubleToDecimal> constructor = DoubleToDecimal.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        DoubleToDecimal doubleToDecimal = constructor.newInstance();
        // Test cases for the exponent method
        // Case 1: e = 0
        invokeExponent(doubleToDecimal, 0);
        assertEquals("E0", getOutput(doubleToDecimal));
        // Case 2: e = 5
        invokeExponent(doubleToDecimal, 5);
        assertEquals("E5", getOutput(doubleToDecimal));
        // Case 3: e = -3
        invokeExponent(doubleToDecimal, -3);
        assertEquals("E-3", getOutput(doubleToDecimal));
        // Case 4: e = 123
        invokeExponent(doubleToDecimal, 123);
        assertEquals("E1E2", getOutput(doubleToDecimal));
        // Case 5: e = -123
        invokeExponent(doubleToDecimal, -123);
        assertEquals("E-1E2", getOutput(doubleToDecimal));
    }

    private void invokeExponent(DoubleToDecimal doubleToDecimal, int e) throws Exception {
        // Access the private exponent method using reflection
        Method method = DoubleToDecimal.class.getDeclaredMethod("exponent", int.class);
        method.setAccessible(true);
        method.invoke(doubleToDecimal, e);
    }

    private String getOutput(DoubleToDecimal doubleToDecimal) throws Exception {
        // Access the private bytes array and index using reflection
        Field bytesField = DoubleToDecimal.class.getDeclaredField("bytes");
        bytesField.setAccessible(true);
        byte[] bytes = (byte[]) bytesField.get(doubleToDecimal);
        Field indexField = DoubleToDecimal.class.getDeclaredField("index");
        indexField.setAccessible(true);
        int index = (int) indexField.get(doubleToDecimal);
        return new String(bytes, 1, index);
    }
}
