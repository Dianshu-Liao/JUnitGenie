package com.fasterxml.jackson.databind.ser.std;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ser_std_ObjectArraySerializer_serializeTypedContents_Object_____JsonGenerator_SerializerProvider_cfg_path_19_Test {

    private ObjectArraySerializer objectArraySerializer;
    private JsonGenerator jsonGenerator;
    private SerializerProvider serializerProvider;
    private PropertySerializerMap propertySerializerMap;
    private TypeSerializer typeSerializer;

    @Before
    public void setUp() throws Exception {
        // Initialize the ObjectArraySerializer with mock dependencies
        typeSerializer = mock(TypeSerializer.class);
        propertySerializerMap = mock(PropertySerializerMap.class);
        objectArraySerializer = new ObjectArraySerializer(null, false, typeSerializer, null);
        objectArraySerializer._dynamicSerializers = propertySerializerMap;

        // Create mock for JsonGenerator and SerializerProvider
        jsonGenerator = mock(JsonGenerator.class);
        serializerProvider = mock(SerializerProvider.class);
    }

    @Test(timeout = 4000)
    public void testSerializeTypedContents_withNullElement() throws IOException {
        Object[] value = {null, "test"};
        
        // Call the method under test
        objectArraySerializer.serializeTypedContents(value, jsonGenerator, serializerProvider);
        
        // Verify that the defaultSerializeNull method was called
        verify(serializerProvider).defaultSerializeNull(jsonGenerator);
        // Verify that the writeObject method was called for the non-null element
        verify(propertySerializerMap).serializerFor(String.class);
    }

    @Test(timeout = 4000)
    public void testSerializeTypedContents_withValidElements() throws IOException {
        Object[] value = {"test1", "test2"};
        JsonSerializer<Object> mockSerializer = mock(JsonSerializer.class);
        
        when(propertySerializerMap.serializerFor(String.class)).thenReturn(mockSerializer);
        
        // Call the method under test
        objectArraySerializer.serializeTypedContents(value, jsonGenerator, serializerProvider);
        
        // Verify that the serializeWithType method was called for each element
        verify(mockSerializer, times(2)).serializeWithType(any(), eq(jsonGenerator), eq(serializerProvider), eq(typeSerializer));
    }

    @Test(timeout = 4000)
    public void testSerializeTypedContents_withException() throws IOException {
        Object[] value = {"test"};
        JsonSerializer<Object> mockSerializer = mock(JsonSerializer.class);
        
        when(propertySerializerMap.serializerFor(String.class)).thenReturn(mockSerializer);
        doThrow(new IOException("Serialization error")).when(mockSerializer).serializeWithType(any(), eq(jsonGenerator), eq(serializerProvider), eq(typeSerializer));
        
        try {
            // Call the method under test
            objectArraySerializer.serializeTypedContents(value, jsonGenerator, serializerProvider);
        } catch (IOException e) {
            // Expected exception
        }
        
        // Verify that wrapAndThrow was called
        verify(objectArraySerializer).wrapAndThrow(serializerProvider, new IOException("Serialization error"), "test", 0);
    }

}