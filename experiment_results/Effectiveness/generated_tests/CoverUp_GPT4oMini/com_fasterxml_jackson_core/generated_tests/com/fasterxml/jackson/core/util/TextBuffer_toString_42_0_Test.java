package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.TextBuffer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.NumberInput;

class TextBuffer_toString_42_0_Test {

    private TextBuffer textBuffer;

    private BufferRecycler bufferRecycler;

    @BeforeEach
    void setUp() {
        bufferRecycler = new BufferRecycler();
        textBuffer = new TextBuffer(bufferRecycler);
    }

    @Test
    void testToString_EmptyBuffer() throws IOException {
        // Setup the current segment to be empty
        textBuffer.setCurrentLength(0);
        String result = textBuffer.toString();
        assertEquals("", result);
    }

    @Test
    void testToString_NonEmptyBuffer() throws IOException {
        // Setup the current segment with some content
        char[] initialSegment = "Hello, World!".toCharArray();
        textBuffer.setCurrentAndReturn(initialSegment.length);
        System.arraycopy(initialSegment, 0, textBuffer.getCurrentSegment(), 0, initialSegment.length);
        String result = textBuffer.toString();
        assertEquals("Hello, World!", result);
    }

    @Test
    void testToString_ExceptionHandling() throws IOException {
        // Simulate an IOException by using reflection to set a private field
        // Simulating conditions that lead to IOException
        setPrivateField(textBuffer, "_resultString", null);
        String result = textBuffer.toString();
        assertEquals("TextBuffer: Exception when reading contents", result);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
