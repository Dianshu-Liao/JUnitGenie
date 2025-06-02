package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class deser_std_UntypedObjectDeserializer_deserialize_JsonParser_DeserializationContext_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testDeserializeReturnsFalseForJsonParserWithFalseToken() {
        // Arrange
        UntypedObjectDeserializer deserializer = new UntypedObjectDeserializer();
        JsonParser mockParser = mock(JsonParser.class);
        DeserializationContext mockContext = mock(DeserializationContext.class);

        try {
            when(mockParser.getCurrentToken()).thenReturn(JsonToken.VALUE_FALSE); // Changed from JsonToken.FALSE to JsonToken.VALUE_FALSE
            // Act
            Object result = deserializer.deserialize(mockParser, mockContext);
            // Assert
            assertEquals(Boolean.FALSE, result);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}