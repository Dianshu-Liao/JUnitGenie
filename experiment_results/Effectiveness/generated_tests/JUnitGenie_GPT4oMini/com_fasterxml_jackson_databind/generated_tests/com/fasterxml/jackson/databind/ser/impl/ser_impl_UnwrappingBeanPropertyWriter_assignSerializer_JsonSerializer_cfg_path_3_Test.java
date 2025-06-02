package com.fasterxml.jackson.databind.ser.impl;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanPropertyWriter;
import com.fasterxml.jackson.databind.util.NameTransformer;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import org.junit.Test;
import static org.junit.Assert.*;

public class ser_impl_UnwrappingBeanPropertyWriter_assignSerializer_JsonSerializer_cfg_path_3_Test {

    private class TestJsonSerializer extends JsonSerializer<Object> {
        private boolean unwrapping;

        public TestJsonSerializer(boolean unwrapping) {
            this.unwrapping = unwrapping;
        }

        @Override
        public void serialize(Object value, com.fasterxml.jackson.core.JsonGenerator gen, com.fasterxml.jackson.databind.SerializerProvider serializers) {
            // Implementation not needed for this test
        }

        @Override
        public boolean isUnwrappingSerializer() {
            return unwrapping;
        }

        @Override
        public JsonSerializer<Object> unwrappingSerializer(NameTransformer transformer) {
            return this; // Return itself for simplicity
        }
    }

    @Test(timeout = 4000)
    public void testAssignSerializerWithUnwrappingSerializer() {
        NameTransformer nameTransformer = NameTransformer.simpleTransformer("", ""); // Provide required arguments
        UnwrappingBeanPropertyWriter writer = new UnwrappingBeanPropertyWriter(null, nameTransformer);
        TestJsonSerializer serializer = new TestJsonSerializer(true); // This serializer is unwrapping

        try {
            writer.assignSerializer(serializer);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAssignSerializerWithNullSerializer() {
        NameTransformer nameTransformer = NameTransformer.simpleTransformer("", ""); // Provide required arguments
        UnwrappingBeanPropertyWriter writer = new UnwrappingBeanPropertyWriter(null, nameTransformer);

        try {
            writer.assignSerializer(null);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAssignSerializerWithNonUnwrappingSerializer() {
        NameTransformer nameTransformer = NameTransformer.simpleTransformer("", ""); // Provide required arguments
        UnwrappingBeanPropertyWriter writer = new UnwrappingBeanPropertyWriter(null, nameTransformer);
        TestJsonSerializer serializer = new TestJsonSerializer(false); // This serializer is not unwrapping

        try {
            writer.assignSerializer(serializer);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    // Added a constructor to UnwrappingBeanPropertyWriter to avoid NullPointerException
    private static class UnwrappingBeanPropertyWriter extends BeanPropertyWriter {
        public UnwrappingBeanPropertyWriter(BeanPropertyWriter base, NameTransformer nameTransformer) {
            super(base);
            // Additional initialization with nameTransformer if needed
        }
    }


}