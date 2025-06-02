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

public class NumberInput_parseBigDecimal_19_0_Test {

    @Test
    public void testParseBigDecimal_ValidInteger() {
        BigDecimal result = NumberInput.parseBigDecimal((String) "12345");
        assertEquals(new BigDecimal("12345"), result);
    }

    @Test
    public void testParseBigDecimal_ValidDecimal() {
        BigDecimal result = NumberInput.parseBigDecimal((String) "123.45");
        assertEquals(new BigDecimal("123.45"), result);
    }

    @Test
    public void testParseBigDecimal_ValidScientificNotation() {
        BigDecimal result = NumberInput.parseBigDecimal((String) "1.23e2");
        assertEquals(new BigDecimal("123.0"), result);
    }

    @Test
    public void testParseBigDecimal_NegativeDecimal() {
        BigDecimal result = NumberInput.parseBigDecimal((String) "-123.45");
        assertEquals(new BigDecimal("-123.45"), result);
    }

    @Test
    public void testParseBigDecimal_LeadingZeros() {
        BigDecimal result = NumberInput.parseBigDecimal((String) "000123.45");
        assertEquals(new BigDecimal("123.45"), result);
    }

    @Test
    public void testParseBigDecimal_TrailingDot() {
        BigDecimal result = NumberInput.parseBigDecimal((String) "123.");
        assertEquals(new BigDecimal("123.0"), result);
    }

    @Test
    public void testParseBigDecimal_InvalidInput_ThrowsNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal((String) "abc");
        });
    }

    @Test
    public void testParseBigDecimal_EmptyString_ThrowsNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal((String) "");
        });
    }

    @Test
    public void testParseBigDecimal_WhitespaceInput_ThrowsNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal((String) "   ");
        });
    }

    @Test
    public void testParseBigDecimal_NullInput_ThrowsNumberFormatException() {
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal((String) null);
        });
    }
}
