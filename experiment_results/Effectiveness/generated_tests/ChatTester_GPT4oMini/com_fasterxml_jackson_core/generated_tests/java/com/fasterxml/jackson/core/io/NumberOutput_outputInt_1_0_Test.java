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
    public void testOutputInt_NegativeMinValue() throws Exception {
        byte[] buffer = new byte[20];
        int offset = NumberOutput.outputInt(Integer.MIN_VALUE, buffer, 0);
        assertEquals(11, offset);
        assertArrayEquals("-2147483648".getBytes(), buffer);
    }

    @Test
    public void testOutputInt_NegativeValue() throws Exception {
        byte[] buffer = new byte[20];
        int offset = NumberOutput.outputInt(-123, buffer, 0);
        assertEquals(4, offset);
        assertArrayEquals("-123".getBytes(), buffer);
    }

    @Test
    public void testOutputInt_SingleDigit() throws Exception {
        byte[] buffer = new byte[20];
        int offset = NumberOutput.outputInt(5, buffer, 0);
        assertEquals(1, offset);
        assertArrayEquals("5".getBytes(), buffer);
    }

    @Test
    public void testOutputInt_TwoDigits() throws Exception {
        byte[] buffer = new byte[20];
        int offset = NumberOutput.outputInt(42, buffer, 0);
        assertEquals(2, offset);
        assertArrayEquals("42".getBytes(), buffer);
    }

    @Test
    public void testOutputInt_ThreeDigits() throws Exception {
        byte[] buffer = new byte[20];
        int offset = NumberOutput.outputInt(999, buffer, 0);
        assertEquals(3, offset);
        assertArrayEquals("999".getBytes(), buffer);
    }

    @Test
    public void testOutputInt_Thousands() throws Exception {
        byte[] buffer = new byte[20];
        int offset = NumberOutput.outputInt(1000, buffer, 0);
        assertEquals(4, offset);
        assertArrayEquals("1000".getBytes(), buffer);
    }

    @Test
    public void testOutputInt_Billion() throws Exception {
        byte[] buffer = new byte[20];
        int offset = NumberOutput.outputInt(1000000000, buffer, 0);
        assertEquals(10, offset);
        assertArrayEquals("1000000000".getBytes(), buffer);
    }

    @Test
    public void testOutputInt_TwoBillions() throws Exception {
        byte[] buffer = new byte[20];
        int offset = NumberOutput.outputInt(2000000000, buffer, 0);
        assertEquals(11, offset);
        assertArrayEquals("2000000000".getBytes(), buffer);
    }

    @Test
    public void testOutputInt_BetweenMillionAndBillion() throws Exception {
        byte[] buffer = new byte[20];
        int offset = NumberOutput.outputInt(1500000000, buffer, 0);
        assertEquals(10, offset);
        assertArrayEquals("1500000000".getBytes(), buffer);
    }
}
