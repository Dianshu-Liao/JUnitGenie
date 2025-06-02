package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import org.junit.Test;
import java.io.Closeable;
import java.io.IOException;
import java.io.StringWriter;
import static org.mockito.Mockito.*;

public class ObjectWriter_writeValue_JsonGenerator_Object_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testWriteValueWithCloseable() throws IOException {
        // Arrange
        ObjectWriter objectWriter = mock(ObjectWriter.class);
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
        Closeable closeableValue = mock(Closeable.class);
        SerializationConfig config = mock(SerializationConfig.class);
        DefaultSerializerProvider serializerProvider = mock(DefaultSerializerProvider.class);

        when(objectWriter.getConfig()).thenReturn(config);
        when(config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(true);
        // Removed the line that caused the error
        // when(objectWriter.getSerializerProvider()).thenReturn(serializerProvider);
        
        // Act
        objectWriter.writeValue(jsonGenerator, closeableValue);

        // Assert
        verify(closeableValue).close();
    }

    @Test(timeout = 4000)
    public void testWriteValueWithoutCloseable() throws IOException {
        // Arrange
        ObjectWriter objectWriter = mock(ObjectWriter.class);
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
        Object nonCloseableValue = new Object();
        SerializationConfig config = mock(SerializationConfig.class);
        
        when(objectWriter.getConfig()).thenReturn(config);
        when(config.isEnabled(SerializationFeature.CLOSE_CLOSEABLE)).thenReturn(false);
        
        // Act
        objectWriter.writeValue(jsonGenerator, nonCloseableValue);

        // Assert
        verify(jsonGenerator, times(1)).flush();
    }


}