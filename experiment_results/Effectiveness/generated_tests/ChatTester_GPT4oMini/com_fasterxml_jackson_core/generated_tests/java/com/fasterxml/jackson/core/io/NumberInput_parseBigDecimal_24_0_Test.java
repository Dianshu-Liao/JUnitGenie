package com.fasterxml.jackson.core.io;

import java.math.BigDecimal;
import java.lang.reflect.Field;
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

public class NumberInput_parseBigDecimal_24_0_Test {

    @Test
    public void testParseBigDecimal_UseFastParser() throws Exception {
        // Arrange
        char[] input = "123.456".toCharArray();
        boolean useFastParser = true;
        // Mocking BigDecimalParser
        BigDecimalParser mockParser = Mockito.mock(BigDecimalParser.class);
        Mockito.when(mockParser.parseWithFastParser(input, 0, input.length)).thenReturn(new BigDecimal("123.456"));
        // Use reflection to set the mock in NumberInput
        setPrivateField("bigDecimalParser", mockParser);
        // Act
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        // Assert
        assertEquals(new BigDecimal("123.456"), result);
    }

    @Test
    public void testParseBigDecimal_UseRegularParser() throws Exception {
        // Arrange
        char[] input = "789.012".toCharArray();
        boolean useFastParser = false;
        // Mocking BigDecimalParser
        BigDecimalParser mockParser = Mockito.mock(BigDecimalParser.class);
        Mockito.when(mockParser.parse(input)).thenReturn(new BigDecimal("789.012"));
        // Use reflection to set the mock in NumberInput
        setPrivateField("bigDecimalParser", mockParser);
        // Act
        BigDecimal result = NumberInput.parseBigDecimal(input, useFastParser);
        // Assert
        assertEquals(new BigDecimal("789.012"), result);
    }

    @Test
    public void testParseBigDecimal_InvalidInput() {
        // Arrange
        char[] input = "invalid".toCharArray();
        boolean useFastParser = true;
        // Act & Assert
        assertThrows(NumberFormatException.class, () -> {
            NumberInput.parseBigDecimal(input, useFastParser);
        });
    }

    private void setPrivateField(String fieldName, Object value) throws Exception {
        Field field = NumberInput.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(null, value);
    }
}
