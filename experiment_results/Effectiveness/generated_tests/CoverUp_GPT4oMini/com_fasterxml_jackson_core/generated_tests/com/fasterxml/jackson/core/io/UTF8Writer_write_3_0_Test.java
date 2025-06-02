package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.UTF8Writer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;

public class UTF8Writer_write_3_0_Test {

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    private UTF8Writer utf8Writer;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = new IOContext(null, null, null, null, null, true);
        utf8Writer = new UTF8Writer(ioContext, outputStream);
    }

    @Test
    public void testWriteSingleAsciiCharacter() throws IOException {
        char[] input = { 'A' };
        utf8Writer.write(input);
        byte[] expected = { 'A' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteMultipleAsciiCharacters() throws IOException {
        char[] input = { 'H', 'e', 'l', 'l', 'o' };
        utf8Writer.write(input);
        byte[] expected = { 'H', 'e', 'l', 'l', 'o' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteSingleNonAsciiCharacter() throws IOException {
        char[] input = { 'é' };
        utf8Writer.write(input);
        // UTF-8 encoding for 'é'
        byte[] expected = { (byte) 0xc3, (byte) 0xa9 };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteSurrogates() throws IOException {
        // Valid surrogate pair for U+10000
        char[] input = { 0xD800, 0xDC00 };
        utf8Writer.write(input);
        // UTF-8 encoding for U+10000
        byte[] expected = { (byte) 0xf0, (byte) 0x90, (byte) 0x80, (byte) 0x80 };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteEmptyArray() throws IOException {
        char[] input = {};
        utf8Writer.write(input);
        byte[] expected = {};
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteSingleCharacter() throws IOException {
        char[] input = { 'B' };
        utf8Writer.write(input);
        byte[] expected = { 'B' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test
    public void testWriteWithSurrogateHandling() throws IOException {
        // Surrogate followed by an ASCII character
        char[] input = { 0xD800, 'A', 0xDC00 };
        utf8Writer.write(input);
        byte[] expected = { (byte) 0xf0, (byte) 0x90, (byte) 0x80, (byte) 0x80, 'A' };
        assertArrayEquals(expected, outputStream.toByteArray());
    }
}
