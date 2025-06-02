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

public class ReaderBasedJsonParser_releaseBuffered_0_0_Test extends ReaderBasedJsonParser {

    private Writer writer;

    public ReaderBasedJsonParser_releaseBuffered_0_0_Test() {
        super(new IOContext(null, new BufferRecycler(), null, true), 0, null, null, CharsToNameCanonicalizer.createRoot());
    }

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        _inputBuffer = "test".toCharArray();
        setInputPtr(0);
        setInputEnd(4);
    }

    private void setInputPtr(int ptr) {
        try {
            java.lang.reflect.Field field = ReaderBasedJsonParser.class.getDeclaredField("_inputPtr");
            field.setAccessible(true);
            field.setInt(this, ptr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setInputEnd(int end) {
        try {
            java.lang.reflect.Field field = ReaderBasedJsonParser.class.getDeclaredField("_inputEnd");
            field.setAccessible(true);
            field.setInt(this, end);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testReleaseBuffered_WhenCountIsLessThanOne_ShouldReturnZero() throws IOException {
        setInputEnd(0);
        setInputPtr(0);
        int result = releaseBuffered(writer);
        assertEquals(0, result);
        assertEquals("", writer.toString());
    }

    @Test
    public void testReleaseBuffered_WhenCountIsZero_ShouldReturnZero() throws IOException {
        setInputEnd(1);
        setInputPtr(1);
        int result = releaseBuffered(writer);
        assertEquals(0, result);
        assertEquals("", writer.toString());
    }

    @Test
    public void testReleaseBuffered_WhenCountIsGreaterThanZero_ShouldReturnCount() throws IOException {
        setInputEnd(4);
        setInputPtr(0);
        int result = releaseBuffered(writer);
        assertEquals(4, result);
        assertEquals("test", writer.toString());
    }
}
