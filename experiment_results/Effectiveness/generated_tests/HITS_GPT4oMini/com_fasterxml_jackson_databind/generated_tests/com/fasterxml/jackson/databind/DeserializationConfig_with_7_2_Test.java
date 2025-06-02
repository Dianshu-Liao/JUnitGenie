package com.fasterxml.jackson.databind;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.cfg.*;
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.databind.jsontype.*;

@ExtendWith(MockitoExtension.class)
public class DeserializationConfig_with_7_2_Test {

    private DeserializationConfig config;

    private ContextAttributes attrs;

    @BeforeEach
    public void setUp() {
        // Mock necessary components for the tests
        BaseSettings baseSettings = mock(BaseSettings.class);
        SubtypeResolver subtypeResolver = mock(SubtypeResolver.class);
        SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
        RootNameLookup rootNames = mock(RootNameLookup.class);
        ConfigOverrides configOverrides = mock(ConfigOverrides.class);
        CoercionConfigs coercionConfigs = mock(CoercionConfigs.class);
        // Use a mock for DatatypeFeatures since it has protected access
        DatatypeFeatures datatypeFeatures = mock(DatatypeFeatures.class);
        // Create a DeserializationConfig instance
        config = new DeserializationConfig(baseSettings, subtypeResolver, mixins, rootNames, configOverrides, coercionConfigs, datatypeFeatures);
        // Mock ContextAttributes
        attrs = mock(ContextAttributes.class);
    }

    @Test
    public void testWithSameAttributes() {
        // Test when the same ContextAttributes is passed
        DeserializationConfig result = config.with(attrs);
        assertSame(config, result, "Expected the same instance to be returned");
    }

    @Test
    public void testWithDifferentAttributes() {
        // Test when a different ContextAttributes is passed
        ContextAttributes differentAttrs = mock(ContextAttributes.class);
        DeserializationConfig result = config.with((ContextAttributes) differentAttrs);
        assertNotSame(config, result, "Expected a new instance to be created");
    }

    @Test
    public void testWithNullAttributes() {
        // Test when null is passed as ContextAttributes
        DeserializationConfig result = config.with((ContextAttributes) null);
        assertNotNull(result, "Expected a new instance to be created even with null attributes");
        assertNotSame(config, result, "Expected a new instance to be created");
    }

    @Test
    public void testWithNullConfig() {
        // Test with a null config instance
        DeserializationConfig nullConfig = null;
        assertThrows(NullPointerException.class, () -> {
            nullConfig.with(attrs);
        }, "Expected NullPointerException when calling with on a null config");
    }
}
