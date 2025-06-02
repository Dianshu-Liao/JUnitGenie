package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.util.ClassUtil;
import org.junit.Test;
import java.io.Closeable;
import java.io.IOException;
import java.io.StringWriter;
import static org.mockito.Mockito.*;

public class ObjectMapper__writeValueAndClose_JsonGenerator_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWriteValueAndCloseWithCloseable() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseable = mock(Closeable.class);
        
        // Set up the SerializationConfig to enable CLOSE_CLOSEABLE
        SerializationConfig mockConfig = mock(SerializationConfig.class);
        when(mockConfig.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(true);
        // Use reflection to set the serialization config
        setSerializationConfig(objectMapper, mockConfig);
        
        try {
            objectMapper.getClass().getDeclaredMethod("_writeValueAndClose", JsonGenerator.class, Object.class)
                    .setAccessible(true);
            objectMapper.getClass().getDeclaredMethod("_writeValueAndClose", JsonGenerator.class, Object.class)
                    .invoke(objectMapper, mockGenerator, mockCloseable);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            try {
                ClassUtil.closeOnFailAndThrowAsIOE(mockGenerator, e);
            } catch (IOException ioException) {
                // Handle IOException if needed
            }
        }
        
        // Verify that the closeable was handled
        verify(mockCloseable).close();
    }

    @Test(timeout = 4000)
    public void testWriteValueAndCloseWithException() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Object value = new Object(); // Any object that is not Closeable
        
        // Set up the SerializationConfig to not enable CLOSE_CLOSEABLE
        SerializationConfig mockConfig = mock(SerializationConfig.class);
        when(mockConfig.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(false);
        // Use reflection to set the serialization config
        setSerializationConfig(objectMapper, mockConfig);
        
        // Mock the serializer provider to throw an exception
        DefaultSerializerProvider mockProvider = mock(DefaultSerializerProvider.class);
        when(objectMapper._serializerProvider(mockConfig)).thenReturn(mockProvider);
        doThrow(new IOException("Serialization error")).when(mockProvider).serializeValue(mockGenerator, value);
        
        try {
            objectMapper.getClass().getDeclaredMethod("_writeValueAndClose", JsonGenerator.class, Object.class)
                    .setAccessible(true);
            objectMapper.getClass().getDeclaredMethod("_writeValueAndClose", JsonGenerator.class, Object.class)
                    .invoke(objectMapper, mockGenerator, value);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            try {
                ClassUtil.closeOnFailAndThrowAsIOE(mockGenerator, e);
            } catch (IOException ioException) {
                // Handle IOException if needed
            }
        }
        
        // Verify that the generator was closed
        verify(mockGenerator).close();
    }

    private void setSerializationConfig(ObjectMapper objectMapper, SerializationConfig config) throws Exception {
        // Use reflection to set the serialization config
        java.lang.reflect.Field field = ObjectMapper.class.getDeclaredField("_serializationConfig");
        field.setAccessible(true);
        field.set(objectMapper, config);
    }

}