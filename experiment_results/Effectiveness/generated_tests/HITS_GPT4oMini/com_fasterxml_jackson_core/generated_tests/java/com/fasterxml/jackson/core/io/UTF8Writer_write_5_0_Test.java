package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;

public class UTF8Writer_write_5_0_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8Writer writer;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, ContentReference.rawReference(outputStream), true);
        writer = new UTF8Writer(ioContext, outputStream);
    }

    @Test
    public void testWriteAscii() throws IOException {
        // ASCII 'A'
        writer.write(65);
        writer.flush();
        assertArrayEquals(new byte[] { 65 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteTwoByteChar() throws IOException {
        // ©
        writer.write(0xC2A9);
        writer.flush();
        assertArrayEquals(new byte[] { (byte) 0xC2, (byte) 0xA9 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteThreeByteChar() throws IOException {
        // 𐩡
        writer.write(0xE2A9A1);
        writer.flush();
        assertArrayEquals(new byte[] { (byte) 0xE2, (byte) 0xA9, (byte) 0xA1 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteFourByteChar() throws IOException {
        // 𐿿
        writer.write(0x10FFFF);
        writer.flush();
        assertArrayEquals(new byte[] { (byte) 0xF4, (byte) 0x8F, (byte) 0xBF, (byte) 0xBF }, outputStream.toByteArray());
    }

    @Test
    public void testWriteSurrogatePair() throws IOException {
        // First part of a surrogate pair
        writer.write(0xD83D);
        // Second part of a surrogate pair
        writer.write(0xDE03);
        writer.flush();
        assertArrayEquals(new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x83 }, outputStream.toByteArray());
    }
}
