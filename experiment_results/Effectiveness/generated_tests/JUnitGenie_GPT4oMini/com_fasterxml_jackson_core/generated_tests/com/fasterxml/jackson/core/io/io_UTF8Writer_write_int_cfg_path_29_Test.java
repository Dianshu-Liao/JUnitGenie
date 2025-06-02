package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_29_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;
    private IOContext ioContext; // Declare IOContext

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = new IOContext(null, outputStream, false); // Initialize IOContext
        writer = new UTF8Writer(ioContext, outputStream); // Pass IOContext and OutputStream
    }

    @Test(timeout = 4000)
    public void testWriteSingleByte() throws IOException {
        writer.write(65); // ASCII 'A'
        writer.write(66); // ASCII 'B'
        writer.write(67); // ASCII 'C'
        writer.write(128); // First byte of a 2-byte character

        // Flush the buffer to the output stream
        writer.write(0); // Trigger flush
        byte[] expectedOutput = new byte[]{65, 66, 67, (byte) 0x80};
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteSurrogate() {
        try {
            writer.write(0xD800); // First part of a surrogate pair
            writer.write(0xDC00); // Second part of a surrogate pair
        } catch (IOException e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteIllegalSurrogate() {
        try {
            writer.write(0xD800); // First part of a surrogate pair
            writer.write(0xDFFF); // Illegal second part
        } catch (IOException e) {
            // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteFourByteCharacter() throws IOException {
        writer.write(0x10FFFF); // Maximum valid Unicode code point
        writer.write(0); // Trigger flush
        byte[] expectedOutput = new byte[]{
            (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0xBF // UTF-8 encoding for U+10FFFF
        };
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

}