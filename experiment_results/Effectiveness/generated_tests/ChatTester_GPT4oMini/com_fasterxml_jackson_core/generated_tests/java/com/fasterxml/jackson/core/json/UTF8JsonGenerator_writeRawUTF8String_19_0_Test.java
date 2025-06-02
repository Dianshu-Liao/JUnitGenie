package com.fasterxml.jackson.core.json;

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
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        generator = new UTF8JsonGenerator(Mockito.mock(IOContext.class), 0, Mockito.mock(ObjectCodec.class), outputStream, (char) '"');
    }

    @Test
    public void testWriteRawUTF8String() throws IOException {
        byte[] text = "Hello".getBytes("UTF-8");
        generator.writeRawUTF8String(text, 0, text.length);
        byte[] expected = new byte[] { '"', 'H', 'e', 'l', 'l', 'o', '"' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteRawUTF8StringWithFlush() throws IOException {
        byte[] text = new byte[512];
        for (int i = 0; i < 512; i++) {
            text[i] = 'A';
        }
        generator.writeRawUTF8String(text, 0, text.length);
        byte[] expected = new byte[514];
        expected[0] = '"';
        expected[expected.length - 1] = '"';
        for (int i = 1; i < expected.length - 1; i++) {
            expected[i] = 'A';
        }
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteRawUTF8StringWithOutOfBounds() {
        byte[] text = "Hello".getBytes(java.nio.charset.StandardCharsets.UTF_8);
        Exception exception = assertThrows(IOException.class, () -> {
            // out of bounds
            generator.writeRawUTF8String(text, 0, 10);
        });
        assertTrue(exception.getMessage().contains("Index out of bounds"));
    }

    @Test
    public void testWriteRawUTF8StringWithNegativeOffset() {
        byte[] text = "Hello".getBytes(java.nio.charset.StandardCharsets.UTF_8);
        Exception exception = assertThrows(IOException.class, () -> {
            generator.writeRawUTF8String(text, -1, text.length);
        });
        assertTrue(exception.getMessage().contains("Index out of bounds"));
    }

    @Test
    public void testWriteRawUTF8StringWithZeroLength() throws IOException {
        byte[] text = "Hello".getBytes(java.nio.charset.StandardCharsets.UTF_8);
        generator.writeRawUTF8String(text, 0, 0);
        byte[] expected = new byte[] { '"', '"' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteRawUTF8StringWithNonUTF8Bytes() throws IOException {
        byte[] text = new byte[] { (byte) 0xFF, (byte) 0xFE, (byte) 0xFD };
        generator.writeRawUTF8String(text, 0, text.length);
        byte[] expected = new byte[] { '"', (byte) 0xFF, (byte) 0xFE, (byte) 0xFD, '"' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }
}
