package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class deser_std_StdDeserializer__parseIntPrimitive_JsonParser_DeserializationContext_cfg_path_12_Test {

    private class TestDeserializer extends StdDeserializer<Integer> {
        protected TestDeserializer() {
            super(Integer.class);
        }

        @Override
        public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return _parseIntPrimitive(p, ctxt);
        }
    }

    @Test(timeout = 4000)
    public void testParseIntPrimitiveWithFloatCoercionAsNull() {
        JsonParser mockParser = Mockito.mock(JsonParser.class);
        DeserializationContext mockContext = Mockito.mock(DeserializationContext.class);
        TestDeserializer deserializer = new TestDeserializer();

        try {
            Mockito.when(mockParser.getCurrentToken()).thenReturn(JsonToken.VALUE_NUMBER_FLOAT);
            Mockito.when(deserializer._checkFloatToIntCoercion(mockParser, mockContext, Integer.TYPE)).thenReturn(CoercionAction.AsNull);
            Mockito.when(mockParser.getValueAsInt(Mockito.anyInt())).thenReturn(0); // Mocking the return value for getValueAsInt

            Integer result = deserializer.deserialize(mockParser, mockContext);
            assertEquals(0, result.intValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}