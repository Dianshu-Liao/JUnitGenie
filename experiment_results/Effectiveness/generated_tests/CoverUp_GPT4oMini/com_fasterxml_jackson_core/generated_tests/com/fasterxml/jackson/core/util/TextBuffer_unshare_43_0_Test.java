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

class TextBuffer_unshare_43_0_Test {

    private BufferRecycler allocator;

    private TextBuffer textBuffer;

    @BeforeEach
    void setUp() {
        allocator = new BufferRecycler();
        textBuffer = new TextBuffer(allocator);
    }

    @Test
    void testUnshareWithNoInputBuffer() throws Exception {
        textBuffer.setCurrentLength(0);
        invokeUnshare(textBuffer, 10);
        assertNotNull(textBuffer.getCurrentSegment());
        assertEquals(10, textBuffer.getCurrentSegment().length);
        assertEquals(0, textBuffer.getCurrentSegmentSize());
    }

    @Test
    void testUnshareWithExistingInputBuffer() throws Exception {
        char[] initialSegment = new char[] { 'a', 'b', 'c', 'd', 'e' };
        textBuffer = new TextBuffer(allocator, initialSegment);
        textBuffer.setCurrentLength(5);
        invokeUnshare(textBuffer, 10);
        assertNotNull(textBuffer.getCurrentSegment());
        assertEquals(15, textBuffer.getCurrentSegment().length);
        assertEquals(5, textBuffer.getCurrentSegmentSize());
        assertEquals('a', textBuffer.getCurrentSegment()[0]);
        assertEquals('b', textBuffer.getCurrentSegment()[1]);
        assertEquals('c', textBuffer.getCurrentSegment()[2]);
        assertEquals('d', textBuffer.getCurrentSegment()[3]);
        assertEquals('e', textBuffer.getCurrentSegment()[4]);
    }

    @Test
    void testUnshareRequiresReallocation() throws Exception {
        char[] initialSegment = new char[] { 'a', 'b', 'c' };
        textBuffer = new TextBuffer(allocator, initialSegment);
        textBuffer.setCurrentLength(3);
        invokeUnshare(textBuffer, 10);
        assertNotNull(textBuffer.getCurrentSegment());
        assertTrue(textBuffer.getCurrentSegment().length >= 13);
        assertEquals(3, textBuffer.getCurrentSegmentSize());
    }

    @Test
    void testUnshareWithEmptyBuffer() throws Exception {
        textBuffer.setCurrentLength(0);
        invokeUnshare(textBuffer, 0);
        assertNotNull(textBuffer.getCurrentSegment());
        assertEquals(TextBuffer.MIN_SEGMENT_LEN, textBuffer.getCurrentSegment().length);
        assertEquals(0, textBuffer.getCurrentSegmentSize());
    }

    private void invokeUnshare(TextBuffer textBuffer, int needExtra) throws Exception {
        Method method = TextBuffer.class.getDeclaredMethod("unshare", int.class);
        method.setAccessible(true);
        method.invoke(textBuffer, needExtra);
    }
}
