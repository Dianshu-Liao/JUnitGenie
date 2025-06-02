package com.fasterxml.jackson.core.io;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.UTF8Writer;

public class io_UTF8Writer_write_int_cfg_path_1_Test {

    private UTF8Writer utf8Writer;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        // Create a valid IOContext with a proper buffer size
        IOContext ioContext = new IOContext(null, outputStream, true);
        utf8Writer = new UTF8Writer(ioContext, outputStream);
    }

    @Test(timeout = 4000)
    public void testWriteWithSurrogateConversion() {
        try {
            // Set _surrogate to a value greater than 0
            setPrivateField(utf8Writer, "_surrogate", 1);
            // Call a value that requires surrogate conversion
            utf8Writer.write(0xD800); // Example of a valid high surrogate
            // Check the output after writing
            assertEquals(2, outputStream.size());
        } catch (IOException e) {
            fail("IOException should not occur");
        }
    }

    // Helper method to set a private field via reflection
    private void setPrivateField(Object obj, String fieldName, int value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.setInt(obj, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }


}