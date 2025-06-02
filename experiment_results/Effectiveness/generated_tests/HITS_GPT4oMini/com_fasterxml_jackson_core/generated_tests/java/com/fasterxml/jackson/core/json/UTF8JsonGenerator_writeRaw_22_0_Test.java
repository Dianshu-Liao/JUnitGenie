package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
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

public class UTF8JsonGenerator_writeRaw_22_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = new IOContext(new BufferRecycler(), outputStream, true);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteRaw_ValidInput() throws IOException {
        String input = "Hello, World!";
        generator.writeRaw(input, 0, input.length());
        byte[] expected = "Hello, World!".getBytes("UTF-8");
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_EmptyString() throws IOException {
        String input = "";
        generator.writeRaw(input, 0, input.length());
        assertArrayEquals(new byte[0], outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_NegativeOffset() {
        String input = "Hello";
        assertThrows(IndexOutOfBoundsException.class, () -> {
            generator.writeRaw(input, -1, 3);
        });
    }

    @Test
    public void testWriteRaw_OffsetOutOfBounds() {
        String input = "Hello";
        assertThrows(IndexOutOfBoundsException.class, () -> {
            generator.writeRaw(input, 6, 1);
        });
    }

    @Test
    public void testWriteRaw_LengthOutOfBounds() {
        String input = "Hello";
        assertThrows(IndexOutOfBoundsException.class, () -> {
            generator.writeRaw(input, 0, 10);
        });
    }

    @Test
    public void testWriteRaw_SurrogateCharacter() throws IOException {
        // Grinning Face Emoji
        String input = "\uD83D\uDE00";
        generator.writeRaw(input, 0, input.length());
        byte[] expected = new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteRaw_MultipleChunks() throws IOException {
        String input = "This is a long string that will be split into multiple chunks.";
        generator.writeRaw(input, 0, input.length());
        byte[] expected = input.getBytes("UTF-8");
        assertArrayEquals(expected, outputStream.toByteArray());
    }
}
