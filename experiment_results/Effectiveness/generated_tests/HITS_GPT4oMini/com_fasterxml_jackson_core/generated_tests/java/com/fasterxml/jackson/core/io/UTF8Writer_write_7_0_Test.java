package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
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
        ioContext = new IOContext(StreamReadConstraints.defaults(), StreamWriteConstraints.defaults(), ErrorReportConfiguration.defaults(), new BufferRecycler(), null, true);
        utf8Writer = new UTF8Writer(ioContext, outputStream);
    }

    @Test
    public void testWriteSingleAsciiCharacter() throws IOException {
        utf8Writer.write("A", 0, 1);
        assertArrayEquals("A".getBytes("UTF-8"), outputStream.toByteArray());
    }

    @Test
    public void testWriteMultipleAsciiCharacters() throws IOException {
        utf8Writer.write("Hello, World!", 0, 13);
        assertArrayEquals("Hello, World!".getBytes("UTF-8"), outputStream.toByteArray());
    }

    @Test
    public void testWriteTwoByteCharacter() throws IOException {
        utf8Writer.write("ñ", 0, 1);
        assertArrayEquals("ñ".getBytes("UTF-8"), outputStream.toByteArray());
    }

    @Test
    public void testWriteThreeByteCharacter() throws IOException {
        utf8Writer.write("€", 0, 1);
        assertArrayEquals("€".getBytes("UTF-8"), outputStream.toByteArray());
    }

    @Test
    public void testWriteFourByteCharacter() throws IOException {
        // Gothic letter hwair
        utf8Writer.write("𐍈", 0, 1);
        assertArrayEquals("𐍈".getBytes("UTF-8"), outputStream.toByteArray());
    }

    @Test
    public void testWriteSurrogatePair() throws IOException {
        // Two Gothic letters
        utf8Writer.write("𐍈𐍈", 0, 2);
        assertArrayEquals("𐍈𐍈".getBytes("UTF-8"), outputStream.toByteArray());
    }

    @Test
    public void testWriteIllegalSurrogate() {
        assertThrows(IOException.class, () -> {
            // High surrogate
            utf8Writer.write("\uD800", 0, 1);
        });
    }

    @Test
    public void testWriteEmptyString() throws IOException {
        utf8Writer.write("", 0, 0);
        assertArrayEquals(new byte[0], outputStream.toByteArray());
    }

    @Test
    public void testWriteSingleCharacterAtOffset() throws IOException {
        utf8Writer.write("ABC", 1, 1);
        assertArrayEquals("B".getBytes("UTF-8"), outputStream.toByteArray());
    }

    @Test
    public void testWriteCharactersWithOffsetAndLength() throws IOException {
        // Write "世界"
        utf8Writer.write("Hello, 世界", 7, 2);
        assertArrayEquals("世界".getBytes("UTF-8"), outputStream.toByteArray());
    }

    @Test
    public void testWriteShortLength() throws IOException {
        utf8Writer.write("A", 0, 1);
        utf8Writer.write("B", 0, 1);
    }
}
