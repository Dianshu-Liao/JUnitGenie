package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import org.junit.Test;
import java.io.IOException;
import java.io.Closeable;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNotNull;

public class ObjectMapper_writeValue_JsonGenerator_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteValueWithPrettyPrinter() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Object value = new Object(); // Any object to serialize

        // Act
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setDefaultPrettyPrinter(new DefaultPrettyPrinter());

        // Act
        objectMapper.writeValue(mockGenerator, value);

        // Assert
        verify(mockGenerator).writeObject(value);
    }

    @Test(timeout = 4000)
    public void testWriteValueWithCloseable() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable closeableValue = mock(Closeable.class);

        // Act
        objectMapper.enable(SerializationFeature.CLOSE_CLOSEABLE);

        // Act
        objectMapper.writeValue(mockGenerator, closeableValue);

        // Assert
        verify(mockGenerator).writeObject(closeableValue);
    }

    @Test(timeout = 4000)
    public void testWriteValueFlushAfterWrite() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Object value = new Object(); // Any object to serialize

        // Act
        objectMapper.enable(SerializationFeature.FLUSH_AFTER_WRITE_VALUE);

        // Act
        objectMapper.writeValue(mockGenerator, value);

        // Assert
        verify(mockGenerator).flush();
    }

    @Test(timeout = 4000)
    public void testWriteValueWithNullGenerator() {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        Object value = new Object(); // Any object to serialize

        // Act
        try {
            objectMapper.writeValue((JsonGenerator) null, value);
        } catch (IOException e) {
            // Assert that the exception is thrown
            assertNotNull(e);
        }
    }

}