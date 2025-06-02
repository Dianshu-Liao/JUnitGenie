package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
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
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.RootNameLookup;

class DeserializationConfig_with_8_0_Test {

    private DeserializationConfig deserializationConfig;

    private DeserializationFeature feature;

    @BeforeEach
    void setUp() {
        // Create a mock for DeserializationFeature
        feature = mock(DeserializationFeature.class);
        // Example mask value
        when(feature.getMask()).thenReturn(1);
        // Initialize DeserializationConfig with default values
        deserializationConfig = new DeserializationConfig(null, null, null, null, null, null, null);
    }

    @Test
    void testWithFeature_NewFeatureApplied() {
        // Set the initial deserialization features
        int initialFeatures = deserializationConfig.getDeserializationFeatures();
        deserializationConfig = deserializationConfig.with(feature);
        // Assert that the new features are applied
        assertNotEquals(initialFeatures, deserializationConfig.getDeserializationFeatures());
    }

    @Test
    void testWithFeature_SameFeatureNotApplied() {
        // Set the initial deserialization features
        deserializationConfig = new DeserializationConfig(null, null, null, null, null, null, null);
        // Mock the feature to return a mask that is already included
        when(feature.getMask()).thenReturn(deserializationConfig.getDeserializationFeatures());
        // Invoke the method
        DeserializationConfig result = deserializationConfig.with(feature);
        // Assert that the same instance is returned
        assertSame(deserializationConfig, result);
    }

    @Test
    void testWithFeature_MultipleFeaturesApplied() {
        DeserializationFeature feature2 = mock(DeserializationFeature.class);
        when(feature.getMask()).thenReturn(1);
        // Another feature mask
        when(feature2.getMask()).thenReturn(2);
        // Apply first feature
        deserializationConfig = deserializationConfig.with(feature);
        // Apply second feature
        deserializationConfig = deserializationConfig.with(feature2);
        // Assert that both features are now applied
        assertEquals(3, deserializationConfig.getDeserializationFeatures());
    }
}
