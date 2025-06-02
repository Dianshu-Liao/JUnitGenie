package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.io.NumberOutput;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;

public class NumberOutput_toString_7_0_Test {

    @Test
    public void testToStringWithPositiveDouble() throws Exception {
        double value = 12345.6789;
        // Expected output from Double.toString
        String expected = "12345.6789";
        String result = invokeToString(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithNegativeDouble() throws Exception {
        double value = -12345.6789;
        // Expected output from Double.toString
        String expected = "-12345.6789";
        String result = invokeToString(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithZero() throws Exception {
        double value = 0.0;
        // Expected output from Double.toString
        String expected = "0.0";
        String result = invokeToString(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithMaxDouble() throws Exception {
        double value = Double.MAX_VALUE;
        // Expected output from Double.toString
        String expected = String.valueOf(Double.MAX_VALUE);
        String result = invokeToString(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithMinDouble() throws Exception {
        double value = Double.MIN_VALUE;
        // Expected output from Double.toString
        String expected = String.valueOf(Double.MIN_VALUE);
        String result = invokeToString(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithNaN() throws Exception {
        double value = Double.NaN;
        // Expected output from Double.toString
        String expected = "NaN";
        String result = invokeToString(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithInfinity() throws Exception {
        double value = Double.POSITIVE_INFINITY;
        // Expected output from Double.toString
        String expected = "Infinity";
        String result = invokeToString(value);
        assertEquals(expected, result);
    }

    @Test
    public void testToStringWithNegativeInfinity() throws Exception {
        double value = Double.NEGATIVE_INFINITY;
        // Expected output from Double.toString
        String expected = "-Infinity";
        String result = invokeToString(value);
        assertEquals(expected, result);
    }

    private String invokeToString(double value) throws Exception {
        Method method = NumberOutput.class.getDeclaredMethod("toString", double.class);
        method.setAccessible(true);
        return (String) method.invoke(null, value);
    }
}
