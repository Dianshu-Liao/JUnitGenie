package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class json_UTF8JsonGenerator__writeBytes_byte_____cfg_path_1_Test {
    private UTF8JsonGenerator generator;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext ioContext = new IOContext(null, outputStream, false);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream);
        // Initialize _outputTail and _outputEnd for testing
        try {
            // Accessing protected fields using reflection
            java.lang.reflect.Field outputTailField = UTF8JsonGenerator.class.getDeclaredField("_outputTail");
            outputTailField.setAccessible(true);
            outputTailField.setInt(generator, 0);

            java.lang.reflect.Field outputEndField = UTF8JsonGenerator.class.getDeclaredField("_outputEnd");
            outputEndField.setAccessible(true);
            outputEndField.setInt(generator, 1024); // Assuming a buffer size of 1024

            java.lang.reflect.Field outputBufferField = UTF8JsonGenerator.class.getDeclaredField("_outputBuffer");
            outputBufferField.setAccessible(true);
            outputBufferField.set(generator, new byte[1024]); // Initialize buffer
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteBytes() {
        byte[] bytesToWrite = new byte[]{1, 2, 3, 4, 5};
        try {
            // Accessing the private method _writeBytes using reflection
            Method writeBytesMethod = UTF8JsonGenerator.class.getDeclaredMethod("_writeBytes", byte[].class);
            writeBytesMethod.setAccessible(true);
            writeBytesMethod.invoke(generator, (Object) bytesToWrite);

            // Verify the output
            byte[] expectedOutput = new byte[]{1, 2, 3, 4, 5};
            assertArrayEquals(expectedOutput, outputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}