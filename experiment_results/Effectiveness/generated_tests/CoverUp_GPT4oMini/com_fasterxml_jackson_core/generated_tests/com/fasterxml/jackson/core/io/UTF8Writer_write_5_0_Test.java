package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.io.IOContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;

class UTF8Writer_write_5_0_Test {

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    private UTF8Writer utf8Writer;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = new IOContext(null, outputStream, true);
        utf8Writer = new UTF8Writer(ioContext, outputStream);
    }

    @Test
    void testWriteAscii() throws IOException {
        // 'A'
        utf8Writer.write(65);
        // 'B'
        utf8Writer.write(66);
        // 'C'
        utf8Writer.write(67);
        assertArrayEquals(new byte[] { 65, 66, 67 }, outputStream.toByteArray());
    }

    @Test
    void testWriteTwoByteCharacter() throws IOException {
        // ©
        utf8Writer.write(0xC2A9);
        // ®
        utf8Writer.write(0xC2AE);
        assertArrayEquals(new byte[] { (byte) 0xC2, (byte) 0xA9, (byte) 0xC2, (byte) 0xAE }, outputStream.toByteArray());
    }

    @Test
    void testWriteThreeByteCharacter() throws IOException {
        // 𐩠
        utf8Writer.write(0xE2A9A0);
        assertArrayEquals(new byte[] { (byte) 0xE2, (byte) 0xA9, (byte) 0xA0 }, outputStream.toByteArray());
    }

    @Test
    void testWriteFourByteCharacter() throws IOException {
        // 𐏿
        utf8Writer.write(0x10FFFF);
        assertArrayEquals(new byte[] { (byte) 0xF4, (byte) 0x8F, (byte) 0xBF, (byte) 0xBF }, outputStream.toByteArray());
    }

    @Test
    void testWriteSurrogatePairs() throws IOException {
        // First part of surrogate
        utf8Writer.write(0xD800);
        // Second part of surrogate
        utf8Writer.write(0xDC00);
        assertArrayEquals(new byte[] { (byte) 0xED, (byte) 0xA0, (byte) 0x80, (byte) 0xED, (byte) 0xB2, (byte) 0x80 }, outputStream.toByteArray());
    }

    @Test
    void testWriteIllegalSurrogate() {
        assertThrows(IOException.class, () -> {
            // Last valid surrogate
            utf8Writer.write(0xDBFF);
            // First part of surrogate
            utf8Writer.write(0xD800);
        });
    }

    @Test
    void testWriteIllegalCharacter() {
        assertThrows(IOException.class, () -> {
            // Invalid character
            utf8Writer.write(0x110000);
        });
    }
}
