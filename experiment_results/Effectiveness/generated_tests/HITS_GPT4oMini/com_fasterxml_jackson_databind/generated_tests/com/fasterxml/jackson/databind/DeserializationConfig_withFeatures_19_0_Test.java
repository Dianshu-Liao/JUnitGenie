package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.cfg.*;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.databind.jsontype.*;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.RootNameLookup;

public class DeserializationConfig_withFeatures_19_0_Test {

    private DeserializationConfig config;

    @BeforeEach
    public void setUp() {
        // Initialize DeserializationConfig with default settings
        config = new DeserializationConfig(null, null, null, null, null, null, null);
    }

    @Test
    public void testWithFeatures_JsonReadFeature() {
        // Given
        FormatFeature[] features = new FormatFeature[] { JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES };
        // When
        DeserializationConfig newConfig = config.withFeatures(features);
        // Then
        assertNotSame(config, newConfig);
        assertEquals(newConfig.getDeserializationFeatures(), config.getDeserializationFeatures());
    }

    @Test
    public void testWithFeatures_Empty() {
        // Given
        FormatFeature[] features = new FormatFeature[] {};
        // When
        DeserializationConfig newConfig = config.withFeatures(features);
        // Then
        assertSame(config, newConfig);
    }

    @Test
    public void testWithFeatures_MultipleFeatures() {
        // Given
        FormatFeature[] features = new FormatFeature[] { JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES };
        // When
        DeserializationConfig newConfig = config.withFeatures(features);
        // Then
        assertNotSame(config, newConfig);
        assertEquals(newConfig.getDeserializationFeatures(), config.getDeserializationFeatures());
    }

    @Test
    public void testWithFeatures_JsonReadFeatureAndOther() {
        // Given
        FormatFeature[] features = new FormatFeature[] { JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES };
        // When
        DeserializationConfig newConfig = config.withFeatures(features);
        // Then
        assertNotSame(config, newConfig);
        assertEquals(newConfig.getDeserializationFeatures(), config.getDeserializationFeatures());
    }
}
