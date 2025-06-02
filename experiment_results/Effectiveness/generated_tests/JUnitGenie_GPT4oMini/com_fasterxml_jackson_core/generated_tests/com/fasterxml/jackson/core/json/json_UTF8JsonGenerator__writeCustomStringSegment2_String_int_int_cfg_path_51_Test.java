package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static org.junit.Assert.assertArrayEquals;

public class json_UTF8JsonGenerator__writeCustomStringSegment2_String_int_int_cfg_path_51_Test {

    @Test(timeout = 4000)
    public void testWriteCustomStringSegment2() {
        // Setup
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream);
        
        // Prepare input parameters
        String text = "Hello, World!";
        int offset = 0;
        int end = text.length();
        
        // Accessing the private method using reflection
        try {
            java.lang.reflect.Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeCustomStringSegment2", String.class, int.class, int.class);
            method.setAccessible(true);
            method.invoke(generator, text, offset, end);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Verify the output
        byte[] expectedOutput = "Hello, World!".getBytes();
        byte[] actualOutput = outputStream.toByteArray();
        assertArrayEquals(expectedOutput, actualOutput);
    }


}