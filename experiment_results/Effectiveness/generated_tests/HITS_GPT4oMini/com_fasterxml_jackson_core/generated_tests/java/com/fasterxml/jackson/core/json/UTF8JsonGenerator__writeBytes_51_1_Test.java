package com.fasterxml.jackson.core.json;

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
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator__writeBytes_51_1_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext context = Mockito.mock(IOContext.class);
        Mockito.when(context.allocWriteEncodingBuffer()).thenReturn(new byte[512]);
        generator = new UTF8JsonGenerator(context, 0, null, outputStream, '"');
    }

    private void invokeWriteBytes(byte[] data, int offset, int length) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeBytes", byte[].class);
        method.setAccessible(true);
        method.invoke(generator, new Object[] { data });
    }

    @Test
    public void testWriteBytes_WithNormalData() throws Exception {
        byte[] data = { 1, 2, 3, 4, 5 };
        invokeWriteBytes(data, 0, data.length);
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_WithBufferFlush() throws Exception {
        byte[] data = new byte[513];
        for (int i = 0; i < 513; i++) {
            data[i] = (byte) i;
        }
        invokeWriteBytes(data, 0, data.length);
        assertArrayEquals(data, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_WithEmptyArray() throws Exception {
        byte[] data = {};
        invokeWriteBytes(data, 0, data.length);
        assertArrayEquals(new byte[] {}, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_WithLargeData() throws Exception {
        byte[] data = new byte[1024];
        for (int i = 0; i < 1024; i++) {
            data[i] = (byte) (i % 256);
        }
        invokeWriteBytes(data, 0, data.length);
        assertArrayEquals(data, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_WithMaxBufferSize() throws Exception {
        byte[] data = new byte[512];
        for (int i = 0; i < 512; i++) {
            data[i] = (byte) i;
        }
        invokeWriteBytes(data, 0, data.length);
        assertArrayEquals(data, outputStream.toByteArray());
    }
}
