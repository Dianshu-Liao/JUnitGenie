package com.fasterxml.jackson.core.util;

import java.lang.reflect.Method;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;
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

public class TextBuffer_emptyAndGetCurrentSegment_33_0_Test {

    private TextBuffer textBuffer;

    private BufferRecycler bufferRecycler;

    @BeforeEach
    public void setUp() {
        bufferRecycler = new BufferRecycler();
        textBuffer = new TextBuffer(bufferRecycler);
    }

    @Test
    public void testEmptyAndGetCurrentSegment_NoCurrentSegment() {
        char[] currentSegment = invokeEmptyAndGetCurrentSegment();
        assertNotNull(currentSegment);
        assertEquals(0, currentSegment.length);
        assertEquals(0, textBuffer.getCurrentSegmentSize());
    }

    @Test
    public void testEmptyAndGetCurrentSegment_WithSegments() {
        // Simulate some length
        textBuffer.setCurrentLength(10);
        char[] segment = new char[10];
        textBuffer.setCurrentLength(segment.length);
        // Initialize _currentSegment
        textBuffer.getCurrentSegment();
        // Should clear segments
        textBuffer.emptyAndGetCurrentSegment();
        assertNull(textBuffer.getBufferWithoutReset());
        assertEquals(0, textBuffer.getCurrentSegmentSize());
    }

    @Test
    public void testEmptyAndGetCurrentSegment_ExistingCurrentSegment() {
        // Initialize _currentSegment
        char[] segment = textBuffer.getCurrentSegment();
        // Set current length
        textBuffer.setCurrentLength(5);
        char[] currentSegment = invokeEmptyAndGetCurrentSegment();
        assertNotNull(currentSegment);
        assertEquals(segment, currentSegment);
        assertEquals(0, textBuffer.getCurrentSegmentSize());
    }

    private char[] invokeEmptyAndGetCurrentSegment() {
        try {
            Method method = TextBuffer.class.getDeclaredMethod("emptyAndGetCurrentSegment");
            method.setAccessible(true);
            return (char[]) method.invoke(textBuffer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
