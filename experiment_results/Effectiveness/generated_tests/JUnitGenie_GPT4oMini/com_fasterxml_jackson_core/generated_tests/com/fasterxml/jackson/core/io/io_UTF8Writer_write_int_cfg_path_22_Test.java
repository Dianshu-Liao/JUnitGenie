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

public class io_UTF8Writer_write_int_cfg_path_22_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;
    private JsonFactory jsonFactory;


    @Test(timeout = 4000)
    public void testWriteSingleByte() throws IOException {
        writer.write(65); // ASCII 'A'
        writer.write(128); // First byte of a 2-byte character
        writer.write(255); // Should be handled as a single byte
        writer.write(2048); // First byte of a 3-byte character
        writer.write(57343); // Last valid surrogate
        writer.write(55296); // First valid surrogate

        byte[] expectedOutput = new byte[] {
            65, // 'A'
            (byte) 0x80, (byte) 0x80, // 2-byte character
            (byte) 0xFF, // single byte
            (byte) 0xE0, (byte) 0xA0, (byte) 0x80, // 3-byte character
            (byte) 0xED, (byte) 0x9F, (byte) 0xBF, // Last valid surrogate
            (byte) 0xED, (byte) 0xA0, (byte) 0x80 // First valid surrogate
        };

        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteSurrogateHandling() {
        try {
            writer.write(57344); // Invalid second part of surrogate
        } catch (IOException e) {
            // Expected exception
        }
    }

}
