package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.ObjectCodec;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import static org.junit.Assert.assertArrayEquals;

public class json_UTF8JsonGenerator__writeStringSegmentASCII2_char_____int_int_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testWriteStringSegmentASCII2() {
        try {
            // Setup the context and the generator
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            IOContext ioContext = new IOContext(null, outputStream, false);
            ObjectCodec objectCodec = null; // Assuming no codec is needed for this test
            UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, objectCodec, outputStream);

            // Set the protected fields directly using reflection
            Field outputTailField = UTF8JsonGenerator.class.getDeclaredField("_outputTail");
            outputTailField.setAccessible(true);
            outputTailField.setInt(generator, 0); // Set _outputTail to 0

            Field outputEndField = UTF8JsonGenerator.class.getDeclaredField("_outputEnd");
            outputEndField.setAccessible(true);
            outputEndField.setInt(generator, 10); // Set _outputEnd to a value greater than _outputTail

            Field outputBufferField = UTF8JsonGenerator.class.getDeclaredField("_outputBuffer");
            outputBufferField.setAccessible(true);
            byte[] outputBuffer = new byte[10]; // Create a buffer of size 10
            outputBufferField.set(generator, outputBuffer);

            // Prepare the input parameters
            char[] cbuf = "Hello".toCharArray();
            int offset = 0;
            int end = cbuf.length;

            // Access the private method using reflection
            Method method = UTF8JsonGenerator.class.getDeclaredMethod("_writeStringSegmentASCII2", char[].class, int.class, int.class);
            method.setAccessible(true);

            // Invoke the method
            method.invoke(generator, cbuf, offset, end);

            // Verify the output
            byte[] expectedOutput = "Hello".getBytes("UTF-8");
            assertArrayEquals(expectedOutput, outputStream.toByteArray());

        } catch (NoSuchMethodException | IllegalAccessException | IOException | java.lang.reflect.InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}