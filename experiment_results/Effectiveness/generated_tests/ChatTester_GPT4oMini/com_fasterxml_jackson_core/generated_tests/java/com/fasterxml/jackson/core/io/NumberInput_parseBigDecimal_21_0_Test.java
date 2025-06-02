package com.fasterxml.jackson.core.io;

import org.junit.jupiter.api.function.Executable;
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
        int offset = 0;
        int length = input.length;
        BigDecimal result = invokeParseBigDecimal(input, offset, length);
        assertEquals(new BigDecimal("123.456"), result);
    }

    @Test
    public void testParseBigDecimal_ValidInputWithScientificNotation() throws Exception {
        char[] input = "1.23e10".toCharArray();
        int offset = 0;
        int length = input.length;
        BigDecimal result = invokeParseBigDecimal(input, offset, length);
        assertEquals(new BigDecimal("1.23E10"), result);
    }

    @Test
    public void testParseBigDecimal_InvalidInput_ThrowsNumberFormatException() throws Exception {
        char[] input = "abc".toCharArray();
        int offset = 0;
        int length = input.length;
        Executable executable = () -> invokeParseBigDecimal(input, offset, length);
        assertThrows(NumberFormatException.class, executable);
    }

    @Test
    public void testParseBigDecimal_EmptyInput_ThrowsNumberFormatException() throws Exception {
        char[] input = "".toCharArray();
        int offset = 0;
        int length = input.length;
        Executable executable = () -> invokeParseBigDecimal(input, offset, length);
        assertThrows(NumberFormatException.class, executable);
    }

    @Test
    public void testParseBigDecimal_NegativeInput() throws Exception {
        char[] input = "-123.456".toCharArray();
        int offset = 0;
        int length = input.length;
        BigDecimal result = invokeParseBigDecimal(input, offset, length);
        assertEquals(new BigDecimal("-123.456"), result);
    }

    @Test
    public void testParseBigDecimal_TrailingDot() throws Exception {
        char[] input = "123.".toCharArray();
        int offset = 0;
        int length = input.length;
        Executable executable = () -> invokeParseBigDecimal(input, offset, length);
        assertThrows(NumberFormatException.class, executable);
    }

    @Test
    public void testParseBigDecimal_LeadingPlus() throws Exception {
        char[] input = "+123.456".toCharArray();
        int offset = 0;
        int length = input.length;
        BigDecimal result = invokeParseBigDecimal(input, offset, length);
        assertEquals(new BigDecimal("123.456"), result);
    }

    private BigDecimal invokeParseBigDecimal(char[] ch, int off, int len) throws Exception {
        Method method = NumberInput.class.getDeclaredMethod("parseBigDecimal", char[].class, int.class, int.class);
        method.setAccessible(true);
        return (BigDecimal) method.invoke(null, ch, off, len);
    }
}
