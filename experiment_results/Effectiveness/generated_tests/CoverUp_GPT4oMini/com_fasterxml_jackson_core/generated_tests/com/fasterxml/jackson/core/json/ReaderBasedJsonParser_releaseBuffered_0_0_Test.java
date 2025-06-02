package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class ReaderBasedJsonParser_releaseBuffered_0_0_Test {

    private ReaderBasedJsonParser parser;

    private Writer writer;

    private char[] inputBuffer;

    @BeforeEach
    public void setUp() {
        IOContext ioContext = mock(IOContext.class);
        CharsToNameCanonicalizer charsToNameCanonicalizer = mock(CharsToNameCanonicalizer.class);
        inputBuffer = "test data".toCharArray();
        parser = new ReaderBasedJsonParser(ioContext, 0, null, null, charsToNameCanonicalizer, inputBuffer, 0, inputBuffer.length, false);
        setInputPtr(0);
        setInputEnd(inputBuffer.length);
    }

    @Test
    public void testReleaseBuffered_WithData() throws IOException {
        writer = new StringWriter();
        int count = parser.releaseBuffered(writer);
        assertEquals(inputBuffer.length, count);
        assertEquals("test data", writer.toString());
    }

    @Test
    public void testReleaseBuffered_NoData() throws IOException {
        setInputPtr(getInputEnd());
        writer = new StringWriter();
        int count = parser.releaseBuffered(writer);
        assertEquals(0, count);
        assertEquals("", writer.toString());
    }

    @Test
    public void testReleaseBuffered_EmptyBuffer() throws IOException {
        setInputBuffer(new char[0]);
        setInputPtr(0);
        setInputEnd(0);
        writer = new StringWriter();
        int count = parser.releaseBuffered(writer);
        assertEquals(0, count);
        assertEquals("", writer.toString());
    }

    private void setInputPtr(int value) {
        try {
            java.lang.reflect.Field field = ReaderBasedJsonParser.class.getDeclaredField("_inputPtr");
            field.setAccessible(true);
            field.setInt(parser, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getInputPtr() {
        try {
            java.lang.reflect.Field field = ReaderBasedJsonParser.class.getDeclaredField("_inputPtr");
            field.setAccessible(true);
            return field.getInt(parser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setInputEnd(int value) {
        try {
            java.lang.reflect.Field field = ReaderBasedJsonParser.class.getDeclaredField("_inputEnd");
            field.setAccessible(true);
            field.setInt(parser, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getInputEnd() {
        try {
            java.lang.reflect.Field field = ReaderBasedJsonParser.class.getDeclaredField("_inputEnd");
            field.setAccessible(true);
            return field.getInt(parser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setInputBuffer(char[] buffer) {
        try {
            java.lang.reflect.Field field = ReaderBasedJsonParser.class.getDeclaredField("_inputBuffer");
            field.setAccessible(true);
            field.set(parser, buffer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
