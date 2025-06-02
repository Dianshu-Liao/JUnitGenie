package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.Closeable;
import java.io.IOException;

public class ObjectWriter_writeValue_JsonGenerator_Object_cfg_path_12_Test {

    @Test(timeout = 4000)
    public void testWriteValueWithCloseable() {
        // Arrange
        ObjectWriter objectWriter = Mockito.mock(ObjectWriter.class);
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        Closeable closeableValue = Mockito.mock(Closeable.class);
        
        // Mock the behavior of _config to return a SerializationConfig with CLOSE_CLOSEABLE disabled
        SerializationConfig serializationConfig = Mockito.mock(SerializationConfig.class);
        Mockito.when(serializationConfig.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(false);
        Mockito.when(objectWriter.getConfig()).thenReturn(serializationConfig);
        
        // Act
        try {
            objectWriter.writeValue(jsonGenerator, closeableValue);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(jsonGenerator, Mockito.times(1)).flush();
            Mockito.verify(closeableValue, Mockito.times(1)).close();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteValueThrowsException() {
        // Arrange
        ObjectWriter objectWriter = Mockito.mock(ObjectWriter.class);
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        Closeable closeableValue = Mockito.mock(Closeable.class);
        
        // Mock the behavior of _config to return a SerializationConfig with CLOSE_CLOSEABLE disabled
        SerializationConfig serializationConfig = Mockito.mock(SerializationConfig.class);
        Mockito.when(serializationConfig.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(false);
        Mockito.when(objectWriter.getConfig()).thenReturn(serializationConfig);
        
        // Mock the behavior of the serialization to throw an exception
        try {
            Mockito.doThrow(new IOException("Serialization error")).when(objectWriter)._prefetch.serialize(jsonGenerator, closeableValue, objectWriter._serializerProvider());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Act
        try {
            objectWriter.writeValue(jsonGenerator, closeableValue);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(closeableValue, Mockito.times(1)).close();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}