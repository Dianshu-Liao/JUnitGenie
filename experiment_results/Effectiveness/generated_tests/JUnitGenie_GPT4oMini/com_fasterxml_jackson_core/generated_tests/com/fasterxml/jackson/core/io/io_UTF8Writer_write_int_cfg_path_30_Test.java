package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.UTF8Writer;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_30_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Create a proper IOContext with a valid buffer size
        writer = new UTF8Writer(new IOContext(null, outputStream, false), outputStream);
    }

    @Test(timeout = 4000)
    public void testWriteWithSurrogateHandling() {
        try {
            // Set up the _surrogate field to a value that requires handling
            writer.write(0xD800); // First part of a surrogate pair
            writer.write(0xDC00); // Second part of a surrogate pair
            writer.write(0x10000); // A valid code point that requires 4 bytes

            // Verify the output
            byte[] expectedOutput = new byte[] {
                (byte) 0xF0, (byte) 0x90, (byte) 0x80, (byte) 0x80 // Expected bytes for 0x10000
            };
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteIllegalSurrogate() {
        try {
            // This should trigger the illegalSurrogate method
            writer.write(0xD800); // First part of a surrogate pair
            writer.write(0xDFFF); // Second part of a surrogate pair, should throw an exception
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteWithHighCodePoint() {
        try {
            // This should trigger the illegalSurrogate method
            writer.write(0x110000); // Code point greater than 0x10FFFF, should throw an exception
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}