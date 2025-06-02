package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.Test;
import org.junit.Before;
import java.io.IOException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class deser_std_StdDeserializer__parseIntPrimitive_JsonParser_DeserializationContext_cfg_path_8_Test {

    private StdDeserializer<Object> deserializer;
    private JsonParser mockParser;
    private DeserializationContext mockContext;

    @Before
    public void setUp() throws Exception {
        // Create a concrete implementation of StdDeserializer
        deserializer = new StdDeserializer<Object>(Object.class) {
            @Override
            public Object deserialize(JsonParser p, DeserializationContext ctxt) {
                return null; // Implementation not needed for this test
            }
        };

        // Mocking JsonParser and DeserializationContext
        mockParser = mock(JsonParser.class);
        mockContext = mock(DeserializationContext.class);
    }

    @Test(timeout = 4000)
    public void testParseIntPrimitiveWithString() {
        try {
            when(mockParser.getCurrentToken()).thenReturn(JsonToken.VALUE_STRING);
            when(mockParser.getText()).thenReturn("123");

            // Invoke the protected method using reflection
            java.lang.reflect.Method method = StdDeserializer.class.getDeclaredMethod("_parseIntPrimitive", JsonParser.class, DeserializationContext.class);
            method.setAccessible(true);
            int result = (int) method.invoke(deserializer, mockParser, mockContext);

            assertEquals(123, result);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParseIntPrimitiveWithNull() {
        try {
            when(mockParser.getCurrentToken()).thenReturn(JsonToken.VALUE_NULL);
            doNothing().when(mockContext).handleUnexpectedToken(any(Class.class), any(JsonParser.class));

            // Invoke the protected method using reflection
            java.lang.reflect.Method method = StdDeserializer.class.getDeclaredMethod("_parseIntPrimitive", JsonParser.class, DeserializationContext.class);
            method.setAccessible(true);
            int result = (int) method.invoke(deserializer, mockParser, mockContext);

            assertEquals(0, result);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testParseIntPrimitiveWithInvalidToken() {
        try {
            when(mockParser.getCurrentToken()).thenReturn(null); // Invalid token

            // Invoke the protected method using reflection
            java.lang.reflect.Method method = StdDeserializer.class.getDeclaredMethod("_parseIntPrimitive", JsonParser.class, DeserializationContext.class);
            method.setAccessible(true);
            int result = (int) method.invoke(deserializer, mockParser, mockContext);

            // Assuming handleUnexpectedToken returns 0 for invalid token
            assertEquals(0, result);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }


}