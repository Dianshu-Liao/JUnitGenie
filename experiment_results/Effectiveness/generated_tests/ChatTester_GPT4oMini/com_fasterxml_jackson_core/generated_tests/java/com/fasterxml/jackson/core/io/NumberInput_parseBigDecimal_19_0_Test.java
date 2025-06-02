package com.fasterxml.jackson.core.io;

import java.lang.reflect.Method;
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
    public void testParseBigDecimal_ValidInput() throws Exception {
        String input = "123.45";
        BigDecimal expected = new BigDecimal("123.45");
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(expected, result);
    }

    @Test
    public void testParseBigDecimal_ValidInputWithExponent() throws Exception {
        String input = "1.23e2";
        BigDecimal expected = new BigDecimal("123");
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(expected, result);
    }

    @Test
    public void testParseBigDecimal_NegativeInput() throws Exception {
        String input = "-123.45";
        BigDecimal expected = new BigDecimal("-123.45");
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(expected, result);
    }

    @Test
    public void testParseBigDecimal_ZeroInput() throws Exception {
        String input = "0";
        BigDecimal expected = new BigDecimal("0");
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(expected, result);
    }

    @Test
    public void testParseBigDecimal_InvalidInput() {
        String input = "invalid";
        assertThrows(NumberFormatException.class, () -> invokeParseBigDecimal(input));
    }

    @Test
    public void testParseBigDecimal_EmptyInput() {
        String input = "";
        assertThrows(NumberFormatException.class, () -> invokeParseBigDecimal(input));
    }

    @Test
    public void testParseBigDecimal_LeadingWhitespace() throws Exception {
        String input = "   123.45";
        BigDecimal expected = new BigDecimal("123.45");
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(expected, result);
    }

    @Test
    public void testParseBigDecimal_TrailingWhitespace() throws Exception {
        String input = "123.45   ";
        BigDecimal expected = new BigDecimal("123.45");
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(expected, result);
    }

    @Test
    public void testParseBigDecimal_SpecialCharacters() {
        String input = "@123.45";
        assertThrows(NumberFormatException.class, () -> invokeParseBigDecimal(input));
    }

    private BigDecimal invokeParseBigDecimal(String s) throws Exception {
        Method method = NumberInput.class.getDeclaredMethod("parseBigDecimal", String.class);
        method.setAccessible(true);
        return (BigDecimal) method.invoke(null, s);
    }
}
