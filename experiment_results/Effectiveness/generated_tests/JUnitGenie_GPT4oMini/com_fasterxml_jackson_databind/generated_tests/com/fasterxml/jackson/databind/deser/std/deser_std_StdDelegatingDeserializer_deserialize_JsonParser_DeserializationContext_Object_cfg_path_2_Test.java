package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import org.junit.Test;
import org.junit.Before;
import java.io.IOException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertSame;

public class deser_std_StdDelegatingDeserializer_deserialize_JsonParser_DeserializationContext_Object_cfg_path_2_Test {

    private StdDelegatingDeserializer<Object> deserializer;
    private JsonDeserializer<Object> mockDelegateDeserializer;
    private JavaType mockDelegateType;
    private JsonParser mockJsonParser;
    private DeserializationContext mockDeserializationContext;
    private Object mockIntoValue;



}
