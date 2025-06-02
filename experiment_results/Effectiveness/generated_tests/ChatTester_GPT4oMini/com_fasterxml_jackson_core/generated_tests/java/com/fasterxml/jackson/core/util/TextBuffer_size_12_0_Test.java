// Test method
package com.fasterxml.jackson.core.util;

import java.lang.reflect.Method;
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

public class TextBuffer_size_12_0_Test {

    private TextBuffer textBuffer;

    private BufferRecycler allocator;

    @BeforeEach
    public void setUp() {
        allocator = new BufferRecycler();
        textBuffer = new TextBuffer(allocator);
    }

    @Test
    public void testSizeWithInputStartNegative() throws Exception {
        // Invoke private fields via reflection
        setPrivateField(textBuffer, "_inputStart", -1);
        setPrivateField(textBuffer, "_resultArray", null);
        setPrivateField(textBuffer, "_resultString", null);
        setPrivateField(textBuffer, "_segmentSize", 10);
        setPrivateField(textBuffer, "_currentSize", 5);
        int size = textBuffer.size();
        assertEquals(15, size);
    }

    @Test
    public void testSizeWithInputStartNonNegative() throws Exception {
        setPrivateField(textBuffer, "_inputStart", 0);
        setPrivateField(textBuffer, "_inputLen", 20);
        int size = textBuffer.size();
        assertEquals(20, size);
    }

    @Test
    public void testSizeWithResultArray() throws Exception {
        setPrivateField(textBuffer, "_inputStart", -1);
        setPrivateField(textBuffer, "_resultArray", new char[30]);
        int size = textBuffer.size();
        assertEquals(30, size);
    }

    @Test
    public void testSizeWithResultString() throws Exception {
        setPrivateField(textBuffer, "_inputStart", -1);
        setPrivateField(textBuffer, "_resultArray", null);
        setPrivateField(textBuffer, "_resultString", "Hello");
        int size = textBuffer.size();
        assertEquals(5, size);
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
