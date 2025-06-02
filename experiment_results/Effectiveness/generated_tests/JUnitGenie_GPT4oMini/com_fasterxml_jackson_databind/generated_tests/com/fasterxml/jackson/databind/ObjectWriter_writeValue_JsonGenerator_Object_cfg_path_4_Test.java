package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.Closeable;
import java.io.IOException;

public class ObjectWriter_writeValue_JsonGenerator_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWriteValueWithCloseable() {
        // Arrange
        ObjectWriter objectWriter = Mockito.mock(ObjectWriter.class);
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        Closeable closeableValue = Mockito.mock(Closeable.class);
        SerializationConfig serializationConfig = Mockito.mock(SerializationConfig.class);
        
        // Mocking the behavior of the config
        Mockito.when(serializationConfig.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(true);
        Mockito.when(serializationConfig.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)).thenReturn(true);
        
        // Setting the internal state of the ObjectWriter
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
            Mockito.verify(closeableValue).close();
            Mockito.verify(jsonGenerator).flush();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteValueWithoutCloseable() {
        // Arrange
        ObjectWriter objectWriter = Mockito.mock(ObjectWriter.class);
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        Object nonCloseableValue = new Object();
        SerializationConfig serializationConfig = Mockito.mock(SerializationConfig.class);
        
        // Mocking the behavior of the config
        Mockito.when(serializationConfig.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(false);
        Mockito.when(serializationConfig.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)).thenReturn(true);
        
        // Setting the internal state of the ObjectWriter
        Mockito.when(objectWriter.getConfig()).thenReturn(serializationConfig);
        
        // Act
        try {
            objectWriter.writeValue(jsonGenerator, nonCloseableValue);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(jsonGenerator).flush();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}