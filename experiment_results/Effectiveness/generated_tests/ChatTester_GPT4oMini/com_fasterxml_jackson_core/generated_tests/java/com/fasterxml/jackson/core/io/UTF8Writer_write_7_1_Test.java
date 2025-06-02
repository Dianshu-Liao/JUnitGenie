package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;

public class UTF8Writer_write_7_1_Test {

    private UTF8Writer utf8Writer;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext context = Mockito.mock(IOContext.class);
        utf8Writer = new UTF8Writer(context, outputStream);
    }

    @Test
    public void testWriteSingleAsciiCharacter() throws IOException {
        utf8Writer.write("A", 0, 1);
        assertArrayEquals(new byte[] { 65 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteMultipleAsciiCharacters() throws IOException {
        utf8Writer.write("Hello", 0, 5);
        assertArrayEquals("Hello".getBytes(), outputStream.toByteArray());
    }

    @Test
    public void testWriteTwoByteCharacter() throws IOException {
        // Euro sign
        utf8Writer.write("€", 0, 1);
        assertArrayEquals(new byte[] { (byte) 0xE2, (byte) 0x82, (byte) 0xAC }, outputStream.toByteArray());
    }

    @Test
    public void testWriteThreeByteCharacter() throws IOException {
        // Japanese Hiragana character
        utf8Writer.write("あ", 0, 1);
        assertArrayEquals(new byte[] { (byte) 0xE3, (byte) 0x81, (byte) 0x82 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteSurrogatePair() throws IOException {
        // Grinning face emoji
        utf8Writer.write("\uD83D\uDE00", 0, 2);
        assertArrayEquals(new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteSingleSurrogate() throws IOException {
        assertThrows(IOException.class, () -> {
            // High surrogate
            utf8Writer.write("\uD800", 0, 1);
        });
    }

    @Test
    public void testWriteEmptyString() throws IOException {
        utf8Writer.write("", 0, 0);
        assertArrayEquals(new byte[] {}, outputStream.toByteArray());
    }

    @Test
    public void testWriteSingleCharacterWithOffset() throws IOException {
        // Write 'e'
        utf8Writer.write("Hello", 1, 1);
        assertArrayEquals(new byte[] { 101 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteWithOffsetAndLength() throws IOException {
        // Write 'Hel'
        utf8Writer.write("Hello", 0, 3);
        assertArrayEquals(new byte[] { 72, 101, 108 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteSurrogateWithoutFollowingCharacter() throws IOException {
        // High surrogate
        utf8Writer.write("\uD800", 0, 1);
        assertThrows(IOException.class, () -> {
            // Attempt to write again
            utf8Writer.write("\uD800", 0, 1);
        });
    }

    @Test
    public void testWriteMixedCharacters() throws IOException {
        // Mixed ASCII and UTF-8 characters
        utf8Writer.write("Hello, 世界!", 0, 11);
        assertArrayEquals(new byte[] { 72, 101, 108, 108, 111, 44, (byte) 0xe4, (byte) 0xb8, (byte) 0x96, (byte) 0xe7, (byte) 0x95, (byte) 0x8c, 33 }, outputStream.toByteArray());
    }
}
