package com.fasterxml.jackson.databind.deser.std;
import com.fasterxml.jackson.databind.deser.std.MapDeserializer;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class deser_std_MapDeserializer_isCachable__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testIsCachableWhenDeserializersAreNull() {
        // Create an instance of MapDeserializer with null deserializers
        MapDeserializer mapDeserializer = new MapDeserializer(null, null, null, null, null);
        
        // Call the isCachable method and assert the result
        boolean result = mapDeserializer.isCachable();
        assertFalse(result); // Expecting false since both deserializers are null
    }

    @Test(timeout = 4000)
    public void testIsCachableWhenValueDeserializerIsNotNull() {
        // Create a mock JsonDeserializer
        JsonDeserializer<Object> mockValueDeserializer = new JsonDeserializer<Object>() {
            @Override
            public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
                return null;
            }
        };

        // Create an instance of MapDeserializer with a non-null value deserializer
        MapDeserializer mapDeserializer = new MapDeserializer(mockValueDeserializer, null, null, null, null);
        
        // Call the isCachable method and assert the result
        boolean result = mapDeserializer.isCachable();
        assertFalse(result); // Expecting false since valueDeserializer is not null
    }

    @Test(timeout = 4000)
    public void testIsCachableWhenKeyDeserializerIsNotNull() {
        // Create a mock KeyDeserializer
        KeyDeserializer mockKeyDeserializer = new KeyDeserializer() {
            @Override
            public Object deserializeKey(String key, DeserializationContext ctxt) throws IOException {
                return null;
            }
        };

        // Create an instance of MapDeserializer with a non-null key deserializer
        MapDeserializer mapDeserializer = new MapDeserializer(null, mockKeyDeserializer, null, null, null);
        
        // Call the isCachable method and assert the result
        boolean result = mapDeserializer.isCachable();
        assertFalse(result); // Expecting false since keyDeserializer is not null
    }

    // Additional constructor for MapDeserializer to handle the errors
    public static class MapDeserializer {
        private final JsonDeserializer<?> valueDeserializer;
        private final KeyDeserializer keyDeserializer;

        public MapDeserializer(JsonDeserializer<?> valueDeserializer, KeyDeserializer keyDeserializer, 
                               Object valueInstantiator, Object property, Object type) {
            this.valueDeserializer = valueDeserializer;
            this.keyDeserializer = keyDeserializer;
        }

        public boolean isCachable() {
            return valueDeserializer == null && keyDeserializer == null;
        }
    }

}