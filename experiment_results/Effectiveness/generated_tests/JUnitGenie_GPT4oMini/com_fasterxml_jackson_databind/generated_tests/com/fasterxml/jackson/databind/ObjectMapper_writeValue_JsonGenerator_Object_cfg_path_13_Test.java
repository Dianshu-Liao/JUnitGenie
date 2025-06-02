package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.io.Closeable;

public class ObjectMapper_writeValue_JsonGenerator_Object_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testWriteValueWithPrettyPrinter() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockJsonGenerator = Mockito.mock(JsonGenerator.class);
        Object value = new Object(); // replace with an actual object to be serialized

        // Act
        objectMapper.writeValue(mockJsonGenerator, value);

        // Assert
        // Verify that the pretty printer was set
        Mockito.verify(mockJsonGenerator).setPrettyPrinter(Mockito.any());
    }

    @Test(timeout = 4000)
    public void testWriteValueWithCloseableValue() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockJsonGenerator = Mockito.mock(JsonGenerator.class);
        Closeable closeableValue = Mockito.mock(Closeable.class);

        // Act
        objectMapper.writeValue(mockJsonGenerator, closeableValue);

        // Assert
        // Verify that flush was called on the mockJsonGenerator
        Mockito.verify(mockJsonGenerator, Mockito.times(1)).flush();
    }

    @Test(timeout = 4000)
    public void testWriteValueForNonCloseableValue() throws IOException {
        // Arrange
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator mockJsonGenerator = Mockito.mock(JsonGenerator.class);
        Object value = new Object(); // Replace with an actual object

        // Act
        objectMapper.writeValue(mockJsonGenerator, value);

        // Assert
        // Verify that flush was called on the mockJsonGenerator
        Mockito.verify(mockJsonGenerator).flush();
    }

    // You can add more test cases to cover different conditions and edge cases


}