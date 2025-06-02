package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
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

class UTF8JsonGenerator_writeRaw_25_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, null, null, null, null, true);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteRaw_WithAsciiCharacters() throws IOException {
        char[] input = "Hello".toCharArray();
        generator.writeRaw(input, 0, input.length);
        byte[] expected = "Hello".getBytes("UTF-8");
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_WithMultiByteCharacters() throws IOException {
        // includes multi-byte characters
        char[] input = "Hello, 世界".toCharArray();
        generator.writeRaw(input, 0, input.length);
        byte[] expected = "Hello, 世界".getBytes("UTF-8");
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_WithSurrogateCharacters() throws IOException {
        // Grinning Face Emoji
        char[] input = new char[] { '\uD83D', '\uDE00' };
        generator.writeRaw(input, 0, input.length);
        // UTF-8 bytes for emoji
        byte[] expected = new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_WithFlush() throws IOException {
        // More than the buffer size
        char[] input = new char[600];
        for (int i = 0; i < input.length; i++) {
            input[i] = 'A';
        }
        generator.writeRaw(input, 0, input.length);
        byte[] expected = new byte[600];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = 'A';
        }
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_WithEmptyInput() throws IOException {
        char[] input = new char[0];
        generator.writeRaw(input, 0, 0);
        assertArrayEquals(new byte[0], outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_WithBoundaryConditions() throws IOException {
        char[] input = "A".toCharArray();
        generator.writeRaw(input, 0, 1);
        assertArrayEquals("A".getBytes("UTF-8"), outputStream.toByteArray());
    }
}
