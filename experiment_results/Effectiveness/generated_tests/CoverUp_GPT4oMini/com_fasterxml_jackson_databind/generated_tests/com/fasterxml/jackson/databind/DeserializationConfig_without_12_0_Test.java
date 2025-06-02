package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.cfg.*;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.databind.jsontype.*;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.RootNameLookup;

class DeserializationConfig_without_12_0_Test {

    private DeserializationConfig config;

    @BeforeEach
    void setUp() {
        // Initialize the DeserializationConfig with default values
        config = new DeserializationConfig(null, null, null, null, null, null, null);
    }

    @Test
    void testWithoutSingleFeature() {
        // Assuming DeserializationFeature is an enum with a method getMask()
        // Example feature
        DeserializationFeature feature = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        DeserializationConfig newConfig = config.without(feature);
        // Validate that the new config has the feature removed
        assertNotSame(config, newConfig);
        assertFalse(newConfig.getDeserializationFeatures() == config.getDeserializationFeatures());
    }

    @Test
    void testWithoutMultipleFeatures() {
        DeserializationFeature feature1 = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        // Another example feature
        DeserializationFeature feature2 = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
        DeserializationConfig newConfig = config.without(feature1, feature2);
        // Validate that the new config has the features removed
        assertNotSame(config, newConfig);
        assertFalse(newConfig.getDeserializationFeatures() == config.getDeserializationFeatures());
    }

    @Test
    void testWithoutNoChange() {
        // Example feature
        DeserializationFeature feature = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        DeserializationConfig newConfig = config.without(feature);
        // Validate that the config remains the same if the feature was not set
        assertSame(config, newConfig);
    }
}
