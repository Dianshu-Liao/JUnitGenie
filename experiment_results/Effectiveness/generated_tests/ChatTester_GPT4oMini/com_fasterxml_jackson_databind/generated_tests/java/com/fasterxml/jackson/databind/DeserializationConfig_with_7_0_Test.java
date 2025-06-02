package com.fasterxml.jackson.databind;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.cfg.*;
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.databind.jsontype.*;

class DeserializationConfig_with_7_0_Test {

    private DeserializationConfig deserializationConfig;

    private ContextAttributes contextAttributes;

    private ContextAttributes differentContextAttributes;

    @BeforeEach
    void setUp() {
        BaseSettings baseSettings = mock(BaseSettings.class);
        SubtypeResolver subtypeResolver = mock(SubtypeResolver.class);
        SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
        RootNameLookup rootNames = new RootNameLookup();
        ConfigOverrides configOverrides = new ConfigOverrides();
        CoercionConfigs coercionConfigs = new CoercionConfigs();
        DatatypeFeatures datatypeFeatures = mock(DatatypeFeatures.class);
        deserializationConfig = new DeserializationConfig(baseSettings, subtypeResolver, mixins, rootNames, configOverrides, coercionConfigs, datatypeFeatures);
        contextAttributes = mock(ContextAttributes.class);
        differentContextAttributes = mock(ContextAttributes.class);
    }

    @Test
    void testWithSameContextAttributes() {
        DeserializationConfig result = deserializationConfig.with(contextAttributes);
        assertSame(deserializationConfig, result, "Expected the same instance when attributes are the same.");
    }

    @Test
    void testWithDifferentContextAttributes() {
        DeserializationConfig result = deserializationConfig.with(differentContextAttributes);
        assertNotSame(deserializationConfig, result, "Expected a new instance when attributes are different.");
    }
}
