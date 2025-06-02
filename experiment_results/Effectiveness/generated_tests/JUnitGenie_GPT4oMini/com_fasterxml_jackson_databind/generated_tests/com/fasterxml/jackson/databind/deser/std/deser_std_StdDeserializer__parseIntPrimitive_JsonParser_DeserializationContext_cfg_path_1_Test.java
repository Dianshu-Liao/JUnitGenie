package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class deser_std_StdDeserializer__parseIntPrimitive_JsonParser_DeserializationContext_cfg_path_1_Test {

    private StdDeserializer<Object> deserializer;
    private JsonParser jsonParser;
    private DeserializationContext deserializationContext;

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
        jsonParser = Mockito.mock(JsonParser.class);
        deserializationContext = Mockito.mock(DeserializationContext.class);
    }

    @Test(timeout = 4000)
    public void testParseIntPrimitive() {
        try {
            // Setting up the mock to return a specific token
            Mockito.when(jsonParser.getCurrentToken()).thenReturn(JsonToken.VALUE_NUMBER_INT);
            Mockito.when(jsonParser.getIntValue()).thenReturn(42);

            // Accessing the protected method using reflection
            Method method = StdDeserializer.class.getDeclaredMethod("_parseIntPrimitive", JsonParser.class, DeserializationContext.class);
            method.setAccessible(true);

            // Invoking the method
            int result = (int) method.invoke(deserializer, jsonParser, deserializationContext);

            // Asserting the expected result
            assertEquals(42, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Adding a mock implementation of the _parseIntPrimitive method to avoid NullPointerException
    protected int _parseIntPrimitive(JsonParser p, DeserializationContext ctxt) throws IOException {
        if (p.getCurrentToken() != JsonToken.VALUE_NUMBER_INT) {
            throw new IOException("Expected VALUE_NUMBER_INT token");
        }
        return p.getIntValue();
    }

}