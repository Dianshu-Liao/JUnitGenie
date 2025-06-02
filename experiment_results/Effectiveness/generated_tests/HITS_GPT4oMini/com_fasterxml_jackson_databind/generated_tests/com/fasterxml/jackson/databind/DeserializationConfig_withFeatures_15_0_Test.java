package com.fasterxml.jackson.databind;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.RootNameLookup;

public class DeserializationConfig_withFeatures_15_0_Test {

    private DeserializationConfig deserializationConfig;

    @BeforeEach
    public void setUp() {
        deserializationConfig = new DeserializationConfig(null, null, null, null, null, null, null);
    }

    @Test
    public void testWithFeatures_NoFeatures() {
        DeserializationConfig result = deserializationConfig.withFeatures((JsonParser.Feature[]) null);
        assertEquals(deserializationConfig, result);
    }

    @Test
    public void testWithFeatures_OneFeature() {
        DeserializationConfig result = deserializationConfig.withFeatures(JsonParser.Feature.ALLOW_COMMENTS);
        assertNotSame(deserializationConfig, result);
        assertEquals(deserializationConfig.getDeserializationFeatures(), result.getDeserializationFeatures() & ~JsonParser.Feature.ALLOW_COMMENTS.getMask());
    }

    @Test
    public void testWithFeatures_MultipleFeatures() {
        DeserializationConfig result = deserializationConfig.withFeatures(JsonParser.Feature.ALLOW_COMMENTS, JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        assertNotSame(deserializationConfig, result);
        assertEquals(deserializationConfig.getDeserializationFeatures(), result.getDeserializationFeatures() & ~(JsonParser.Feature.ALLOW_COMMENTS.getMask() | JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask()));
    }

    @Test
    public void testWithFeatures_SameFeatures() {
        DeserializationConfig result = deserializationConfig.withFeatures((JsonParser.Feature[]) null);
        assertEquals(deserializationConfig, result);
    }

    @Test
    public void testWithFeatures_ChangeParserFeatures() {
        DeserializationConfig initialConfig = deserializationConfig.withFeatures(JsonParser.Feature.ALLOW_COMMENTS);
        DeserializationConfig newConfig = initialConfig.withFeatures(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        assertNotSame(initialConfig, newConfig);
        assertEquals(initialConfig.getDeserializationFeatures() | JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask(), newConfig.getDeserializationFeatures());
    }
}
