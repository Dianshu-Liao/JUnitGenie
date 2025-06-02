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
    public void testToStringPositiveFloat() {
        float input = 3.14f;
        String expected = "3.14";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result, "The toString method should convert the positive float to string correctly.");
    }

    @Test
    public void testToStringNegativeFloat() {
        float input = -2.71f;
        String expected = "-2.71";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result, "The toString method should convert the negative float to string correctly.");
    }

    @Test
    public void testToStringZero() {
        float input = 0.0f;
        String expected = "0.0";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result, "The toString method should convert zero float to string correctly.");
    }

    @Test
    public void testToStringLargeFloat() {
        // Large float value
        float input = 1.2345678E10f;
        String expected = "1.2345678E10";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result, "The toString method should convert large float to string correctly.");
    }

    @Test
    public void testToStringSmallFloat() {
        // Small float value
        float input = 1.0E-10f;
        String expected = "1.0E-10";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result, "The toString method should convert small float to string correctly.");
    }

    @Test
    public void testToStringNaN() {
        float input = Float.NaN;
        String expected = "NaN";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result, "The toString method should convert NaN to string correctly.");
    }

    @Test
    public void testToStringInfinity() {
        float input = Float.POSITIVE_INFINITY;
        String expected = "Infinity";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result, "The toString method should convert positive infinity to string correctly.");
    }

    @Test
    public void testToStringNegativeInfinity() {
        float input = Float.NEGATIVE_INFINITY;
        String expected = "-Infinity";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result, "The toString method should convert negative infinity to string correctly.");
    }
}
