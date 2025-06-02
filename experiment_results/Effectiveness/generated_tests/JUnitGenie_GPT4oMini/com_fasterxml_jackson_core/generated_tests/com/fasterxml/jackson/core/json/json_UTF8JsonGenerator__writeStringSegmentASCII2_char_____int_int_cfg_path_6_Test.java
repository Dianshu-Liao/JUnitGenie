package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class json_UTF8JsonGenerator__writeStringSegmentASCII2_char_____int_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testWriteStringSegmentASCII2() {
        // Setup
        char[] cbuf = new char[] {'a', 'b', 'c', 'd', 'e', 'f'};
        int offset = 0;
        int end = cbuf.length;

        // Create an instance of UTF8JsonGenerator
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        ObjectCodec codec = null; // Initialize ObjectCodec to avoid NullPointerException
        UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, codec, outputStream);

        // Set up the protected fields for testing
        try {
            // Access the private method using reflection
            Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeStringSegmentASCII2", char[].class, int.class, int.class);
            method.setAccessible(true);

            // Call the method
            method.invoke(generator, cbuf, offset, end);

            // Verify the output
            byte[] expectedOutput = new byte[] {'a', 'b', 'c', 'd', 'e', 'f'};
            assertArrayEquals(expectedOutput, outputStream.toByteArray());

        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }


}