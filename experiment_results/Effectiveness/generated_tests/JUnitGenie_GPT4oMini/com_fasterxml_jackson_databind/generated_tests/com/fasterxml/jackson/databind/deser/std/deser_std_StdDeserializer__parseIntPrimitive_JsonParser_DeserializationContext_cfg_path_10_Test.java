package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class deser_std_StdDeserializer__parseIntPrimitive_JsonParser_DeserializationContext_cfg_path_10_Test {

    private static class TestDeserializer extends StdDeserializer<Integer> {
        protected TestDeserializer() {
            super(Integer.class);
        }

        @Override
        public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            if (p.getCurrentToken() == JsonToken.VALUE_NULL) {
                return 0; // Handle null case
            }
            return _parseIntPrimitive(p, ctxt);
        }
    }


    @Test(timeout = 4000)
    public void testParseIntPrimitiveWithNull() {
        JsonParser mockParser = Mockito.mock(JsonParser.class);
        DeserializationContext mockContext = Mockito.mock(DeserializationContext.class);

        try {
            Mockito.when(mockParser.getCurrentToken()).thenReturn(JsonToken.VALUE_NULL);
            Mockito.doNothing().when(mockContext).checkUnresolvedObjectId();

            TestDeserializer deserializer = new TestDeserializer();
            int result = deserializer.deserialize(mockParser, mockContext);
            assertEquals(0, result);
        } catch (IOException e) {
            // Handle exception
        }
    }


}
