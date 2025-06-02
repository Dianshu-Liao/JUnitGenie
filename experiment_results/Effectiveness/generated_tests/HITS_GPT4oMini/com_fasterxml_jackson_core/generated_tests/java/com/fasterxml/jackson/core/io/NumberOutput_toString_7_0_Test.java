package com.fasterxml.jackson.core.io;

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
    public void testToString_PositiveInteger() {
        double input = 123.0;
        String expected = "123.0";
        String actual = NumberOutput.toString(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testToString_NegativeInteger() {
        double input = -123.0;
        String expected = "-123.0";
        String actual = NumberOutput.toString(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testToString_Zero() {
        double input = 0.0;
        String expected = "0.0";
        String actual = NumberOutput.toString(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testToString_PositiveDecimal() {
        double input = 123.456;
        String expected = "123.456";
        String actual = NumberOutput.toString(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testToString_NegativeDecimal() {
        double input = -123.456;
        String expected = "-123.456";
        String actual = NumberOutput.toString(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testToString_LargeNumber() {
        // 10 billion
        double input = 1e10;
        String expected = "10000000000.0";
        String actual = NumberOutput.toString(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testToString_SmallNumber() {
        // 0.0000000001
        double input = 1e-10;
        String expected = "1.0E-10";
        String actual = NumberOutput.toString(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testToString_Infinity() {
        double input = Double.POSITIVE_INFINITY;
        String expected = "Infinity";
        String actual = NumberOutput.toString(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testToString_NegativeInfinity() {
        double input = Double.NEGATIVE_INFINITY;
        String expected = "-Infinity";
        String actual = NumberOutput.toString(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testToString_NaN() {
        double input = Double.NaN;
        String expected = "NaN";
        String actual = NumberOutput.toString(input);
        assertEquals(expected, actual);
    }
}
