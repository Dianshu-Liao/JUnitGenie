package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
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
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator__writeBytes_52_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = new IOContext(null, null, null, null, null, true);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteBytes_withinBuffer() throws Exception {
        byte[] input = { 1, 2, 3, 4, 5 };
        invokeWriteBytes(input, 0, 5);
        assertArrayEquals(input, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_exceedBufferFlush() throws Exception {
        // Set a small buffer
        generator._outputBuffer = new byte[3];
        generator._outputTail = 0;
        // More than the buffer size
        byte[] input = { 1, 2, 3, 4, 5 };
        invokeWriteBytes(input, 0, 5);
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_largeInput() throws Exception {
        // Larger than MAX_BYTES_TO_BUFFER
        byte[] input = new byte[600];
        for (int i = 0; i < input.length; i++) {
            input[i] = (byte) i;
        }
        invokeWriteBytes(input, 0, 600);
        assertArrayEquals(input, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_zeroLength() throws Exception {
        byte[] input = { 1, 2, 3, 4, 5 };
        // Write zero bytes
        invokeWriteBytes(input, 0, 0);
        assertArrayEquals(new byte[] {}, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_negativeLength() {
        byte[] input = { 1, 2, 3, 4, 5 };
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            // Negative length should throw exception
            invokeWriteBytes(input, 0, -1);
        });
    }

    private void invokeWriteBytes(byte[] bytes, int offset, int len) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeBytes", byte[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, bytes, offset, len);
    }
}
