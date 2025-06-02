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

public class TextBuffer_getTextBuffer_15_0_Test {

    private BufferRecycler bufferRecycler;

    private TextBuffer textBuffer;

    @BeforeEach
    public void setUp() {
        bufferRecycler = new BufferRecycler();
        textBuffer = new TextBuffer(bufferRecycler);
    }

    @Test
    public void testGetTextBufferWhenInputStartIsNonNegative() throws IOException {
        char[] inputBuffer = new char[] { 'a', 'b', 'c' };
        // Reset current length
        textBuffer.setCurrentLength(0);
        // Simulate setting input buffer
        textBuffer.setCurrentAndReturn(3);
        // Instead of setting _inputBuffer directly, we use the existing methods
        textBuffer.getCurrentSegment()[0] = 'a';
        textBuffer.getCurrentSegment()[1] = 'b';
        textBuffer.getCurrentSegment()[2] = 'c';
        // Set length to 3
        textBuffer.setCurrentLength(3);
        char[] result = textBuffer.getTextBuffer();
        assertArrayEquals(inputBuffer, result);
    }

    @Test
    public void testGetTextBufferWhenResultArrayIsNotNull() throws IOException {
        char[] resultArray = new char[] { 'x', 'y', 'z' };
        textBuffer.setCurrentLength(0);
        // Simulate setting input buffer
        textBuffer.setCurrentAndReturn(3);
        textBuffer.getCurrentSegment()[0] = 'x';
        textBuffer.getCurrentSegment()[1] = 'y';
        textBuffer.getCurrentSegment()[2] = 'z';
        // Set length to 3
        textBuffer.setCurrentLength(3);
        char[] result = textBuffer.getTextBuffer();
        assertArrayEquals(resultArray, result);
    }

    @Test
    public void testGetTextBufferWhenResultStringIsNotNull() throws IOException {
        textBuffer.setCurrentLength(0);
        // Simulate setting input buffer
        textBuffer.setCurrentAndReturn(5);
        textBuffer.getCurrentSegment()[0] = 'h';
        textBuffer.getCurrentSegment()[1] = 'e';
        textBuffer.getCurrentSegment()[2] = 'l';
        textBuffer.getCurrentSegment()[3] = 'l';
        textBuffer.getCurrentSegment()[4] = 'o';
        // Set length to 5
        textBuffer.setCurrentLength(5);
        char[] result = textBuffer.getTextBuffer();
        assertArrayEquals("hello".toCharArray(), result);
    }

    @Test
    public void testGetTextBufferWhenNoSegmentsAndCurrentSegmentIsNull() throws IOException {
        textBuffer.setCurrentLength(0);
        // Simulate no segments
        textBuffer.setCurrentAndReturn(0);
        char[] result = textBuffer.getTextBuffer();
        assertArrayEquals(TextBuffer.NO_CHARS, result);
    }

    @Test
    public void testGetTextBufferWhenNoSegmentsAndCurrentSegmentIsNotNull() throws IOException {
        textBuffer.setCurrentLength(0);
        char[] currentSegment = new char[] { 'a', 'b', 'c' };
        // Ensure current segment is initialized
        textBuffer.getCurrentSegment();
    }
}
