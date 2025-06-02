package com.fasterxml.jackson.core.json;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;

class UTF8JsonGenerator__writeStringSegmentASCII2_61_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext context = Mockito.mock(IOContext.class);
        Mockito.when(context.allocWriteEncodingBuffer()).thenReturn(new byte[512]);
        generator = new UTF8JsonGenerator(context, 0, null, outputStream, '"');
    }

    @Test
    void testWriteStringSegmentASCII2_NormalString() throws Exception {
        String input = "Hello";
        invokeWriteStringSegmentASCII2(input, 0, input.length());
        assertEquals("Hello", outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteStringSegmentASCII2_EscapedCharacters() throws Exception {
        String input = "Hello\nWorld\t!";
        invokeWriteStringSegmentASCII2(input, 0, input.length());
        String expected = "Hello\\nWorld\\t!";
        assertEquals(expected, outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteStringSegmentASCII2_NonASCIICharacters() throws Exception {
        String input = "Hello, 世界!";
        invokeWriteStringSegmentASCII2(input, 0, input.length());
        String expected = "Hello, \\u4e16\\u754c!";
        assertEquals(expected, outputStream.toString("UTF-8"));
    }

    @Test
    void testWriteStringSegmentASCII2_BufferFlush() throws Exception {
        // Prepare a string that will exceed the buffer size
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            input.append("Hello");
        }
        invokeWriteStringSegmentASCII2(input.toString(), 0, input.length());
        // Check if buffer has flushed
        assertTrue(outputStream.size() > 512);
    }

    private void invokeWriteStringSegmentASCII2(String text, int offset, int end) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeStringSegmentASCII2", String.class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, text, offset, end);
    }
}
