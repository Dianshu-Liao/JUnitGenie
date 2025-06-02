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

public class UTF8JsonGenerator__writeBytes_52_2_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8JsonGenerator generator;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, true);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteBytes_WhenBufferIsSufficient() throws IOException {
        byte[] inputBytes = new byte[] { 1, 2, 3, 4, 5 };
        generator._outputBuffer = new byte[10];
        generator._outputTail = 0;
        invokeWriteBytes(generator, inputBytes, 0, inputBytes.length);
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_WhenBufferIsFullAndFlushed() throws IOException {
        byte[] inputBytes = new byte[] { 1, 2, 3, 4, 5 };
        generator._outputBuffer = new byte[5];
        generator._outputTail = 5;
        invokeWriteBytes(generator, inputBytes, 0, inputBytes.length);
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_WhenInputLengthExceedsBuffer() throws IOException {
        byte[] inputBytes = new byte[600];
        for (int i = 0; i < inputBytes.length; i++) {
            inputBytes[i] = (byte) i;
        }
        generator._outputBuffer = new byte[10];
        generator._outputTail = 0;
        invokeWriteBytes(generator, inputBytes, 0, inputBytes.length);
        assertArrayEquals(new byte[600], outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_WhenWritingPartialBytes() throws IOException {
        byte[] inputBytes = new byte[] { 1, 2, 3, 4, 5 };
        generator._outputBuffer = new byte[10];
        generator._outputTail = 0;
        invokeWriteBytes(generator, inputBytes, 1, 3);
        assertArrayEquals(new byte[] { 2, 3, 4 }, outputStream.toByteArray());
    }

    private void invokeWriteBytes(UTF8JsonGenerator generator, byte[] bytes, int offset, int length) throws IOException {
        // Use reflection to access the private method
        try {
            Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeBytes", byte[].class, int.class, int.class);
            method.setAccessible(true);
            method.invoke(generator, bytes, offset, length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
