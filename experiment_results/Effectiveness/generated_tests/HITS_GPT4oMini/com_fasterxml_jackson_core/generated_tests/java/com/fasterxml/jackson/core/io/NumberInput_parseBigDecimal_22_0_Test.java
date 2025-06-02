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

public class NumberInput_parseBigDecimal_22_0_Test {

    @Test
    public void testParseBigDecimal_ValidInput_WithFastParser() {
        char[] input = "123.456".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, 0, input.length, true);
        assertEquals(new BigDecimal("123.456"), result);
    }

    @Test
    public void testParseBigDecimal_ValidInput_WithoutFastParser() {
        char[] input = "789.012".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, 0, input.length, false);
        assertEquals(new BigDecimal("789.012"), result);
    }

    @Test
    public void testParseBigDecimal_NegativeNumber_WithFastParser() {
        char[] input = "-345.678".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, 0, input.length, true);
        assertEquals(new BigDecimal("-345.678"), result);
    }

    @Test
    public void testParseBigDecimal_NegativeNumber_WithoutFastParser() {
        char[] input = "-987.654".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, 0, input.length, false);
        assertEquals(new BigDecimal("-987.654"), result);
    }

    @Test
    public void testParseBigDecimal_ScientificNotation_WithFastParser() {
        char[] input = "1.23e4".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, 0, input.length, true);
        assertEquals(new BigDecimal("12300"), result);
    }

    @Test
    public void testParseBigDecimal_ScientificNotation_WithoutFastParser() {
        char[] input = "5.67E-2".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, 0, input.length, false);
        assertEquals(new BigDecimal("0.0567"), result);
    }

    @Test
    public void testParseBigDecimal_InvalidInput_ThrowsNumberFormatException_WithFastParser() {
        char[] input = "abc".toCharArray();
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, 0, input.length, true);
        });
    }

    @Test
    public void testParseBigDecimal_InvalidInput_ThrowsNumberFormatException_WithoutFastParser() {
        char[] input = "xyz".toCharArray();
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, 0, input.length, false);
        });
    }

    @Test
    public void testParseBigDecimal_EmptyInput_ThrowsNumberFormatException_WithFastParser() {
        char[] input = "".toCharArray();
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, 0, input.length, true);
        });
    }

    @Test
    public void testParseBigDecimal_EmptyInput_ThrowsNumberFormatException_WithoutFastParser() {
        char[] input = "".toCharArray();
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, 0, input.length, false);
        });
    }

    @Test
    public void testParseBigDecimal_LeadingSpaces_WithFastParser() {
        char[] input = "   123.45".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, 3, 5, true);
        assertEquals(new BigDecimal("123.45"), result);
    }

    @Test
    public void testParseBigDecimal_LeadingSpaces_WithoutFastParser() {
        char[] input = "   678.90".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, 3, 5, false);
        assertEquals(new BigDecimal("678.90"), result);
    }
}
