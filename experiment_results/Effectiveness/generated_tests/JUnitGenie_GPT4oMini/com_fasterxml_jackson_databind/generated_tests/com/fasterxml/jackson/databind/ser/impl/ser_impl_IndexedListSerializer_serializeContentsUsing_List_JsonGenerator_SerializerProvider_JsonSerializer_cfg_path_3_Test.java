package com.fasterxml.jackson.databind.ser.impl;
import com.fasterxml.jackson.databind.ser.impl.IndexedListSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ser_impl_IndexedListSerializer_serializeContentsUsing_List_JsonGenerator_SerializerProvider_JsonSerializer_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSerializeContentsUsing() {
        // Arrange
        IndexedListSerializer serializer = new IndexedListSerializer(null, false, null, null);
        List<Object> value = Arrays.asList("test", null, 123);
        JsonGenerator jgen = Mockito.mock(JsonGenerator.class);
        SerializerProvider provider = Mockito.mock(SerializerProvider.class);
        JsonSerializer<Object> jsonSerializer = Mockito.mock(JsonSerializer.class);

        // Act
        try {
            // Ensure that the provider is set up to handle null values
            Mockito.when(provider.isEnabled(SerializationFeature.WRITE_NULL_MAP_VALUES)).thenReturn(true); // Specify SerializationFeature
            serializer.serializeContentsUsing(value, jgen, provider, jsonSerializer);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(provider, Mockito.times(1)).defaultSerializeNull(jgen);
            Mockito.verify(jsonSerializer, Mockito.times(1)).serialize(Mockito.any(), Mockito.eq(jgen), Mockito.eq(provider));
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }


}
