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

public class UTF8JsonGenerator__writeBytes_52_1_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Assuming IOContext and ObjectCodec are properly mocked or instantiated
        IOContext ctxt = Mockito.mock(IOContext.class);
        ObjectCodec codec = Mockito.mock(ObjectCodec.class);
        generator = new UTF8JsonGenerator(ctxt, 0, codec, outputStream, '"');
    }

    @Test
    public void testWriteBytes_Success() throws Exception {
        byte[] bytes = new byte[] { 1, 2, 3, 4, 5 };
        int offset = 0;
        int len = 5;
        invokeWriteBytes(bytes, offset, len);
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_BufferFlush() throws Exception {
        // Prepare generator with a small buffer
        byte[] outputBuffer = new byte[5];
        setOutputBuffer(generator, outputBuffer, 0, true);
        // 6 bytes to trigger flush
        byte[] bytes = new byte[] { 1, 2, 3, 4, 5, 6 };
        int offset = 0;
        int len = 6;
        invokeWriteBytes(bytes, offset, len);
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5, 6 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_ExceedsMaxBytes() throws Exception {
        // Exceeding MAX_BYTES_TO_BUFFER
        byte[] bytes = new byte[1000];
        int offset = 0;
        int len = 1000;
        assertDoesNotThrow(() -> invokeWriteBytes(bytes, offset, len));
        assertEquals(1000, outputStream.size());
    }

    @Test
    public void testWriteBytes_PartialFlush() throws Exception {
        // Prepare generator with a small buffer
        byte[] outputBuffer = new byte[5];
        setOutputBuffer(generator, outputBuffer, 0, true);
        // 3 bytes to fit in the buffer
        byte[] bytes = new byte[] { 1, 2, 3 };
        int offset = 0;
        int len = 3;
        invokeWriteBytes(bytes, offset, len);
        assertArrayEquals(new byte[] { 1, 2, 3 }, outputStream.toByteArray());
    }

    private void invokeWriteBytes(byte[] bytes, int offset, int len) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeBytes", byte[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, bytes, offset, len);
    }

    private void setOutputBuffer(UTF8JsonGenerator generator, byte[] outputBuffer, int outputOffset, boolean bufferRecyclable) throws Exception {
        java.lang.reflect.Field field = UTF8JsonGenerator.class.getDeclaredField("_outputBuffer");
        field.setAccessible(true);
        field.set(generator, outputBuffer);
        field = UTF8JsonGenerator.class.getDeclaredField("_outputTail");
        field.setAccessible(true);
        field.set(generator, outputOffset);
        field = UTF8JsonGenerator.class.getDeclaredField("_bufferRecyclable");
        field.setAccessible(true);
        field.set(generator, bufferRecyclable);
    }
}
