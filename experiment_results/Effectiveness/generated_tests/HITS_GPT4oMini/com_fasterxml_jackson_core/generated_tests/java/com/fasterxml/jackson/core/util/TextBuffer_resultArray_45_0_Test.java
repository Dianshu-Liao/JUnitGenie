package com.fasterxml.jackson.core.util;

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

public class TextBuffer_resultArray_45_0_Test {

    private BufferRecycler bufferRecycler;

    private TextBuffer textBuffer;

    @BeforeEach
    public void setUp() {
        bufferRecycler = new BufferRecycler();
        textBuffer = new TextBuffer(bufferRecycler);
    }

    @Test
    public void testResultArrayWithNullResultString() throws IOException {
        textBuffer.setCurrentLength(0);
        char[] result = textBuffer.getTextBuffer();
        assertArrayEquals(TextBuffer.NO_CHARS, result);
    }

    @Test
    public void testResultArrayWithEmptyResultString() throws IOException {
        textBuffer.setCurrentLength(0);
        textBuffer.setCurrentAndReturn(0);
        char[] result = textBuffer.getTextBuffer();
        assertArrayEquals(TextBuffer.NO_CHARS, result);
    }

    @Test
    public void testResultArrayWithSharedInputBuffer() throws IOException {
        char[] inputBuffer = new char[] { 'H', 'e', 'l', 'l', 'o' };
        textBuffer.setCurrentLength(inputBuffer.length);
        textBuffer.setCurrentAndReturn(inputBuffer.length);
        // Simulate using shared buffer
        textBuffer.getTextBuffer();
        char[] result = textBuffer.getTextBuffer();
        assertArrayEquals(inputBuffer, result);
    }

    @Test
    public void testResultArrayWithSegments() throws IOException {
        char[] segment1 = new char[] { 'H', 'e', 'l', 'l', 'o' };
        char[] segment2 = new char[] { ' ', 'W', 'o', 'r', 'l', 'd' };
        textBuffer.setCurrentLength(segment1.length);
        textBuffer.setCurrentAndReturn(segment1.length);
        textBuffer.setCurrentLength(segment2.length);
        textBuffer.setCurrentAndReturn(segment2.length);
        // Here we can't set segments directly, but we can simulate their behavior
        textBuffer.setCurrentLength(segment1.length + segment2.length);
        char[] result = textBuffer.getTextBuffer();
        char[] expected = new char[] { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd' };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testResultArrayWithCurrentSegmentOnly() throws IOException {
        char[] currentSegment = new char[] { 'T', 'e', 's', 't' };
        textBuffer.setCurrentLength(currentSegment.length);
        textBuffer.setCurrentAndReturn(currentSegment.length);
        char[] result = textBuffer.getTextBuffer();
        assertArrayEquals(currentSegment, result);
    }

    @Test
    public void testResultArrayWithBufferOverflow() {
        textBuffer.setCurrentLength(Integer.MAX_VALUE);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            textBuffer.getTextBuffer();
        });
        assertTrue(exception.getMessage().contains("TextBuffer overrun"));
    }
}
