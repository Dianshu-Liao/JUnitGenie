package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;
import static com.fasterxml.jackson.core.JsonTokenId.ID_NUMBER_INT;
import java.io.IOException;

public class deser_std_UntypedObjectDeserializer_deserializeWithType_JsonParser_DeserializationContext_TypeDeserializer_cfg_path_2_Test {

    private UntypedObjectDeserializer deserializer;
    private JsonParser mockParser;
    private DeserializationContext mockContext;
    private TypeDeserializer mockTypeDeserializer;

    @Before
    public void setUp() {
        deserializer = new UntypedObjectDeserializer();
        mockParser = Mockito.mock(JsonParser.class);
        mockContext = Mockito.mock(DeserializationContext.class);
        mockTypeDeserializer = Mockito.mock(TypeDeserializer.class);
    }

    @Test(timeout = 4000)
    public void testDeserializeWithType_NumberCoercion() throws IOException {
        // Setup mock behavior
        Mockito.when(mockParser.getCurrentTokenId()).thenReturn(ID_NUMBER_INT);
        Mockito.when(mockContext.hasSomeOfFeatures(Mockito.anyInt())).thenReturn(false);
        Mockito.when(mockParser.getNumberValue()).thenReturn(42);

        // Call the method under test
        Object result = deserializer.deserializeWithType(mockParser, mockContext, mockTypeDeserializer);

        // Verify the result
        assertEquals(42, result);
    }

    @Test(timeout = 4000)
    public void testDeserializeWithType_NumberCoercionWithFeature() throws IOException {
        // Setup mock behavior
        Mockito.when(mockParser.getCurrentTokenId()).thenReturn(ID_NUMBER_INT);
        Mockito.when(mockContext.hasSomeOfFeatures(Mockito.anyInt())).thenReturn(true);
        Mockito.when(mockParser.getNumberValue()).thenReturn(42);

        // Call the method under test
        Object result = deserializer.deserializeWithType(mockParser, mockContext, mockTypeDeserializer);

        // Verify the result
        assertEquals(42, result);
    }

}