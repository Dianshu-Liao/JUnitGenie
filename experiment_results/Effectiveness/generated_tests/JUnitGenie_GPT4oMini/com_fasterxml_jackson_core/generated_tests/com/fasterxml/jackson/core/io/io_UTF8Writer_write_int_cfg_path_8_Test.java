package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_8_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Create a valid IOContext object instead of passing null
        writer = new UTF8Writer(new IOContext(new BufferRecycler(), outputStream, false), outputStream);
    }

    @Test(timeout = 4000)
    public void testWriteWithSurrogateConversion() {
        try {
            writer.write(0xD800); // First part of surrogate
            writer.write(0xDC00); // Second part of surrogate (must be >= 56320)
            // The output should now contain the correct UTF-8 bytes for the surrogate pair
            byte[] expectedOutput = new byte[] {(byte) 0xED, (byte) 0xA0, (byte) 0x80, (byte) 0xED, (byte) 0xB0, (byte) 0x80};
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteWithIllegalSurrogate() {
        try {
            writer.write(0xD800); // First part of surrogate
            writer.write(0xDFFF); // Second part of surrogate (illegal)
        } catch (IOException e) {
            // Expected exception for illegal surrogate
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteAsciiCharacter() {
        try {
            writer.write(65); // ASCII 'A'
            byte[] expectedOutput = new byte[] {65}; // Expecting ASCII byte
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteTwoByteCharacter() {
        try {
            writer.write(0x7FF); // 2-byte character
            byte[] expectedOutput = new byte[] {(byte) 0xC1, (byte) 0xBF}; // Expecting UTF-8 bytes
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteThreeByteCharacter() {
        try {
            writer.write(0xFFFF); // 3-byte character
            byte[] expectedOutput = new byte[] {(byte) 0xE0, (byte) 0xBF, (byte) 0xBF}; // Expecting UTF-8 bytes
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteFourByteCharacter() {
        try {
            writer.write(0x10FFFF); // 4-byte character
            byte[] expectedOutput = new byte[] {(byte) 0xF4, (byte) 0x8F, (byte) 0xBF, (byte) 0xBF}; // Expecting UTF-8 bytes
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}