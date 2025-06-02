package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;
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

public class TextBuffer_contentsAsDecimal_22_3_Test {

    private TextBuffer textBuffer;

    private BufferRecycler bufferRecycler;

    @BeforeEach
    public void setUp() {
        bufferRecycler = new BufferRecycler();
        textBuffer = new TextBuffer(bufferRecycler);
    }

    @Test
    public void testContentsAsDecimal_WithValidString() {
        // Set up the current segment with a valid decimal string
        String decimalString = "123.45";
        textBuffer.setCurrentLength(decimalString.length());
        char[] segment = decimalString.toCharArray();
        System.arraycopy(segment, 0, textBuffer.getCurrentSegment(), 0, segment.length);
        // Invoke the focal method
        BigDecimal result = textBuffer.contentsAsDecimal();
        // Verify the result
        assertEquals(new BigDecimal("123.45"), result);
    }

    @Test
    public void testContentsAsDecimal_WithZero() {
        // Set up the current segment with zero
        String decimalString = "0";
        textBuffer.setCurrentLength(decimalString.length());
        char[] segment = decimalString.toCharArray();
        System.arraycopy(segment, 0, textBuffer.getCurrentSegment(), 0, segment.length);
        // Invoke the focal method
        BigDecimal result = textBuffer.contentsAsDecimal();
        // Verify the result
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    public void testContentsAsDecimal_WithNegativeValue() {
        // Set up the current segment with a negative decimal string
        String decimalString = "-123.45";
        textBuffer.setCurrentLength(decimalString.length());
        char[] segment = decimalString.toCharArray();
        System.arraycopy(segment, 0, textBuffer.getCurrentSegment(), 0, segment.length);
        // Invoke the focal method
        BigDecimal result = textBuffer.contentsAsDecimal();
        // Verify the result
        assertEquals(new BigDecimal("-123.45"), result);
    }

    @Test
    public void testContentsAsDecimal_WithInvalidString() {
        // Set up the current segment with an invalid decimal string
        String invalidDecimalString = "abc";
        textBuffer.setCurrentLength(invalidDecimalString.length());
        char[] segment = invalidDecimalString.toCharArray();
        System.arraycopy(segment, 0, textBuffer.getCurrentSegment(), 0, segment.length);
        // Verify that NumberFormatException is thrown
        assertThrows(NumberFormatException.class, () -> textBuffer.contentsAsDecimal());
    }

    @Test
    public void testContentsAsDecimal_WithEmptyString() {
        // Set up the current segment with an empty string
        String emptyString = "";
        textBuffer.setCurrentLength(emptyString.length());
        char[] segment = emptyString.toCharArray();
        System.arraycopy(segment, 0, textBuffer.getCurrentSegment(), 0, segment.length);
        // Verify that NumberFormatException is thrown
        assertThrows(NumberFormatException.class, () -> textBuffer.contentsAsDecimal());
    }
}
