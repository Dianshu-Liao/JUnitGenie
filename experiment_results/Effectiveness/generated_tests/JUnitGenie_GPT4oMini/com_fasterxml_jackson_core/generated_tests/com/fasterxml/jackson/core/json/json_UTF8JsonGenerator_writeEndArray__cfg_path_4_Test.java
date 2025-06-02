package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.io.IOContext;
import java.io.OutputStream;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class json_UTF8JsonGenerator_writeEndArray__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWriteEndArray_WithContextInArray() {
        // Arrange
        IOContext ioContext = new IOContext(null, new ByteArrayOutputStream(), false);
        OutputStream outputStream = new ByteArrayOutputStream();
        UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream);
        
        // Mock or set the _writeContext to have an array context
        // This is a placeholder for the actual context setup
        // You may need to use reflection or a mocking framework to set this up correctly

        try {
            // Act
            generator.writeStartArray(); // Start an array context
            generator.writeEndArray();    // This should not throw

            // If still reachable, assert some output conditions if needed
        } catch (IOException e) {
            fail("IOException should not be thrown");
        }
    }

    @Test(timeout = 4000)
    public void testWriteEndArray_WithoutArrayContext() {
        // Arrange
        IOContext ioContext = new IOContext(null, new ByteArrayOutputStream(), false);
        OutputStream outputStream = new ByteArrayOutputStream();
        UTF8JsonGenerator generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream);

        // Act and Assert
        try {
            generator.writeEndArray();
            fail("Expected IOException due to current context not being an Array");
        } catch (IOException e) {
            // Expected exception
            assertTrue(e.getMessage().contains("Current context not Array"));
        }
    }


}