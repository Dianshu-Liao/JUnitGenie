package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_4_Test {
    private UTF8Writer writer;
    private ByteArrayOutputStream outputStream;


    @Test(timeout = 4000)
    public void testWriteWithSurrogateConversion() {
        try {
            // Set the _surrogate field to a valid value
            writer.getClass().getDeclaredField("_surrogate").set(writer, 56320); // First part of surrogate
            writer.write(57343); // Second part of surrogate

            // Expected output after surrogate conversion
            byte[] expectedOutput = new byte[] {
                (byte) 0xed, (byte) 0xa0, (byte) 0x80, // UTF-8 encoding for U+D800
                (byte) 0xed, (byte) 0xbf, (byte) 0xbf  // UTF-8 encoding for U+DFFF
            };
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
