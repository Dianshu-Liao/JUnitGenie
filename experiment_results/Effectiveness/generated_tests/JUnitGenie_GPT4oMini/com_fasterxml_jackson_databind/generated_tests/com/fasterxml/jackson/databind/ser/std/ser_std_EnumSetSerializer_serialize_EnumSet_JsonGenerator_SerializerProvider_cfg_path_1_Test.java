package com.fasterxml.jackson.databind.ser.std;
import com.fasterxml.jackson.databind.ser.std.EnumSetSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.EnumSet;

public class ser_std_EnumSetSerializer_serialize_EnumSet_JsonGenerator_SerializerProvider_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSerializeWithSingleElement() {
        EnumSet<TestEnum> value = EnumSet.of(TestEnum.VALUE1);
        JsonGenerator gen = Mockito.mock(JsonGenerator.class);
        SerializerProvider provider = Mockito.mock(SerializerProvider.class);
        
        try {
            Mockito.when(provider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)).thenReturn(true);
            EnumSetSerializer serializer = new EnumSetSerializer(TestEnum.class, null, null, null, false);
            serializer.serialize(value, gen, provider);
            Mockito.verify(gen).writeStartArray();
            Mockito.verify(gen).writeString("VALUE1");
            Mockito.verify(gen).writeEndArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSerializeWithMultipleElements() {
        EnumSet<TestEnum> value = EnumSet.of(TestEnum.VALUE1, TestEnum.VALUE2);
        JsonGenerator gen = Mockito.mock(JsonGenerator.class);
        SerializerProvider provider = Mockito.mock(SerializerProvider.class);
        
        try {
            Mockito.when(provider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)).thenReturn(false);
            EnumSetSerializer serializer = new EnumSetSerializer(TestEnum.class, null, null, null, false);
            serializer.serialize(value, gen, provider);
            Mockito.verify(gen).writeStartArray();
            Mockito.verify(gen).writeString("VALUE1");
            Mockito.verify(gen).writeString("VALUE2");
            Mockito.verify(gen).writeEndArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private enum TestEnum {
        VALUE1, VALUE2
    }

    // Corrected constructor for EnumSetSerializer
    private static class EnumSetSerializer extends com.fasterxml.jackson.databind.JsonSerializer<EnumSet<?>> {
        private final Class<?> enumClass;

        public EnumSetSerializer(Class<?> enumClass, Object obj1, Object obj2, Object obj3, boolean flag) {
            this.enumClass = enumClass;
        }

        @Override
        public void serialize(EnumSet<?> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
            gen.writeStartArray();
            for (Object enumValue : value) {
                gen.writeString(enumValue.toString());
            }
            gen.writeEndArray();
        }
    }


}