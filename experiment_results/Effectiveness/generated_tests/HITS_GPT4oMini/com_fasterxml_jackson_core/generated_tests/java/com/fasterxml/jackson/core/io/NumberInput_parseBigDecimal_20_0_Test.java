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

public class NumberInput_parseBigDecimal_20_0_Test {

    @Test
    public void testParseBigDecimal_ValidString_FastParser() {
        String input = "123.456";
        boolean useFastParser = true;
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        assertEquals(new BigDecimal("123.456"), result);
    }

    @Test
    public void testParseBigDecimal_ValidString_RegularParser() {
        String input = "987.654";
        boolean useFastParser = false;
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        assertEquals(new BigDecimal("987.654"), result);
    }

    @Test
    public void testParseBigDecimal_NegativeNumber_FastParser() {
        String input = "-123.456";
        boolean useFastParser = true;
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        assertEquals(new BigDecimal("-123.456"), result);
    }

    @Test
    public void testParseBigDecimal_NegativeNumber_RegularParser() {
        String input = "-987.654";
        boolean useFastParser = false;
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        assertEquals(new BigDecimal("-987.654"), result);
    }

    @Test
    public void testParseBigDecimal_Zero_FastParser() {
        String input = "0";
        boolean useFastParser = true;
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void testParseBigDecimal_Zero_RegularParser() {
        String input = "0";
        boolean useFastParser = false;
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void testParseBigDecimal_InvalidString_FastParser() {
        String input = "invalid";
        boolean useFastParser = true;
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, useFastParser);
        });
    }

    @Test
    public void testParseBigDecimal_InvalidString_RegularParser() {
        String input = "invalid";
        boolean useFastParser = false;
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, useFastParser);
        });
    }

    @Test
    public void testParseBigDecimal_ScientificNotation_FastParser() {
        String input = "1.23e10";
        boolean useFastParser = true;
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        assertEquals(new BigDecimal("1.23E10"), result);
    }

    @Test
    public void testParseBigDecimal_ScientificNotation_RegularParser() {
        String input = "1.23e10";
        boolean useFastParser = false;
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        assertEquals(new BigDecimal("1.23E10"), result);
    }
}
