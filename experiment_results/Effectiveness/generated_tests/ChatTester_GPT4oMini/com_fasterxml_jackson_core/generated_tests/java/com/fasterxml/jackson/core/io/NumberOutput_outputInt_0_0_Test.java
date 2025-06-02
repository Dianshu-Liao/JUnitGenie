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
    public void testOutputInt_NegativeMinValue() throws Exception {
        char[] buffer = new char[20];
        int offset = NumberOutput.outputInt(Integer.MIN_VALUE, buffer, 0);
        assertArrayEquals("-2147483648".toCharArray(), java.util.Arrays.copyOf(buffer, offset));
    }

    @Test
    public void testOutputInt_NegativeSmallValue() throws Exception {
        char[] buffer = new char[20];
        int offset = NumberOutput.outputInt(-5, buffer, 0);
        assertArrayEquals("-5".toCharArray(), java.util.Arrays.copyOf(buffer, offset));
    }

    @Test
    public void testOutputInt_SmallValue() throws Exception {
        char[] buffer = new char[20];
        int offset = NumberOutput.outputInt(10, buffer, 0);
        assertArrayEquals("10".toCharArray(), java.util.Arrays.copyOf(buffer, offset));
    }

    @Test
    public void testOutputInt_ThreeDigitValue() throws Exception {
        char[] buffer = new char[20];
        int offset = NumberOutput.outputInt(123, buffer, 0);
        assertArrayEquals("123".toCharArray(), java.util.Arrays.copyOf(buffer, offset));
    }

    @Test
    public void testOutputInt_ThousandValue() throws Exception {
        char[] buffer = new char[20];
        int offset = NumberOutput.outputInt(1000, buffer, 0);
        assertArrayEquals("1000".toCharArray(), java.util.Arrays.copyOf(buffer, offset));
    }

    @Test
    public void testOutputInt_MillionValue() throws Exception {
        char[] buffer = new char[20];
        int offset = NumberOutput.outputInt(1000000, buffer, 0);
        assertArrayEquals("1000000".toCharArray(), java.util.Arrays.copyOf(buffer, offset));
    }

    @Test
    public void testOutputInt_BillionValue() throws Exception {
        char[] buffer = new char[20];
        int offset = NumberOutput.outputInt(1000000000, buffer, 0);
        assertArrayEquals("1000000000".toCharArray(), java.util.Arrays.copyOf(buffer, offset));
    }

    @Test
    public void testOutputInt_TwoBillionValue() throws Exception {
        char[] buffer = new char[20];
        int offset = NumberOutput.outputInt(2000000000, buffer, 0);
        assertArrayEquals("2000000000".toCharArray(), java.util.Arrays.copyOf(buffer, offset));
    }

    @Test
    public void testOutputInt_LargeNegativeValue() throws Exception {
        char[] buffer = new char[20];
        int offset = NumberOutput.outputInt(-123456789, buffer, 0);
        assertArrayEquals("-123456789".toCharArray(), java.util.Arrays.copyOf(buffer, offset));
    }

    @Test
    public void testOutputInt_ZeroValue() throws Exception {
        char[] buffer = new char[20];
        int offset = NumberOutput.outputInt(0, buffer, 0);
        assertArrayEquals("0".toCharArray(), java.util.Arrays.copyOf(buffer, offset));
    }

    @Test
    public void testOutputInt_NegativeThousandValue() throws Exception {
        char[] buffer = new char[20];
        int offset = NumberOutput.outputInt(-1000, buffer, 0);
        assertArrayEquals("-1000".toCharArray(), java.util.Arrays.copyOf(buffer, offset));
    }

    @Test
    public void testOutputInt_NegativeLargeValue() throws Exception {
        char[] buffer = new char[20];
        int offset = NumberOutput.outputInt(-987654321, buffer, 0);
        assertArrayEquals("-987654321".toCharArray(), java.util.Arrays.copyOf(buffer, offset));
    }

    @Test
    public void testOutputInt_BillionMinusOne() throws Exception {
        char[] buffer = new char[20];
        int offset = NumberOutput.outputInt(999999999, buffer, 0);
        assertArrayEquals("999999999".toCharArray(), java.util.Arrays.copyOf(buffer, offset));
    }
}
