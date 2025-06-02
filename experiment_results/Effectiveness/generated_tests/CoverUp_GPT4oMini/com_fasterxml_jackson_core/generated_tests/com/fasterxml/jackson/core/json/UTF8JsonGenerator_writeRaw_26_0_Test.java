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

public class UTF8JsonGenerator_writeRaw_26_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteRawSingleByteCharacter() throws Exception {
        // ASCII character
        generator.writeRaw('A');
        assertArrayEquals(new byte[] { 65 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteRawTwoByteCharacter() throws Exception {
        // Unicode character
        generator.writeRaw('é');
        assertArrayEquals(new byte[] { (byte) 0xc3, (byte) 0xa9 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteRawThreeByteCharacter() throws Exception {
        // Euro sign
        generator.writeRaw('€');
        assertArrayEquals(new byte[] { (byte) 0xe2, (byte) 0x82, (byte) 0xac }, outputStream.toByteArray());
    }

    @Test
    public void testWriteRawFlushBuffer() throws Exception {
        // Fill the buffer to trigger a flush
        for (char ch = 0; ch < 600; ch++) {
            generator.writeRaw(ch);
        }
        // Use reflection to invoke _flushBuffer()
        Method flushBufferMethod = UTF8JsonGenerator.class.getDeclaredMethod("_flushBuffer");
        flushBufferMethod.setAccessible(true);
        flushBufferMethod.invoke(generator);
        // Verify that the output stream contains the expected bytes
        byte[] expectedOutput = new byte[600];
        for (int i = 0; i < expectedOutput.length; i++) {
            // Just for testing, can be adjusted as needed
            expectedOutput[i] = (byte) i;
        }
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }
}
