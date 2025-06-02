package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ClassUtil;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.Closeable;
import java.io.IOException;

public class ObjectWriter_writeValue_JsonGenerator_Object_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testWriteValue_withCloseableAndIOException() {
        // Arrange
        ObjectWriter writer = Mockito.mock(ObjectWriter.class);
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        Closeable closeableMock = Mockito.mock(Closeable.class);
        
        // Mocking the configuration to return a specific behavior
        SerializationConfig configMock = Mockito.mock(SerializationConfig.class);
        Mockito.when(configMock.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(true);
        Mockito.when(writer.getConfig()).thenReturn(configMock);
        
        // Act
        try {
            writer.writeValue(jsonGenerator, closeableMock);
        } catch (IOException e) {
            // Handle IOException
            try {
                ClassUtil.closeOnFailAndThrowAsIOE(null, closeableMock, e);
            } catch (IOException ioException) {
                // Handle potential IOException from closeOnFailAndThrowAsIOE
                ioException.printStackTrace();
            }
            return; // Exit on exception to mimic the method behavior
        }

        // Assert
        try {
            Mockito.verify(closeableMock).close();
        } catch (IOException e) {
            // Handle potential IOException on close
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteValue_withoutCloseable() {
        // Arrange
        ObjectWriter writer = Mockito.mock(ObjectWriter.class);
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        Object value = new Object(); // Not a Closeable

        // Mocking the configuration to return a specific behavior
        SerializationConfig configMock = Mockito.mock(SerializationConfig.class);
        Mockito.when(configMock.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(false);
        Mockito.when(writer.getConfig()).thenReturn(configMock);

        // Act
        try {
            writer.writeValue(jsonGenerator, value);
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }

        // Assert
        // Additional verifications can be added here to check the serialization process
    }

}