package com.fasterxml.jackson.databind;

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

public class DeserializationConfig_with_8_0_Test {

    private DeserializationConfig config;

    @BeforeEach
    public void setUp() {
        // Initialize DeserializationConfig with default settings
        config = new DeserializationConfig(null, null, null, null, null, null, null);
    }

    @Test
    public void testWithFeature_NewFeatureApplied() {
        // Assume DeserializationFeature is an enum with a method getMask()
        // Example feature
        DeserializationFeature feature = DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS;
        DeserializationConfig newConfig = config.with(feature);
        // Check if the new deserialization features are applied correctly
        assertEquals(config.getDeserializationFeatures() | feature.getMask(), newConfig.getDeserializationFeatures());
        assertSame(newConfig.getNodeFactory(), config.getNodeFactory());
    }

    @Test
    public void testWithFeature_SameFeatureNoChange() {
        // Example feature
        DeserializationFeature feature = DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS;
        DeserializationConfig newConfig = config.with(feature);
        DeserializationConfig sameConfig = newConfig.with(feature);
        // Ensure that calling with the same feature does not create a new instance
        assertSame(newConfig, sameConfig);
    }

    @Test
    public void testWithFeature_MultipleFeatures() {
        // Example feature
        DeserializationFeature feature1 = DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS;
        // Another example feature
        DeserializationFeature feature2 = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        DeserializationConfig newConfig = config.with(feature1).with(feature2);
        // Check if both features are applied
        int expectedFeatures = config.getDeserializationFeatures() | feature1.getMask() | feature2.getMask();
        assertEquals(expectedFeatures, newConfig.getDeserializationFeatures());
    }

    @Test
    public void testWithFeature_NoChangeWhenSameFeature() {
        // Example feature
        DeserializationFeature feature = DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS;
        DeserializationConfig newConfig = config.with(feature);
        DeserializationConfig sameConfig = newConfig.with(feature);
        // Ensure that calling with the same feature again does not create a new instance
        assertSame(newConfig, sameConfig);
    }
}
