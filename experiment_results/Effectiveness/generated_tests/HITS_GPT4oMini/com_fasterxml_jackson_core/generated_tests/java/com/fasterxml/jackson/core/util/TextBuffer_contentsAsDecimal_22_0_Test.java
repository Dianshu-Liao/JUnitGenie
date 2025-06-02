package com.fasterxml.jackson.core.util;

import java.math.BigDecimal;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.NumberInput;

class TextBuffer_contentsAsDecimal_22_0_Test {

    private TextBuffer textBuffer;

    private BufferRecycler bufferRecycler;

    @BeforeEach
    void setUp() {
        bufferRecycler = new BufferRecycler();
        textBuffer = new TextBuffer(bufferRecycler);
    }

    @Test
    void testContentsAsDecimalWithResultString() {
        // Arrange
        String decimalString = "12345.6789";
        char[] segment = textBuffer.getCurrentSegment();
        System.arraycopy(decimalString.toCharArray(), 0, segment, 0, decimalString.length());
        textBuffer.setCurrentLength(decimalString.length());
        // Act
        BigDecimal result = textBuffer.contentsAsDecimal();
        // Assert
        assertEquals(new BigDecimal(decimalString), result);
    }

    @Test
    void testContentsAsDecimalWithInputBuffer() {
        // Arrange
        String decimalString = "98765.4321";
        char[] segment = textBuffer.getCurrentSegment();
        System.arraycopy(decimalString.toCharArray(), 0, segment, 0, decimalString.length());
        textBuffer.setCurrentLength(decimalString.length());
        // Act
        BigDecimal result = textBuffer.contentsAsDecimal();
        // Assert
        assertEquals(new BigDecimal(decimalString), result);
    }

    @Test
    void testContentsAsDecimalWithSingleSegment() {
        // Arrange
        String decimalString = "0.1234";
        char[] segment = textBuffer.getCurrentSegment();
        System.arraycopy(decimalString.toCharArray(), 0, segment, 0, decimalString.length());
        textBuffer.setCurrentLength(decimalString.length());
        // Act
        BigDecimal result = textBuffer.contentsAsDecimal();
        // Assert
        assertEquals(new BigDecimal(decimalString), result);
    }

    @Test
    void testContentsAsDecimalWithSegments() {
        // Arrange
        String decimalString = "123456789.987654321";
        char[] segment = textBuffer.getCurrentSegment();
        System.arraycopy(decimalString.toCharArray(), 0, segment, 0, decimalString.length());
        textBuffer.setCurrentLength(decimalString.length());
        // Act
        BigDecimal result = textBuffer.contentsAsDecimal();
        // Assert
        assertEquals(new BigDecimal(decimalString), result);
    }

    @Test
    void testContentsAsDecimalWithInvalidInput() {
        // Arrange
        String invalidDecimalString = "invalid";
        char[] segment = textBuffer.getCurrentSegment();
        System.arraycopy(invalidDecimalString.toCharArray(), 0, segment, 0, invalidDecimalString.length());
        textBuffer.setCurrentLength(invalidDecimalString.length());
        // Act & Assert
        assertThrows(NumberFormatException.class, () -> textBuffer.contentsAsDecimal());
    }
}
