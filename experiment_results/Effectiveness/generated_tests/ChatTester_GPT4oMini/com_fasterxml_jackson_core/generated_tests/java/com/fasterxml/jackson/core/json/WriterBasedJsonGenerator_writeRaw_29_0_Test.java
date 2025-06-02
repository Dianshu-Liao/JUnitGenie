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

public class WriterBasedJsonGenerator_writeRaw_29_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        generator = new WriterBasedJsonGenerator(Mockito.mock(IOContext.class), 0, null, writer, '"');
        // Initialize the necessary fields to avoid NullPointerException
        generator._outputBuffer = new char[64];
        generator._outputTail = 0;
        generator._outputEnd = 64;
    }

    @Test
    public void testWriteRaw_ShortWrite() throws IOException {
        char[] input = "Hello".toCharArray();
        generator.writeRaw(input, 0, input.length);
        assertEquals("Hello", writer.toString());
    }

    @Test
    public void testWriteRaw_FlushBuffer() throws IOException {
        char[] input = "Hello, World!".toCharArray();
        // Reset the tail
        generator._outputTail = 0;
        // Set a small buffer size to force a flush
        generator._outputEnd = 10;
        generator.writeRaw(input, 0, input.length);
        assertEquals("Hello, World!", writer.toString());
    }

    @Test
    public void testWriteRaw_ExactBufferSize() throws IOException {
        char[] input = "Short".toCharArray();
        // Set tail close to the end
        generator._outputTail = 59;
        generator.writeRaw(input, 0, input.length);
        assertEquals("Short", writer.toString().substring(59));
    }

    @Test
    public void testWriteRaw_EmptyInput() throws IOException {
        char[] input = new char[0];
        generator.writeRaw(input, 0, 0);
        assertEquals("", writer.toString());
    }

    @Test
    public void testWriteRaw_NegativeLength() {
        char[] input = "Hello".toCharArray();
        assertThrows(IOException.class, () -> {
            generator.writeRaw(input, 0, -1);
        });
    }

    @Test
    public void testWriteRaw_OffsetOutOfBounds() {
        char[] input = "Hello".toCharArray();
        assertThrows(IOException.class, () -> {
            generator.writeRaw(input, 10, 1);
        });
    }

    @Test
    public void testWriteRaw_OffsetAndLengthOutOfBounds() {
        char[] input = "Hello".toCharArray();
        assertThrows(IOException.class, () -> {
            generator.writeRaw(input, 5, 1);
        });
    }

    @Test
    public void testWriteRaw_LargeInput() throws IOException {
        char[] input = new char[100];
        for (int i = 0; i < input.length; i++) {
            input[i] = 'A';
        }
        generator.writeRaw(input, 0, input.length);
        assertEquals(new String(input), writer.toString());
    }
}
