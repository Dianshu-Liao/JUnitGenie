package com.fasterxml.jackson.databind;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.databind.util.LinkedNode;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.cfg.*;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.databind.jsontype.*;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.LogicalType;

@ExtendWith(MockitoExtension.class)
public class DeserializationConfig_without_11_1_Test {

    private DeserializationConfig config;

    @Mock
    private BaseSettings baseSettings;

    @Mock
    private SubtypeResolver subtypeResolver;

    @Mock
    private SimpleMixInResolver simpleMixInResolver;

    @Mock
    private RootNameLookup rootNameLookup;

    @Mock
    private ConfigOverrides configOverrides;

    @Mock
    private CoercionConfigs coercionConfigs;

    @BeforeEach
    public void setUp() {
        // Initialize the DeserializationConfig with mocked dependencies
        config = new // Assuming null for DatatypeFeatures for simplicity
        // Assuming null for DatatypeFeatures for simplicity
        // Assuming null for DatatypeFeatures for simplicity
        DeserializationConfig(// Assuming null for DatatypeFeatures for simplicity
        baseSettings, // Assuming null for DatatypeFeatures for simplicity
        subtypeResolver, // Assuming null for DatatypeFeatures for simplicity
        simpleMixInResolver, // Assuming null for DatatypeFeatures for simplicity
        rootNameLookup, configOverrides, coercionConfigs, null);
    }

    @Test
    public void testWithoutFeature_RemovesFeature() {
        DeserializationFeature featureToRemove = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        DeserializationConfig newConfig = config.without(featureToRemove);
        assertFalse((newConfig.getDeserializationFeatures() & featureToRemove.getMask()) != 0);
        assertTrue((config.getDeserializationFeatures() & featureToRemove.getMask()) != 0);
    }

    @Test
    public void testWithoutFeature_NoChangeWhenFeatureNotPresent() {
        DeserializationFeature featureNotPresent = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
        DeserializationConfig newConfig = config.without(featureNotPresent);
        assertSame(config, newConfig);
    }

    @Test
    public void testWithoutFeature_Chainability() {
        DeserializationFeature featureToRemove = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        DeserializationConfig newConfig1 = config.without(featureToRemove);
        DeserializationConfig newConfig2 = newConfig1.without(featureToRemove);
        assertSame(newConfig1, newConfig2);
    }

    @Test
    public void testWithoutFeature_MultipleFeatures() {
        DeserializationFeature feature1 = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        DeserializationFeature feature2 = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
        DeserializationConfig newConfig = config.without(feature1).without(feature2);
        assertFalse((newConfig.getDeserializationFeatures() & feature1.getMask()) != 0);
        assertFalse((newConfig.getDeserializationFeatures() & feature2.getMask()) != 0);
    }
}
