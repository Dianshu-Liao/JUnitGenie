package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class json_UTF8JsonGenerator__writeStringSegmentASCII2_char_____int_int_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testWriteStringSegmentASCII2() {
        try {
            // Setup
            char[] cbuf = new char[] {'a', 'b', 'c', 'd', 'e'};
            int offset = 0;
            int end = cbuf.length;

            // Create an instance of UTF8JsonGenerator
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            IOContext ioContext = new IOContext(null, outputStream, false); // Set BufferRecycler to null
            UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream);

            // Set the protected fields to meet the constraints
            java.lang.reflect.Field outputTailField = UTF8JsonGenerator.class.getDeclaredField("_outputTail");
            outputTailField.setAccessible(true);
            outputTailField.setInt(generator, 1); // Set _outputTail to 1

            java.lang.reflect.Field outputEndField = UTF8JsonGenerator.class.getDeclaredField("_outputEnd");
            outputEndField.setAccessible(true);
            outputEndField.setInt(generator, 10); // Set _outputEnd to 10

            // Call the private method using reflection
            Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeStringSegmentASCII2", char[].class, int.class, int.class);
            method.setAccessible(true);
            method.invoke(generator, cbuf, offset, end);

            // Verify the output
            byte[] expectedOutput = new byte[] {'a', 'b', 'c', 'd', 'e'};
            assertArrayEquals(expectedOutput, outputStream.toByteArray());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}