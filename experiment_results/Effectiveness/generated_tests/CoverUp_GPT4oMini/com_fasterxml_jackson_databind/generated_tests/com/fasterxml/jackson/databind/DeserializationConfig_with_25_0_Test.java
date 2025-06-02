package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.util.LinkedNode;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Constructor;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.type.LogicalType;
// Added import for TypeFactory
import com.fasterxml.jackson.databind.type.TypeFactory;
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
class DeserializationConfig_with_25_0_Test {

    private BaseSettings createBaseSettings() {
        return new BaseSettings(mock(ClassIntrospector.class), mock(AnnotationIntrospector.class), mock(PropertyNamingStrategy.class), mock(EnumNamingStrategy.class), mock(TypeFactory.class), mock(TypeResolverBuilder.class), mock(java.text.DateFormat.class), mock(HandlerInstantiator.class), Locale.getDefault(), TimeZone.getDefault(), mock(Base64Variant.class), mock(PolymorphicTypeValidator.class), mock(AccessorNamingStrategy.Provider.class), mock(CacheProvider.class));
    }

    @Test
    void testWithSameConstructorDetector() {
        // Arrange
        ConstructorDetector ctorDetector = mock(ConstructorDetector.class);
        DeserializationConfig config = new DeserializationConfig(createBaseSettings(), mock(SubtypeResolver.class), mock(SimpleMixInResolver.class), mock(RootNameLookup.class), mock(ConfigOverrides.class), mock(CoercionConfigs.class), mock(DatatypeFeatures.class));
        // Act
        DeserializationConfig result = config.with(ctorDetector);
        // Assert
        assertSame(config, result, "Expected the same instance when passing the same ConstructorDetector");
    }

    @Test
    void testWithDifferentConstructorDetector() {
        // Arrange
        ConstructorDetector ctorDetector1 = mock(ConstructorDetector.class);
        ConstructorDetector ctorDetector2 = mock(ConstructorDetector.class);
        DeserializationConfig config = new DeserializationConfig(createBaseSettings(), mock(SubtypeResolver.class), mock(SimpleMixInResolver.class), mock(RootNameLookup.class), mock(ConfigOverrides.class), mock(CoercionConfigs.class), mock(DatatypeFeatures.class));
        // Act
        DeserializationConfig result = config.with(ctorDetector1);
        DeserializationConfig newResult = result.with(ctorDetector2);
        // Assert
        assertNotSame(result, newResult, "Expected a new instance when passing a different ConstructorDetector");
    }
}
