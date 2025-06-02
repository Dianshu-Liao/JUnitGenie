package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_25_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;


    @Test(timeout = 4000)
    public void testWriteWithValidSurrogate() {
        try {
            writer.write(0xD800); // First part of a surrogate pair
            writer.write(0xDC00); // Second part of a surrogate pair
            writer.write(0x41); // ASCII character 'A'
            writer.write(0xFF); // Another valid character

            byte[] expectedOutput = new byte[] {
                (byte) 0xED, (byte) 0xA0, (byte) 0x80, // 0xD800
                (byte) 0xED, (byte) 0xB0, (byte) 0x80, // 0xDC00
                (byte) 0x41, // 'A'
                (byte) 0xFF  // 0xFF
            };
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteWithIllegalSurrogate() {
        try {
            writer.write(0xD800); // First part of a surrogate pair
            writer.write(0xDFFF); // This should trigger an illegal surrogate exception
        } catch (IOException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testWriteWithOutBufferEnd() {
        try {
            // Instead of using getBufferEnd(), we will define a buffer size
            int bufferSize = 1024; // Assuming a buffer size of 1024 bytes
            for (int i = 0; i < bufferSize; i++) {
                writer.write(0x41); // Writing 'A'
            }
            // Now write one more character to trigger the flush
            writer.write(0x42); // Writing 'B'
            
            // Check if the output is as expected
            byte[] expectedOutput = new byte[bufferSize + 1];
            for (int i = 0; i < bufferSize; i++) {
                expectedOutput[i] = (byte) 0x41; // 'A'
            }
            expectedOutput[bufferSize] = (byte) 0x42; // 'B'
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
