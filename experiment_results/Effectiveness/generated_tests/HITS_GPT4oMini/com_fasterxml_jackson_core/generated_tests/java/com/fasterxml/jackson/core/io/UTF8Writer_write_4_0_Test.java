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

public class UTF8Writer_write_4_0_Test {

    private ByteArrayOutputStream outputStream;

    private UTF8Writer utf8Writer;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(StreamReadConstraints.defaults(), StreamWriteConstraints.defaults(), ErrorReportConfiguration.defaults(), new BufferRecycler(), ContentReference.rawReference(new Object()), true);
        utf8Writer = new UTF8Writer(ioContext, outputStream);
    }

    @Test
    public void testWriteSingleAsciiCharacter() throws IOException {
        char[] input = { 'a' };
        utf8Writer.write(input, 0, 1);
        assertArrayEquals(new byte[] { 'a' }, outputStream.toByteArray());
    }

    @Test
    public void testWriteMultipleAsciiCharacters() throws IOException {
        char[] input = { 'h', 'e', 'l', 'l', 'o' };
        utf8Writer.write(input, 0, input.length);
        assertArrayEquals("hello".getBytes(), outputStream.toByteArray());
    }

    @Test
    public void testWriteTwoByteCharacter() throws IOException {
        // ©
        char[] input = { (char) 0x00A9 };
        utf8Writer.write(input, 0, 1);
        assertArrayEquals(new byte[] { (byte) 0xC2, (byte) 0xA9 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteThreeByteCharacter() throws IOException {
        // ✔
        // Unicode for check mark
        char[] input = { (char) 0x2713 };
        utf8Writer.write(input, 0, 1);
        assertArrayEquals(new byte[] { (byte) 0xE2, (byte) 0x9C, (byte) 0x94 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteFourByteCharacter() throws IOException {
        // 😀
        // Unicode for grinning face
        char[] input = { (char) 0x1F600 };
        utf8Writer.write(input, 0, 1);
        assertArrayEquals(new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteSurrogatePair() throws IOException {
        // 😀 (surrogate pair)
        char[] input = { (char) 0xD83D, (char) 0xDE00 };
        utf8Writer.write(input, 0, input.length);
        assertArrayEquals(new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 }, outputStream.toByteArray());
    }

    @Test
    public void testWriteEmptyArray() throws IOException {
        char[] input = {};
        utf8Writer.write(input, 0, 0);
        assertArrayEquals(new byte[] {}, outputStream.toByteArray());
    }

    @Test
    public void testWriteSingleSurrogate() throws IOException {
        // High surrogate
        char[] input = { (char) 0xD800 };
    }
}
