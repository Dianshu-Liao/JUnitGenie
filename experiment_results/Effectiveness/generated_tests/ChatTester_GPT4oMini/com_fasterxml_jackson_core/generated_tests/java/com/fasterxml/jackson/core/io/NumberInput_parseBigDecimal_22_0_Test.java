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

public class NumberInput_parseBigDecimal_22_0_Test {

    @Test
    public void testParseBigDecimal_UseFastParser() {
        // Arrange
        char[] input = "123.456".toCharArray();
        int offset = 0;
        int length = input.length;
        boolean useFastParser = true;
        // Mock the BigDecimalParser class
        BigDecimal expected = new BigDecimal("123.456");
        BigDecimalParser mockParser = mock(BigDecimalParser.class);
        when(mockParser.parseWithFastParser(input, offset, length)).thenReturn(expected);
        // Act
        BigDecimal result = NumberInput.parseBigDecimal(input, offset, length, useFastParser);
        // Assert
        assertEquals(expected, result);
        verify(mockParser).parseWithFastParser(input, offset, length);
    }

    @Test
    public void testParseBigDecimal_UseStandardParser() {
        // Arrange
        char[] input = "789.012".toCharArray();
        int offset = 0;
        int length = input.length;
        boolean useFastParser = false;
        // Mock the BigDecimalParser class
        BigDecimal expected = new BigDecimal("789.012");
        BigDecimalParser mockParser = mock(BigDecimalParser.class);
        when(mockParser.parse(input, offset, length)).thenReturn(expected);
        // Act
        BigDecimal result = NumberInput.parseBigDecimal(input, offset, length, useFastParser);
        // Assert
        assertEquals(expected, result);
        verify(mockParser).parse(input, offset, length);
    }

    @Test
    public void testParseBigDecimal_InvalidInput() {
        // Arrange
        char[] input = "invalid".toCharArray();
        int offset = 0;
        int length = input.length;
        boolean useFastParser = true;
        // Act & Assert
        Executable executable = () -> NumberInput.parseBigDecimal(input, offset, length, useFastParser);
        assertThrows(NumberFormatException.class, executable);
    }

    @Test
    public void testParseBigDecimal_EmptyInput() {
        // Arrange
        char[] input = "".toCharArray();
        int offset = 0;
        int length = input.length;
        boolean useFastParser = true;
        // Act & Assert
        Executable executable = () -> NumberInput.parseBigDecimal(input, offset, length, useFastParser);
        assertThrows(NumberFormatException.class, executable);
    }

    @Test
    public void testParseBigDecimal_NegativeNumber() {
        // Arrange
        char[] input = "-123.456".toCharArray();
        int offset = 0;
        int length = input.length;
        boolean useFastParser = false;
        // Mock the BigDecimalParser class
        BigDecimal expected = new BigDecimal("-123.456");
        BigDecimalParser mockParser = mock(BigDecimalParser.class);
        when(mockParser.parse(input, offset, length)).thenReturn(expected);
        // Act
        BigDecimal result = NumberInput.parseBigDecimal(input, offset, length, useFastParser);
        // Assert
        assertEquals(expected, result);
        verify(mockParser).parse(input, offset, length);
    }

    @Test
    public void testParseBigDecimal_ScientificNotation() {
        // Arrange
        char[] input = "1.23e2".toCharArray();
        int offset = 0;
        int length = input.length;
        boolean useFastParser = true;
        // Mock the BigDecimalParser class
        BigDecimal expected = new BigDecimal("1.23e2");
        BigDecimalParser mockParser = mock(BigDecimalParser.class);
        when(mockParser.parseWithFastParser(input, offset, length)).thenReturn(expected);
        // Act
        BigDecimal result = NumberInput.parseBigDecimal(input, offset, length, useFastParser);
        // Assert
        assertEquals(expected, result);
        verify(mockParser).parseWithFastParser(input, offset, length);
    }
}
