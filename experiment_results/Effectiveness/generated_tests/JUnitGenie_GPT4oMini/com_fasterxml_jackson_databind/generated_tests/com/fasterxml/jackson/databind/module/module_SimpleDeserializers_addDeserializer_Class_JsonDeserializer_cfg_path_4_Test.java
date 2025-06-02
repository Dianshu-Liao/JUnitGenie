package com.fasterxml.jackson.databind.module;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class module_SimpleDeserializers_addDeserializer_Class_JsonDeserializer_cfg_path_4_Test {

    private static class TestDeserializer extends JsonDeserializer<Object> {
        @Override
        public Object deserialize(JsonParser p, DeserializationContext ctxt) {
            return new Object(); // Dummy implementation for testing
        }
    }

    @Test(timeout = 4000)
    public void testAddDeserializer() {
        SimpleDeserializers deserializers = new SimpleDeserializers();
        Class<Object> forClass = Object.class;
        JsonDeserializer<Object> deser = new TestDeserializer();

        try {
            deserializers.addDeserializer(forClass, deser);
            assertNotNull(deserializers._classMappings); // Check if _classMappings is initialized
            assertNotNull(deserializers._classMappings.get(new ClassKey(forClass))); // Check if the deserializer is added
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }



}
