package com.fasterxml.jackson.core.util;

import java.math.BigDecimal;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.NumberInput;

public class TextBuffer_contentsAsDecimal_23_0_Test {

    private TextBuffer textBuffer;

    private BufferRecycler bufferRecycler;

    @BeforeEach
    public void setUp() {
        bufferRecycler = new BufferRecycler();
        textBuffer = new TextBuffer(bufferRecycler);
    }

    @Test
    public void testContentsAsDecimal_WithResultString() throws IOException {
        String resultString = "123.45";
        textBuffer.setCurrentLength(resultString.length());
        textBuffer.setCurrentAndReturn(resultString.length());
        textBuffer.getCurrentSegment()[0] = resultString.charAt(0);
        textBuffer.getCurrentSegment()[1] = resultString.charAt(1);
        textBuffer.getCurrentSegment()[2] = resultString.charAt(2);
        textBuffer.getCurrentSegment()[3] = resultString.charAt(3);
        textBuffer.getCurrentSegment()[4] = resultString.charAt(4);
        BigDecimal result = textBuffer.contentsAsDecimal(false);
        assertEquals(new BigDecimal("123.45"), result);
    }

    @Test
    public void testContentsAsDecimal_WithInputBuffer() throws IOException {
        char[] inputBuffer = "678.90".toCharArray();
        textBuffer.setCurrentLength(inputBuffer.length);
        System.arraycopy(inputBuffer, 0, textBuffer.getCurrentSegment(), 0, inputBuffer.length);
        BigDecimal result = textBuffer.contentsAsDecimal(false);
        assertEquals(new BigDecimal("678.90"), result);
    }

    @Test
    public void testContentsAsDecimal_WithCurrentSegment() throws IOException {
        char[] currentSegment = "234.56".toCharArray();
        textBuffer.setCurrentLength(currentSegment.length);
        System.arraycopy(currentSegment, 0, textBuffer.getCurrentSegment(), 0, currentSegment.length);
        BigDecimal result = textBuffer.contentsAsDecimal(false);
        assertEquals(new BigDecimal("234.56"), result);
    }

    @Test
    public void testContentsAsDecimal_WithResultArray() throws IOException {
        char[] resultArray = "345.67".toCharArray();
        textBuffer.setCurrentLength(resultArray.length);
        System.arraycopy(resultArray, 0, textBuffer.getCurrentSegment(), 0, resultArray.length);
        BigDecimal result = textBuffer.contentsAsDecimal(false);
        assertEquals(new BigDecimal("345.67"), result);
    }

    @Test
    public void testContentsAsDecimal_WithSegments() throws IOException {
        textBuffer.setCurrentLength(6);
        char[] segment = "456.78".toCharArray();
        System.arraycopy(segment, 0, textBuffer.getCurrentSegment(), 0, segment.length);
        BigDecimal result = textBuffer.contentsAsDecimal(false);
        assertEquals(new BigDecimal("456.78"), result);
    }

    @Test
    public void testContentsAsDecimal_ThrowsNumberFormatException() {
        textBuffer.setCurrentLength("invalid".length());
        System.arraycopy("invalid".toCharArray(), 0, textBuffer.getCurrentSegment(), 0, "invalid".length());
        assertThrows(NumberFormatException.class, () -> {
            textBuffer.contentsAsDecimal(false);
        });
    }
}
