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

public class DeserializationConfig_without_20_0_Test {

    private DeserializationConfig config;

    @BeforeEach
    public void setUp() {
        config = new DeserializationConfig(null, null, null, null, null, null, null);
    }

    @Test
    public void testWithoutJsonReadFeature() {
        // Use a valid feature
        JsonReadFeature feature = JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER;
        DeserializationConfig result = config.without(feature);
        assertNotNull(result);
        assertNotSame(config, result);
        assertEquals(config.getDeserializationFeatures(), result.getDeserializationFeatures());
    }

    @Test
    public void testWithoutDeserializationFeature() {
        // Example feature
        DeserializationFeature feature = DeserializationFeature.FAIL_ON_TRAILING_TOKENS;
        DeserializationConfig result = config.without(feature);
        assertNotNull(result);
        assertNotSame(config, result);
        assertNotEquals(config.getDeserializationFeatures(), result.getDeserializationFeatures());
    }

    @Test
    public void testWithoutMultipleFeatures() {
        // Test one feature at a time
        DeserializationFeature feature1 = DeserializationFeature.FAIL_ON_TRAILING_TOKENS;
        DeserializationConfig result1 = config.without(feature1);
        assertNotNull(result1);
        assertNotSame(config, result1);
        assertNotEquals(config.getDeserializationFeatures(), result1.getDeserializationFeatures());
        DeserializationFeature feature2 = DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES;
        DeserializationConfig result2 = result1.without(feature2);
        assertNotNull(result2);
        assertNotSame(result1, result2);
        assertNotEquals(result1.getDeserializationFeatures(), result2.getDeserializationFeatures());
    }

    @Test
    public void testWithoutNoChange() {
        // No change
        DeserializationFeature feature = DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS;
        DeserializationConfig result = config.without(feature);
        assertSame(config, result);
    }

    @Test
    public void testWithoutJsonReadFeatureMultiple() {
        // Use valid features one at a time
        JsonReadFeature feature1 = JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER;
        JsonReadFeature feature2 = JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES;
        DeserializationConfig result1 = config.without(feature1);
        assertNotNull(result1);
        assertNotSame(config, result1);
        assertEquals(config.getDeserializationFeatures(), result1.getDeserializationFeatures());
        DeserializationConfig result2 = result1.without(feature2);
        assertNotNull(result2);
        assertNotSame(result1, result2);
        assertEquals(result1.getDeserializationFeatures(), result2.getDeserializationFeatures());
    }
}
