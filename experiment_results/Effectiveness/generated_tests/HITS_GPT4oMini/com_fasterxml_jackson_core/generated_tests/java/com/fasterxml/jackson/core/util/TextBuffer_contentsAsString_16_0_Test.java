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

public class TextBuffer_contentsAsString_16_0_Test {

    private TextBuffer textBuffer;

    private BufferRecycler bufferRecycler;

    @BeforeEach
    public void setUp() {
        bufferRecycler = new BufferRecycler();
        textBuffer = new TextBuffer(bufferRecycler);
    }

    @Test
    public void testContentsAsString_EmptyBuffer() throws IOException {
        assertEquals("", textBuffer.contentsAsString());
    }

    @Test
    public void testContentsAsString_SingleSegment() throws IOException {
        char[] segment = new char[] { 'H', 'e', 'l', 'l', 'o' };
        textBuffer.setCurrentLength(segment.length);
        System.arraycopy(segment, 0, textBuffer.getCurrentSegment(), 0, segment.length);
        assertEquals("Hello", textBuffer.contentsAsString());
    }

    @Test
    public void testContentsAsString_MultipleSegments() throws IOException {
        char[] segment1 = new char[] { 'H', 'e', 'l', 'l', 'o' };
        char[] segment2 = new char[] { ' ', 'W', 'o', 'r', 'l', 'd' };
        textBuffer.setCurrentLength(segment1.length);
        System.arraycopy(segment1, 0, textBuffer.getCurrentSegment(), 0, segment1.length);
        // Simulate adding a second segment by directly modifying the current segment
        textBuffer.setCurrentLength(segment2.length);
        System.arraycopy(segment2, 0, textBuffer.getCurrentSegment(), 0, segment2.length);
        assertEquals("Hello World", textBuffer.contentsAsString());
    }

    @Test
    public void testContentsAsString_NullCurrentSegment() throws IOException {
        textBuffer.setCurrentLength(0);
        // Resetting the current segment to empty by not modifying it
        textBuffer.setCurrentLength(0);
        assertEquals("", textBuffer.contentsAsString());
    }

    @Test
    public void testContentsAsString_SingleCharacter() throws IOException {
        char[] segment = new char[] { 'A' };
        textBuffer.setCurrentLength(segment.length);
        System.arraycopy(segment, 0, textBuffer.getCurrentSegment(), 0, segment.length);
        assertEquals("A", textBuffer.contentsAsString());
    }

    @Test
    public void testContentsAsString_SegmentWithSpecialCharacters() throws IOException {
        char[] segment = new char[] { 'T', 'e', 's', 't', '!', '@', '#', '$', '%', '^', '&', '*' };
        textBuffer.setCurrentLength(segment.length);
        System.arraycopy(segment, 0, textBuffer.getCurrentSegment(), 0, segment.length);
        assertEquals("Test!@#$%^&*", textBuffer.contentsAsString());
    }

    @Test
    public void testContentsAsString_BufferOverflow() {
        textBuffer.setCurrentLength(Integer.MAX_VALUE);
        assertThrows(IllegalStateException.class, () -> textBuffer.contentsAsString());
    }
}
