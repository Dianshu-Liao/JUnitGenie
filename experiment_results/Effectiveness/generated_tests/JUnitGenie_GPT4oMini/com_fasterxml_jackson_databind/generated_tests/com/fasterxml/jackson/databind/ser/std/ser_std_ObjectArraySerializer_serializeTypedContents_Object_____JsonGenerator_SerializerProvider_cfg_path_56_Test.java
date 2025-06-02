package com.fasterxml.jackson.databind.ser.std;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.ObjectArraySerializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class ser_std_ObjectArraySerializer_serializeTypedContents_Object_____JsonGenerator_SerializerProvider_cfg_path_56_Test {

    private ObjectArraySerializer objectArraySerializer;
    private JsonGenerator jsonGenerator;
    private SerializerProvider serializerProvider;

    @Before
    public void setUp() throws Exception {
        // Initialize the ObjectArraySerializer with mock parameters
        TypeSerializer typeSerializer = Mockito.mock(TypeSerializer.class);
        objectArraySerializer = new ObjectArraySerializer(null, false, typeSerializer, null);
        jsonGenerator = Mockito.mock(JsonGenerator.class);
        serializerProvider = Mockito.mock(SerializerProvider.class);
    }

    @Test(timeout = 4000)
    public void testSerializeTypedContents() {
        Object[] value = new Object[]{"test", null, 123};
        try {
            objectArraySerializer.serializeTypedContents(value, jsonGenerator, serializerProvider);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSerializeTypedContentsWithNull() {
        Object[] value = new Object[]{null};
        try {
            objectArraySerializer.serializeTypedContents(value, jsonGenerator, serializerProvider);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSerializeTypedContentsWithException() {
        Object[] value = new Object[]{"test"};
        try {
            Mockito.doThrow(new IOException("Test Exception")).when(serializerProvider).defaultSerializeNull(jsonGenerator);
            objectArraySerializer.serializeTypedContents(value, jsonGenerator, serializerProvider);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

}