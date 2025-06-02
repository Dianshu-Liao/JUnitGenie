package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import java.io.IOException;
import java.io.Closeable;
import static org.mockito.Mockito.*;

public class ObjectMapper_writeValue_JsonGenerator_Object_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testWriteValueWithCloseable() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseableValue = mock(Closeable.class);
        
        // Instead of mocking SerializationConfig, we create a real instance
        SerializationConfig mockConfig = objectMapper.getSerializationConfig();
        
        // Act
        try {
            objectMapper.writeValue(mockGenerator, mockCloseableValue);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }

        // Assert
        verify(mockGenerator, times(1)).flush();
        verify(mockCloseableValue, times(1)).close();
    }

    @Test(timeout = 4000)
    public void testWriteValueWithoutCloseable() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Object mockValue = new Object();
        
        // Instead of mocking SerializationConfig, we create a real instance
        SerializationConfig mockConfig = objectMapper.getSerializationConfig();
        
        // Act
        try {
            objectMapper.writeValue(mockGenerator, mockValue);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }

        // Assert
        verify(mockGenerator, times(1)).flush();
    }


}