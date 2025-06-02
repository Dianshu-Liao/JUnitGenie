package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_21_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;


    @Test(timeout = 4000)
    public void testWriteSingleByte() throws IOException {
        writer.write(65); // ASCII 'A'
        writer.write(128); // First byte of a 2-byte character
        writer.write(255); // Should be handled as a single byte
        writer.write(0xC2); // First byte of a 2-byte character
        writer.write(0xA9); // Second byte of a 2-byte character

        byte[] expectedOutput = new byte[] {65, (byte) 0x80, (byte) 0xC2, (byte) 0xA9};
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
            writer.write(0xDFFF); // Should throw an illegal surrogate exception
        } catch (IOException e) {
            // Handle the exception
        }
    }

}
