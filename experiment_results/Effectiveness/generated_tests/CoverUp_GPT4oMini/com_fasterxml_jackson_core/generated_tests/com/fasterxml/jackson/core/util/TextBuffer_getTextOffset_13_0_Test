package com.fasterxml.jackson.core.util;

import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.NumberInput;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;

public class TextBuffer_getTextOffset_13_0_Test {

    private TextBuffer textBuffer;

    @BeforeEach
    public void setUp() {
        textBuffer = new TextBuffer(null);
    }

    @Test
    public void testGetTextOffsetWithPositiveInputStart() throws Exception {
        // Set _inputStart to a positive value using reflection
        setPrivateField(textBuffer, "_inputStart", 10);
        int offset = textBuffer.getTextOffset();
        assertEquals(10, offset);
    }

    @Test
    public void testGetTextOffsetWithNegativeInputStart() throws Exception {
        // Set _inputStart to a negative value using reflection
        setPrivateField(textBuffer, "_inputStart", -1);
        int offset = textBuffer.getTextOffset();
        assertEquals(0, offset);
    }

    @Test
    public void testGetTextOffsetWithZeroInputStart() throws Exception {
        // Set _inputStart to zero using reflection
        setPrivateField(textBuffer, "_inputStart", 0);
        int offset = textBuffer.getTextOffset();
        assertEquals(0, offset);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
