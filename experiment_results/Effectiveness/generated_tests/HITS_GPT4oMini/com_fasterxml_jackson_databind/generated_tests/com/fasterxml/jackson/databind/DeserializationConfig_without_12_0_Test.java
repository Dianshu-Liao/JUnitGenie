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

public class DeserializationConfig_without_12_0_Test {

    private DeserializationConfig config;

    @BeforeEach
    public void setUp() {
        // Initialize the DeserializationConfig with default values
        config = new DeserializationConfig(null, null, null, null, null, null, null);
    }

    @Test
    public void testWithoutSingleFeature() {
        // Assuming DeserializationFeature has a method to retrieve a feature by its name
        DeserializationFeature featureToRemove = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        DeserializationConfig newConfig = config.without(featureToRemove);
        // Check that the new configuration is not the same as the original
        assertEquals(newConfig.getDeserializationFeatures(), config.getDeserializationFeatures() & ~featureToRemove.getMask());
        assertSame(newConfig, config.without(featureToRemove));
    }

    @Test
    public void testWithoutMultipleFeatures() {
        DeserializationFeature feature1 = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        DeserializationFeature feature2 = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
        DeserializationConfig newConfig = config.without(feature1, feature2);
        // Check that the new configuration has both features removed
        int expectedFeatures = config.getDeserializationFeatures() & ~feature1.getMask() & ~feature2.getMask();
        assertEquals(newConfig.getDeserializationFeatures(), expectedFeatures);
    }

    @Test
    public void testWithoutNoChange() {
        DeserializationConfig newConfig = config.without();
        // Check that invoking without with no features returns the same instance
        assertSame(newConfig, config);
    }

    @Test
    public void testWithoutSameConfigReturned() {
        DeserializationFeature featureToRemove = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        // Check that if no features are removed, the same instance is returned
        DeserializationConfig newConfig = config.without(featureToRemove);
        assertSame(newConfig, config);
    }
}
