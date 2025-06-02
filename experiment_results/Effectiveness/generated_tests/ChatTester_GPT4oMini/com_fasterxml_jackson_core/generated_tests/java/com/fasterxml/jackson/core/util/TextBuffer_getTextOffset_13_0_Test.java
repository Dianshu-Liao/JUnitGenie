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

public class TextBuffer_getTextOffset_13_0_Test {

    private BufferRecycler mockAllocator;

    private TextBuffer textBuffer;

    @BeforeEach
    public void setUp() {
        mockAllocator = new BufferRecycler();
        textBuffer = new TextBuffer(mockAllocator);
    }

    @Test
    public void testGetTextOffset_WithPositiveInputStart() throws Exception {
        // Using reflection to set private field _inputStart
        setPrivateField(textBuffer, "_inputStart", 10);
        int offset = textBuffer.getTextOffset();
        assertEquals(10, offset);
    }

    @Test
    public void testGetTextOffset_WithZeroInputStart() throws Exception {
        setPrivateField(textBuffer, "_inputStart", 0);
        int offset = textBuffer.getTextOffset();
        assertEquals(0, offset);
    }

    @Test
    public void testGetTextOffset_WithNegativeInputStart() throws Exception {
        setPrivateField(textBuffer, "_inputStart", -5);
        int offset = textBuffer.getTextOffset();
        assertEquals(0, offset);
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
