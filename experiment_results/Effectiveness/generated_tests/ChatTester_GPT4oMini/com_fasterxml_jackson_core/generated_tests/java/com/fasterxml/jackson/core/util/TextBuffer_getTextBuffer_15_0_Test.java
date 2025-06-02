// Test method
package com.fasterxml.jackson.core.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.NumberInput;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;

class TextBuffer_getTextBuffer_15_0_Test {

    private TextBuffer textBuffer;

    private BufferRecycler mockAllocator;

    @BeforeEach
    void setUp() {
        mockAllocator = Mockito.mock(BufferRecycler.class);
        textBuffer = new TextBuffer(mockAllocator);
    }

    @Test
    void testGetTextBuffer_WithSharedInputBuffer() throws Exception {
        // Arrange
        char[] inputBuffer = new char[] { 'H', 'e', 'l', 'l', 'o' };
        setPrivateField(textBuffer, "_inputBuffer", inputBuffer);
        setPrivateField(textBuffer, "_inputStart", 0);
        // Act
        char[] result = textBuffer.getTextBuffer();
        // Assert
        assertArrayEquals(inputBuffer, result);
    }

    @Test
    void testGetTextBuffer_WithResultArray() throws Exception {
        // Arrange
        char[] resultArray = new char[] { 'W', 'o', 'r', 'l', 'd' };
        setPrivateField(textBuffer, "_resultArray", resultArray);
        // Act
        char[] result = textBuffer.getTextBuffer();
        // Assert
        assertArrayEquals(resultArray, result);
    }

    @Test
    void testGetTextBuffer_WithResultString() throws Exception {
        // Arrange
        String resultString = "Test String";
        setPrivateField(textBuffer, "_resultString", resultString);
        // Act
        char[] result = textBuffer.getTextBuffer();
        // Assert
        assertArrayEquals(resultString.toCharArray(), result);
    }

    @Test
    void testGetTextBuffer_WithNoSegmentsAndNullCurrentSegment() throws Exception {
        // Arrange
        setPrivateField(textBuffer, "_hasSegments", false);
        setPrivateField(textBuffer, "_currentSegment", null);
        // Act
        char[] result = textBuffer.getTextBuffer();
        // Assert
        assertArrayEquals(TextBuffer.NO_CHARS, result);
    }

    @Test
    void testGetTextBuffer_WithNoSegmentsAndCurrentSegment() throws Exception {
        // Arrange
        setPrivateField(textBuffer, "_hasSegments", false);
        setPrivateField(textBuffer, "_currentSegment", new char[] { 'A', 'B', 'C' });
        // Act
        char[] result = textBuffer.getTextBuffer();
        // Assert
        assertArrayEquals(new char[] { 'A', 'B', 'C' }, result);
    }

    @Test
    void testGetTextBuffer_WithSegments() throws Exception {
        // Arrange
        setPrivateField(textBuffer, "_hasSegments", true);
        List<char[]> segments = new ArrayList<>();
        segments.add(new char[] { 'S', 'e', 'g', 'm', 'e', 'n', 't' });
        setPrivateField(textBuffer, "_segments", segments);
        // Using reflection to access the private method contentsAsArray
        char[] expectedArray = new char[] { 'S', 'e', 'g', 'm', 'e', 'n', 't' };
        char[] result = invokeContentsAsArray(textBuffer);
        // Assert
        assertArrayEquals(expectedArray, result);
    }

    // Reflection method to invoke the private contentsAsArray method
    private char[] invokeContentsAsArray(TextBuffer textBuffer) throws Exception {
        java.lang.reflect.Method method = TextBuffer.class.getDeclaredMethod("contentsAsArray");
        method.setAccessible(true);
        return (char[]) method.invoke(textBuffer);
    }

    // Reflection method to set private fields
    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
