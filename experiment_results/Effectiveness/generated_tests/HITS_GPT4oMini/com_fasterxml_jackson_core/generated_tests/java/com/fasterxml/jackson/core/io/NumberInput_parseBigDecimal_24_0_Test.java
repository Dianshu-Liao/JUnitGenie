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

public class NumberInput_parseBigDecimal_24_0_Test {

    @Test
    public void testParseBigDecimal_ValidInput_UseFastParser() {
        char[] input = "123.456".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, true);
        Assertions.assertEquals(new BigDecimal("123.456"), result);
    }

    @Test
    public void testParseBigDecimal_ValidInput_NotUsingFastParser() {
        char[] input = "789.012".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, false);
        Assertions.assertEquals(new BigDecimal("789.012"), result);
    }

    @Test
    public void testParseBigDecimal_ScientificNotation_UseFastParser() {
        char[] input = "1.23e4".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, true);
        Assertions.assertEquals(new BigDecimal("12300"), result);
    }

    @Test
    public void testParseBigDecimal_ScientificNotation_NotUsingFastParser() {
        char[] input = "5.67E-2".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, false);
        Assertions.assertEquals(new BigDecimal("0.0567"), result);
    }

    @Test
    public void testParseBigDecimal_InvalidInput_ThrowsNumberFormatException_UseFastParser() {
        char[] input = "abc".toCharArray();
        Assertions.assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, true);
        });
    }

    @Test
    public void testParseBigDecimal_InvalidInput_ThrowsNumberFormatException_NotUsingFastParser() {
        char[] input = "xyz".toCharArray();
        Assertions.assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, false);
        });
    }

    @Test
    public void testParseBigDecimal_EmptyInput_ThrowsNumberFormatException_UseFastParser() {
        char[] input = "".toCharArray();
        Assertions.assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, true);
        });
    }

    @Test
    public void testParseBigDecimal_EmptyInput_ThrowsNumberFormatException_NotUsingFastParser() {
        char[] input = "".toCharArray();
        Assertions.assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, false);
        });
    }

    @Test
    public void testParseBigDecimal_LeadingSpaces_ValidInput_UseFastParser() {
        char[] input = "   456.789".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, true);
        Assertions.assertEquals(new BigDecimal("456.789"), result);
    }

    @Test
    public void testParseBigDecimal_LeadingSpaces_ValidInput_NotUsingFastParser() {
        char[] input = "   321.654".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, false);
        Assertions.assertEquals(new BigDecimal("321.654"), result);
    }

    @Test
    public void testParseBigDecimal_TrailingSpaces_ValidInput_UseFastParser() {
        char[] input = "123.456   ".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, true);
        Assertions.assertEquals(new BigDecimal("123.456"), result);
    }

    @Test
    public void testParseBigDecimal_TrailingSpaces_ValidInput_NotUsingFastParser() {
        char[] input = "789.012   ".toCharArray();
        BigDecimal result = NumberInput.parseBigDecimal(input, false);
        Assertions.assertEquals(new BigDecimal("789.012"), result);
    }
}
