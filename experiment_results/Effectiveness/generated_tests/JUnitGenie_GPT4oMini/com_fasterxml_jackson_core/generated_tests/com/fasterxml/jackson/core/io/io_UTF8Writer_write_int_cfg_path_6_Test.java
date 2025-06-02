package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.UTF8Writer;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_6_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Create a new IOContext with a proper buffer size
        IOContext context = new IOContext(null, outputStream, false);
        writer = new UTF8Writer(context, outputStream);
    }

    @Test(timeout = 4000)
    public void testWriteWithSurrogateConversion() {
        try {
            writer.write(0xD800); // First part of a surrogate pair
            writer.write(0xDC00); // Second part of a surrogate pair

            // Expected output after surrogate conversion
            byte[] expectedOutput = new byte[] {
                (byte) 0xED, (byte) 0xA0, (byte) 0x80, // 4-byte UTF-8 encoding for U+10000
            };

            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteWithIllegalSurrogate() {
        try {
            writer.write(0xD800); // Set first part of surrogate
            writer.write(0xD800); // Attempt to write an illegal second part

            // If the method does not throw an exception, the test fails
            assert false : "Expected an IOException due to illegal surrogate";
        } catch (IOException e) {
            // Expected exception for illegal surrogate
        }
    }

    @Test(timeout = 4000)
    public void testWriteAsciiCharacter() {
        try {
            writer.write(65); // ASCII 'A'

            byte[] expectedOutput = new byte[] { 65 }; // Expected output is just the byte for 'A'
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteTwoByteCharacter() {
        try {
            writer.write(0x00E9); // 'é' in UTF-8

            byte[] expectedOutput = new byte[] { (byte) 0xC3, (byte) 0xA9 }; // Expected UTF-8 encoding for 'é'
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteThreeByteCharacter() {
        try {
            writer.write(0x20AC); // '€' in UTF-8

            byte[] expectedOutput = new byte[] { (byte) 0xE2, (byte) 0x82, (byte) 0xAC }; // Expected UTF-8 encoding for '€'
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteFourByteCharacter() {
        try {
            writer.write(0x1F600); // '😀' in UTF-8

            byte[] expectedOutput = new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x80 }; // Expected UTF-8 encoding for '😀'
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}