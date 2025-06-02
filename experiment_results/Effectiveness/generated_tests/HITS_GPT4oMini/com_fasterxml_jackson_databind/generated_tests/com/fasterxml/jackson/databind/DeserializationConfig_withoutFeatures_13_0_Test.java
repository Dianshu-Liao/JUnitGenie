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

public class DeserializationConfig_withoutFeatures_13_0_Test {

    private DeserializationConfig config;

    @BeforeEach
    public void setUp() {
        config = new DeserializationConfig(null, null, null, null, null, null, null);
    }

    @Test
    public void testWithoutFeatures_NoFeaturesRemoved() {
        // Given: No features to remove
        DeserializationFeature[] featuresToRemove = new DeserializationFeature[0];
        // When: Calling withoutFeatures
        DeserializationConfig newConfig = config.withoutFeatures(featuresToRemove);
        // Then: The new config should be the same as the original
        assertSame(config, newConfig);
    }

    @Test
    public void testWithoutFeatures_SingleFeatureRemoved() {
        // Given: A feature to remove
        DeserializationFeature featureToRemove = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        // When: Calling withoutFeatures
        DeserializationConfig newConfig = config.withoutFeatures(featureToRemove);
        // Then: The new config should not be the same as the original
        assertNotSame(config, newConfig);
        assertEquals(config.getDeserializationFeatures() & ~featureToRemove.getMask(), newConfig.getDeserializationFeatures());
    }

    @Test
    public void testWithoutFeatures_MultipleFeaturesRemoved() {
        // Given: Multiple features to remove
        DeserializationFeature featureToRemove1 = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        DeserializationFeature featureToRemove2 = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
        // When: Calling withoutFeatures
        DeserializationConfig newConfig = config.withoutFeatures(featureToRemove1, featureToRemove2);
        // Then: The new config should not be the same as the original
        assertNotSame(config, newConfig);
        int expectedFeatures = config.getDeserializationFeatures() & ~featureToRemove1.getMask() & ~featureToRemove2.getMask();
        assertEquals(expectedFeatures, newConfig.getDeserializationFeatures());
    }

    @Test
    public void testWithoutFeatures_NoEffectOnSameFeatures() {
        // Given: Features that are not set in the original config
        DeserializationFeature featureToRemove = DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL;
        // When: Calling withoutFeatures
        DeserializationConfig newConfig = config.withoutFeatures(featureToRemove);
        // Then: The new config should be the same as the original
        assertSame(config, newConfig);
    }
}
