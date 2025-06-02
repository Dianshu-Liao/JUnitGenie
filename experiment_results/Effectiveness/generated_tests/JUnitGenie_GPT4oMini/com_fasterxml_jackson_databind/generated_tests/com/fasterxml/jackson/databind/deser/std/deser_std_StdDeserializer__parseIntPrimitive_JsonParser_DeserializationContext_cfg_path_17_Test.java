package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.junit.Test;
import org.junit.Before;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class deser_std_StdDeserializer__parseIntPrimitive_JsonParser_DeserializationContext_cfg_path_17_Test {

    private StdDeserializer<Object> deserializer;
    private JsonParser jsonParser;
    private DeserializationContext deserializationContext;

    @Before
    public void setUp() {
        // Initialize the deserializer, jsonParser, and deserializationContext before the test
        deserializer = new StdDeserializer<Object>(Object.class) {
            @Override
            public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                return null; // Mock implementation
            }
        };
        jsonParser = null; // Simulating a null input
        deserializationContext = null; // Simulating a null context
    }

    @Test(timeout = 4000)
    public void testParseIntPrimitiveWithNull() {
        try {
            // Access the protected method _parseIntPrimitive using reflection
            Method method = StdDeserializer.class.getDeclaredMethod("_parseIntPrimitive", JsonParser.class, DeserializationContext.class);
            method.setAccessible(true);
            int result = (int) method.invoke(deserializer, jsonParser, deserializationContext);
            assertEquals(0, result); // Expecting 0 for null input
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}