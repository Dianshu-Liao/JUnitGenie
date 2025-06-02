package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;

public class UTF8Writer_write_5_0_Test {

    private UTF8Writer utf8Writer;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Mocking IOContext as it's not provided
        IOContext ioContext = mock(IOContext.class);
        utf8Writer = new UTF8Writer(ioContext, outputStream);
    }

    @Test
    public void testWriteAscii() throws IOException {
        // 'A'
        utf8Writer.write(65);
        // 'B'
        utf8Writer.write(66);
        // 'C'
        utf8Writer.write(67);
        byte[] result = outputStream.toByteArray();
        assertArrayEquals(new byte[] { 65, 66, 67 }, result);
    }

    @Test
    public void testWriteTwoByteCharacter() throws IOException {
        // ©
        utf8Writer.write(0xC2A9);
        byte[] result = outputStream.toByteArray();
        assertArrayEquals(new byte[] { (byte) 0xC2, (byte) 0xA9 }, result);
    }

    @Test
    public void testWriteThreeByteCharacter() throws IOException {
        // ⊕
        utf8Writer.write(0xE2A9);
        byte[] result = outputStream.toByteArray();
        assertArrayEquals(new byte[] { (byte) 0xE2, (byte) 0xA9 }, result);
    }

    @Test
    public void testWriteFourByteCharacter() throws IOException {
        // 𐍈
        utf8Writer.write(0xF0908D88);
        byte[] result = outputStream.toByteArray();
        assertArrayEquals(new byte[] { (byte) 0xF0, (byte) 0x90, (byte) 0x8D, (byte) 0x88 }, result);
    }

    @Test
    public void testWriteSurrogatePair() throws IOException {
        // First part of surrogate
        utf8Writer.write(0xD800);
        // Second part of surrogate
        utf8Writer.write(0xDC00);
        // The expected output should be the combined character
        byte[] result = outputStream.toByteArray();
        // Surrogates should not produce output
        assertEquals(0, result.length);
    }

    @Test
    public void testWriteIllegalSurrogate() {
        assertThrows(IOException.class, () -> {
            // Illegal to start with second part
            utf8Writer.write(0xDC00);
        });
    }

    @Test
    public void testWriteIllegalCharacter() {
        assertThrows(IOException.class, () -> {
            // Illegal character
            utf8Writer.write(0x110000);
        });
    }
}
