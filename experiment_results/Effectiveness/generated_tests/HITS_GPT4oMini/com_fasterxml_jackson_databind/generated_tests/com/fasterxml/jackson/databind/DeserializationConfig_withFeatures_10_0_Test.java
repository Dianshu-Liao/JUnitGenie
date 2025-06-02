package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.DeserializationFeature;
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

public class DeserializationConfig_withFeatures_10_0_Test {

    @Test
    public void testWithFeatures() {
        // Create an instance of DeserializationConfig with default features
        DeserializationConfig config = new DeserializationConfig(null, null, null, null, null, null, null);
        // Check the initial deserialization features
        int initialFeatures = config.getDeserializationFeatures();
        // Create new DeserializationFeature to test
        DeserializationFeature feature1 = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        DeserializationFeature feature2 = DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY;
        // Call withFeatures with the specific feature types
        DeserializationConfig newConfig = config.withFeatures(feature1, feature2);
        // Verify that newConfig is not the same instance as config
        assertSame(newConfig, config.withFeatures(feature1), "New config should be different when features are added.");
        // Verify that the deserialization features have been updated
        int expectedFeatures = initialFeatures | feature1.getMask() | feature2.getMask();
        assertEquals(expectedFeatures, newConfig.getDeserializationFeatures());
    }
}
