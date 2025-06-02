package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
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

public class UTF8JsonGenerator__writeGenericEscape_78_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
        // Initialize with a buffer
        generator._outputBuffer = new byte[512];
        // Reset output tail
        generator._outputTail = 0;
    }

    @Test
    public void testWriteGenericEscapeWithControlChar() throws Exception {
        // Line Feed
        invokeWriteGenericEscape(0x0A);
        // Expected output for LF
        byte[] expectedOutput = new byte[] { '\\', 'u', '0', '0', '0', 'a' };
        assertArrayEquals(expectedOutput, getOutputBuffer());
    }

    @Test
    public void testWriteGenericEscapeWithHighChar() throws Exception {
        // Unicode character U+0100
        invokeWriteGenericEscape(0x0100);
        // Expected output for U+0100
        byte[] expectedOutput = new byte[] { '\\', 'u', '0', '1', '0', '0' };
        assertArrayEquals(expectedOutput, getOutputBuffer());
    }

    @Test
    public void testWriteGenericEscapeWithLowChar() throws Exception {
        // DEL character
        invokeWriteGenericEscape(0x007F);
        // Expected output for DEL
        byte[] expectedOutput = new byte[] { '\\', 'u', '0', '0', '7', 'f' };
        assertArrayEquals(expectedOutput, getOutputBuffer());
    }

    private void invokeWriteGenericEscape(int charToEscape) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeGenericEscape", int.class, int.class);
        method.setAccessible(true);
        generator._outputTail = (int) method.invoke(generator, charToEscape, generator._outputTail);
    }

    private byte[] getOutputBuffer() {
        byte[] output = new byte[generator._outputTail];
        System.arraycopy(generator._outputBuffer, 0, output, 0, generator._outputTail);
        return output;
    }
}
