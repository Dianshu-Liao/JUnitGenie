package com.fasterxml.jackson.core.json;

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

public class UTF8JsonGenerator__writeNull_77_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private final int BUFFER_SIZE = 512;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext context = new IOContext(null, outputStream, false);
        generator = new UTF8JsonGenerator(context, 0, null, outputStream, '"', new byte[BUFFER_SIZE], 0, true);
    }

    @Test
    public void testWriteNull() throws Exception {
        // Invoke the private _writeNull method using reflection
        java.lang.reflect.Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeNull");
        method.setAccessible(true);
        // Call the method
        method.invoke(generator);
        // Verify that the output stream contains the expected null representation
        assertArrayEquals(new byte[] { 'n', 'u', 'l', 'l' }, outputStream.toByteArray());
    }

    @Test
    public void testWriteNullFlushBuffer() throws Exception {
        // Fill the buffer to ensure it flushes
        for (int i = 0; i < BUFFER_SIZE - 4; i++) {
            // Fill with dummy data
            generator._outputBuffer[i] = (byte) 'a';
        }
        generator._outputTail = BUFFER_SIZE - 4;
        // Invoke the private _writeNull method
        java.lang.reflect.Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeNull");
        method.setAccessible(true);
        method.invoke(generator);
        // Verify that the output stream contains the expected null representation
        assertArrayEquals(new byte[] { 'a', 'a', 'a', 'a', 'n', 'u', 'l', 'l' }, outputStream.toByteArray());
    }
}
