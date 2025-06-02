package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator__writeUTF8Segment2_68_3_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = Mockito.mock(IOContext.class);
        Mockito.when(ioContext.allocWriteEncodingBuffer()).thenReturn(new byte[512]);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteUTF8Segment2_NoEscapes() throws IOException, JsonGenerationException {
        byte[] input = "Hello".getBytes("UTF-8");
        invokePrivateWriteUTF8Segment2(generator, input, 0, input.length);
        assertEquals("Hello", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteUTF8Segment2_WithEscapes() throws IOException, JsonGenerationException {
        // '\n' should be escaped
        byte[] input = "Hello\nWorld".getBytes("UTF-8");
        invokePrivateWriteUTF8Segment2(generator, input, 0, input.length);
        assertEquals("Hello\\nWorld", outputStream.toString("UTF-8"));
    }

    @Test
    public void testWriteUTF8Segment2_FlushBuffer() throws IOException, JsonGenerationException {
        // Simulate buffer almost full
        generator._outputTail = 510;
        byte[] input = "Hello".getBytes("UTF-8");
        invokePrivateWriteUTF8Segment2(generator, input, 0, input.length);
        assertEquals("Hello", outputStream.toString("UTF-8"));
    }

    private void invokePrivateWriteUTF8Segment2(UTF8JsonGenerator generator, byte[] utf8, int offset, int len) {
        try {
            Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeUTF8Segment2", byte[].class, int.class, int.class);
            method.setAccessible(true);
            method.invoke(generator, utf8, offset, len);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
