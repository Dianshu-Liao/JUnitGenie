package com.fasterxml.jackson.core.util;

import java.lang.reflect.Field;
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

    private BufferRecycler allocator;

    private TextBuffer textBuffer;

    @BeforeEach
    public void setUp() {
        allocator = new BufferRecycler();
        textBuffer = new TextBuffer(allocator);
    }

    @Test
    public void testEmptyAndGetCurrentSegment_WhenCurrentSegmentIsNull() {
        char[] segment = textBuffer.emptyAndGetCurrentSegment();
        assertNotNull(segment, "Current segment should not be null after calling emptyAndGetCurrentSegment");
        assertEquals(0, segment.length, "Current segment should be an empty array");
    }

    @Test
    public void testEmptyAndGetCurrentSegment_WhenCurrentSegmentIsNotNull() {
        textBuffer.getCurrentSegment();
        textBuffer.setCurrentLength(10);
        char[] segment = textBuffer.emptyAndGetCurrentSegment();
        assertNotNull(segment, "Current segment should not be null after calling emptyAndGetCurrentSegment");
        assertEquals(0, textBuffer.getCurrentSegmentSize(), "Current segment size should be 0 after emptying");
    }

    @Test
    public void testEmptyAndGetCurrentSegment_ClearsInputBuffer() {
        textBuffer.getCurrentSegment();
        textBuffer.emptyAndGetCurrentSegment();
        assertEquals(-1, textBuffer.getTextOffset(), "Text offset should be -1 after emptying the segment");
    }

    @Test
    public void testEmptyAndGetCurrentSegment_ClearsResultString() throws Exception {
        textBuffer.getCurrentSegment();
        textBuffer.setCurrentAndReturn(5);
        textBuffer.emptyAndGetCurrentSegment();
        Field resultStringField = TextBuffer.class.getDeclaredField("_resultString");
        resultStringField.setAccessible(true);
        String resultString = (String) resultStringField.get(textBuffer);
        assertNull(resultString, "Result string should be null after emptying the segment");
    }

    @Test
    public void testEmptyAndGetCurrentSegment_ClearsResultArray() throws Exception {
        textBuffer.getCurrentSegment();
        textBuffer.setCurrentAndReturn(5);
        textBuffer.emptyAndGetCurrentSegment();
        Field resultArrayField = TextBuffer.class.getDeclaredField("_resultArray");
        resultArrayField.setAccessible(true);
        char[] resultArray = (char[]) resultArrayField.get(textBuffer);
        assertNull(resultArray, "Result array should be null after emptying the segment");
    }

    @Test
    public void testEmptyAndGetCurrentSegment_WhenSegmentsExist() throws Exception {
        textBuffer.getCurrentSegment();
        textBuffer.emptyAndGetCurrentSegment();
        Field segmentsField = TextBuffer.class.getDeclaredField("_segments");
        segmentsField.setAccessible(true);
        ArrayList<char[]> segments = (ArrayList<char[]>) segmentsField.get(textBuffer);
        assertTrue(segments.isEmpty(), "Segments should be cleared after calling emptyAndGetCurrentSegment");
    }
}
