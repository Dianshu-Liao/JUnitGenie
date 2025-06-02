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

public class NumberInput_parseBigDecimal_21_0_Test {

    @Test
    public void testParseBigDecimal_ValidInput() throws Exception {
        char[] input = "123.456".toCharArray();
        BigDecimal result = invokeParseBigDecimal(input, 0, input.length);
        assertEquals(new BigDecimal("123.456"), result);
    }

    @Test
    public void testParseBigDecimal_ValidInputWithExponent() throws Exception {
        char[] input = "1.23e2".toCharArray();
        BigDecimal result = invokeParseBigDecimal(input, 0, input.length);
        assertEquals(new BigDecimal("123"), result);
    }

    @Test
    public void testParseBigDecimal_EmptyInput() throws Exception {
        char[] input = "".toCharArray();
        assertThrows(NumberFormatException.class, () -> invokeParseBigDecimal(input, 0, 0));
    }

    @Test
    public void testParseBigDecimal_InvalidInput() throws Exception {
        char[] input = "abc".toCharArray();
        assertThrows(NumberFormatException.class, () -> invokeParseBigDecimal(input, 0, input.length));
    }

    @Test
    public void testParseBigDecimal_NegativeInput() throws Exception {
        char[] input = "-123.456".toCharArray();
        BigDecimal result = invokeParseBigDecimal(input, 0, input.length);
        assertEquals(new BigDecimal("-123.456"), result);
    }

    @Test
    public void testParseBigDecimal_LargeInput() throws Exception {
        char[] input = "123456789012345678901234567890.12345678901234567890".toCharArray();
        BigDecimal result = invokeParseBigDecimal(input, 0, input.length);
        assertEquals(new BigDecimal("123456789012345678901234567890.12345678901234567890"), result);
    }

    private BigDecimal invokeParseBigDecimal(char[] ch, int off, int len) throws Exception {
        Method method = NumberInput.class.getDeclaredMethod("parseBigDecimal", char[].class, int.class, int.class);
        method.setAccessible(true);
        return (BigDecimal) method.invoke(null, ch, off, len);
    }
}
