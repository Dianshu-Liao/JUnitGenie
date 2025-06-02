package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_26_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, null, false); // Create a valid IOContext
        writer = new UTF8Writer(ioContext, outputStream); // Pass the IOContext to UTF8Writer
    }

    @Test(timeout = 4000)
    public void testWriteAsciiCharacter() throws IOException {
        writer.write(65); // ASCII 'A'
        writer.write(66); // ASCII 'B'
        writer.write(67); // ASCII 'C'
        writer.write(128); // First non-ASCII character

        byte[] expectedOutput = new byte[] {65, 66, 67};
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteTwoByteCharacter() throws IOException {
        writer.write(0xC2); // Start of 2-byte character
        writer.write(0xA9); // '©' character

        byte[] expectedOutput = new byte[] {(byte) 0xC2, (byte) 0xA9};
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteThreeByteCharacter() throws IOException {
        writer.write(0xE2); // Start of 3-byte character
        writer.write(0x82); // 'â'
        writer.write(0xAC); // '€'

        byte[] expectedOutput = new byte[] {(byte) 0xE2, (byte) 0x82, (byte) 0xAC};
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteFourByteCharacter() throws IOException {
        writer.write(0xF0); // Start of 4-byte character
        writer.write(0x9F); // '😀' character
        writer.write(0x98);
        writer.write(0x80);

        byte[] expectedOutput = new byte[] {(byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80};
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteIllegalSurrogate() {
        try {
            writer.write(0xD800); // Illegal surrogate
        } catch (IOException e) {
            // Expected exception
        }
    }

}