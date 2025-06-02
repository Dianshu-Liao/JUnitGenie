package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class deser_std_StdDeserializer__parseIntPrimitive_JsonParser_DeserializationContext_cfg_path_15_Test {

    private StdDeserializer<Object> deserializer;
    private JsonParser mockParser;
    private DeserializationContext mockContext;

    class TestDeserializer extends StdDeserializer<Object> {
        protected TestDeserializer() {
            super(Object.class);
        }

        @Override
        public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return null; // Not implemented for this test
        }
    }

    @Before
    public void setUp() {
        deserializer = new TestDeserializer();
        mockParser = mock(JsonParser.class);
        mockContext = mock(DeserializationContext.class);
    }

    @Test(timeout = 4000)
    public void testParseIntPrimitive() {
        try {
            // Setup the mock behavior
            when(mockParser.getCurrentToken()).thenReturn(JsonToken.VALUE_STRING);
            when(mockParser.getText()).thenReturn("42");

            int result = invokeParseIntPrimitive(deserializer, mockParser, mockContext);
            
            assertEquals(42, result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testParseIntPrimitiveWithNull() {
        try {
            // Setup the mock behavior
            when(mockParser.getCurrentToken()).thenReturn(JsonToken.VALUE_NULL);
            // Change doNothing() to doThrow() for the handleUnexpectedToken method
            doThrow(new IOException("Unexpected token")).when(mockContext).handleUnexpectedToken(eq(Integer.TYPE), any(JsonParser.class));

            int result = invokeParseIntPrimitive(deserializer, mockParser, mockContext);
            
            assertEquals(0, result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testParseIntPrimitiveWithTextualNull() {
        try {
            // Setup the mock behavior
            when(mockParser.getCurrentToken()).thenReturn(JsonToken.VALUE_STRING);
            when(mockParser.getText()).thenReturn("null");

            int result = invokeParseIntPrimitive(deserializer, mockParser, mockContext);
            
            assertEquals(0, result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int invokeParseIntPrimitive(StdDeserializer<Object> deserializer, JsonParser p, DeserializationContext ctxt) throws IOException {
        try {
            java.lang.reflect.Method method = StdDeserializer.class.getDeclaredMethod("_parseIntPrimitive", JsonParser.class, DeserializationContext.class);
            method.setAccessible(true);
            return (int) method.invoke(deserializer, p, ctxt);
        } catch (Exception e) {
            throw new IOException("Failed to invoke _parseIntPrimitive", e);
        }
    }


}