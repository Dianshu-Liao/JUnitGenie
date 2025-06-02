package com.fasterxml.jackson.core.json;

import java.lang.reflect.Method;
import com.fasterxml.jackson.core.io.IOContext;
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
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator_writeNumber_31_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = mock(IOContext.class);
        when(ioContext.allocWriteEncodingBuffer()).thenReturn(new byte[512]);
        generator = new UTF8JsonGenerator(ioContext, 0, mock(ObjectCodec.class), outputStream, '"');
    }

    @Test
    public void testWriteNumberPositiveShort() throws Exception {
        short number = 123;
        generator.writeNumber(number);
        assertEquals("123", outputStream.toString());
    }

    @Test
    public void testWriteNumberNegativeShort() throws Exception {
        short number = -123;
        generator.writeNumber(number);
        assertEquals("-123", outputStream.toString());
    }

    @Test
    public void testWriteNumberZero() throws Exception {
        short number = 0;
        generator.writeNumber(number);
        assertEquals("0", outputStream.toString());
    }

    @Test
    public void testWriteNumberFlushBuffer() throws Exception {
        // Fill the buffer to force a flush
        for (short i = 0; i < 1000; i++) {
            generator.writeNumber(i);
        }
        String result = outputStream.toString();
        // Check if the output is as expected
        assertTrue(result.contains("999"));
    }

    @Test
    public void testWriteQuotedShort() throws Exception {
        // Use reflection to access the private method _writeQuotedShort
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeQuotedShort", short.class);
        method.setAccessible(true);
        short number = 123;
        method.invoke(generator, number);
        assertEquals("\"123\"", outputStream.toString());
    }
}
