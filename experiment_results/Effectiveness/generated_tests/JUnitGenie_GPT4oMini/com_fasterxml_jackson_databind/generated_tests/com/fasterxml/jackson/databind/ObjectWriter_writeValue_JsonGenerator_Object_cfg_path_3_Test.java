package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.util.ClassUtil;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.Closeable;
import java.io.IOException;

public class ObjectWriter_writeValue_JsonGenerator_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWriteValueWithCloseable() {
        // Arrange
        ObjectWriter objectWriter = Mockito.mock(ObjectWriter.class);
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        Closeable closeableValue = Mockito.mock(Closeable.class);
        
        // Mocking the behavior of _config to return true for CLOSE_CLOSEABLE
        SerializationConfig config = Mockito.mock(SerializationConfig.class);
        Mockito.when(config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(true);
        Mockito.when(objectWriter.getConfig()).thenReturn(config);
        
        // Act
        try {
            objectWriter.writeValue(jsonGenerator, closeableValue);
        } catch (IOException e) {
            // Handle the exception
            try {
                ClassUtil.closeOnFailAndThrowAsIOE(null, closeableValue, e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return; // Exit if exception is thrown
        }
        
        // Assert
        try {
            Mockito.verify(closeableValue).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteValueWithoutCloseable() {
        // Arrange
        ObjectWriter objectWriter = Mockito.mock(ObjectWriter.class);
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        Object nonCloseableValue = new Object();
        
        // Mocking the behavior of _config to return false for CLOSE_CLOSEABLE
        SerializationConfig config = Mockito.mock(SerializationConfig.class);
        Mockito.when(config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(false);
        Mockito.when(objectWriter.getConfig()).thenReturn(config);
        
        // Act
        try {
            objectWriter.writeValue(jsonGenerator, nonCloseableValue);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
        
        // Assert
        try {
            Mockito.verify(jsonGenerator, Mockito.times(1)).writeObject(nonCloseableValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}