package com.fasterxml.jackson.databind.ser.impl;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ser_impl_IndexedListSerializer_serializeContentsUsing_List_JsonGenerator_SerializerProvider_JsonSerializer_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testSerializeContentsUsing() throws IOException {
        // Given
        JsonGenerator jgen = Mockito.mock(JsonGenerator.class);
        SerializerProvider provider = Mockito.mock(SerializerProvider.class);
        JsonSerializer<Object> ser = Mockito.mock(JsonSerializer.class);
        IndexedListSerializer indexedListSerializer = new IndexedListSerializer(null, false, null, ser);
        
        List<Object> value = Arrays.asList("test", null);
        
        // When
        indexedListSerializer.serializeContentsUsing(value, jgen, provider, ser);

        // Then
        Mockito.verify(ser, Mockito.times(1)).serialize("test", jgen, provider);
        Mockito.verify(provider, Mockito.times(1)).defaultSerializeNull(jgen);
    }

    @Test(timeout = 4000)
    public void testSerializeContentsUsingWithException() throws IOException {
        // Given
        JsonGenerator jgen = Mockito.mock(JsonGenerator.class);
        SerializerProvider provider = Mockito.mock(SerializerProvider.class);
        JsonSerializer<Object> ser = new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
                throw new IOException("Test exception");
            }
        };
        IndexedListSerializer indexedListSerializer = new IndexedListSerializer(null, false, null, ser);
        
        List<Object> value = Arrays.asList("test");

        // When
        try {
            indexedListSerializer.serializeContentsUsing(value, jgen, provider, ser);
        } catch (IOException e) {
            // Expecting an exception to be thrown and handled
            e.printStackTrace();
        }

        // Then
        Mockito.verify(ser, Mockito.times(1)).serialize("test", jgen, provider);
        Mockito.verify(provider, Mockito.times(1)).defaultSerializeNull(jgen);
    }

}