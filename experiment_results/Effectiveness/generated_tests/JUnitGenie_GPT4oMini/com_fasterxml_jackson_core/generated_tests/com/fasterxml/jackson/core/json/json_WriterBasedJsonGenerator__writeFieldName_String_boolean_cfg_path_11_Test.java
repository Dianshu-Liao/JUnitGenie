package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Before;
import org.junit.Test;
import java.io.StringWriter;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class json_WriterBasedJsonGenerator__writeFieldName_String_boolean_cfg_path_11_Test {
    private WriterBasedJsonGenerator generator;
    private StringWriter writer;

    @Before
    public void setUp() {
        writer = new StringWriter();
        IOContext ioContext = new IOContext(null, writer, false);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, writer);
        // Initialize necessary fields to ensure valid state
        try {
            // Accessing protected fields using reflection
            Method setOutputTail = WriterBasedJsonGenerator.class.getDeclaredMethod("setOutputTail", int.class);
            setOutputTail.setAccessible(true);
            setOutputTail.invoke(generator, 0);

            Method setOutputEnd = WriterBasedJsonGenerator.class.getDeclaredMethod("setOutputEnd", int.class);
            setOutputEnd.setAccessible(true);
            setOutputEnd.invoke(generator, 100); // Set a valid output end

            Method setQuoteChar = WriterBasedJsonGenerator.class.getDeclaredMethod("setQuoteChar", char.class);
            setQuoteChar.setAccessible(true);
            setQuoteChar.invoke(generator, '"'); // Set quote character
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteFieldNameWithCommaBefore() {
        try {
            // Invoke the protected method using reflection
            Method writeFieldNameMethod = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeFieldName", String.class, boolean.class);
            writeFieldNameMethod.setAccessible(true);
            writeFieldNameMethod.invoke(generator, "fieldName", true);

            // Verify the output
            String expectedOutput = ",\"fieldName\"";
            assertEquals(expectedOutput, writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteFieldNameWithoutCommaBefore() {
        try {
            // Clear the writer before the test
            writer.getBuffer().setLength(0); // Reset the writer's content

            // Invoke the protected method using reflection
            Method writeFieldNameMethod = WriterBasedJsonGenerator.class.getDeclaredMethod("_writeFieldName", String.class, boolean.class);
            writeFieldNameMethod.setAccessible(true);
            writeFieldNameMethod.invoke(generator, "fieldName", false);

            // Verify the output
            String expectedOutput = "\"fieldName\"";
            assertEquals(expectedOutput, writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}