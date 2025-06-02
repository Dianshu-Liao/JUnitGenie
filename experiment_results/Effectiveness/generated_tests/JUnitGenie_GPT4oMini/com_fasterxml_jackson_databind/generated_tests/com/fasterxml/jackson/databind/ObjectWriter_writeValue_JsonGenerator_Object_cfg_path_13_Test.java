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

public class ObjectWriter_writeValue_JsonGenerator_Object_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testWriteValueWithCloseable() {
        // Arrange
        ObjectWriter objectWriter = createObjectWriter();
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
        Closeable closeableValue = mock(Closeable.class);
        
        // Act
        try {
            objectWriter.writeValue(jsonGenerator, closeableValue);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }

        // Assert
        try {
            verify(closeableValue).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteValueWithoutCloseable() {
        // Arrange
        ObjectWriter objectWriter = createObjectWriter();
        JsonGenerator jsonGenerator = mock(JsonGenerator.class);
        Object nonCloseableValue = new Object();

        // Act
        try {
            objectWriter.writeValue(jsonGenerator, nonCloseableValue);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }

        // Assert
        try {
            verify(jsonGenerator, times(1)).flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ObjectWriter createObjectWriter() {
        // Create an instance of ObjectWriter using a valid constructor
        ObjectMapper objectMapper = new ObjectMapper();
        SerializationConfig serializationConfig = objectMapper.getSerializationConfig();
        return objectMapper.writer(); // Using ObjectMapper to create ObjectWriter
    }


}