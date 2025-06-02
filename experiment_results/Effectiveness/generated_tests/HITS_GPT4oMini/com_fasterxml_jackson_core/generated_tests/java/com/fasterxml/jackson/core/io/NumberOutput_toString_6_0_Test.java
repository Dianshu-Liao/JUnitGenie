package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;

public class NumberOutput_toString_6_0_Test {

    @Test
    public void testToString_withSmallPositiveInteger() {
        long input = 5L;
        String expected = "5";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToString_withSmallNegativeInteger() {
        long input = -3L;
        String expected = "-3";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToString_withZero() {
        long input = 0L;
        String expected = "0";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToString_withPositiveIntegerWithinRange() {
        long input = 10L;
        String expected = "10";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToString_withNegativeIntegerWithinRange() {
        long input = -10L;
        String expected = "-10";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToString_withMaxIntegerValue() {
        // 2147483647
        long input = Integer.MAX_VALUE;
        String expected = "2147483647";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToString_withMinIntegerValue() {
        // -2147483648
        long input = Integer.MIN_VALUE;
        String expected = "-2147483648";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToString_withGreaterThanMaxIntegerValue() {
        // 2147483648
        long input = Integer.MAX_VALUE + 1L;
        String expected = "2147483648";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToString_withLessThanMinIntegerValue() {
        // -2147483649
        long input = Integer.MIN_VALUE - 1L;
        String expected = "-2147483649";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToString_withLargePositiveLong() {
        // A large long value
        long input = 10000000000L;
        String expected = "10000000000";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result);
    }

    @Test
    public void testToString_withLargeNegativeLong() {
        // A large negative long value
        long input = -10000000000L;
        String expected = "-10000000000";
        String result = NumberOutput.toString(input);
        assertEquals(expected, result);
    }
}
