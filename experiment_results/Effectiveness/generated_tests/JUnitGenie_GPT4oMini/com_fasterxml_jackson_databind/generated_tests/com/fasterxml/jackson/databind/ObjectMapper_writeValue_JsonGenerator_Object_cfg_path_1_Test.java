package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import java.io.IOException;
import java.io.Closeable;
import static org.mockito.Mockito.*;

public class ObjectMapper_writeValue_JsonGenerator_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteValueWithCloseable() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseableValue = mock(Closeable.class);
        
        // Act
        try {
            objectMapper.writeValue(mockGenerator, mockCloseableValue);
        } catch (IOException e) {
            // Handle exception if necessary
        }

        // Assert
        verify(mockGenerator, times(1)).setPrettyPrinter(any());
        verify(mockCloseableValue, times(1)).close();
    }

    @Test(timeout = 4000)
    public void testWriteValueWithoutCloseable() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Object value = new Object(); // Non-Closeable object
        
        // Act
        try {
            objectMapper.writeValue(mockGenerator, value);
        } catch (IOException e) {
            // Handle exception if necessary
        }

        // Assert
        verify(mockGenerator, times(1)).flush();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWriteValueWithNullGenerator() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        Object value = new Object(); // Non-Closeable object
        
        // Act
        try {
            objectMapper.writeValue((JsonGenerator) null, value);
        } catch (IOException e) {
            // Handle exception if necessary
        }
    }


}