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

public class DeserializationConfig_withFeatures_10_2_Test {

    private DeserializationConfig config;

    @BeforeEach
    public void setUp() {
        config = new DeserializationConfig(null, null, null, null, null, null, null);
    }

    @Test
    public void testWithFeatures_NoFeatures() {
        DeserializationConfig newConfig = config.withFeatures(new DeserializationFeature[0]);
        assertSame(config, newConfig, "Expected the same instance when no features are added.");
    }

    @Test
    public void testWithFeatures_OneFeature() {
        DeserializationFeature feature = DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY;
        DeserializationConfig newConfig = config.withFeatures(new DeserializationFeature[] { feature });
        assertNotSame(config, newConfig, "Expected a new instance when a feature is added.");
        assertTrue((newConfig.getDeserializationFeatures() & feature.getMask()) != 0, "Expected the feature to be set in the new config.");
    }

    @Test
    public void testWithFeatures_MultipleFeatures() {
        DeserializationFeature feature1 = DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY;
        DeserializationFeature feature2 = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        DeserializationConfig newConfig = config.withFeatures(new DeserializationFeature[] { feature1, feature2 });
        assertNotSame(config, newConfig, "Expected a new instance when multiple features are added.");
        assertTrue((newConfig.getDeserializationFeatures() & feature1.getMask()) != 0, "Expected feature1 to be set in the new config.");
        assertTrue((newConfig.getDeserializationFeatures() & feature2.getMask()) != 0, "Expected feature2 to be set in the new config.");
    }

    @Test
    public void testWithFeatures_SameFeatures() {
        DeserializationFeature feature = DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY;
        DeserializationConfig intermediateConfig = config.withFeatures(new DeserializationFeature[] { feature });
        DeserializationConfig newConfig = intermediateConfig.withFeatures(new DeserializationFeature[] { feature });
        assertSame(intermediateConfig, newConfig, "Expected the same instance when the same feature is added again.");
    }

    @Test
    public void testWithFeatures_CombiningFeatures() {
        DeserializationFeature feature1 = DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY;
        DeserializationFeature feature2 = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        DeserializationConfig intermediateConfig = config.withFeatures(new DeserializationFeature[] { feature1 });
        DeserializationConfig newConfig = intermediateConfig.withFeatures(new DeserializationFeature[] { feature2 });
        assertNotSame(intermediateConfig, newConfig, "Expected a new instance when combining features.");
        assertTrue((newConfig.getDeserializationFeatures() & feature1.getMask()) != 0, "Expected feature1 to be set in the new config.");
        assertTrue((newConfig.getDeserializationFeatures() & feature2.getMask()) != 0, "Expected feature2 to be set in the new config.");
    }
}
