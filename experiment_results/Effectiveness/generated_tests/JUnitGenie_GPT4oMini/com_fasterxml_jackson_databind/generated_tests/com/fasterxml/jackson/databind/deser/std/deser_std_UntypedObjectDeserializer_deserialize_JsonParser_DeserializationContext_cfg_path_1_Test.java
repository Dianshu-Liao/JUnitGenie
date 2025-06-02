package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static com.fasterxml.jackson.core.JsonTokenId.ID_NUMBER_INT;

public class deser_std_UntypedObjectDeserializer_deserialize_JsonParser_DeserializationContext_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDeserialize_NumberValue() {
        // Arrange
        UntypedObjectDeserializer deserializer = new UntypedObjectDeserializer();
        JsonParser mockParser = Mockito.mock(JsonParser.class);
        DeserializationContext mockContext = Mockito.mock(DeserializationContext.class);
        
        try {
            // Set up the mock behavior
            Mockito.when(mockParser.getCurrentTokenId()).thenReturn(ID_NUMBER_INT);
            Mockito.when(mockParser.getNumberValue()).thenReturn(42);
            Mockito.when(mockContext.hasSomeOfFeatures(Mockito.anyInt())).thenReturn(false);
            
            // Act
            Object result = deserializer.deserialize(mockParser, mockContext);
            
            // Assert
            assertEquals(42, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}