package com.fasterxml.jackson.databind.ser.std;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class ser_std_ObjectArraySerializer_serializeTypedContents_Object_____JsonGenerator_SerializerProvider_cfg_path_29_Test {
    
    private ObjectArraySerializer objectArraySerializer;
    private JsonGenerator mockJsonGenerator;
    private SerializerProvider mockSerializerProvider;

    @Before
    public void setUp() {
        objectArraySerializer = new ObjectArraySerializer(null, false, null, null);
        mockJsonGenerator = Mockito.mock(JsonGenerator.class);
        mockSerializerProvider = Mockito.mock(SerializerProvider.class);
    }

    @Test(timeout = 4000)
    public void testSerializeTypedContents() {
        Object[] testValues = new Object[]{ "test", null };
        try {
            objectArraySerializer.serializeTypedContents(testValues, mockJsonGenerator, mockSerializerProvider);
        } catch (IOException e) {
            // Handle exception related to serialization
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testSerializeTypedContentsWithException() {
        Object[] testValues = new Object[]{ "test" };
        // Configure mocks to throw an Exception during serialization
        try {
            Mockito.doThrow(new IOException("Test Exception")).when(mockJsonGenerator).writeObject(Mockito.any());
        } catch (IOException e) {
            // Handle exception related to mock configuration
            e.printStackTrace();
        }

        try {
            objectArraySerializer.serializeTypedContents(testValues, mockJsonGenerator, mockSerializerProvider);
        } catch (IOException e) {
            // Expected exception
            e.printStackTrace();
        }
    }


}