package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import java.io.IOException;
import java.io.Closeable;
import java.io.StringWriter;
import static org.mockito.Mockito.*;

public class ObjectMapper_writeValue_JsonGenerator_Object_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testWriteValueWithIndentOutput() {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
        when(jsonGenerator.getPrettyPrinter()).thenReturn(null);
        
        // Mocking SerializationConfig using a spy on ObjectMapper
        // Instead of mocking SerializationConfig, we can use the ObjectMapper directly
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        // Act
        try {
            objectMapper.writeValue(jsonGenerator, new Object());
            verify(jsonGenerator).setPrettyPrinter(any());
            verify(jsonGenerator).flush();
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        } 
    }

    @Test(timeout = 4000)
    public void testWriteValueWithCloseable() {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
        Closeable closeableValue = mock(Closeable.class);
        
        // Enable CLOSE_CLOSEABLE feature directly on ObjectMapper
        objectMapper.enable(SerializationFeature.CLOSE_CLOSEABLE);
        
        // Act
        try {
            objectMapper.writeValue(jsonGenerator, closeableValue);
            // Verify that _writeCloseableValue is called
            // Note: _writeCloseableValue is a private method, so we cannot verify it directly.
            // Instead, we would need to verify the behavior that it would invoke.
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        } 
    }

}