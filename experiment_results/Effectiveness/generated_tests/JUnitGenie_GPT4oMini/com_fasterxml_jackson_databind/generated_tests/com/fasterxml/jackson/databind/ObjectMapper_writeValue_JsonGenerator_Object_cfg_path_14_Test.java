package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import org.junit.Test;
import java.io.Closeable;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ObjectMapper_writeValue_JsonGenerator_Object_cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testWriteValueWithCloseable() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Closeable mockCloseableValue = mock(Closeable.class);
        DefaultSerializerProvider mockProvider = mock(DefaultSerializerProvider.class);

        when(mockGenerator.getCodec()).thenReturn(objectMapper); // Mocking the codec to return the objectMapper
        when(objectMapper.getSerializerProvider()).thenReturn(mockProvider); // Corrected method call
        when(mockProvider.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(true);
        when(mockProvider.isEnabled(SerializationFeature.INDENT_OUTPUT)).thenReturn(false);
        when(mockProvider.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)).thenReturn(false);

        // Act
        objectMapper.writeValue(mockGenerator, mockCloseableValue);

        // Assert
        verify(mockProvider).serializeValue(mockGenerator, mockCloseableValue);
        verify(mockGenerator, never()).flush(); // Since FLUSH_AFTER_WRITE_VALUE is false
    }

    @Test(timeout = 4000)
    public void testWriteValueWithNonCloseable() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        Object nonCloseableValue = new Object();
        DefaultSerializerProvider mockProvider = mock(DefaultSerializerProvider.class);

        when(mockGenerator.getCodec()).thenReturn(objectMapper); // Mocking the codec to return the objectMapper
        when(objectMapper.getSerializerProvider()).thenReturn(mockProvider); // Corrected method call
        when(mockProvider.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(false);
        when(mockProvider.isEnabled(SerializationFeature.INDENT_OUTPUT)).thenReturn(false);
        when(mockProvider.isEnabled(SerializationFeature.FLUSH_AFTER_WRITE_VALUE)).thenReturn(true);

        // Act
        objectMapper.writeValue(mockGenerator, nonCloseableValue);

        // Assert
        verify(mockProvider).serializeValue(mockGenerator, nonCloseableValue);
        verify(mockGenerator).flush(); // Since FLUSH_AFTER_WRITE_VALUE is true
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWriteValueWithNullGenerator() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        Object value = new Object();

        // Act
        objectMapper.writeValue((JsonGenerator) null, value);
    }


}