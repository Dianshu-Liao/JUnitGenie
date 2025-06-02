package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class ReaderBasedJsonParser_releaseBuffered_0_0_Test {

    private ReaderBasedJsonParser parser;

    private Writer writer;

    @BeforeEach
    public void setUp() {
        // Initialize dependencies
        CharsToNameCanonicalizer symbols = mock(CharsToNameCanonicalizer.class);
        ObjectCodec codec = mock(ObjectCodec.class);
        IOContext ctxt = mock(IOContext.class);
        // Initialize the parser with a buffer
        char[] inputBuffer = new char[10];
        parser = new ReaderBasedJsonParser(ctxt, 0, null, codec, symbols, inputBuffer, 0, 10, true);
        parser._inputBuffer = "HelloWorld".toCharArray();
        // Use reflection to set protected fields
        setProtectedField(parser, "_inputPtr", 0);
        setProtectedField(parser, "_inputEnd", 10);
        writer = new StringWriter();
    }

    @Test
    public void testReleaseBuffered_withFullBuffer() throws IOException {
        int count = parser.releaseBuffered(writer);
        assertEquals(10, count);
        assertEquals("HelloWorld", writer.toString());
    }

    @Test
    public void testReleaseBuffered_withEmptyBuffer() throws IOException {
        setProtectedField(parser, "_inputPtr", 10);
        setProtectedField(parser, "_inputEnd", 10);
        int count = parser.releaseBuffered(writer);
        assertEquals(0, count);
        assertEquals("", writer.toString());
    }

    @Test
    public void testReleaseBuffered_withPartialBuffer() throws IOException {
        setProtectedField(parser, "_inputPtr", 5);
        setProtectedField(parser, "_inputEnd", 10);
        int count = parser.releaseBuffered(writer);
        assertEquals(5, count);
        assertEquals("World", writer.toString());
    }

    @Test
    public void testReleaseBuffered_withZeroLengthBuffer() throws IOException {
        setProtectedField(parser, "_inputPtr", 0);
        setProtectedField(parser, "_inputEnd", 0);
        int count = parser.releaseBuffered(writer);
        assertEquals(0, count);
        assertEquals("", writer.toString());
    }

    @Test
    public void testReleaseBuffered_withNegativePointer() throws IOException {
        setProtectedField(parser, "_inputPtr", -1);
        setProtectedField(parser, "_inputEnd", 10);
        int count = parser.releaseBuffered(writer);
        assertEquals(0, count);
        assertEquals("", writer.toString());
    }

    private void setProtectedField(Object obj, String fieldName, int value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.setInt(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
