package com.fasterxml.jackson.databind;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.DeserializationConfig;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectMapper_configure_MapperFeature_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConfigureWithStateTrue() {
        ObjectMapper objectMapper = new ObjectMapper();
        MapperFeature feature = MapperFeature.DEFAULT_VIEW_INCLUSION; // Example feature
        boolean state = true;

        // Configure the ObjectMapper
        ObjectMapper result = objectMapper.configure(feature, state);

        // Validate the serialization and deserialization configurations
        SerializationConfig serializationConfig = (SerializationConfig) result._serializationConfig;
        DeserializationConfig deserializationConfig = (DeserializationConfig) result._deserializationConfig;

        // Check if the feature is enabled in serialization config
        assertTrue(serializationConfig.isEnabled(feature));
        // Check if the feature is disabled in deserialization config
        assertFalse(deserializationConfig.isEnabled(feature));
    }

    @Test(timeout = 4000)
    public void testConfigureWithStateFalse() {
        ObjectMapper objectMapper = new ObjectMapper();
        MapperFeature feature = MapperFeature.DEFAULT_VIEW_INCLUSION; // Example feature
        boolean state = false;

        // Configure the ObjectMapper
        ObjectMapper result = objectMapper.configure(feature, state);

        // Validate the serialization and deserialization configurations
        SerializationConfig serializationConfig = (SerializationConfig) result._serializationConfig;
        DeserializationConfig deserializationConfig = (DeserializationConfig) result._deserializationConfig;

        // Check if the feature is disabled in serialization config
        assertFalse(serializationConfig.isEnabled(feature));
        // Check if the feature is enabled in deserialization config
        assertTrue(deserializationConfig.isEnabled(feature));
    }

}