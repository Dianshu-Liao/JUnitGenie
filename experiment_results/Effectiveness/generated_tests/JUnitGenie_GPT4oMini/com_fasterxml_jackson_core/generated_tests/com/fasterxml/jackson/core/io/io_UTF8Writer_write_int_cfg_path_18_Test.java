package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.io.UTF8Writer;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_18_Test {

    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Corrected the instantiation of UTF8Writer to include OutputStream
        writer = new UTF8Writer(new com.fasterxml.jackson.core.io.IOContext(
            null, // BufferRecycler
            null, // ContentReference
            false // boolean
        ), outputStream); // Pass the outputStream as the second argument
    }

    @Test(timeout = 4000)
    public void testWriteAscii() {
        try {
            writer.write(65); // ASCII value for 'A'
            writer.write(66); // ASCII value for 'B'
            writer.write(67); // ASCII value for 'C'
            // Flush the writer to ensure content is written to the output stream
            writer.flush(); // Use flush instead of writing 0
            assertArrayEquals(new byte[]{65, 66, 67}, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrite2ByteCharacter() {
        try {
            writer.write(196); // 0xC4, start of 2-byte UTF-8
            writer.write(130); // 0x82, continuation
            writer.flush(); // Use flush instead of writing 0
            assertArrayEquals(new byte[]{-60, -110}, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrite3ByteCharacter() {
        try {
            writer.write(2047); // 0x7FF, start of 3-byte UTF-8
            writer.flush(); // Use flush instead of writing 0
            assertArrayEquals(new byte[]{-16, -128, -1}, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWrite4ByteCharacter() {
        try {
            writer.write(65536); // 0x10000, start of 4-byte UTF-8
            writer.flush(); // Use flush instead of writing 0
            assertArrayEquals(new byte[]{-8, -24, -128, 0}, outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IOException.class)
    public void testWriteIllegalSurrogate() throws IOException { // Declare IOException to be thrown
        writer.write(0xD800); // Illegal surrogate
        writer.flush(); // Use flush instead of writing 0
    }

}