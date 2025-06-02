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

class NumberInput_parseBigDecimal_24_0_Test {

    @Test
    void testParseBigDecimalWithFastParser() {
        char[] input = "123.45".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, true);
        assertEquals(new BigDecimal("123.45"), result);
    }

    @Test
    void testParseBigDecimalWithRegularParser() {
        char[] input = "678.90".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, false);
        assertEquals(new BigDecimal("678.90"), result);
    }

    @Test
    void testParseBigDecimalWithNegativeNumberUsingFastParser() {
        char[] input = "-123.45".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, true);
        assertEquals(new BigDecimal("-123.45"), result);
    }

    @Test
    void testParseBigDecimalWithNegativeNumberUsingRegularParser() {
        char[] input = "-678.90".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, false);
        assertEquals(new BigDecimal("-678.90"), result);
    }

    @Test
    void testParseBigDecimalWithScientificNotationUsingFastParser() {
        char[] input = "1.23e10".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, true);
        assertEquals(new BigDecimal("1.23E10"), result);
    }

    @Test
    void testParseBigDecimalWithScientificNotationUsingRegularParser() {
        char[] input = "4.56E-2".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, false);
        assertEquals(new BigDecimal("0.0456"), result);
    }

    @Test
    void testParseBigDecimalWithInvalidInputUsingFastParser() {
        char[] input = "invalid".toCharArray();
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, true);
        });
    }

    @Test
    void testParseBigDecimalWithInvalidInputUsingRegularParser() {
        char[] input = "invalid".toCharArray();
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, false);
        });
    }

    @Test
    void testParseBigDecimalWithEmptyInputUsingFastParser() {
        char[] input = "".toCharArray();
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, true);
        });
    }

    @Test
    void testParseBigDecimalWithEmptyInputUsingRegularParser() {
        char[] input = "".toCharArray();
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, false);
        });
    }
}
