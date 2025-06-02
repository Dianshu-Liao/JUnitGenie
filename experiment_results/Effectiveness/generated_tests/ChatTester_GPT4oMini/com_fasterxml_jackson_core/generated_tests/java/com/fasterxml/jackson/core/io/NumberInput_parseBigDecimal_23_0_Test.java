// Test method
package com.fasterxml.jackson.core.io;

import java.math.BigDecimal;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.regex.Pattern;
import ch.randelshofer.fastdoubleparser.JavaDoubleParser;
import ch.randelshofer.fastdoubleparser.JavaFloatParser;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NumberInput_parseBigDecimal_23_0_Test {

    @Test
    public void testParseBigDecimal_ValidInput() {
        char[] input = "123.45".toCharArray();
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(new BigDecimal("123.45"), result);
    }

    @Test
    public void testParseBigDecimal_ValidInputWithExponent() {
        char[] input = "1.23e2".toCharArray();
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(new BigDecimal("123"), result);
    }

    @Test
    public void testParseBigDecimal_NegativeInput() {
        char[] input = "-123.45".toCharArray();
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(new BigDecimal("-123.45"), result);
    }

    @Test
    public void testParseBigDecimal_EmptyInput() {
        char[] input = "".toCharArray();
        assertThrows(NumberFormatException.class, () -> invokeParseBigDecimal(input));
    }

    @Test
    public void testParseBigDecimal_InvalidInput() {
        char[] input = "abc".toCharArray();
        assertThrows(NumberFormatException.class, () -> invokeParseBigDecimal(input));
    }

    @Test
    public void testParseBigDecimal_LeadingWhitespace() {
        char[] input = "   123.45".toCharArray();
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(new BigDecimal("123.45"), result);
    }

    @Test
    public void testParseBigDecimal_TrailingWhitespace() {
        char[] input = "123.45   ".toCharArray();
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(new BigDecimal("123.45"), result);
    }

    @Test
    public void testParseBigDecimal_TrailingDot() {
        char[] input = "123.".toCharArray();
        assertThrows(NumberFormatException.class, () -> invokeParseBigDecimal(input));
    }

    @Test
    public void testParseBigDecimal_ZeroInput() {
        char[] input = "0".toCharArray();
        BigDecimal result = invokeParseBigDecimal(input);
        assertEquals(BigDecimal.ZERO, result);
    }

    private BigDecimal invokeParseBigDecimal(char[] ch) {
        try {
            // Fixed the buggy line by replacing 'var' with 'java.lang.reflect.Method'
            java.lang.reflect.Method method = NumberInput.class.getDeclaredMethod("parseBigDecimal", char[].class);
            method.setAccessible(true);
            return (BigDecimal) method.invoke(null, (Object) ch);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
