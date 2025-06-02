package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.NumberInput;

public class TextBuffer_size_12_0_Test {

    private TextBuffer textBuffer;

    private BufferRecycler bufferRecycler;

    @BeforeEach
    public void setUp() {
        bufferRecycler = new BufferRecycler();
        textBuffer = new TextBuffer(bufferRecycler);
    }

    @Test
    public void testSizeWithInputBuffer() throws IOException {
        textBuffer.setCurrentLength(10);
        textBuffer.setCurrentAndReturn(10);
        assertEquals(10, textBuffer.size());
    }

    @Test
    public void testSizeWithResultArray() throws IOException {
        char[] resultArray = new char[] { 'a', 'b', 'c' };
        textBuffer.setCurrentLength(3);
        textBuffer.setCurrentAndReturn(3);
        assertEquals(3, textBuffer.size());
    }

    @Test
    public void testSizeWithResultString() throws IOException {
        textBuffer.setCurrentLength(5);
        textBuffer.setCurrentAndReturn(5);
        assertEquals(5, textBuffer.size());
    }

    @Test
    public void testSizeWithSegments() throws IOException {
        textBuffer.setCurrentLength(10);
        textBuffer.setCurrentAndReturn(10);
        try {
            java.lang.reflect.Field segmentSizeField = TextBuffer.class.getDeclaredField("_segmentSize");
            segmentSizeField.setAccessible(true);
            segmentSizeField.setInt(textBuffer, 20);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(30, textBuffer.size());
    }

    @Test
    public void testSizeWithNoInput() {
        assertEquals(0, textBuffer.size());
    }
}
