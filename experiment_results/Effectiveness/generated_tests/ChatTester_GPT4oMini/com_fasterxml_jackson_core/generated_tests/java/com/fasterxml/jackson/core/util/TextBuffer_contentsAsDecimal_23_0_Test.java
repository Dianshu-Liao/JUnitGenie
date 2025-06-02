package com.fasterxml.jackson.core.util;

import java.math.BigDecimal;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.NumberInput;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;

class TextBuffer_contentsAsDecimal_23_0_Test {

    private BufferRecycler mockAllocator;

    private TextBuffer textBuffer;

    @BeforeEach
    void setUp() {
        mockAllocator = mock(BufferRecycler.class);
        textBuffer = new TextBuffer(mockAllocator);
    }

    @Test
    void testContentsAsDecimal_WithResultString() {
        // Arrange
        String expected = "123.45";
        setPrivateField(textBuffer, "_resultString", expected);
        // Act
        BigDecimal result = textBuffer.contentsAsDecimal(true);
        // Assert
        assertEquals(new BigDecimal(expected), result);
    }

    @Test
    void testContentsAsDecimal_WithInputBuffer() {
        // Arrange
        String expected = "678.90";
        char[] inputBuffer = expected.toCharArray();
        setPrivateField(textBuffer, "_inputBuffer", inputBuffer);
        setPrivateField(textBuffer, "_inputStart", 0);
        setPrivateField(textBuffer, "_inputLen", inputBuffer.length);
        // Act
        BigDecimal result = textBuffer.contentsAsDecimal(true);
        // Assert
        assertEquals(new BigDecimal(expected), result);
    }

    @Test
    void testContentsAsDecimal_WithCurrentSegment() {
        // Arrange
        String expected = "135.79";
        char[] currentSegment = expected.toCharArray();
        setPrivateField(textBuffer, "_currentSegment", currentSegment);
        setPrivateField(textBuffer, "_currentSize", currentSegment.length);
        setPrivateField(textBuffer, "_hasSegments", false);
        // Act
        BigDecimal result = textBuffer.contentsAsDecimal(true);
        // Assert
        assertEquals(new BigDecimal(expected), result);
    }

    @Test
    void testContentsAsDecimal_WithResultArray() {
        // Arrange
        String expected = "246.80";
        char[] resultArray = expected.toCharArray();
        setPrivateField(textBuffer, "_resultArray", resultArray);
        // Act
        BigDecimal result = textBuffer.contentsAsDecimal(true);
        // Assert
        assertEquals(new BigDecimal(expected), result);
    }

    @Test
    void testContentsAsDecimal_WithIOException() {
        // Arrange
        setPrivateField(textBuffer, "_hasSegments", true);
        // Corrected line: Mocking the BufferRecycler's behavior to throw an IOException
        doThrow(new IOException("Mocked IOException")).when(mockAllocator).allocByteBuffer(anyInt());
        // Act & Assert
        assertThrows(NumberFormatException.class, () -> {
            textBuffer.contentsAsDecimal(true);
        });
    }

    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
