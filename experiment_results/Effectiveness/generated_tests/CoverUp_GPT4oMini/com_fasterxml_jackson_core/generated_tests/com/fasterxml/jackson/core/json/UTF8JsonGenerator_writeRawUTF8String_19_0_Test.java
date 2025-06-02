package com.fasterxml.jackson.core.json;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;

public class UTF8JsonGenerator_writeRawUTF8String_19_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() throws UnsupportedEncodingException {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = mock(IOContext.class);
        when(ioContext.allocWriteEncodingBuffer()).thenReturn(new byte[512]);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteRawUTF8String() throws Exception {
        byte[] input = "Hello".getBytes("UTF-8");
        generator.writeRawUTF8String(input, 0, input.length);
        // Check if the output is as expected
        byte[] expected = new byte[] { '"', 'H', 'e', 'l', 'l', 'o', '"' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteRawUTF8String_FlushBuffer() throws Exception {
        // Larger than buffer
        byte[] input = new byte[600];
        for (int i = 0; i < input.length; i++) {
            input[i] = 'A';
        }
        generator.writeRawUTF8String(input, 0, input.length);
        // Check if the output is as expected
        // Ensure something was written
        assertTrue(outputStream.size() > 0);
    }

    @Test
    public void testWriteRawUTF8String_WithOffsetAndLength() throws Exception {
        byte[] input = "World".getBytes("UTF-8");
        generator.writeRawUTF8String(input, 0, 5);
        // Check if the output is as expected
        byte[] expected = new byte[] { '"', 'W', 'o', 'r', 'l', 'd', '"' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteRawUTF8String_EmptyInput() throws Exception {
        byte[] input = new byte[0];
        generator.writeRawUTF8String(input, 0, 0);
        // Check if the output is as expected (just quotes)
        byte[] expected = new byte[] { '"', '"' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteRawUTF8String_NegativeOffset() {
        byte[] input = "Test".getBytes();
        Exception exception = assertThrows(IOException.class, () -> {
            generator.writeRawUTF8String(input, -1, 4);
        });
        assertEquals("Index out of bounds", exception.getMessage());
    }

    @Test
    public void testWriteRawUTF8String_OverflowLength() {
        byte[] input = "Test".getBytes();
        Exception exception = assertThrows(IOException.class, () -> {
            generator.writeRawUTF8String(input, 0, 10);
        });
        assertEquals("Index out of bounds", exception.getMessage());
    }

    private void invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = UTF8JsonGenerator.class.getDeclaredMethod(methodName, byte[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, args);
    }
}
