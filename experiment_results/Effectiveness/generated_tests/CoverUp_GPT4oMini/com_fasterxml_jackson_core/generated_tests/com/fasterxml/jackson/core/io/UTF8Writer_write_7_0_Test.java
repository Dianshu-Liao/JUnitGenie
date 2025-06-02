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

public class UTF8Writer_write_7_0_Test {

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    private UTF8Writer utf8Writer;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = new IOContext(null, outputStream, true);
        utf8Writer = new UTF8Writer(ioContext, outputStream);
    }

    @Test
    public void testWriteSingleAsciiCharacter() throws IOException {
        utf8Writer.write("A", 0, 1);
        utf8Writer.flush();
        assertArrayEquals(new byte[] { 65 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteMultipleAsciiCharacters() throws IOException {
        utf8Writer.write("Hello", 0, 5);
        utf8Writer.flush();
        assertArrayEquals("Hello".getBytes(), outputStream.toByteArray());
    }

    @Test
    public void testWriteTwoByteCharacter() throws IOException {
        // é
        utf8Writer.write("\u00E9", 0, 2);
        utf8Writer.flush();
        assertArrayEquals(new byte[] { (byte) 0xC3, (byte) 0xA9 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteThreeByteCharacter() throws IOException {
        // €
        utf8Writer.write("\u20AC", 0, 3);
        utf8Writer.flush();
        assertArrayEquals(new byte[] { (byte) 0xE2, (byte) 0x82, (byte) 0xAC }, outputStream.toByteArray());
    }

    @Test
    public void testWriteFourByteCharacter() throws IOException {
        // 😀
        utf8Writer.write("\uD83D\uDE00", 0, 4);
        utf8Writer.flush();
        assertArrayEquals(new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteSurrogatePair() throws IOException {
        // 😀
        utf8Writer.write("\uD83D\uDE00", 0, 4);
        utf8Writer.flush();
        assertArrayEquals(new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteIllegalSurrogate() {
        assertThrows(IOException.class, () -> {
            // Invalid surrogate
            utf8Writer.write("\uD800", 0, 2);
        });
    }

    @Test
    public void testWriteEmptyString() throws IOException {
        utf8Writer.write("", 0, 0);
        utf8Writer.flush();
        assertArrayEquals(new byte[] {}, outputStream.toByteArray());
    }

    @Test
    public void testWriteSingleCharacter() throws IOException {
        utf8Writer.write("A", 0, 1);
        utf8Writer.flush();
        assertArrayEquals(new byte[] { 65 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteSingleCharacterSurrogate() throws IOException {
        // First part of surrogate
        utf8Writer.write("\uD83D", 0, 2);
        utf8Writer.flush();
        assertArrayEquals(new byte[] {}, outputStream.toByteArray());
    }

    @Test
    public void testWriteSurrogateFollowedByValidCharacter() throws IOException {
        // First part of surrogate
        utf8Writer.write("\uD83D", 0, 2);
        // Second part of surrogate
        utf8Writer.write("\uDE00", 0, 2);
        utf8Writer.flush();
        assertArrayEquals(new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 }, outputStream.toByteArray());
    }
}
