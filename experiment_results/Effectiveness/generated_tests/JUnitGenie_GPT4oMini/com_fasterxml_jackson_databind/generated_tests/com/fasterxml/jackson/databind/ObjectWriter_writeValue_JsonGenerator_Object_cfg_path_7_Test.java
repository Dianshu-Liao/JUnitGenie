package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import java.io.Closeable;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ObjectWriter_writeValue_JsonGenerator_Object_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testWriteValueWithCloseable() throws IOException {
        // Arrange
        ObjectWriter objectWriter = mock(ObjectWriter.class);
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
        Closeable closeableValue = mock(Closeable.class);
        SerializationConfig config = mock(SerializationConfig.class);

        // Use a spy to mock the ObjectWriter and avoid mocking final classes
        ObjectWriter spyObjectWriter = spy(objectWriter);
        
        when(spyObjectWriter.getConfig()).thenReturn(config);
        when(config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(true);
        when(config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)).thenReturn(true);

        // Act
        try {
            spyObjectWriter.writeValue(jsonGenerator, closeableValue);
        } catch (IOException e) {
            // Handle exception
        }

        // Assert
        verify(closeableValue).close();
        verify(jsonGenerator).flush();
    }

    @Test(timeout = 4000)
    public void testWriteValueWithoutCloseable() throws IOException {
        // Arrange
        ObjectWriter objectWriter = mock(ObjectWriter.class);
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
        Object nonCloseableValue = new Object();
        SerializationConfig config = mock(SerializationConfig.class);

        // Use a spy to mock the ObjectWriter and avoid mocking final classes
        ObjectWriter spyObjectWriter = spy(objectWriter);
        
        when(spyObjectWriter.getConfig()).thenReturn(config);
        when(config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(false);
        when(config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)).thenReturn(true);

        // Act
        try {
            spyObjectWriter.writeValue(jsonGenerator, nonCloseableValue);
        } catch (IOException e) {
            // Handle exception
        }

        // Assert
        verify(jsonGenerator).flush();
    }

    @Test(timeout = 4000)
    public void testWriteValueThrowsException() throws IOException {
        // Arrange
        ObjectWriter objectWriter = mock(ObjectWriter.class);
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
        Closeable closeableValue = mock(Closeable.class);
        SerializationConfig config = mock(SerializationConfig.class);

        // Use a spy to mock the ObjectWriter and avoid mocking final classes
        ObjectWriter spyObjectWriter = spy(objectWriter);
        
        when(spyObjectWriter.getConfig()).thenReturn(config);
        when(config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(true);
        when(config.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)).thenReturn(true);

        doThrow(new IOException("Test Exception")).when(spyObjectWriter)._prefetch.serialize(any(JsonGenerator.class), any(), any());

        // Act
        try {
            spyObjectWriter.writeValue(jsonGenerator, closeableValue);
        } catch (IOException e) {
            // Handle exception
        }

        // Assert
        verify(closeableValue).close();
    }

}