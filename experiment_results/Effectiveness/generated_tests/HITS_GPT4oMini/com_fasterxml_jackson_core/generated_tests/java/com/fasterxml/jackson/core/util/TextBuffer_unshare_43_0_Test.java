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

class TextBuffer_unshare_43_0_Test {

    private BufferRecycler allocator;

    private TextBuffer textBuffer;

    @BeforeEach
    void setUp() {
        allocator = new BufferRecycler();
        textBuffer = new TextBuffer(allocator);
    }

    @Test
    void testUnshareWithNoInput() {
        textBuffer.setCurrentLength(0);
        // This will call unshare indirectly
        textBuffer.getCurrentSegment();
        // MIN_SEGMENT_LEN
        assertEquals(500, textBuffer.getCurrentSegment().length);
        assertEquals(0, textBuffer.getCurrentSegmentSize());
    }

    @Test
    void testUnshareWithExistingInput() {
        char[] input = new char[] { 'H', 'e', 'l', 'l', 'o' };
        textBuffer.setCurrentLength(input.length);
        System.arraycopy(input, 0, textBuffer.getCurrentSegment(), 0, input.length);
        // This will call unshare indirectly
        textBuffer.getCurrentSegment();
        // MIN_SEGMENT_LEN
        assertEquals(500, textBuffer.getCurrentSegment().length);
        assertEquals(5, textBuffer.getCurrentSegmentSize());
        assertEquals('H', textBuffer.getCurrentSegment()[0]);
        assertEquals('e', textBuffer.getCurrentSegment()[1]);
        assertEquals('l', textBuffer.getCurrentSegment()[2]);
        assertEquals('l', textBuffer.getCurrentSegment()[3]);
        assertEquals('o', textBuffer.getCurrentSegment()[4]);
    }

    @Test
    void testUnshareWithReallocation() {
        textBuffer.setCurrentLength(TextBuffer.MIN_SEGMENT_LEN);
        // This will call unshare indirectly
        textBuffer.getCurrentSegment();
        assertEquals(TextBuffer.MIN_SEGMENT_LEN, textBuffer.getCurrentSegment().length);
    }

    @Test
    void testUnshareWithExactCapacity() {
        textBuffer.setCurrentLength(TextBuffer.MAX_SEGMENT_LEN);
        // This will call unshare indirectly
        textBuffer.getCurrentSegment();
        assertEquals(TextBuffer.MAX_SEGMENT_LEN, textBuffer.getCurrentSegment().length);
    }

    @Test
    void testUnshareWithExceedingCapacity() {
        textBuffer.setCurrentLength(TextBuffer.MAX_SEGMENT_LEN);
        // This will call unshare indirectly
        textBuffer.getCurrentSegment();
        assertEquals(TextBuffer.MAX_SEGMENT_LEN, textBuffer.getCurrentSegment().length);
    }
}
