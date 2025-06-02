package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class io_UTF8Writer_write_int_cfg_path_32_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Create a valid IOContext object instead of passing null
        writer = new UTF8Writer(new IOContext(new BufferRecycler(), null, false), outputStream);
    }

    @Test(timeout = 4000)
    public void testWriteSurrogate() throws IOException {
        // Set _surrogate to 0 to allow writing
        writer.write(0xD800); // First part of a surrogate pair
        // The _surrogate should now hold the value of the first part
        // The next call should write the second part
        writer.write(0xDC00); // Second part of a surrogate pair
        // Verify the output
        byte[] expectedOutput = new byte[] {(byte) 0xED, (byte) 0xA0, (byte) 0x80, (byte) 0xED, (byte) 0xB0, (byte) 0x80}; // UTF-8 encoding of the surrogate pair
        assertEquals(expectedOutput, outputStream.toByteArray());
    }

    @Test(timeout = 4000)
    public void testWriteIllegalSurrogate() {
        try {
            writer.write(0xDC00); // Attempt to write second part without first
        } catch (IOException e) {
            // Expected exception
        }
    }

}