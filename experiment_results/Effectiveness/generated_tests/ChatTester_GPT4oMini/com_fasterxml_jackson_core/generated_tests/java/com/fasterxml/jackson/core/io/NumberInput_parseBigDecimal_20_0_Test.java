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

class NumberInput_parseBigDecimal_20_0_Test {

    @Test
    void testParseBigDecimal_UseFastParser_ValidInput() {
        String input = "123.456";
        boolean useFastParser = true;
        BigDecimal result = invokeParseBigDecimal(input, useFastParser);
        assertEquals(new BigDecimal("123.456"), result);
    }

    @Test
    void testParseBigDecimal_UseFastParser_InvalidInput() {
        String input = "invalid";
        boolean useFastParser = true;
        Executable executable = () -> invokeParseBigDecimal(input, useFastParser);
        assertThrows(NumberFormatException.class, executable);
    }

    @Test
    void testParseBigDecimal_NotUsingFastParser_ValidInput() {
        String input = "789.012";
        boolean useFastParser = false;
        BigDecimal result = invokeParseBigDecimal(input, useFastParser);
        assertEquals(new BigDecimal("789.012"), result);
    }

    @Test
    void testParseBigDecimal_NotUsingFastParser_InvalidInput() {
        String input = "invalid";
        boolean useFastParser = false;
        Executable executable = () -> invokeParseBigDecimal(input, useFastParser);
        assertThrows(NumberFormatException.class, executable);
    }

    private BigDecimal invokeParseBigDecimal(String s, boolean useFastParser) {
        try {
            return (BigDecimal) NumberInput.class.getDeclaredMethod("parseBigDecimal", String.class, boolean.class).invoke(null, s, useFastParser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
