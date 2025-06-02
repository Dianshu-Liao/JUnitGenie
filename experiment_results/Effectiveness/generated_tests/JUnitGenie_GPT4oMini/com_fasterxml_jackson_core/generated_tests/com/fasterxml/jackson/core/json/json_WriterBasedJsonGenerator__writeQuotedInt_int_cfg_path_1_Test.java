package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Before;
import org.junit.Test;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class json_WriterBasedJsonGenerator__writeQuotedInt_int_cfg_path_1_Test {
    private WriterBasedJsonGenerator generator;
    private StringWriter writer;

    @Before
    public void setUp() {
        writer = new StringWriter();
        IOContext context = new IOContext(null, null, false); // The second parameter should not be null
        generator = new WriterBasedJsonGenerator(context, 0, null, writer);
        // Initialize protected fields for testing
        try {
            setProtectedFields(generator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setProtectedFields(WriterBasedJsonGenerator generator) throws Exception {
        // Access and set the protected fields using reflection
        java.lang.reflect.Field outputTailField = WriterBasedJsonGenerator.class.getDeclaredField("_outputTail");
        outputTailField.setAccessible(true);
        outputTailField.setInt(generator, 0);

        java.lang.reflect.Field outputBufferField = WriterBasedJsonGenerator.class.getDeclaredField("_outputBuffer");
        outputBufferField.setAccessible(true);
        char[] outputBuffer = new char[100]; // Ensure enough space
        outputBufferField.set(generator, outputBuffer);

        java.lang.reflect.Field quoteCharField = WriterBasedJsonGenerator.class.getDeclaredField("_quoteChar");
        quoteCharField.setAccessible(true);
        quoteCharField.setChar(generator, '"');

        java.lang.reflect.Field outputEndField = WriterBasedJsonGenerator.class.getDeclaredField("_outputEnd");
        outputEndField.setAccessible(true);
        outputEndField.setInt(generator, outputBuffer.length);
    }

    @Test(timeout = 4000)
    public void testWriteQuotedInt() {
        try {
            Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeQuotedInt", int.class);
            method.setAccessible(true);
            method.invoke(generator, 123); // Valid input within constraints

            // Check the output
            String expectedOutput = "\"123\"";
            assertEquals(expectedOutput, writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}