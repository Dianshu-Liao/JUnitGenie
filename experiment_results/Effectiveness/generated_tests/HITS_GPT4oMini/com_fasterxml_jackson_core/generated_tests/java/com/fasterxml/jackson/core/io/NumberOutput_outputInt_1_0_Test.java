package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;

public class NumberOutput_outputInt_1_0_Test {

    @Test
    public void testOutputInt_NegativeMinimumValue() {
        byte[] buffer = new byte[20];
        int result = NumberOutput.outputInt(Integer.MIN_VALUE, buffer, 0);
        byte[] expected = String.valueOf(Integer.MIN_VALUE).getBytes();
        assertArrayEquals(expected, buffer);
        assertEquals(expected.length, result);
    }

    @Test
    public void testOutputInt_NegativeValue() {
        byte[] buffer = new byte[20];
        int result = NumberOutput.outputInt(-123, buffer, 0);
        byte[] expected = "-123".getBytes();
        assertArrayEquals(expected, buffer);
        assertEquals(expected.length, result);
    }

    @Test
    public void testOutputInt_SingleDigit() {
        byte[] buffer = new byte[20];
        int result = NumberOutput.outputInt(5, buffer, 0);
        byte[] expected = "5".getBytes();
        assertArrayEquals(expected, buffer);
        assertEquals(expected.length, result);
    }

    @Test
    public void testOutputInt_TwoDigits() {
        byte[] buffer = new byte[20];
        int result = NumberOutput.outputInt(42, buffer, 0);
        byte[] expected = "42".getBytes();
        assertArrayEquals(expected, buffer);
        assertEquals(expected.length, result);
    }

    @Test
    public void testOutputInt_ThreeDigits() {
        byte[] buffer = new byte[20];
        int result = NumberOutput.outputInt(999, buffer, 0);
        byte[] expected = "999".getBytes();
        assertArrayEquals(expected, buffer);
        assertEquals(expected.length, result);
    }

    @Test
    public void testOutputInt_Thousand() {
        byte[] buffer = new byte[20];
        int result = NumberOutput.outputInt(1000, buffer, 0);
        byte[] expected = "1000".getBytes();
        assertArrayEquals(expected, buffer);
        assertEquals(expected.length, result);
    }

    @Test
    public void testOutputInt_Million() {
        byte[] buffer = new byte[20];
        int result = NumberOutput.outputInt(1000000, buffer, 0);
        byte[] expected = "1000000".getBytes();
        assertArrayEquals(expected, buffer);
        assertEquals(expected.length, result);
    }

    @Test
    public void testOutputInt_Billion() {
        byte[] buffer = new byte[20];
        int result = NumberOutput.outputInt(1000000000, buffer, 0);
        byte[] expected = "1000000000".getBytes();
        assertArrayEquals(expected, buffer);
        assertEquals(expected.length, result);
    }

    @Test
    public void testOutputInt_AboveBillion() {
        byte[] buffer = new byte[20];
        int result = NumberOutput.outputInt(2000000000, buffer, 0);
        byte[] expected = "2000000000".getBytes();
        assertArrayEquals(expected, buffer);
        assertEquals(expected.length, result);
    }

    @Test
    public void testOutputInt_NegativeAboveThousand() {
        byte[] buffer = new byte[20];
        int result = NumberOutput.outputInt(-1001, buffer, 0);
        byte[] expected = "-1001".getBytes();
        assertArrayEquals(expected, buffer);
        assertEquals(expected.length, result);
    }

    @Test
    public void testOutputInt_NegativeMillion() {
        byte[] buffer = new byte[20];
        int result = NumberOutput.outputInt(-1000000, buffer, 0);
        byte[] expected = "-1000000".getBytes();
        assertArrayEquals(expected, buffer);
        assertEquals(expected.length, result);
    }

    @Test
    public void testOutputInt_NegativeBillion() {
        byte[] buffer = new byte[20];
        int result = NumberOutput.outputInt(-1000000000, buffer, 0);
        byte[] expected = "-1000000000".getBytes();
        assertArrayEquals(expected, buffer);
        assertEquals(expected.length, result);
    }
}
