package com.fasterxml.jackson.core.io;

import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import com.fasterxml.jackson.core.io.schubfach.DoubleToDecimal;
import com.fasterxml.jackson.core.io.schubfach.FloatToDecimal;

@ExtendWith(MockitoExtension.class)
public class NumberOutput_outputInt_0_0_Test {

    @Test
    public void testOutputIntPositiveSingleDigit() throws Exception {
        char[] buffer = new char[10];
        int offset = NumberOutput.outputInt(5, buffer, 0);
        assertEquals(1, offset);
        assertArrayEquals(new char[] { '5' }, new char[] { buffer[0] });
    }

    @Test
    public void testOutputIntPositiveDoubleDigit() throws Exception {
        char[] buffer = new char[10];
        int offset = NumberOutput.outputInt(42, buffer, 0);
        assertEquals(2, offset);
        assertArrayEquals(new char[] { '4', '2' }, new char[] { buffer[0], buffer[1] });
    }

    @Test
    public void testOutputIntPositiveTripleDigit() throws Exception {
        char[] buffer = new char[10];
        int offset = NumberOutput.outputInt(123, buffer, 0);
        assertEquals(3, offset);
        assertArrayEquals(new char[] { '1', '2', '3' }, new char[] { buffer[0], buffer[1], buffer[2] });
    }

    @Test
    public void testOutputIntPositiveThousand() throws Exception {
        char[] buffer = new char[10];
        int offset = NumberOutput.outputInt(1000, buffer, 0);
        assertEquals(4, offset);
        assertArrayEquals(new char[] { '1', '0', '0', '0' }, new char[] { buffer[0], buffer[1], buffer[2], buffer[3] });
    }

    @Test
    public void testOutputIntPositiveMillion() throws Exception {
        char[] buffer = new char[10];
        int offset = NumberOutput.outputInt(1000000, buffer, 0);
        assertEquals(7, offset);
        assertArrayEquals(new char[] { '1', '0', '0', '0', '0', '0', '0' }, new char[] { buffer[0], buffer[1], buffer[2], buffer[3], buffer[4], buffer[5], buffer[6] });
    }

    @Test
    public void testOutputIntPositiveBillion() throws Exception {
        char[] buffer = new char[10];
        int offset = NumberOutput.outputInt(1000000000, buffer, 0);
        assertEquals(10, offset);
        assertArrayEquals(new char[] { '1', '0', '0', '0', '0', '0', '0', '0', '0', '0' }, new char[] { buffer[0], buffer[1], buffer[2], buffer[3], buffer[4], buffer[5], buffer[6], buffer[7], buffer[8], buffer[9] });
    }

    @Test
    public void testOutputIntNegativeSingleDigit() throws Exception {
        char[] buffer = new char[10];
        int offset = NumberOutput.outputInt(-3, buffer, 0);
        assertEquals(2, offset);
        assertArrayEquals(new char[] { '-', '3' }, new char[] { buffer[0], buffer[1] });
    }

    @Test
    public void testOutputIntNegativeDoubleDigit() throws Exception {
        char[] buffer = new char[10];
        int offset = NumberOutput.outputInt(-27, buffer, 0);
        assertEquals(3, offset);
        assertArrayEquals(new char[] { '-', '2', '7' }, new char[] { buffer[0], buffer[1], buffer[2] });
    }

    @Test
    public void testOutputIntNegativeMinValue() throws Exception {
        char[] buffer = new char[10];
        int offset = NumberOutput.outputInt(Integer.MIN_VALUE, buffer, 0);
        assertEquals(NumberOutput.SMALLEST_INT.length(), offset);
        assertArrayEquals(NumberOutput.SMALLEST_INT.toCharArray(), new char[] { buffer[0], buffer[1], buffer[2], buffer[3], buffer[4], buffer[5], buffer[6], buffer[7], buffer[8], buffer[9] });
    }
}
