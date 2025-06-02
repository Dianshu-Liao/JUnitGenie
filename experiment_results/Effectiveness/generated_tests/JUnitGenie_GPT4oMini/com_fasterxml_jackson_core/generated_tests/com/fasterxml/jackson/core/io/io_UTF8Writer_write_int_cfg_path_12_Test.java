package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_12_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;
    private JsonFactory jsonFactory;


    @Test(timeout = 4000)
    public void testWriteSingleByte() throws IOException {
        writer.write(65); // ASCII 'A'
        writer.write(66); // ASCII 'B'
        writer.write(67); // ASCII 'C'
        writer.write(128); // First byte of a 2-byte character

        // Flush the output to ensure all data is written
        writer.write(0); // Trigger flush by writing a non-character
        byte[] expected = new byte[]{65, 66, 67, (byte) 0x80};
        assertArrayEquals(expected, outputStream.toByteArray());
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

    @Test(timeout = 4000)
    public void testWriteFourByteCharacter() throws IOException {
        writer.write(0x10FFFF); // Valid 4-byte character
        writer.write(0); // Trigger flush
        byte[] expected = new byte[]{(byte) 0xF4, (byte) 0x8F, (byte) 0xBF, (byte) 0xBF};
        assertArrayEquals(expected, outputStream.toByteArray());
    }

}
