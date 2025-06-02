package com.fasterxml.jackson.databind.module;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.type.ClassKey;
import org.junit.Test;
import static org.junit.Assert.*;

public class module_SimpleDeserializers_addDeserializer_Class_JsonDeserializer_cfg_path_1_Test {

    private static class TestDeserializer extends JsonDeserializer<Object> {
        @Override
        public Object deserialize(com.fasterxml.jackson.core.JsonParser p, com.fasterxml.jackson.databind.DeserializationContext ctxt) {
            return null; // Implement your deserialization logic here
        }
    }

    @Test(timeout = 4000)
    public void testAddDeserializer() {
        SimpleDeserializers deserializers = new SimpleDeserializers();
        Class<Object> forClass = Object.class; // Valid class type
        JsonDeserializer<Object> deser = new TestDeserializer();

        // Ensure _classMappings is initially null
        assertNull(deserializers._classMappings);

        // Call the method under test
        deserializers.addDeserializer(forClass, deser);

        // Verify that the deserializer was added
        assertNotNull(deserializers._classMappings);
        assertTrue(deserializers._classMappings.containsKey(new ClassKey(forClass)));
        assertEquals(deser, deserializers._classMappings.get(new ClassKey(forClass)));
    }

    @Test(timeout = 4000)
    public void testAddDeserializerWithEnum() {
        SimpleDeserializers deserializers = new SimpleDeserializers();
        Class<Enum> forClass = Enum.class; // Valid class type for Enum
        JsonDeserializer<Enum> deser = new JsonDeserializer<Enum>() {
            @Override
            public Enum deserialize(com.fasterxml.jackson.core.JsonParser p, com.fasterxml.jackson.databind.DeserializationContext ctxt) {
                return null; // Implement your deserialization logic here
            }
        };

        // Call the method under test
        deserializers.addDeserializer(forClass, deser);

        // Verify that the enum deserializer flag is set
        assertTrue(deserializers._hasEnumDeserializer);
    }


}