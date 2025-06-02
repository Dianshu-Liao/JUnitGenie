package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_5_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;


    @Test(timeout = 4000)
    public void testWriteWithSurrogate() {
        try {
            // Test with a surrogate pair
            writer.write(0xD800); // First part of surrogate
            writer.write(0xDC00); // Second part of surrogate
            writer.write(0x61);   // ASCII character 'a'
            writer.write(0xD83D); // First part of another surrogate
            writer.write(0xDE00); // Second part of another surrogate
            byte[] expectedOutput = new byte[] {
                (byte) 0xED, (byte) 0xA0, (byte) 0x80, // 4-byte surrogate
                (byte) 0x61,                           // ASCII 'a'
                (byte) 0xED, (byte) 0xA0, (byte) 0xA0  // 4-byte surrogate
            };
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteIllegalSurrogate() {
        try {
            // Test with an illegal surrogate
            writer.write(0xDFFF); // This should trigger illegalSurrogate
        } catch (IOException e) {
            // Expected exception for illegal surrogate
        }
    }

    @Test(timeout = 4000)
    public void testWriteValidCharacters() {
        try {
            writer.write(0x61); // ASCII character 'a'
            writer.write(0xC2); // Start of 2-byte character
            writer.write(0xA9); // '©' character
            byte[] expectedOutput = new byte[] {
                (byte) 0x61, // 'a'
                (byte) 0xC2, (byte) 0xA9 // '©'
            };
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
