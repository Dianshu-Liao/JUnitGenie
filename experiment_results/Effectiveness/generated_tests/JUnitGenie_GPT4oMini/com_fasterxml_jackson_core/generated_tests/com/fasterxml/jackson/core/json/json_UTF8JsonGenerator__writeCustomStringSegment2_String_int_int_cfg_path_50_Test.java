package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class json_UTF8JsonGenerator__writeCustomStringSegment2_String_int_int_cfg_path_50_Test {

    @Test(timeout = 4000)
    public void testWriteCustomStringSegment2() {
        // Setup
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, byteArrayOutputStream, false);
        OutputStream outputStream = byteArrayOutputStream;
        UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream);
        
        String text = "Sample text";
        int offset = 0;
        int end = text.length();

        try {
            // Accessing the private method using reflection
            java.lang.reflect.Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeCustomStringSegment2", String.class, int.class, int.class);
            method.setAccessible(true);
            
            // Invoke the method
            method.invoke(generator, text, offset, end);
            
            // Verify the output
            byte[] outputBuffer = (byte[]) UTF8JsonGenerator.class.getDeclaredField("_outputBuffer").get(generator);
            int outputTail = (int) UTF8JsonGenerator.class.getDeclaredField("_outputTail").get(generator);
            String result = new String(outputBuffer, 0, outputTail, "UTF-8");
            
            assertEquals("Sample text", result);
        } catch (IOException e) {
            fail("IOException occurred: " + e.getMessage());
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }


}