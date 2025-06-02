package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;

public class NumberOutput_toString_10_0_Test {

    @Test
    public void testToString_WithFastWriter() {
        // Test with positive float
        assertEquals("1.0", NumberOutput.toString(1.0f, true));
        // Test with negative float
        assertEquals("-1.0", NumberOutput.toString(-1.0f, true));
        // Test with zero
        assertEquals("0.0", NumberOutput.toString(0.0f, true));
        // Test with a large float
        assertEquals("12345678.0", NumberOutput.toString(12345678.0f, true));
        // Test with a small float
        assertEquals("0.000001", NumberOutput.toString(0.000001f, true));
    }

    @Test
    public void testToString_WithoutFastWriter() {
        // Test with positive float
        assertEquals("1.0", NumberOutput.toString(1.0f, false));
        // Test with negative float
        assertEquals("-1.0", NumberOutput.toString(-1.0f, false));
        // Test with zero
        assertEquals("0.0", NumberOutput.toString(0.0f, false));
        // Test with a large float
        assertEquals("12345678.0", NumberOutput.toString(12345678.0f, false));
        // Test with a small float
        assertEquals("0.000001", NumberOutput.toString(0.000001f, false));
    }

    @Test
    public void testToString_WithSpecialValues() {
        // Test with NaN
        assertEquals("NaN", NumberOutput.toString(Float.NaN, true));
        assertEquals("NaN", NumberOutput.toString(Float.NaN, false));
        // Test with positive infinity
        assertEquals("Infinity", NumberOutput.toString(Float.POSITIVE_INFINITY, true));
        assertEquals("Infinity", NumberOutput.toString(Float.POSITIVE_INFINITY, false));
        // Test with negative infinity
        assertEquals("-Infinity", NumberOutput.toString(Float.NEGATIVE_INFINITY, true));
        assertEquals("-Infinity", NumberOutput.toString(Float.NEGATIVE_INFINITY, false));
    }
}
