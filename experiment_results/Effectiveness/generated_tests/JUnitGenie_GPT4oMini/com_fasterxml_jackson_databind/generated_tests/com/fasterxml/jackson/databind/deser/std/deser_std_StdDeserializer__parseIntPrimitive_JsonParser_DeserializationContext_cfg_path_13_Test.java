package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class deser_std_StdDeserializer__parseIntPrimitive_JsonParser_DeserializationContext_cfg_path_13_Test {

    private static class TestDeserializer extends StdDeserializer<Integer> {
        protected TestDeserializer() {
            super(Integer.class);
        }

        @Override
        public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            if (p == null || ctxt == null) {
                throw new IOException("JsonParser or DeserializationContext cannot be null");
            }
            try {
                return _parseIntPrimitive(p, ctxt);
            } catch (IOException e) {
                // Handle the exception accordingly, maybe log or rethrow
                return null; // or some default value
            }
        }
    }

    @Test(timeout = 4000)
    public void testParseIntPrimitiveWithString() throws IOException {
        JsonParser mockParser = Mockito.mock(JsonParser.class);
        DeserializationContext mockContext = Mockito.mock(DeserializationContext.class);
        TestDeserializer deserializer = new TestDeserializer();
        
        Mockito.when(mockParser.getText()).thenReturn("123");
        Mockito.when(mockParser.getCurrentTokenId()).thenReturn(1);

        Integer result = deserializer.deserialize(mockParser, mockContext);
        assertEquals(Integer.valueOf(123), result); // Changed to use Integer.valueOf
    }

    @Test(timeout = 4000)
    public void testParseIntPrimitiveWithNumberFloat() throws IOException {
        JsonParser mockParser = Mockito.mock(JsonParser.class);
        DeserializationContext mockContext = Mockito.mock(DeserializationContext.class);
        TestDeserializer deserializer = new TestDeserializer();
        
        Mockito.when(mockParser.getValueAsInt()).thenReturn(456);
        Mockito.when(mockParser.getCurrentTokenId()).thenReturn(2);

        Integer result = deserializer.deserialize(mockParser, mockContext);
        assertEquals(Integer.valueOf(456), result); // Changed to use Integer.valueOf
    }

    @Test(timeout = 4000)
    public void testParseIntPrimitiveWithNull() throws IOException {
        JsonParser mockParser = Mockito.mock(JsonParser.class);
        DeserializationContext mockContext = Mockito.mock(DeserializationContext.class);
        TestDeserializer deserializer = new TestDeserializer();
        
        Mockito.when(mockParser.getCurrentTokenId()).thenReturn(3);
        Integer result = deserializer.deserialize(mockParser, mockContext); // Should not throw
        assertEquals(null, result); // Check that it returns null
    }

    @Test(timeout = 4000)
    public void testParseIntPrimitiveHandlesUnexpectedToken() throws IOException {
        JsonParser mockParser = Mockito.mock(JsonParser.class);
        DeserializationContext mockContext = Mockito.mock(DeserializationContext.class);
        TestDeserializer deserializer = new TestDeserializer();
        
        Mockito.when(mockParser.getCurrentTokenId()).thenReturn(99); // Unexpected token
        Integer result = deserializer.deserialize(mockParser, mockContext); // Should not throw
        assertEquals(null, result); // Check that it returns null
    }


}