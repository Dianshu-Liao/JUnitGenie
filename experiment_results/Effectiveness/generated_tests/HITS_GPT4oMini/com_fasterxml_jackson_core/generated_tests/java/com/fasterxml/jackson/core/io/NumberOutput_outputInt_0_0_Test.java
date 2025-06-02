package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;

public class NumberOutput_outputInt_0_0_Test {

    @Test
    public void testOutputInt_PositiveSingleDigit() {
        char[] buffer = new char[10];
        int result = NumberOutput.outputInt(5, buffer, 0);
        assertEquals(1, result);
        assertEquals("5", new String(buffer, 0, result));
    }

    @Test
    public void testOutputInt_PositiveDoubleDigit() {
        char[] buffer = new char[10];
        int result = NumberOutput.outputInt(42, buffer, 0);
        assertEquals(2, result);
        assertEquals("42", new String(buffer, 0, result));
    }

    @Test
    public void testOutputInt_PositiveTripleDigit() {
        char[] buffer = new char[10];
        int result = NumberOutput.outputInt(123, buffer, 0);
        assertEquals(3, result);
        assertEquals("123", new String(buffer, 0, result));
    }

    @Test
    public void testOutputInt_PositiveThousands() {
        char[] buffer = new char[10];
        int result = NumberOutput.outputInt(1000, buffer, 0);
        assertEquals(4, result);
        assertEquals("1000", new String(buffer, 0, result));
    }

    @Test
    public void testOutputInt_PositiveMillions() {
        char[] buffer = new char[15];
        int result = NumberOutput.outputInt(1000000, buffer, 0);
        assertEquals(7, result);
        assertEquals("1000000", new String(buffer, 0, result));
    }

    @Test
    public void testOutputInt_NegativeSingleDigit() {
        char[] buffer = new char[10];
        int result = NumberOutput.outputInt(-3, buffer, 0);
        assertEquals(2, result);
        assertEquals("-3", new String(buffer, 0, result));
    }

    @Test
    public void testOutputInt_NegativeDoubleDigit() {
        char[] buffer = new char[10];
        int result = NumberOutput.outputInt(-25, buffer, 0);
        assertEquals(3, result);
        assertEquals("-25", new String(buffer, 0, result));
    }

    @Test
    public void testOutputInt_NegativeTripleDigit() {
        char[] buffer = new char[10];
        int result = NumberOutput.outputInt(-456, buffer, 0);
        assertEquals(4, result);
        assertEquals("-456", new String(buffer, 0, result));
    }

    @Test
    public void testOutputInt_NegativeThousands() {
        char[] buffer = new char[10];
        int result = NumberOutput.outputInt(-7890, buffer, 0);
        assertEquals(5, result);
        assertEquals("-7890", new String(buffer, 0, result));
    }

    @Test
    public void testOutputInt_NegativeSmallestInteger() {
        char[] buffer = new char[15];
        int result = NumberOutput.outputInt(Integer.MIN_VALUE, buffer, 0);
        assertEquals(11, result);
        assertEquals("-2147483648", new String(buffer, 0, result));
    }

    @Test
    public void testOutputInt_PositiveBillion() {
        char[] buffer = new char[15];
        int result = NumberOutput.outputInt(1000000000, buffer, 0);
        assertEquals(10, result);
        assertEquals("1000000000", new String(buffer, 0, result));
    }

    @Test
    public void testOutputInt_PositiveAboveBillion() {
        char[] buffer = new char[15];
        int result = NumberOutput.outputInt(2147483647, buffer, 0);
        assertEquals(10, result);
        assertEquals("2147483647", new String(buffer, 0, result));
    }
}
