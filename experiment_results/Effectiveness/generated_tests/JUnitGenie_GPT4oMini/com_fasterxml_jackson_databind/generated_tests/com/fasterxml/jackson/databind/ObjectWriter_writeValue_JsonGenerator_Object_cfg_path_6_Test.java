package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.Closeable;
import java.io.IOException;

public class ObjectWriter_writeValue_JsonGenerator_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testWriteValueWithCloseable() throws IOException {
        // Arrange
        ObjectWriter objectWriter = Mockito.mock(ObjectWriter.class);
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        Closeable closeableValue = Mockito.mock(Closeable.class);
        
        // Set up the necessary conditions
        SerializationConfig config = Mockito.mock(SerializationConfig.class);
        Mockito.when(objectWriter.getConfig()).thenReturn(config);
        Mockito.when(config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(true);
        Mockito.when(config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)).thenReturn(true);
        
        // Act
        objectWriter.writeValue(jsonGenerator, closeableValue);
        
        // Assert
        Mockito.verify(closeableValue).close();
        Mockito.verify(jsonGenerator).flush();
    }

    @Test(timeout = 4000)
    public void testWriteValueWithoutCloseable() throws IOException {
        // Arrange
        ObjectWriter objectWriter = Mockito.mock(ObjectWriter.class);
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        Object nonCloseableValue = new Object();
        
        // Set up the necessary conditions
        SerializationConfig config = Mockito.mock(SerializationConfig.class);
        Mockito.when(objectWriter.getConfig()).thenReturn(config);
        Mockito.when(config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(false);
        Mockito.when(config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)).thenReturn(true);
        
        // Act
        objectWriter.writeValue(jsonGenerator, nonCloseableValue);
        
        // Assert
        Mockito.verify(jsonGenerator).flush();
    }

}