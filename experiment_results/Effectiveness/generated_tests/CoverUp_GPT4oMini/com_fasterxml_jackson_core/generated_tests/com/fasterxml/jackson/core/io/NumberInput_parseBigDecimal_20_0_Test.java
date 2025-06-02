package com.fasterxml.jackson.core.io;

import org.junit.jupiter.api.function.Executable;
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

public class NumberInput_parseBigDecimal_20_0_Test {

    @Test
    public void testParseBigDecimalWithFastParser_ValidInput() {
        String input = "123.45";
        boolean useFastParser = true;
        BigDecimal expected = new BigDecimal("123.45");
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        assertEquals(expected, result);
    }

    @Test
    public void testParseBigDecimalWithoutFastParser_ValidInput() {
        String input = "678.90";
        boolean useFastParser = false;
        BigDecimal expected = new BigDecimal("678.90");
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        assertEquals(expected, result);
    }

    @Test
    public void testParseBigDecimalWithFastParser_InvalidInput() {
        String input = "invalid_number";
        boolean useFastParser = true;
        Executable executable = () -> NumberInput.parseBigDecimal(input, useFastParser);
        assertThrows(NumberFormatException.class, executable);
    }

    @Test
    public void testParseBigDecimalWithoutFastParser_InvalidInput() {
        String input = "invalid_number";
        boolean useFastParser = false;
        Executable executable = () -> NumberInput.parseBigDecimal(input, useFastParser);
        assertThrows(NumberFormatException.class, executable);
    }

    @Test
    public void testParseBigDecimalWithFastParser_EmptyString() {
        String input = "";
        boolean useFastParser = true;
        Executable executable = () -> NumberInput.parseBigDecimal(input, useFastParser);
        assertThrows(NumberFormatException.class, executable);
    }

    @Test
    public void testParseBigDecimalWithoutFastParser_EmptyString() {
        String input = "";
        boolean useFastParser = false;
        Executable executable = () -> NumberInput.parseBigDecimal(input, useFastParser);
        assertThrows(NumberFormatException.class, executable);
    }

    @Test
    public void testParseBigDecimalWithFastParser_NegativeNumber() {
        String input = "-123.45";
        boolean useFastParser = true;
        BigDecimal expected = new BigDecimal("-123.45");
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        assertEquals(expected, result);
    }

    @Test
    public void testParseBigDecimalWithoutFastParser_NegativeNumber() {
        String input = "-678.90";
        boolean useFastParser = false;
        BigDecimal expected = new BigDecimal("-678.90");
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        assertEquals(expected, result);
    }

    @Test
    public void testParseBigDecimalWithFastParser_ScientificNotation() {
        String input = "1.23e2";
        boolean useFastParser = true;
        BigDecimal expected = new BigDecimal("123.00");
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        assertEquals(expected, result);
    }

    @Test
    public void testParseBigDecimalWithoutFastParser_ScientificNotation() {
        String input = "4.56e-2";
        boolean useFastParser = false;
        BigDecimal expected = new BigDecimal("0.0456");
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        assertEquals(expected, result);
    }
}
