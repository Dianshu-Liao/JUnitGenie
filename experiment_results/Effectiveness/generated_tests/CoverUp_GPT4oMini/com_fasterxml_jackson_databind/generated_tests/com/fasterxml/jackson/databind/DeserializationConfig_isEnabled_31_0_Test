package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.databind.jsontype.*;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.LogicalType;

public class DeserializationConfig_isEnabled_31_0_Test {

    private DeserializationConfig deserializationConfig;

    @BeforeEach
    public void setUp() throws Exception {
        // Create an instance of DeserializationConfig using reflection
        Constructor<DeserializationConfig> constructor = DeserializationConfig.class.getDeclaredConstructor(BaseSettings.class, SubtypeResolver.class, SimpleMixInResolver.class, RootNameLookup.class, ConfigOverrides.class, CoercionConfigs.class, DatatypeFeatures.class);
        constructor.setAccessible(true);
        // Mock parameters for the constructor (you may need to create mock objects)
        // Replace with actual mock
        BaseSettings baseSettings = null;
        // Replace with actual mock
        SubtypeResolver subtypeResolver = null;
        // Replace with actual mock
        SimpleMixInResolver mixinResolver = null;
        // Replace with actual mock
        RootNameLookup rootNameLookup = null;
        // Replace with actual mock
        ConfigOverrides configOverrides = null;
        // Replace with actual mock
        CoercionConfigs coercionConfigs = null;
        // Replace with actual mock
        DatatypeFeatures datatypeFeatures = null;
        // Initialize the DeserializationConfig instance
        deserializationConfig = constructor.newInstance(baseSettings, subtypeResolver, mixinResolver, rootNameLookup, configOverrides, coercionConfigs, datatypeFeatures);
    }

    @Test
    public void testIsEnabledFeatureEnabled() {
        // Assuming DeserializationFeature has a feature that is enabled
        // Example feature
        DeserializationFeature feature = DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT;
        // Set the feature to be enabled in _deserFeatures (you may need to use reflection to set this)
        setDeserFeatures(deserializationConfig, feature.getMask());
        // Assert that the feature is enabled
        assertTrue(deserializationConfig.isEnabled(feature));
    }

    @Test
    public void testIsEnabledFeatureDisabled() {
        // Assuming DeserializationFeature has a feature that is disabled
        // Example feature
        DeserializationFeature feature = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        // Set the feature to be disabled in _deserFeatures (you may need to use reflection to set this)
        // Disable all features
        setDeserFeatures(deserializationConfig, 0);
        // Assert that the feature is disabled
        assertFalse(deserializationConfig.isEnabled(feature));
    }

    private void setDeserFeatures(DeserializationConfig config, int features) {
        try {
            java.lang.reflect.Field field = DeserializationConfig.class.getDeclaredField("_deserFeatures");
            field.setAccessible(true);
            field.setInt(config, features);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to set _deserFeatures", e);
        }
    }
}
