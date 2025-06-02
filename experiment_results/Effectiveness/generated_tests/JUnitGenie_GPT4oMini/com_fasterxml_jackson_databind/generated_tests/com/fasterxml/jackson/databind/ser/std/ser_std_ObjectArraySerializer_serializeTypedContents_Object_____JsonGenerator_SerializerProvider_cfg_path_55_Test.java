package com.fasterxml.jackson.databind.ser.std;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class ser_std_ObjectArraySerializer_serializeTypedContents_Object_____JsonGenerator_SerializerProvider_cfg_path_55_Test {

    private ObjectArraySerializer objectArraySerializer;
    private JsonGenerator jsonGenerator;
    private SerializerProvider serializerProvider;

    @Before
    public void setUp() throws Exception {
        // Create a mock for JsonGenerator
        jsonGenerator = mock(JsonGenerator.class);
        
        // Create a mock for SerializerProvider
        serializerProvider = mock(SerializerProvider.class);
        
        // Initialize the ObjectArraySerializer
        objectArraySerializer = new ObjectArraySerializer(null, false, null, null);
    }

    @Test(timeout = 4000)
    public void testSerializeTypedContentsWithNullElement() {
        Object[] value = {null}; // Test input with a null element

        try {
            objectArraySerializer.serializeTypedContents(value, jsonGenerator, serializerProvider);
            verify(serializerProvider).defaultSerializeNull(jsonGenerator); // Verify that defaultSerializeNull was called
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSerializeTypedContentsWithNonNullElement() {
        Object[] value = {"test"}; // Test input with a non-null element

        try {
            // Mock the behavior of the serializerProvider to return a mock serializer
            JsonSerializer<Object> mockSerializer = mock(JsonSerializer.class);
            when(serializerProvider.serializerInstance(any(), any())).thenReturn(mockSerializer);
            
            objectArraySerializer.serializeTypedContents(value, jsonGenerator, serializerProvider);
            verify(mockSerializer).serializeWithType("test", jsonGenerator, serializerProvider, null); // Verify serialization
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSerializeTypedContentsThrowsException() {
        Object[] value = {"test"}; // Test input with a non-null element

        try {
            // Mock the behavior to throw an exception during serialization
            JsonSerializer<Object> mockSerializer = mock(JsonSerializer.class);
            when(serializerProvider.serializerInstance(any(), any())).thenReturn(mockSerializer);
            doThrow(new IOException("Serialization error")).when(mockSerializer).serializeWithType(any(), any(), any(), any());

            objectArraySerializer.serializeTypedContents(value, jsonGenerator, serializerProvider);
        } catch (IOException e) {
            // Verify that defaultSerializeNull was called
            try {
                verify(serializerProvider).defaultSerializeNull(jsonGenerator);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}