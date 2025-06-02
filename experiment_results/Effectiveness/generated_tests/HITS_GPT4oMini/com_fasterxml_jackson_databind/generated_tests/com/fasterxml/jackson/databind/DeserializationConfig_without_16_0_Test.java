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

public class DeserializationConfig_without_16_0_Test {

    private DeserializationConfig config;

    @BeforeEach
    public void setUp() {
        // Initialize DeserializationConfig with default parameters
        config = new DeserializationConfig(null, null, null, null, null, null, null);
    }

    @Test
    public void testWithoutFeature_RemovesFeature() {
        // Assuming a feature that is not set initially
        JsonParser.Feature feature = JsonParser.Feature.ALLOW_COMMENTS;
        // Call without method to remove the feature
        DeserializationConfig newConfig = config.without(feature);
        // Verify that the feature is removed
        assertNotSame(config, newConfig);
        assertEquals(config.getDeserializationFeatures(), newConfig.getDeserializationFeatures());
    }

    @Test
    public void testWithoutFeature_NoChangeWhenFeatureNotSet() {
        // Assume a feature that is not set initially
        JsonParser.Feature feature = JsonParser.Feature.ALLOW_COMMENTS;
        // Call without method
        DeserializationConfig newConfig = config.without(feature);
        // Verify that the original config remains unchanged
        assertSame(config, newConfig);
    }

    @Test
    public void testWithoutFeature_AddsFeatureToChangeMask() {
        // Assume a feature that is not set initially
        JsonParser.Feature feature = JsonParser.Feature.ALLOW_COMMENTS;
        // Call without method to remove the feature
        DeserializationConfig newConfig = config.without(feature);
        // Verify that the new config has the feature added to the change mask
        assertTrue((newConfig._parserFeaturesToChange & feature.getMask()) != 0);
    }

    @Test
    public void testWithoutFeature_HandlesMultipleFeatures() {
        // Setup initial features
        JsonParser.Feature feature1 = JsonParser.Feature.ALLOW_COMMENTS;
        JsonParser.Feature feature2 = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES;
        // Call without method to remove feature1
        DeserializationConfig newConfig = config.without(feature1);
        // Call without method to remove feature2
        newConfig = newConfig.without(feature2);
        // Verify that both features are removed
        assertNotSame(config, newConfig);
        assertEquals(config.getDeserializationFeatures(), newConfig.getDeserializationFeatures());
        assertTrue((newConfig._parserFeaturesToChange & (feature1.getMask() | feature2.getMask())) != 0);
    }

    @Test
    public void testWithoutFeature_ReturnsSameInstanceIfNoChange() {
        // Setup initial features
        JsonParser.Feature feature = JsonParser.Feature.ALLOW_COMMENTS;
        // Call without method with a feature that isn't set
        DeserializationConfig newConfig = config.without(feature);
        // Ensure the same instance is returned if no changes were made
        assertSame(config, newConfig);
    }
}
