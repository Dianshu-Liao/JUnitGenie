package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.type.TypeFactory;
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

class DeserializationConfig_without_11_0_Test {

    @Test
    void testWithoutDeserializationFeature() {
        // Create mocks for the required parameters of BaseSettings constructor
        ClassIntrospector classIntrospector = mock(ClassIntrospector.class);
        AnnotationIntrospector annotationIntrospector = mock(AnnotationIntrospector.class);
        PropertyNamingStrategy propertyNamingStrategy = mock(PropertyNamingStrategy.class);
        TypeFactory typeFactory = mock(TypeFactory.class);
        TypeResolverBuilder<?> typeResolverBuilder = mock(TypeResolverBuilder.class);
        // Instantiate BaseSettings with mocked parameters
        BaseSettings baseSettings = new BaseSettings(classIntrospector, annotationIntrospector, propertyNamingStrategy, typeFactory, typeResolverBuilder, null, null, null, null, null, null, null);
        // Create a DeserializationConfig instance with default features
        DeserializationConfig config = new DeserializationConfig(baseSettings, null, null, new RootNameLookup(), new ConfigOverrides(), new CoercionConfigs(), DatatypeFeatures.defaultFeatures());
        // Create a new configuration without the FAIL_ON_UNKNOWN_PROPERTIES feature
        DeserializationConfig newConfig = config.without(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // Assert that the new configuration has the FAIL_ON_UNKNOWN_PROPERTIES feature disabled
        assertEquals(newConfig.getDeserializationFeatures(), config.getDeserializationFeatures() & ~DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES.getMask());
    }
}
