package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.util.LinkedNode;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.databind.jsontype.*;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.RootNameLookup;

class DeserializationConfig_without_11_0_Test {

    private DeserializationConfig deserializationConfig;

    @BeforeEach
    void setUp() {
        // Initialize with default settings
        deserializationConfig = createDeserializationConfig();
    }

    private DeserializationConfig createDeserializationConfig() {
        // Mocking dependencies for BaseSettings and SimpleMixInResolver
        BaseSettings baseSettings = mock(BaseSettings.class);
        SimpleMixInResolver mixins = mock(SimpleMixInResolver.class);
        LinkedNode<DeserializationProblemHandler> problemHandlers = null;
        JsonNodeFactory nodeFactory = JsonNodeFactory.instance;
        // Create a new instance of DeserializationConfig using reflection
        try {
            Constructor<DeserializationConfig> constructor = DeserializationConfig.class.getDeclaredConstructor(BaseSettings.class, SubtypeResolver.class, SimpleMixInResolver.class, RootNameLookup.class, ConfigOverrides.class, CoercionConfigs.class, DatatypeFeatures.class);
            constructor.setAccessible(true);
            return constructor.newInstance(baseSettings, null, mixins, null, null, null, null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testWithoutFeatureRemovesFeature() throws Exception {
        DeserializationFeature featureToRemove = DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
        DeserializationConfig modifiedConfig = deserializationConfig.without(featureToRemove);
        assertNotSame(deserializationConfig, modifiedConfig);
        assertFalse((modifiedConfig.getDeserializationFeatures() & featureToRemove.getMask()) != 0);
    }

    @Test
    void testWithoutFeatureDoesNotChangeConfigWhenFeatureNotPresent() throws Exception {
        DeserializationFeature featureNotPresent = DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY;
        DeserializationConfig resultConfig = deserializationConfig.without(featureNotPresent);
        assertSame(deserializationConfig, resultConfig);
    }

    @Test
    void testWithoutFeatureReturnsSameInstanceWhenNoChange() throws Exception {
        DeserializationConfig resultConfig = deserializationConfig.without(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        assertSame(deserializationConfig, resultConfig);
    }

    @Test
    void testWithoutFeatureCreatesNewInstanceWhenFeatureIsPresent() throws Exception {
        DeserializationConfig modifiedConfig = deserializationConfig.without(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        assertNotSame(deserializationConfig, modifiedConfig);
    }

    // Helper method to access private constructor using reflection
    private DeserializationConfig createDeserializationConfigWithParams(DeserializationConfig src, long mapperFeatures, int deserFeatures) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<DeserializationConfig> constructor = DeserializationConfig.class.getDeclaredConstructor(DeserializationConfig.class, long.class, int.class);
        constructor.setAccessible(true);
        return constructor.newInstance(src, mapperFeatures, deserFeatures);
    }
}
