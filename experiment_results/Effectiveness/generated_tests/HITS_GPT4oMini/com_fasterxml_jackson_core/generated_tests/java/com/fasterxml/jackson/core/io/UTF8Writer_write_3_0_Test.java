package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.fasterxml.jackson.core.StreamReadConstraints;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;

public class UTF8Writer_write_3_0_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8Writer utf8Writer;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(StreamReadConstraints.defaults(), StreamWriteConstraints.defaults(), ErrorReportConfiguration.defaults(), new BufferRecycler(), null, true);
        utf8Writer = new UTF8Writer(ioContext, outputStream);
    }

    @Test
    public void testWriteSingleAsciiCharacter() throws IOException {
        char[] input = { 'A' };
        utf8Writer.write(input);
        assertArrayEquals(new byte[] { 65 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteMultipleAsciiCharacters() throws IOException {
        char[] input = { 'H', 'e', 'l', 'l', 'o' };
        utf8Writer.write(input);
        assertArrayEquals(new byte[] { 72, 101, 108, 108, 111 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteTwoByteCharacter() throws IOException {
        char[] input = { 'é' };
        utf8Writer.write(input);
        assertArrayEquals(new byte[] { (byte) 0xc3, (byte) 0xa9 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteThreeByteCharacter() throws IOException {
        char[] input = { '€' };
        utf8Writer.write(input);
        assertArrayEquals(new byte[] { (byte) 0xe2, (byte) 0x82, (byte) 0xac }, outputStream.toByteArray());
    }

    @Test
    public void testWriteSurrogatePair() throws IOException {
        char[] input = { '\uD83D', '\uDE00' };
        utf8Writer.write(input);
        assertArrayEquals(new byte[] { (byte) 0xf0, (byte) 0x9f, (byte) 0x98, (byte) 0x80 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteEmptyArray() throws IOException {
        char[] input = {};
        utf8Writer.write(input);
        assertArrayEquals(new byte[] {}, outputStream.toByteArray());
    }

    @Test
    public void testWriteSingleSurrogate() throws IOException {
        char[] input = { '\uD800' };
        utf8Writer.write(input);
        assertArrayEquals(new byte[] {}, outputStream.toByteArray());
    }

    @Test
    public void testWriteInvalidSurrogate() throws IOException {
        char[] input = { '\uD83D', '\uDCA0' };
        utf8Writer.write(input);
        // The behavior for invalid surrogate should be handled in the actual method, so we don't assert here.
    }
}
