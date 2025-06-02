package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.NumberInput;

public class TextBuffer_resultArray_45_1_Test {

    private TextBuffer textBuffer;

    private BufferRecycler bufferRecycler;

    @BeforeEach
    public void setUp() {
        bufferRecycler = new BufferRecycler();
        textBuffer = new TextBuffer(bufferRecycler);
    }

    @Test
    public void testResultArrayWithNonNullResultString() throws Exception {
        // Set up the _resultString field
        invokeSetCurrentAndReturn("Hello, World!");
        char[] expected = "Hello, World!".toCharArray();
        char[] result = invokeResultArray();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testResultArrayWithInputBuffer() throws Exception {
        textBuffer.setCurrentLength(5);
        textBuffer.setCurrentLength(5);
        char[] inputBuffer = new char[] { 'H', 'e', 'l', 'l', 'o' };
        // Initialize the current segment
        textBuffer.getCurrentSegment();
        System.arraycopy(inputBuffer, 0, textBuffer.getCurrentSegment(), 0, inputBuffer.length);
        char[] expected = new char[] { 'H', 'e', 'l', 'l', 'o' };
        char[] result = invokeResultArray();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testResultArrayWithNoSegments() throws Exception {
        char[] expected = TextBuffer.NO_CHARS;
        char[] result = invokeResultArray();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testResultArrayWithBufferOverflow() throws Exception {
        textBuffer.setCurrentLength(1);
        textBuffer.setCurrentLength(1);
        // Initialize the current segment
        textBuffer.getCurrentSegment();
        // Simulate overflow
        textBuffer.setCurrentLength(Integer.MAX_VALUE);
        assertThrows(IllegalStateException.class, this::invokeResultArray);
    }

    private char[] invokeResultArray() throws Exception {
        Method method = TextBuffer.class.getDeclaredMethod("resultArray");
        method.setAccessible(true);
        return (char[]) method.invoke(textBuffer);
    }

    private void invokeSetCurrentAndReturn(String str) throws Exception {
        Method method = TextBuffer.class.getDeclaredMethod("setCurrentAndReturn", int.class);
        method.setAccessible(true);
        method.invoke(textBuffer, str.length());
    }
}
