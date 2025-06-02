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

public class io_UTF8Writer_write_int_cfg_path_11_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;
    private JsonFactory jsonFactory;


    @Test(timeout = 4000)
    public void testWriteAsciiCharacter() throws IOException {
        writer.write(65); // ASCII 'A'
        writer.write(66); // ASCII 'B'
        writer.write(67); // ASCII 'C'
        writer.write(68); // ASCII 'D'
        writer.write(69); // ASCII 'E'
        
        byte[] expectedOutput = new byte[]{65, 66, 67, 68, 69};
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteTwoByteCharacter() throws IOException {
        writer.write(0xC2); // Two-byte character start
        writer.write(0xA9); // ©
        
        byte[] expectedOutput = new byte[]{(byte) 0xC2, (byte) 0xA9};
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteThreeByteCharacter() throws IOException {
        writer.write(0xE2); // Three-byte character start
        writer.write(0x82); // –
        writer.write(0xAC); // €
        
        byte[] expectedOutput = new byte[]{(byte) 0xE2, (byte) 0x82, (byte) 0xAC};
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteFourByteCharacter() throws IOException {
        writer.write(0xF0); // Four-byte character start
        writer.write(0x9F); // 𝄞
        writer.write(0x8E); // 𝄞
        writer.write(0x9C); // 𝄞
        
        byte[] expectedOutput = new byte[]{(byte) 0xF0, (byte) 0x9F, (byte) 0x8E, (byte) 0x9C};
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteIllegalSurrogate() {
        try {
            writer.write(0xD800); // Illegal surrogate
        } catch (IOException e) {
            // Expected exception
        }
    }

}
