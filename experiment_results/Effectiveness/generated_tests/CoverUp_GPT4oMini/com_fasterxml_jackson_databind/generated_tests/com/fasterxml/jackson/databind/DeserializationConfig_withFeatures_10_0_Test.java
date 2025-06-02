package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.cfg.*;
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.databind.jsontype.*;

public class DeserializationConfig_withFeatures_10_0_Test {

    private DeserializationConfig config;

    @BeforeEach
    public void setUp() throws Exception {
        // Create a new instance of DeserializationConfig with mocked parameters
        BaseSettings baseSettings = mock(BaseSettings.class);
        SubtypeResolver subtypeResolver = mock(SubtypeResolver.class);
        SimpleMixInResolver mixinResolver = mock(SimpleMixInResolver.class);
        RootNameLookup rootNameLookup = mock(RootNameLookup.class);
        ConfigOverrides configOverrides = mock(ConfigOverrides.class);
        CoercionConfigs coercionConfigs = mock(CoercionConfigs.class);
        JsonNodeFactory jsonNodeFactory = mock(JsonNodeFactory.class);
        ConstructorDetector ctorDetector = mock(ConstructorDetector.class);
        LinkedNode<DeserializationProblemHandler> problemHandlers = mock(LinkedNode.class);
        // Use reflection to invoke the constructor
        Constructor<DeserializationConfig> constructor = DeserializationConfig.class.getDeclaredConstructor(BaseSettings.class, SubtypeResolver.class, SimpleMixInResolver.class, RootNameLookup.class, ConfigOverrides.class, CoercionConfigs.class, DatatypeFeatures.class);
        constructor.setAccessible(true);
        config = constructor.newInstance(baseSettings, subtypeResolver, mixinResolver, rootNameLookup, configOverrides, coercionConfigs, mock(DatatypeFeatures.class));
    }

    @Test
    public void testWithFeatures_NoChange() {
        // Test with no features
        DeserializationConfig result = config.withFeatures(new DeserializationFeature[] {});
        assertSame(config, result, "Expected the same instance when no features are added.");
    }

    @Test
    public void testWithFeatures_Change() {
        // Test with a feature that changes the configuration
        DeserializationFeature feature = DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL;
        DeserializationConfig result = config.withFeatures(feature);
        assertNotSame(config, result, "Expected a new instance when features are added.");
        assertEquals(config.getDeserializationFeatures() | feature.getMask(), result.getDeserializationFeatures(), "Expected deserialization features to be updated.");
    }

    @Test
    public void testWithFeatures_MultipleFeatures() {
        // Test with multiple features
        DeserializationFeature feature1 = DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL;
        DeserializationFeature feature2 = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        DeserializationConfig result = config.withFeatures(feature1, feature2);
        assertNotSame(config, result, "Expected a new instance when multiple features are added.");
        assertEquals(config.getDeserializationFeatures() | feature1.getMask() | feature2.getMask(), result.getDeserializationFeatures(), "Expected deserialization features to be updated correctly.");
    }

    @Test
    public void testWithFeatures_SameFeatureTwice() {
        // Test adding the same feature twice
        DeserializationFeature feature = DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL;
        DeserializationConfig result1 = config.withFeatures(feature);
        DeserializationConfig result2 = result1.withFeatures(feature);
        assertSame(result1, result2, "Expected the same instance when the same feature is added twice.");
    }

    @Test
    public void testWithFeatures_EmptyFeatures() {
        // Test adding no features
        DeserializationConfig result = config.withFeatures(new DeserializationFeature[] {});
        assertSame(config, result, "Expected the same instance when no features are added.");
    }
}
