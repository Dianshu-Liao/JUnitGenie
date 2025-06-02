package com.fasterxml.jackson.databind.ser.std;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ser_std_ObjectArraySerializer_serializeTypedContents_Object_____JsonGenerator_SerializerProvider_cfg_path_47_Test {

    private ObjectArraySerializer objectArraySerializer;
    private JsonGenerator jsonGenerator;
    private SerializerProvider serializerProvider;

    @Before
    public void setUp() {
        // Initialize the ObjectArraySerializer with necessary parameters
        TypeSerializer typeSerializer = mock(TypeSerializer.class);
        objectArraySerializer = new ObjectArraySerializer(null, false, typeSerializer, null);
        jsonGenerator = mock(JsonGenerator.class);
        serializerProvider = mock(SerializerProvider.class);
    }

    @Test(timeout = 4000)
    public void testSerializeTypedContents_withNullElement() {
        Object[] value = {null};

        try {
            objectArraySerializer.serializeTypedContents(value, jsonGenerator, serializerProvider);
            verify(serializerProvider).defaultSerializeNull(jsonGenerator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSerializeTypedContents_withSerializableElement() {
        Object[] value = {"test"};
        PropertySerializerMap serializers = mock(PropertySerializerMap.class);
        JsonSerializer<Object> jsonSerializer = mock(JsonSerializer.class);
        
        when(serializers.serializerFor(String.class)).thenReturn(jsonSerializer);
        when(serializerProvider.getConfig()).thenReturn(null);
        
        try {
            // Set the dynamic serializers to the mock
            objectArraySerializer._dynamicSerializers = serializers;
            objectArraySerializer.serializeTypedContents(value, jsonGenerator, serializerProvider);
            verify(jsonSerializer).serializeWithType("test", jsonGenerator, serializerProvider, objectArraySerializer._valueTypeSerializer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
