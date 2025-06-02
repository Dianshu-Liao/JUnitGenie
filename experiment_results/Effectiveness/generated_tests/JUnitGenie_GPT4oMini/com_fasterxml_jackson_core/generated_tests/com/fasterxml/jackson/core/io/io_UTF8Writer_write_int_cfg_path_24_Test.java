package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_24_Test {
    private UTF8Writer utf8Writer;
    private ByteArrayOutputStream outputStream;
    private IOContext ioContext; // Declare IOContext

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = new IOContext(null, outputStream, false); // Initialize IOContext
        utf8Writer = new UTF8Writer(ioContext, outputStream); // Pass IOContext to UTF8Writer
    }

    @Test(timeout = 4000)
    public void testWriteSingleByte() throws IOException {
        utf8Writer.write(65); // ASCII 'A'
        utf8Writer.write(66); // ASCII 'B'
        utf8Writer.write(67); // ASCII 'C'
        utf8Writer.write(128); // Start of multi-byte character
        utf8Writer.flush(); // Ensure all data is written to the output stream

        // Expected output: [65, 66, 67, -128]
        byte[] expectedOutput = new byte[]{65, 66, 67, -128};
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteSurrogate() throws IOException {
        utf8Writer.write(0xD800); // First part of a surrogate pair
        utf8Writer.write(0xDC00); // Second part of a surrogate pair
        utf8Writer.flush(); // Ensure all data is written to the output stream
    }

    @Test(timeout = 4000)
    public void testWriteIllegalSurrogate() throws IOException {
        utf8Writer.write(0xDFFF); // Illegal surrogate
        utf8Writer.flush(); // Ensure all data is written to the output stream
    }

    @Test(timeout = 4000)
    public void testWriteFourByteCharacter() throws IOException {
        utf8Writer.write(0x10FFFF); // Maximum valid Unicode code point
        utf8Writer.flush(); // Ensure all data is written to the output stream
        // Expected output for 4-byte character
        byte[] expectedOutput = new byte[]{(byte) 0xF4, (byte) 0x8F, (byte) 0xBF, (byte) 0xBF};
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

}