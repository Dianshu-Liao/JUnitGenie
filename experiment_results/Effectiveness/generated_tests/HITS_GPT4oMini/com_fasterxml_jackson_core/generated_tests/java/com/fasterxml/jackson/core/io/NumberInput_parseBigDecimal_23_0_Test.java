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

public class NumberInput_parseBigDecimal_23_0_Test {

    @Test
    public void testParseBigDecimal_ValidPositiveInteger() {
        char[] input = "12345".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input);
        Assertions.assertEquals(new BigDecimal("12345"), result);
    }

    @Test
    public void testParseBigDecimal_ValidNegativeInteger() {
        char[] input = "-12345".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input);
        Assertions.assertEquals(new BigDecimal("-12345"), result);
    }

    @Test
    public void testParseBigDecimal_ValidPositiveDecimal() {
        char[] input = "123.45".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input);
        Assertions.assertEquals(new BigDecimal("123.45"), result);
    }

    @Test
    public void testParseBigDecimal_ValidNegativeDecimal() {
        char[] input = "-123.45".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input);
        Assertions.assertEquals(new BigDecimal("-123.45"), result);
    }

    @Test
    public void testParseBigDecimal_ValidScientificNotation() {
        char[] input = "1.23e10".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input);
        Assertions.assertEquals(new BigDecimal("1.23E10"), result);
    }

    @Test
    public void testParseBigDecimal_ValidNegativeScientificNotation() {
        char[] input = "-1.23e10".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input);
        Assertions.assertEquals(new BigDecimal("-1.23E10"), result);
    }

    @Test
    public void testParseBigDecimal_ValidZero() {
        char[] input = "0".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input);
        Assertions.assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void testParseBigDecimal_InvalidInput() {
        char[] input = "abc".toCharArray();
        Assertions.assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input);
        });
    }

    @Test
    public void testParseBigDecimal_EmptyInput() {
        char[] input = "".toCharArray();
        Assertions.assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input);
        });
    }

    @Test
    public void testParseBigDecimal_WhitespaceInput() {
        char[] input = "   ".toCharArray();
        Assertions.assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input);
        });
    }
}
