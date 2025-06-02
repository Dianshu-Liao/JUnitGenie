package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;

class UTF8Writer_write_4_0_Test {

    private UTF8Writer utf8Writer;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext context = Mockito.mock(IOContext.class);
        utf8Writer = new UTF8Writer(context, outputStream);
    }

    @Test
    void testWriteSingleAsciiCharacter() throws IOException {
        char[] input = { 'A' };
        utf8Writer.write(input, 0, 1);
        assertArrayEquals(new byte[] { 65 }, outputStream.toByteArray());
    }

    @Test
    void testWriteMultipleAsciiCharacters() throws IOException {
        char[] input = { 'H', 'e', 'l', 'l', 'o' };
        utf8Writer.write(input, 0, input.length);
        assertArrayEquals(new byte[] { 72, 101, 108, 108, 111 }, outputStream.toByteArray());
    }

    @Test
    void testWriteTwoByteCharacter() throws IOException {
        // Euro sign
        char[] input = { '€' };
        utf8Writer.write(input, 0, 1);
        assertArrayEquals(new byte[] { (byte) 0xE2, (byte) 0x82, (byte) 0xAC }, outputStream.toByteArray());
    }

    @Test
    void testWriteThreeByteCharacter() throws IOException {
        // Hiragana character
        char[] input = { 'あ' };
        utf8Writer.write(input, 0, 1);
        assertArrayEquals(new byte[] { (byte) 0xE3, (byte) 0x81, (byte) 0x82 }, outputStream.toByteArray());
    }

    @Test
    void testWriteSurrogatePair() throws IOException {
        // Grinning face emoji
        char[] input = { '\uD83D', '\uDE00' };
        utf8Writer.write(input, 0, 2);
        assertArrayEquals(new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 }, outputStream.toByteArray());
    }

    @Test
    void testWriteIllegalSurrogate() throws IOException {
        // Valid surrogate pair
        char[] input = { '\uD83D', '\uDC00' };
        utf8Writer.write(input, 0, 2);
        assertArrayEquals(new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 }, outputStream.toByteArray());
    }

    @Test
    void testWriteThrowsIOException() throws IOException {
        doThrow(new IOException("Output stream error")).when(outputStream).write(Mockito.any(byte[].class), Mockito.anyInt(), Mockito.anyInt());
        char[] input = { 'A' };
        IOException thrown = org.junit.jupiter.api.Assertions.assertThrows(IOException.class, () -> {
            utf8Writer.write(input, 0, 1);
        });
        assertArrayEquals(new byte[] {}, outputStream.toByteArray());
        assertEquals("Output stream error", thrown.getMessage());
    }
}
