package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class UTF8Writer_write_6_0_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8Writer writer;

    @BeforeEach
    public void setUp() {
        IOContext ioContext = new IOContext(StreamReadConstraints.defaults(), StreamWriteConstraints.defaults(), ErrorReportConfiguration.defaults(), new BufferRecycler(), ContentReference.rawReference(new Object()), true);
        outputStream = new ByteArrayOutputStream();
        writer = new UTF8Writer(ioContext, outputStream);
    }

    @Test
    public void testWriteSingleAsciiCharacter() throws IOException {
        writer.write("A");
        assertArrayEquals("A".getBytes(), outputStream.toByteArray());
    }

    @Test
    public void testWriteMultipleAsciiCharacters() throws IOException {
        writer.write("Hello");
        assertArrayEquals("Hello".getBytes(), outputStream.toByteArray());
    }

    @Test
    public void testWriteSingleUnicodeCharacter() throws IOException {
        // é
        writer.write("\u00E9");
        assertArrayEquals(new byte[] { (byte) 0xC3, (byte) 0xA9 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteSurrogatePair() throws IOException {
        // 😀
        writer.write("\uD83D\uDE00");
        assertArrayEquals(new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteMixedContent() throws IOException {
        writer.write("Hello, \u00E9 and 😀");
        byte[] expected = "Hello, ".getBytes();
        byte[] unicode = new byte[] { (byte) 0xC3, (byte) 0xA9 };
        byte[] emoji = new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 };
        byte[] combined = new byte[expected.length + unicode.length + emoji.length];
        System.arraycopy(expected, 0, combined, 0, expected.length);
        System.arraycopy(unicode, 0, combined, expected.length, unicode.length);
        System.arraycopy(emoji, 0, combined, expected.length + unicode.length, emoji.length);
        assertArrayEquals(combined, outputStream.toByteArray());
    }

    @Test
    public void testWriteEmptyString() throws IOException {
        writer.write("");
        assertArrayEquals(new byte[] {}, outputStream.toByteArray());
    }

    @Test
    public void testWriteSingleCharacterAtOffset() throws IOException {
        writer.write("A", 0, 1);
        assertArrayEquals("A".getBytes(), outputStream.toByteArray());
    }
}
