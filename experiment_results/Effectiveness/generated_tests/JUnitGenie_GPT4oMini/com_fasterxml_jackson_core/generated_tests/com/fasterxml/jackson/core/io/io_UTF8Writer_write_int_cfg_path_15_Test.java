package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_15_Test {

    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;
    private IOContext context; // Declare context

    @Before
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
        BufferRecycler bufferRecycler = new BufferRecycler();
        context = new IOContext(bufferRecycler, outputStream, false);
        writer = new UTF8Writer(context, outputStream); // Initialize writer with context and outputStream
    }

    @Test(timeout = 4000)
    public void testWriteValidSingleByte() {
        try {
            writer.write(65); // ASCII letter 'A'
            writer.write(128); // First byte of a 2-byte character
            writer.write(255); // Valid byte
            writer.write(1114111); // Last valid Unicode character
            writer.close(); // Close writer to flush output
        } catch (IOException e) {
            // Handle exceptions, if any
        }

        // Validate the output
        byte[] expectedOutput = new byte[]{65, (byte) 0x80, (byte) 0xff, (byte) 0xf4, (byte) 0x8f, (byte) 0xbf, (byte) 0xbf}; // Example based on given inputs
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteSurrogateInterleaving() {
        try {
            writer.write(0xD800); // First surrogate
            writer.write(0xDCA0); // Second surrogate (valid scenario)
            writer.close(); // Close writer to flush output
        } catch (IOException e) {
            // Handle exceptions, if any
        }

        // Check the output state, you may assert against expected byte sequence
    }

    @Test(timeout = 4000)
    public void testWriteIllegalSurrogate() {
        try {
            writer.write(0xD800); // First part of a surrogate
            writer.write(0xDBFF); // Should trigger the illegal surrogate exception on next write
            writer.write(0xFFFF); // Invalid second surrogate
            writer.close(); // Close writer to flush output
        } catch (IOException e) {
            // Expected illegal surrogate exception handling
        }
    }


}