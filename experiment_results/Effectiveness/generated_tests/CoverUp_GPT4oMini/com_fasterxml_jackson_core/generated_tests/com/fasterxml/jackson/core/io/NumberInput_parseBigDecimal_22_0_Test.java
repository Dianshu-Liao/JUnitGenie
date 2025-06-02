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

public class NumberInput_parseBigDecimal_22_0_Test {

    @Test
    public void testParseBigDecimalWithFastParser() throws Exception {
        char[] input = "123.456".toCharArray();
        BigDecimal result = invokeParseBigDecimal(input, 0, input.length, true);
        assertEquals(new BigDecimal("123.456"), result);
    }

    @Test
    public void testParseBigDecimalWithoutFastParser() throws Exception {
        char[] input = "789.012".toCharArray();
        BigDecimal result = invokeParseBigDecimal(input, 0, input.length, false);
        assertEquals(new BigDecimal("789.012"), result);
    }

    @Test
    public void testParseBigDecimalThrowsNumberFormatException() {
        char[] input = "invalid".toCharArray();
        assertThrows(NumberFormatException.class, () -> {
            invokeParseBigDecimal(input, 0, input.length, true);
        });
    }

    @Test
    public void testParseBigDecimalWithEmptyInput() {
        char[] input = "".toCharArray();
        assertThrows(NumberFormatException.class, () -> {
            invokeParseBigDecimal(input, 0, input.length, false);
        });
    }

    @Test
    public void testParseBigDecimalWithNegativeInput() throws Exception {
        char[] input = "-123.456".toCharArray();
        BigDecimal result = invokeParseBigDecimal(input, 0, input.length, true);
        assertEquals(new BigDecimal("-123.456"), result);
    }

    private BigDecimal invokeParseBigDecimal(char[] ch, int off, int len, boolean useFastParser) throws Exception {
        Method method = NumberInput.class.getDeclaredMethod("parseBigDecimal", char[].class, int.class, int.class, boolean.class);
        method.setAccessible(true);
        return (BigDecimal) method.invoke(null, ch, off, len, useFastParser);
    }
}
