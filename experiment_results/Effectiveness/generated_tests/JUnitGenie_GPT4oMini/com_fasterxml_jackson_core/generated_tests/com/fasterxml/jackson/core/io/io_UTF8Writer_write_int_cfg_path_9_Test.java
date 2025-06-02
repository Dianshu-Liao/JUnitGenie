package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_9_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Create a new IOContext with a valid buffer size
        IOContext context = new IOContext(null, outputStream, false);
        writer = new UTF8Writer(context, outputStream);
    }

    @Test(timeout = 4000)
    public void testWriteWithSurrogateConversion() {
        try {
            // Write a surrogate pair
            writer.write(0xD800); // First part of surrogate
            writer.write(0xDC00); // Second part of surrogate

            // Expected output after writing surrogate pair
            byte[] expectedOutput = new byte[] {
                (byte) 0xF0, (byte) 0x9D, (byte) 0x9C, (byte) 0x80 // Example expected output for the surrogate pair
            };

            // Flush the writer to ensure all data is written to the output stream
            writer.flush(); // Use flush instead of writing a dummy byte
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            // Handle the exception as per rule 1
            e.printStackTrace();
        }
    }

}