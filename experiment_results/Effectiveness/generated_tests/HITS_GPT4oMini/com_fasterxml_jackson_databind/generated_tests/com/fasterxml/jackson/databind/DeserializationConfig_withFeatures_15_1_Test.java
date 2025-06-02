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

public class DeserializationConfig_withFeatures_15_1_Test {

    private DeserializationConfig config;

    @BeforeEach
    public void setUp() {
        // Initialize the DeserializationConfig with default values
        config = new DeserializationConfig(null, null, null, null, null, null, null);
    }

    @Test
    public void testWithFeatures_NoFeatures() {
        // Test with no features provided
        DeserializationConfig result = config.withFeatures(new JsonParser.Feature[] {});
        assertSame(config, result, "Expected the same instance when no features are added");
    }

    @Test
    public void testWithFeatures_SingleFeature() {
        // Test with a single feature
        DeserializationConfig result = config.withFeatures(JsonParser.Feature.ALLOW_COMMENTS);
        assertEquals(config.getDeserializationFeatures() | JsonParser.Feature.ALLOW_COMMENTS.getMask(), result.getDeserializationFeatures(), "Expected features to be updated");
    }

    @Test
    public void testWithFeatures_MultipleFeatures() {
        // Test with multiple features
        DeserializationConfig result = config.withFeatures(JsonParser.Feature.ALLOW_COMMENTS, JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        assertEquals(config.getDeserializationFeatures() | JsonParser.Feature.ALLOW_COMMENTS.getMask() | JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask(), result.getDeserializationFeatures(), "Expected features to be updated with multiple features");
    }

    @Test
    public void testWithFeatures_NoChange() {
        // Test with features that do not change the config
        DeserializationConfig result = config.withFeatures(new JsonParser.Feature[] {});
        assertSame(config, result, "Expected the same instance when features do not change");
    }

    @Test
    public void testWithFeatures_ChangeExistingFeatures() {
        // First, set some initial features
        DeserializationConfig initialConfig = config.withFeatures(JsonParser.Feature.ALLOW_COMMENTS);
        // Now add another feature
        DeserializationConfig result = initialConfig.withFeatures(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        assertEquals(initialConfig.getDeserializationFeatures() | JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask(), result.getDeserializationFeatures(), "Expected features to reflect the addition of a new feature");
    }
}
