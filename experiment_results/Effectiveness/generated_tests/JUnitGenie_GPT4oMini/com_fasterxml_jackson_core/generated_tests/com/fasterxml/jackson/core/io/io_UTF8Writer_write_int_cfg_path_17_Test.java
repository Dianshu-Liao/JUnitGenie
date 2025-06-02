package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_17_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Create a valid IOContext object instead of passing null
        writer = new UTF8Writer(new IOContext(new BufferRecycler(), null, false), outputStream);
    }

    @Test(timeout = 4000)
    public void testWrite_ValidASCIICharacter() {
        try {
            writer.write(65); // Writing 'A'
            writer.write(66); // Writing 'B'
            writer.write(67); // Writing 'C'
            assertArrayEquals(new byte[]{65, 66, 67}, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace(); // Handle IOException
        }
    }

    @Test(timeout = 4000)
    public void testWrite_ValidTwoByteCharacter() {
        try {
            writer.write(200); // Example of a 2-byte character
            assertArrayEquals(new byte[]{(byte) 0xc8, (byte) 0x80}, outputStream.toByteArray()); // Expected bytes
        } catch (IOException e) {
            e.printStackTrace(); // Handle IOException
        }
    }

    @Test(timeout = 4000)
    public void testWrite_ValidThreeByteCharacter() {
        try {
            writer.write(0x20AC); // Example Euro sign (3-byte character)
            assertArrayEquals(new byte[]{(byte) 0xe2, (byte) 0x82, (byte) 0xac}, outputStream.toByteArray()); // Expected bytes
        } catch (IOException e) {
            e.printStackTrace(); // Handle IOException
        }
    }

    @Test(timeout = 4000)
    public void testWrite_ValidFourByteCharacter() {
        try {
            writer.write(0x1F600); // Grinning face emoji (4-byte character)
            // Expect appropriate bytes representation for the character
            assertArrayEquals(new byte[]{(byte) 0xf0, (byte) 0x9f, (byte) 0x98, (byte) 0x80}, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace(); // Handle IOException
        }
    }

    @Test(expected = IOException.class)
    public void testWrite_InvalidCharacter() throws IOException { // Added throws declaration
        writer.write(0x110000); // Invalid character above 0x10FFFF
    }

    @Test(timeout = 4000)
    public void testWrite_SurrogatePairHandling() {
        try {
            writer.write(0xD800); // First part of a surrogate pair
            writer.write(0xDC00); // Second part of a surrogate pair
            // Expected handling of surrogate pair, verifications might depend on logic
        } catch (IOException e) {
            e.printStackTrace(); // Handle IOException
        }
    }

}