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

public class UTF8JsonGenerator__writeBytes_51_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, true);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteBytes_Success() throws Exception {
        byte[] input = { 1, 2, 3, 4, 5 };
        invokeWriteBytes(input);
        assertArrayEquals(input, outputStream.toByteArray());
    }

    @Test
    public void testWriteBytes_BufferFlush() throws Exception {
        // More than MAX_BYTES_TO_BUFFER
        byte[] input = new byte[513];
        for (int i = 0; i < input.length; i++) {
            input[i] = (byte) i;
        }
        invokeWriteBytes(input);
        // Output stream should contain the first 512 bytes
        byte[] expectedOutput = new byte[512];
        System.arraycopy(input, 0, expectedOutput, 0, 512);
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    private void invokeWriteBytes(byte[] bytes) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeBytes", byte[].class);
        method.setAccessible(true);
        method.invoke(generator, (Object) bytes);
    }
}
