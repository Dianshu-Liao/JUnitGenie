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

public class UTF8JsonGenerator__writeStringSegmentASCII2_60_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, null, null, true);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteStringSegmentASCII2() throws Exception {
        char[] input = "Hello, World!".toCharArray();
        int offset = 0;
        int end = input.length;
        // Use reflection to access the private method
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeStringSegmentASCII2", char[].class, int.class, int.class);
        method.setAccessible(true);
        // Call the method
        method.invoke(generator, input, offset, end);
        // Verify the output
        // Expected byte output
        byte[] expectedOutput = "Hello, World!".getBytes();
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteStringSegmentWithEscapes() throws Exception {
        char[] input = "Hello, \"World!\"".toCharArray();
        int offset = 0;
        int end = input.length;
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeStringSegmentASCII2", char[].class, int.class, int.class);
        method.setAccessible(true);
        // Set to escape the quote character
        generator.setHighestNonEscapedChar(127);
        method.invoke(generator, input, offset, end);
        // Expected byte output with escapes
        byte[] expectedOutput = "Hello, \\\"World!\\\"".getBytes();
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteStringSegmentWithNonASCII() throws Exception {
        char[] input = "Hello, 世界!".toCharArray();
        int offset = 0;
        int end = input.length;
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeStringSegmentASCII2", char[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, input, offset, end);
        // Expected byte output for non-ASCII characters
        byte[] expectedOutput = new byte[] { // Expected byte representation for '世' and '界'
        // Expected byte representation for '世' and '界'
        // Expected byte representation for '世' and '界'
        'H', // Expected byte representation for '世' and '界'
        'e', // Expected byte representation for '世' and '界'
        'l', // Expected byte representation for '世' and '界'
        'l', // Expected byte representation for '世' and '界'
        'o', ',', ' ', (byte) 0xe4, (byte) 0xb8, (byte) 0x96, (byte) 0xe7, (byte) 0x95, (byte) 0x8c, '!' };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test
    public void testWriteStringSegmentBufferFlush() throws Exception {
        // Large input to force buffer flush
        char[] input = new char[1000];
        for (int i = 0; i < input.length; i++) {
            // Fill with 'a'
            input[i] = 'a';
        }
        int offset = 0;
        int end = input.length;
        Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeStringSegmentASCII2", char[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, input, offset, end);
        byte[] expectedOutput = new byte[1000];
        for (int i = 0; i < expectedOutput.length; i++) {
            // Expected output
            expectedOutput[i] = 'a';
        }
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }
}
