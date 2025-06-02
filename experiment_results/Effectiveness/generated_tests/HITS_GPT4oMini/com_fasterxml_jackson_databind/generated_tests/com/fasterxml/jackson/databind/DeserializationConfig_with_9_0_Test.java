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

public class DeserializationConfig_with_9_0_Test {

    private DeserializationConfig config;

    @BeforeEach
    public void setUp() {
        // Initialize the DeserializationConfig with default values
        config = new DeserializationConfig(null, null, null, null, null, null, null);
    }

    @Test
    public void testWithSingleFeature() {
        DeserializationFeature feature = DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT;
        DeserializationConfig newConfig = config.with(feature);
        // Check that the new config has the feature enabled
        assertEquals(config.getDeserializationFeatures() | feature.getMask(), newConfig.getDeserializationFeatures());
    }

    @Test
    public void testWithMultipleFeatures() {
        DeserializationFeature feature1 = DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT;
        DeserializationFeature feature2 = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        DeserializationConfig newConfig = config.with(feature1, feature2);
        // Check that the new config has both features enabled
        assertEquals(config.getDeserializationFeatures() | feature1.getMask() | feature2.getMask(), newConfig.getDeserializationFeatures());
    }

    @Test
    public void testWithNoNewFeatures() {
        DeserializationFeature feature = DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT;
        DeserializationConfig newConfig = config.with(feature);
        // Call again with the same feature, should return the same instance
        DeserializationConfig sameConfig = newConfig.with(feature);
        assertSame(newConfig, sameConfig);
    }

    @Test
    public void testWithNoChange() {
        DeserializationConfig newConfig = config.with();
        // Should return the same instance if no features are added
        assertSame(config, newConfig);
    }
}
