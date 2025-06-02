package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_23_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;
    private IOContext ioContext; // Declare IOContext

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = new IOContext(null, outputStream, false); // Initialize IOContext
        writer = new UTF8Writer(ioContext, outputStream); // Pass IOContext and output stream
    }

    @Test(timeout = 4000)
    public void testWriteSingleByte() throws IOException {
        writer.write(65); // ASCII 'A'
        writer.write(66); // ASCII 'B'
        writer.write(67); // ASCII 'C'
        writer.write(128); // First byte of a 2-byte character

        // Flush the buffer to the output stream
        writer.write(200); // Second byte of a 2-byte character

        byte[] expectedOutput = new byte[] {65, 66, 67, (byte) 0xC2, (byte) 0x80};
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
    public void testWriteOverBuffer() throws IOException {
        // Assuming _outBufferEnd is set to a value that will cause a flush
        // This is a hypothetical test as we don't have access to the internal state
        // of _outBufferEnd in this context.
        for (int i = 0; i < 1000; i++) {
            writer.write(i % 256); // Write a byte
        }
        // Verify that the output stream contains the expected number of bytes
        assertArrayEquals(new byte[1000], outputStream.toByteArray());
    }

}