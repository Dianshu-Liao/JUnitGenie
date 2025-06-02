package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_14_Test {
    private UTF8Writer utf8Writer;
    private ByteArrayOutputStream outputStream;


    @Test(timeout = 4000)
    public void testWriteAscii() throws IOException {
        utf8Writer.write(65); // ASCII 'A'
        utf8Writer.write(66); // ASCII 'B'
        utf8Writer.write(67); // ASCII 'C'
        utf8Writer.write(68); // ASCII 'D'
        utf8Writer.write(69); // ASCII 'E'
        
        byte[] expected = new byte[]{65, 66, 67, 68, 69};
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteTwoByteCharacter() throws IOException {
        utf8Writer.write(0xC2); // first part of 2-byte character
        utf8Writer.write(0xA9); // second part of 2-byte character
        
        byte[] expected = new byte[]{(byte) 0xC2, (byte) 0xA9};
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteThreeByteCharacter() throws IOException {
        utf8Writer.write(0xE2); // first part of 3-byte character
        utf8Writer.write(0x9C); // second part of 3-byte character
        utf8Writer.write(0xA8); // third part of 3-byte character
        
        byte[] expected = new byte[]{(byte) 0xE2, (byte) 0x9C, (byte) 0xA8};
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteFourByteCharacter() throws IOException {
        utf8Writer.write(0xF0); // first part of 4-byte character
        utf8Writer.write(0x9F); // second part of 4-byte character
        utf8Writer.write(0x8C); // third part of 4-byte character
        utf8Writer.write(0xBC); // fourth part of 4-byte character
        
        byte[] expected = new byte[]{(byte) 0xF0, (byte) 0x9F, (byte) 0x8C, (byte) 0xBC};
        assertArrayEquals(expected, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteIllegalCharacter() {
        try {
            utf8Writer.write(0x110000); // illegal UTF-8 character
        } catch (IOException e) {
            // expected
        }
    }

}
