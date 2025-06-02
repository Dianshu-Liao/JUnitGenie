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

public class DeserializationConfig_withoutFeatures_17_0_Test {

    @Test
    public void testWithoutFeatures_NoChange() {
        // Arrange
        DeserializationConfig config = new DeserializationConfig(null, null, null, null, null, null, null);
        JsonParser.Feature[] features = new JsonParser.Feature[] {};
        // Act
        DeserializationConfig result = config.withoutFeatures(features);
        // Assert
        assertSame(config, result, "The same instance should be returned when no features are provided.");
    }

    @Test
    public void testWithoutFeatures_SingleFeature() {
        // Arrange
        DeserializationConfig config = new DeserializationConfig(null, null, null, null, null, null, null);
        config = config.withoutFeatures(JsonParser.Feature.ALLOW_COMMENTS);
        // Act
        DeserializationConfig result = config.withoutFeatures(JsonParser.Feature.ALLOW_COMMENTS);
        // Assert
        assertSame(config, result, "The same instance should be returned when the same feature is removed.");
    }

    @Test
    public void testWithoutFeatures_MultipleFeatures() {
        // Arrange
        DeserializationConfig config = new DeserializationConfig(null, null, null, null, null, null, null);
        JsonParser.Feature[] features = new JsonParser.Feature[] { JsonParser.Feature.ALLOW_COMMENTS, JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES };
        // Act
        DeserializationConfig result = config.withoutFeatures(features);
        // Assert
        assertNotSame(config, result, "A new instance should be returned when features are removed.");
        // Additional assertions can be added here to verify the new state if needed.
    }

    @Test
    public void testWithoutFeatures_ExistingFeature() {
        // Arrange
        DeserializationConfig config = new DeserializationConfig(null, null, null, null, null, null, null);
        config = config.withoutFeatures(JsonParser.Feature.ALLOW_COMMENTS);
        // Act
        DeserializationConfig result = config.withoutFeatures(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        // Assert
        assertNotSame(config, result, "A new instance should be returned when a new feature is removed.");
    }

    @Test
    public void testWithoutFeatures_NoChangeWithSameInstance() {
        // Arrange
        DeserializationConfig config = new DeserializationConfig(null, null, null, null, null, null, null);
        JsonParser.Feature[] features = new JsonParser.Feature[] { JsonParser.Feature.ALLOW_COMMENTS };
        // Act
        DeserializationConfig result = config.withoutFeatures(features);
        // Assert
        assertNotSame(config, result, "A new instance should be returned when features are removed.");
    }
}
