package com.fasterxml.jackson.core.io;

import java.math.BigDecimal;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.regex.Pattern;
import ch.randelshofer.fastdoubleparser.JavaDoubleParser;
import ch.randelshofer.fastdoubleparser.JavaFloatParser;

public class NumberInput_parseBigDecimal_21_0_Test {

    @Test
    public void testParseBigDecimal_ValidInput() {
        char[] input = "123.45".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, 0, input.length);
        assertEquals(new BigDecimal("123.45"), result);
    }

    @Test
    public void testParseBigDecimal_ValidInputWithExponent() {
        char[] input = "1.23e10".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, 0, input.length);
        assertEquals(new BigDecimal("1.23E10"), result);
    }

    @Test
    public void testParseBigDecimal_NegativeInput() {
        char[] input = "-123.45".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, 0, input.length);
        assertEquals(new BigDecimal("-123.45"), result);
    }

    @Test
    public void testParseBigDecimal_LeadingZeros() {
        char[] input = "0000123.45".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, 0, input.length);
        assertEquals(new BigDecimal("123.45"), result);
    }

    @Test
    public void testParseBigDecimal_TrailingDot() {
        char[] input = "123.".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, 0, input.length);
        assertEquals(new BigDecimal("123.0"), result);
    }

    @Test
    public void testParseBigDecimal_InvalidInput_Empty() {
        char[] input = "".toCharArray();
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, 0, input.length);
        });
    }

    @Test
    public void testParseBigDecimal_InvalidInput_NonNumeric() {
        char[] input = "abc".toCharArray();
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, 0, input.length);
        });
    }

    @Test
    public void testParseBigDecimal_InvalidInput_NegativeExponent() {
        char[] input = "1.23e-".toCharArray();
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, 0, input.length);
        });
    }

    @Test
    public void testParseBigDecimal_ValidInput_LargeNumber() {
        char[] input = "12345678901234567890".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, 0, input.length);
        assertEquals(new BigDecimal("12345678901234567890"), result);
    }

    @Test
    public void testParseBigDecimal_ValidInput_SmallNumber() {
        char[] input = "0.0000000001".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, 0, input.length);
        assertEquals(new BigDecimal("0.0000000001"), result);
    }
}
