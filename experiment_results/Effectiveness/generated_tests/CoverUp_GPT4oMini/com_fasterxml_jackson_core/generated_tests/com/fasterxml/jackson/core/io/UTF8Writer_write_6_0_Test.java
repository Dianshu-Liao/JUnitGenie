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

public class UTF8Writer_write_6_0_Test {

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
        utf8Writer.write("A");
        utf8Writer.flush();
        assertArrayEquals("A".getBytes("UTF-8"), outputStream.toByteArray());
    }

    @Test
    public void testWriteMultipleAsciiCharacters() throws IOException {
        utf8Writer.write("Hello");
        utf8Writer.flush();
        assertArrayEquals("Hello".getBytes("UTF-8"), outputStream.toByteArray());
    }

    @Test
    public void testWriteNonAsciiCharacter() throws IOException {
        utf8Writer.write("€");
        utf8Writer.flush();
        assertArrayEquals("€".getBytes("UTF-8"), outputStream.toByteArray());
    }

    @Test
    public void testWriteSurrogatePair() throws IOException {
        // U+10340
        utf8Writer.write("𐍈");
        utf8Writer.flush();
        assertArrayEquals("𐍈".getBytes("UTF-8"), outputStream.toByteArray());
    }

    @Test
    public void testWriteEmptyString() throws IOException {
        utf8Writer.write("");
        utf8Writer.flush();
        assertArrayEquals(new byte[0], outputStream.toByteArray());
    }

    @Test
    public void testWriteSingleCharacter() throws IOException {
        utf8Writer.write("B");
        utf8Writer.flush();
        assertArrayEquals("B".getBytes("UTF-8"), outputStream.toByteArray());
    }

    @Test
    public void testWriteStringWithSurrogates() throws IOException {
        // Grinning Face Emoji
        utf8Writer.write("\uD83D\uDE00");
        utf8Writer.flush();
        assertArrayEquals("\uD83D\uDE00".getBytes("UTF-8"), outputStream.toByteArray());
    }

    @Test
    public void testWriteStringWithIllegalSurrogate() {
        assertThrows(IOException.class, () -> {
            // Invalid surrogate pair
            utf8Writer.write("\uD83D\uDC00\uD83D");
            utf8Writer.flush();
        });
    }
}
