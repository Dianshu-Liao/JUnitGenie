package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_13_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;
    private IOContext ioContext; // Declare IOContext

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = new IOContext(null, outputStream, false); // Initialize IOContext
        writer = new UTF8Writer(ioContext, outputStream); // Pass IOContext and OutputStream to UTF8Writer
    }

    @Test(timeout = 4000)
    public void testWriteSingleByte() throws IOException {
        writer.write(65); // ASCII 'A'
        writer.write(66); // ASCII 'B'
        writer.write(67); // ASCII 'C'
        writer.write(128); // First byte of a 2-byte character

        // Flush the buffer to the output stream
        writer.write(200); // Second byte of a 2-byte character
        writer.write(0); // Write a null byte to check buffer handling

        byte[] expectedOutput = new byte[] {65, 66, 67, (byte) 0xC2, (byte) 0x80, 0};
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
            writer.write(0xDFFF); // Illegal surrogate
        } catch (IOException e) {
            // Handle the exception
        }
    }

}