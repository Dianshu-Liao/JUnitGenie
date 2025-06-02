package com.fasterxml.jackson.databind.ser.std;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.EnumSetSerializer;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.EnumSet;

public class ser_std_EnumSetSerializer_serialize_EnumSet_JsonGenerator_SerializerProvider_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testSerialize() {
        // Arrange
        EnumSet<SampleEnum> value = EnumSet.of(SampleEnum.VALUE1);
        JsonGenerator gen = Mockito.mock(JsonGenerator.class);
        SerializerProvider provider = Mockito.mock(SerializerProvider.class);
        JavaType enumType = provider.constructType(SampleEnum.class); // Create JavaType from SampleEnum class
        EnumSetSerializer serializer = new EnumSetSerializer(enumType); // Use JavaType in constructor

        // Mock the behavior of the provider to avoid NullPointerException
        Mockito.when(provider.isEnabled(Mockito.any(com.fasterxml.jackson.databind.SerializationFeature.class))).thenReturn(true);

        try {
            // Act
            serializer.serialize(value, gen, provider);

            // Assert
            Mockito.verify(gen).writeStartArray();
            Mockito.verify(gen).writeEndArray();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    private enum SampleEnum {
        VALUE1, VALUE2
    }


}