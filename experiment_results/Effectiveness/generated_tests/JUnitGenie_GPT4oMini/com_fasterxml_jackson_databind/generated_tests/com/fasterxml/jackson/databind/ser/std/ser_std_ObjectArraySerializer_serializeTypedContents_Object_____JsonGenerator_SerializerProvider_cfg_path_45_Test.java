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

public class ser_std_ObjectArraySerializer_serializeTypedContents_Object_____JsonGenerator_SerializerProvider_cfg_path_45_Test {

    private ObjectArraySerializer objectArraySerializer;
    private JsonGenerator jsonGenerator;
    private SerializerProvider serializerProvider;
    private TypeSerializer typeSerializer;
    private PropertySerializerMap propertySerializerMap;

    @Before
    public void setUp() throws Exception {
        // Initialize the ObjectArraySerializer with mock dependencies
        typeSerializer = mock(TypeSerializer.class);
        propertySerializerMap = mock(PropertySerializerMap.class);
        objectArraySerializer = new ObjectArraySerializer(null, false, typeSerializer, null);
        objectArraySerializer._dynamicSerializers = propertySerializerMap;

        // Create mocks for JsonGenerator and SerializerProvider
        jsonGenerator = mock(JsonGenerator.class);
        serializerProvider = mock(SerializerProvider.class);
    }

    @Test(timeout = 4000)
    public void testSerializeTypedContents() {
        Object[] values = new Object[]{"test", 123, null};

        try {
            // Mock the behavior of the propertySerializerMap
            JsonSerializer<Object> mockSerializer = mock(JsonSerializer.class);
            when(propertySerializerMap.serializerFor(String.class)).thenReturn(mockSerializer);
            when(propertySerializerMap.serializerFor(Integer.class)).thenReturn(mockSerializer);
            when(propertySerializerMap.serializerFor(Object.class)).thenReturn(null);

            // Call the method under test
            objectArraySerializer.serializeTypedContents(values, jsonGenerator, serializerProvider);

            // Verify interactions with mocks
            verify(jsonGenerator, times(1)).writeString("test");
            verify(jsonGenerator, times(1)).writeNumber(123);
            verify(serializerProvider, times(1)).defaultSerializeNull(jsonGenerator);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSerializeTypedContentsThrowsException() {
        Object[] values = new Object[]{"test"};

        try {
            // Mock the behavior to throw an exception
            when(propertySerializerMap.serializerFor(String.class)).thenThrow(new RuntimeException("Serialization error"));

            // Call the method under test
            objectArraySerializer.serializeTypedContents(values, jsonGenerator, serializerProvider);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }


}