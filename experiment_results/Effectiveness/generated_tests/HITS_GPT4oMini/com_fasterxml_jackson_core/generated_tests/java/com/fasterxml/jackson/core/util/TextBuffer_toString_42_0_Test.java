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

public class TextBuffer_toString_42_0_Test {

    private BufferRecycler bufferRecycler;

    private TextBuffer textBuffer;

    @BeforeEach
    public void setUp() {
        bufferRecycler = new BufferRecycler();
        textBuffer = new TextBuffer(bufferRecycler);
    }

    @Test
    public void testToString_EmptyBuffer() throws IOException {
        // Arrange
        textBuffer.setCurrentLength(0);
        // Act
        String result = textBuffer.toString();
        // Assert
        assertEquals("", result, "Expected empty string for empty buffer");
    }

    @Test
    public void testToString_SingleSegment() throws IOException {
        // Arrange
        char[] segment = "Hello".toCharArray();
        textBuffer.setCurrentLength(segment.length);
        System.arraycopy(segment, 0, textBuffer.getCurrentSegment(), 0, segment.length);
        // Act
        String result = textBuffer.toString();
        // Assert
        assertEquals("Hello", result, "Expected 'Hello' from single segment");
    }

    @Test
    public void testToString_MultipleSegments() throws IOException {
        // Arrange
        char[] segment1 = "Hello".toCharArray();
        char[] segment2 = " World".toCharArray();
        // Set first segment
        textBuffer.setCurrentLength(segment1.length);
        System.arraycopy(segment1, 0, textBuffer.getCurrentSegment(), 0, segment1.length);
        // Simulating adding a second segment by setting the current length to include both segments
        textBuffer.setCurrentLength(segment1.length + segment2.length);
        System.arraycopy(segment2, 0, textBuffer.getCurrentSegment(), segment1.length, segment2.length);
        // Act
        String result = textBuffer.toString();
        // Assert
        assertEquals("Hello World", result, "Expected 'Hello World' from multiple segments");
    }

    @Test
    public void testToString_IOExceptionHandling() throws IOException {
        // Arrange
        textBuffer.setCurrentLength(0);
        // Act
        String result = textBuffer.toString();
        // Assert
        assertEquals("TextBuffer: Exception when reading contents", result, "Expected exception message on IOException");
    }
}
