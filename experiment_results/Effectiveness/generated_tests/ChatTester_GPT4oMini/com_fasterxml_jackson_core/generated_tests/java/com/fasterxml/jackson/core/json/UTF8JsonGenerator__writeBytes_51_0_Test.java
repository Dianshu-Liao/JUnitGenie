package com.fasterxml.jackson.core.json;

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

public class UTF8JsonGenerator__writeBytes_51_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        generator = new UTF8JsonGenerator(Mockito.mock(IOContext.class), 0, Mockito.mock(ObjectCodec.class), outputStream, '"');
    }

    @Test
    public void testWriteBytesWithinBufferLimit() throws Exception {
        byte[] bytes = { 'h', 'e', 'l', 'l', 'o' };
        invokePrivateMethod(generator, "_writeBytes", bytes);
        assertArrayEquals(new byte[] { 'h', 'e', 'l', 'l', 'o' }, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytesExceedingBufferLimit() throws Exception {
        // Exceeds MAX_BYTES_TO_BUFFER
        byte[] bytes = new byte[600];
        for (int i = 0; i < 600; i++) {
            // Fill with some data
            bytes[i] = (byte) ('a' + (i % 26));
        }
        invokePrivateMethod(generator, "_writeBytes", bytes);
        // Verify that the output stream received the bytes
        assertArrayEquals(bytes, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytesExactBufferLimit() throws Exception {
        // Exactly MAX_BYTES_TO_BUFFER
        byte[] bytes = new byte[512];
        for (int i = 0; i < 512; i++) {
            // Fill with some data
            bytes[i] = (byte) ('a' + (i % 26));
        }
        invokePrivateMethod(generator, "_writeBytes", bytes);
        assertArrayEquals(bytes, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytesZeroLength() throws Exception {
        // Zero length
        byte[] bytes = new byte[0];
        invokePrivateMethod(generator, "_writeBytes", bytes);
        assertArrayEquals(new byte[0], outputStream.toByteArray());
    }

    @Test
    public void testWriteBytesWhenFlushBufferCalled() throws Exception {
        // Simulate the condition where the buffer needs to be flushed
        // Fill the buffer
        byte[] initialBytes = new byte[512];
        for (int i = 0; i < 512; i++) {
            initialBytes[i] = (byte) ('a' + (i % 26));
        }
        invokePrivateMethod(generator, "_writeBytes", initialBytes);
        // Now write additional bytes that will exceed the buffer limit
        byte[] additionalBytes = { 'x', 'y', 'z' };
        invokePrivateMethod(generator, "_writeBytes", additionalBytes);
        // Verify the output stream has both the initial and additional bytes
        // 512 + 3
        byte[] expectedOutput = new byte[515];
        System.arraycopy(initialBytes, 0, expectedOutput, 0, 512);
        expectedOutput[512] = 'x';
        expectedOutput[513] = 'y';
        expectedOutput[514] = 'z';
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    private void invokePrivateMethod(Object obj, String methodName, Object... args) throws Exception {
        java.lang.reflect.Method method = obj.getClass().getDeclaredMethod(methodName, byte[].class);
        method.setAccessible(true);
        method.invoke(obj, (Object) args);
    }
}
