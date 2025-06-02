package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.NumberInput;

class TextBuffer_getTextBuffer_15_0_Test {

    private TextBuffer textBuffer;

    private BufferRecycler allocator;

    @BeforeEach
    void setUp() {
        allocator = new BufferRecycler();
        textBuffer = new TextBuffer(allocator);
    }

    @Test
    void testGetTextBuffer_WithInputBuffer() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Setup
        char[] inputBuffer = new char[] { 'a', 'b', 'c' };
        textBuffer.setCurrentLength(inputBuffer.length);
        setPrivateField(textBuffer, "_inputBuffer", inputBuffer);
        setPrivateField(textBuffer, "_inputStart", 0);
        // Execute
        char[] result = textBuffer.getTextBuffer();
        // Verify
        assertArrayEquals(inputBuffer, result);
    }

    @Test
    void testGetTextBuffer_WithResultArray() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Setup
        String resultString = "Hello";
        textBuffer.setCurrentAndReturn(resultString.length());
        setPrivateField(textBuffer, "_resultArray", null);
        setPrivateField(textBuffer, "_resultString", resultString);
        // Execute
        char[] result = textBuffer.getTextBuffer();
        // Verify
        assertArrayEquals(resultString.toCharArray(), result);
    }

    @Test
    void testGetTextBuffer_WithSingleSegment() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Setup
        setPrivateField(textBuffer, "_hasSegments", false);
        char[] segment = new char[] { 'x', 'y', 'z' };
        setPrivateField(textBuffer, "_currentSegment", segment);
        textBuffer.setCurrentLength(3);
        // Execute
        char[] result = textBuffer.getTextBuffer();
        // Verify
        assertArrayEquals(segment, result);
    }

    @Test
    void testGetTextBuffer_WithNoSegments() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Setup
        setPrivateField(textBuffer, "_hasSegments", true);
        setPrivateField(textBuffer, "_currentSegment", null);
        // Execute
        char[] result = textBuffer.getTextBuffer();
        // Verify
        assertArrayEquals(TextBuffer.NO_CHARS, result);
    }

    @Test
    void testGetTextBuffer_WithContentsAsArray() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Setup
        setPrivateField(textBuffer, "_hasSegments", true);
        char[] expectedArray = new char[] { 'a', 'b', 'c' };
        setPrivateField(textBuffer, "_resultArray", null);
        setPrivateField(textBuffer, "_resultString", null);
        ArrayList<char[]> segments = new ArrayList<>();
        segments.add(expectedArray);
        setPrivateField(textBuffer, "_segments", segments);
        // Execute
        char[] result = textBuffer.getTextBuffer();
        // Verify
        assertArrayEquals(expectedArray, result);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
