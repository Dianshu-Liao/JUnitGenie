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

    private ByteArrayOutputStream outputStream;

    private UTF8JsonGenerator jsonGenerator;

    private static final int OUTPUT_BUFFER_SIZE = 10;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        jsonGenerator = new UTF8JsonGenerator(new IOContext(null, outputStream, false), 0, null, outputStream, '"', new byte[OUTPUT_BUFFER_SIZE], 0, true);
    }

    private void invokeWriteBytes(byte[] bytes, int offset, int length) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeBytes", byte[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(jsonGenerator, bytes, offset, length);
    }

    @Test
    public void testWriteBytes_WhenOutputTailPlusLengthExceedsOutputEnd_ShouldFlushBuffer() throws Exception {
        // Arrange
        byte[] bytesToWrite = { 1, 2, 3, 4, 5 };
        // Set output tail close to the end
        jsonGenerator._outputTail = OUTPUT_BUFFER_SIZE - 2;
        // Act
        invokeWriteBytes(bytesToWrite, 0, bytesToWrite.length);
        // Assert
        assertArrayEquals(new byte[] { 0, 0, 0, 0, 0, 1, 2, 3, 4, 5 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_WhenLengthIsGreaterThanMaxBytesToBuffer_ShouldWriteDirectlyToOutputStream() throws Exception {
        // Arrange
        byte[] bytesToWrite = new byte[OUTPUT_BUFFER_SIZE + 1];
        for (int i = 0; i < bytesToWrite.length; i++) {
            bytesToWrite[i] = (byte) i;
        }
        // Set output tail to buffer size
        jsonGenerator._outputTail = OUTPUT_BUFFER_SIZE;
        // Act
        invokeWriteBytes(bytesToWrite, 0, bytesToWrite.length);
        // Assert
        assertArrayEquals(bytesToWrite, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_WhenBufferHasSpace_ShouldWriteToBuffer() throws Exception {
        // Arrange
        byte[] bytesToWrite = { 1, 2, 3 };
        // Set output tail to start of buffer
        jsonGenerator._outputTail = 0;
        // Act
        invokeWriteBytes(bytesToWrite, 0, bytesToWrite.length);
        // Assert
        assertArrayEquals(new byte[] { 1, 2, 3 }, new byte[] { jsonGenerator._outputBuffer[0], jsonGenerator._outputBuffer[1], jsonGenerator._outputBuffer[2] });
    }
}
