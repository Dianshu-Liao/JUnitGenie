package com.fasterxml.jackson.core.io;

import java.math.BigDecimal;
import java.lang.reflect.Method;
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
    public void testParseBigDecimal_ValidInput() {
        String input = "123.456";
        BigDecimal expected = new BigDecimal("123.456");
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(expected, result);
    }

    @Test
    public void testParseBigDecimal_ValidInputWithExponent() {
        String input = "1.23e2";
        BigDecimal expected = new BigDecimal("123.00");
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(expected, result);
    }

    @Test
    public void testParseBigDecimal_NegativeInput() {
        String input = "-123.456";
        BigDecimal expected = new BigDecimal("-123.456");
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(expected, result);
    }

    @Test
    public void testParseBigDecimal_ZeroInput() {
        String input = "0";
        BigDecimal expected = new BigDecimal("0");
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(expected, result);
    }

    @Test
    public void testParseBigDecimal_EmptyInput() {
        String input = "";
        assertThrows(NumberFormatException.class, () -> invokeParseBigDecimal(input));
    }

    @Test
    public void testParseBigDecimal_InvalidInput() {
        String input = "abc";
        assertThrows(NumberFormatException.class, () -> invokeParseBigDecimal(input));
    }

    private BigDecimal invokeParseBigDecimal(String input) {
        try {
            Method method = NumberInput.class.getDeclaredMethod("parseBigDecimal", String.class);
            method.setAccessible(true);
            return (BigDecimal) method.invoke(null, input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
