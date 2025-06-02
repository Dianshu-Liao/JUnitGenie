package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.EnumSetDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.JsonToken;
import org.junit.Test;
import org.junit.Before;
import java.io.IOException;
import java.util.EnumSet;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class deser_std_EnumSetDeserializer_handleNonArray_JsonParser_DeserializationContext_EnumSet_cfg_path_24_Test {

    private EnumSetDeserializer enumSetDeserializer;
    private JsonParser jsonParser;
    private DeserializationContext deserializationContext;
    private EnumSet<SampleEnum> result;

    @Before
    public void setUp() {
        enumSetDeserializer = mock(EnumSetDeserializer.class);
        jsonParser = mock(JsonParser.class);
        deserializationContext = mock(DeserializationContext.class);
        result = EnumSet.noneOf(SampleEnum.class); // Initialize result to avoid NullPointerException
    }

    @Test(timeout = 4000)
    public void testHandleNonArray_withNullValue() {
        try {
            when(jsonParser.hasToken(JsonToken.VALUE_NULL)).thenReturn(true);
            when(deserializationContext.handleUnexpectedToken(any(Class.class), any(JsonParser.class))).thenReturn(result);

            // Cast the result to EnumSet<SampleEnum> to avoid type mismatch
            EnumSet<SampleEnum> output = (EnumSet<SampleEnum>) enumSetDeserializer.handleNonArray(jsonParser, deserializationContext, result);
            assertNotNull(output);
            assertTrue(output.isEmpty());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test(timeout = 4000)
    public void testHandleNonArray_withException() {
        try {
            when(jsonParser.hasToken(JsonToken.VALUE_NULL)).thenReturn(false);
            when(enumSetDeserializer._enumDeserializer.deserialize(jsonParser, deserializationContext)).thenThrow(new RuntimeException("Deserialization error"));

            enumSetDeserializer.handleNonArray(jsonParser, deserializationContext, result);
            fail("Expected JsonMappingException to be thrown");
        } catch (JsonMappingException e) {
            // Expected exception
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    private enum SampleEnum {
        VALUE_ONE,
        VALUE_TWO
    }

}