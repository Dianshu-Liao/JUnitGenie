package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_16_Test {

    private ByteArrayOutputStream outputStream;
    private UTF8Writer utf8Writer;
    
    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Create a valid IOContext instead of passing null
        utf8Writer = new UTF8Writer(new IOContext(new BufferRecycler(), null, false), outputStream);
    }

    @Test(timeout = 4000)
    public void testWriteAsciiCharacter() throws IOException {
        utf8Writer.write(65); // 'A' in ASCII
        utf8Writer.write(66); // 'B' in ASCII
        
        byte[] expectedOutput = new byte[] {65, 66}; // Expected byte output
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteTwoByteCharacter() throws IOException {
        utf8Writer.write(0xC2); // Two-byte character start
        utf8Writer.write(0xA9); // Copyright symbol
        
        byte[] expectedOutput = new byte[] {(byte) 0xC2, (byte) 0xA9};
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteThreeByteCharacter() throws IOException {
        utf8Writer.write(0xE2); // Three-byte character start
        utf8Writer.write(0x82); //…
        utf8Writer.write(0xA8); // Ellipsis
        
        byte[] expectedOutput = new byte[] {(byte) 0xE2, (byte) 0x82, (byte) 0xA8};
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteFourByteCharacter() throws IOException {
        utf8Writer.write(0xF0); // Four-byte character start
        utf8Writer.write(0x9F); // 
        utf8Writer.write(0x98); // 
        utf8Writer.write(0x81); // 
        
        byte[] expectedOutput = new byte[] {(byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x81};
        assertArrayEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteIllegalSurrogate() {
        try {
            utf8Writer.write(0xD800); // Attempting to write an illegal surrogate
        } catch (IOException e) {
            // Expected exception
            return;
        }
        throw new AssertionError("Expected IOException for illegal surrogate");
    }

}