package com.fasterxml.jackson.databind.ser.std;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.EnumSetSerializer;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.EnumSet;

public class ser_std_EnumSetSerializer_serialize_EnumSet_JsonGenerator_SerializerProvider_cfg_path_5_Test {

    private EnumSetSerializer enumSetSerializer;
    private JsonGenerator mockGenerator;
    private SerializerProvider mockProvider;


    @Test(timeout = 4000)
    public void testSerializeSingleElementArrayUnwrapped() {
        try {
            EnumSet<MyEnum> value = EnumSet.of(MyEnum.VALUE_ONE);
            Mockito.when(mockProvider.isEnabled(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)).thenReturn(true);

            // Correct the method call to writeStartArray
            enumSetSerializer.serialize(value, mockGenerator, mockProvider);

            Mockito.verify(mockGenerator).writeStartArray();
            Mockito.verify(mockGenerator).writeString(MyEnum.VALUE_ONE.name());
            Mockito.verify(mockGenerator).writeEndArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private enum MyEnum {
        VALUE_ONE,
        VALUE_TWO;
    }


}
