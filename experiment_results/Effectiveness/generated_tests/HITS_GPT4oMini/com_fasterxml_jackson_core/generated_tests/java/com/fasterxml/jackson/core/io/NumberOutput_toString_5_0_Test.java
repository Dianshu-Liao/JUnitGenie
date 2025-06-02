package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;

public class NumberOutput_toString_5_0_Test {

    @Test
    public void testToString_withSmallPositiveValues() {
        assertEquals("0", NumberOutput.toString(0));
        assertEquals("1", NumberOutput.toString(1));
        assertEquals("2", NumberOutput.toString(2));
        assertEquals("3", NumberOutput.toString(3));
        assertEquals("4", NumberOutput.toString(4));
        assertEquals("5", NumberOutput.toString(5));
        assertEquals("6", NumberOutput.toString(6));
        assertEquals("7", NumberOutput.toString(7));
        assertEquals("8", NumberOutput.toString(8));
        assertEquals("9", NumberOutput.toString(9));
        assertEquals("10", NumberOutput.toString(10));
    }

    @Test
    public void testToString_withSmallNegativeValues() {
        assertEquals("-1", NumberOutput.toString(-1));
        assertEquals("-2", NumberOutput.toString(-2));
        assertEquals("-3", NumberOutput.toString(-3));
        assertEquals("-4", NumberOutput.toString(-4));
        assertEquals("-5", NumberOutput.toString(-5));
        assertEquals("-6", NumberOutput.toString(-6));
        assertEquals("-7", NumberOutput.toString(-7));
        assertEquals("-8", NumberOutput.toString(-8));
        assertEquals("-9", NumberOutput.toString(-9));
        assertEquals("-10", NumberOutput.toString(-10));
    }

    @Test
    public void testToString_withLargePositiveValue() {
        assertEquals("100", NumberOutput.toString(100));
        assertEquals("123456789", NumberOutput.toString(123456789));
        assertEquals("2147483647", NumberOutput.toString(Integer.MAX_VALUE));
    }

    @Test
    public void testToString_withLargeNegativeValue() {
        assertEquals("-100", NumberOutput.toString(-100));
        assertEquals("-123456789", NumberOutput.toString(-123456789));
        assertEquals("-2147483648", NumberOutput.toString(Integer.MIN_VALUE));
    }

    @Test
    public void testToString_withZero() {
        assertEquals("0", NumberOutput.toString(0));
    }
}
