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

public class ser_impl_IndexedListSerializer_serializeContentsUsing_List_JsonGenerator_SerializerProvider_JsonSerializer_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testSerializeContentsUsingWithNullElement() {
        // Arrange
        IndexedListSerializer serializer = new IndexedListSerializer(null, false, null, null);
        List<Object> value = Arrays.asList((Object) null); // Cast null to Object to avoid NullPointerException
        
        JsonGenerator jgen = Mockito.mock(JsonGenerator.class);
        SerializerProvider provider = Mockito.mock(SerializerProvider.class);
        JsonSerializer<Object> ser = Mockito.mock(JsonSerializer.class);

        // Act
        try {
            serializer.serializeContentsUsing(value, jgen, provider, ser);
        } catch (IOException e) {
            // Handle the exception if needed
        }

        // Assert
        try {
            Mockito.verify(provider).defaultSerializeNull(jgen);
        } catch (IOException e) {
            // Handle the exception if needed
        }
    }

    @Test(timeout = 4000)
    public void testSerializeContentsUsingWithNonNullElement() {
        // Arrange
        IndexedListSerializer serializer = new IndexedListSerializer(null, false, null, null);
        List<Object> value = Arrays.asList("test");
        
        JsonGenerator jgen = Mockito.mock(JsonGenerator.class);
        SerializerProvider provider = Mockito.mock(SerializerProvider.class);
        JsonSerializer<Object> ser = Mockito.mock(JsonSerializer.class);

        // Act
        try {
            serializer.serializeContentsUsing(value, jgen, provider, ser);
        } catch (IOException e) {
            // Handle the exception if needed
        }

        // Assert
        try {
            Mockito.verify(ser).serialize("test", jgen, provider);
        } catch (IOException e) {
            // Handle the exception if needed
        }
    }


}