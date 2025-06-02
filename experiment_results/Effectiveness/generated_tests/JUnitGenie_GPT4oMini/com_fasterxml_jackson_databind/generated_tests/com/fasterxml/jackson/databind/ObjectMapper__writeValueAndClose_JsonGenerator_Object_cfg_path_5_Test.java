package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.mockito.Mockito.*;

public class ObjectMapper__writeValueAndClose_JsonGenerator_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testWriteValueAndCloseWithCloseable() throws Exception {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseable = mock(Closeable.class);
        
        // Set up the SerializationConfig to return true for CLOSE_CLOSEABLE
        SerializationConfig mockConfig = mock(SerializationConfig.class);
        when(mockConfig.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(true);
        when(objectMapper.getSerializationConfig()).thenReturn(mockConfig);
        
        // Act
        Method method = ObjectMapper.class.getDeclaredMethod("_writeValueAndClose", JsonGenerator.class, Object.class);
        method.setAccessible(true);
        method.invoke(objectMapper, mockGenerator, mockCloseable);
        
        // Assert
        verify(mockGenerator).close();
    }

    @Test(timeout = 4000)
    public void testWriteValueAndCloseWithNonCloseable() throws Exception {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Object nonCloseableObject = new Object();
        
        // Set up the SerializationConfig to return false for CLOSE_CLOSEABLE
        SerializationConfig mockConfig = mock(SerializationConfig.class);
        when(mockConfig.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(false);
        when(objectMapper.getSerializationConfig()).thenReturn(mockConfig);
        
        // Act
        Method method = ObjectMapper.class.getDeclaredMethod("_writeValueAndClose", JsonGenerator.class, Object.class);
        method.setAccessible(true);
        try {
            method.invoke(objectMapper, mockGenerator, nonCloseableObject);
        } catch (Exception e) {
            // Handle the exception
            if (e.getCause() instanceof IOException) {
                // Assert
                verify(mockGenerator).close();
            }
        }
    }

}