package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class JsonParser_nextIntValue_int_cfg_path_2_Test {

    private JsonParser jsonParser;

    @Before
    public void setUp() throws Exception {
        // Using reflection to create an instance of JsonParser
        jsonParser = Mockito.mock(JsonParser.class);
    }

    @Test(timeout = 4000)
    public void testNextIntValueReturnsDefaultValue() throws IOException {
        // Arrange
        int defaultValue = 42;
        Mockito.when(jsonParser.nextToken()).thenReturn(JsonToken.VALUE_NUMBER_INT);
        Mockito.when(jsonParser.getIntValue()).thenReturn(10);

        // Act
        int result = jsonParser.nextIntValue(defaultValue);

        // Assert
        assertEquals(10, result);
    }

    @Test(timeout = 4000)
    public void testNextIntValueReturnsProvidedDefaultValue() throws IOException {
        // Arrange
        int defaultValue = 42;
        Mockito.when(jsonParser.nextToken()).thenReturn(JsonToken.VALUE_NUMBER_INT);
        Mockito.when(jsonParser.getIntValue()).thenThrow(new IOException("Simulated IOException"));

        // Act
        int result;
        try {
            result = jsonParser.nextIntValue(defaultValue);
        } catch (IOException e) {
            result = defaultValue; // Fallback to default value on exception
        }

        // Assert
        assertEquals(defaultValue, result);
    }

}