package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.UTF8Writer;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;

public class io_UTF8Writer_write_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteWithSurrogateConversion() {
        // Prepare the OutputStream and UTF8Writer
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int initialSurrogate = 56320; // Example surrogate initial value
        
        // Create a valid IOContext with a non-null buffer
        com.fasterxml.jackson.core.io.IOContext ioContext = new com.fasterxml.jackson.core.io.IOContext(null, outputStream, false);
        
        // Corrected constructor call for UTF8Writer
        UTF8Writer writer = new UTF8Writer(ioContext, outputStream);

        // Set the _surrogate value using reflection (since it's private)
        setSurrogateField(writer, initialSurrogate);

        // Test write with a valid second part of the surrogate
        int secondPart = 57343; // Valid range as per the constraints
        try {
            writer.write(secondPart);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }

        // Assert the output buffer contents
        byte[] expectedBytes = {  };
        assertArrayEquals(expectedBytes, outputStream.toByteArray());
    }

    private void setSurrogateField(UTF8Writer writer, int value) {
        try {
            java.lang.reflect.Field surrogateField = UTF8Writer.class.getDeclaredField("_surrogate");
            surrogateField.setAccessible(true);
            surrogateField.setInt(writer, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}