package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;

public class NumberOutput_toString_9_0_Test {

    @Test
    public void testToStringPositiveInteger() {
        float value = 10.0f;
        String expected = "10.0";
        String actual = NumberOutput.toString(value);
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringNegativeInteger() {
        float value = -10.0f;
        String expected = "-10.0";
        String actual = NumberOutput.toString(value);
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringZero() {
        float value = 0.0f;
        String expected = "0.0";
        String actual = NumberOutput.toString(value);
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringPositiveFloat() {
        float value = 10.5f;
        String expected = "10.5";
        String actual = NumberOutput.toString(value);
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringNegativeFloat() {
        float value = -10.5f;
        String expected = "-10.5";
        String actual = NumberOutput.toString(value);
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringVeryLargeNumber() {
        // Large float
        float value = 1e10f;
        String expected = "10000000000.0";
        String actual = NumberOutput.toString(value);
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringVerySmallNumber() {
        // Small float
        float value = 1e-10f;
        String expected = "1.0E-10";
        String actual = NumberOutput.toString(value);
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringNaN() {
        float value = Float.NaN;
        String expected = "NaN";
        String actual = NumberOutput.toString(value);
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringInfinity() {
        float value = Float.POSITIVE_INFINITY;
        String expected = "Infinity";
        String actual = NumberOutput.toString(value);
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringNegativeInfinity() {
        float value = Float.NEGATIVE_INFINITY;
        String expected = "-Infinity";
        String actual = NumberOutput.toString(value);
        assertEquals(expected, actual);
    }
}
