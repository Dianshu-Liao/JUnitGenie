package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.MinimalClassNameIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.*;

public class XmlTypeResolverBuilder_idResolver_1_0_Test {

    private XmlTypeResolverBuilder xmlTypeResolverBuilder;

    @BeforeEach
    public void setUp() {
        xmlTypeResolverBuilder = new XmlTypeResolverBuilder();
    }

    @Test
    public void testIdResolver_CustomIdResolver() {
        // Arrange
        TypeIdResolver customIdResolver = mock(TypeIdResolver.class);
        setPrivateField(xmlTypeResolverBuilder, "_customIdResolver", customIdResolver);
        MapperConfig<?> config = mock(MapperConfig.class);
        JavaType baseType = mock(JavaType.class);
        PolymorphicTypeValidator subtypeValidator = mock(PolymorphicTypeValidator.class);
        Collection<NamedType> subtypes = Collections.emptyList();
        // Act
        TypeIdResolver result = xmlTypeResolverBuilder.idResolver(config, baseType, subtypeValidator, subtypes, true, false);
        // Assert
        assertEquals(customIdResolver, result);
    }

    @Test
    public void testIdResolver_ClassType() {
        // Arrange
        setPrivateField(xmlTypeResolverBuilder, "_idType", JsonTypeInfo.Id.CLASS);
        MapperConfig<?> config = mock(MapperConfig.class);
        JavaType baseType = mock(JavaType.class);
        PolymorphicTypeValidator subtypeValidator = mock(PolymorphicTypeValidator.class);
        Collection<NamedType> subtypes = Collections.emptyList();
        // Act
        TypeIdResolver result = xmlTypeResolverBuilder.idResolver(config, baseType, subtypeValidator, subtypes, true, false);
        // Assert
        assertTrue(result instanceof ClassNameIdResolver);
    }

    @Test
    public void testIdResolver_MinimalClassType() {
        // Arrange
        setPrivateField(xmlTypeResolverBuilder, "_idType", JsonTypeInfo.Id.MINIMAL_CLASS);
        MapperConfig<?> config = mock(MapperConfig.class);
        JavaType baseType = mock(JavaType.class);
        PolymorphicTypeValidator subtypeValidator = mock(PolymorphicTypeValidator.class);
        Collection<NamedType> subtypes = Collections.emptyList();
        // Act
        TypeIdResolver result = xmlTypeResolverBuilder.idResolver(config, baseType, subtypeValidator, subtypes, true, false);
        // Assert
        assertTrue(result instanceof MinimalClassNameIdResolver);
    }

    @Test
    public void testIdResolver_Default() {
        // Arrange
        setPrivateField(xmlTypeResolverBuilder, "_idType", JsonTypeInfo.Id.NONE);
        MapperConfig<?> config = mock(MapperConfig.class);
        JavaType baseType = mock(JavaType.class);
        PolymorphicTypeValidator subtypeValidator = mock(PolymorphicTypeValidator.class);
        Collection<NamedType> subtypes = Collections.emptyList();
        // Act
        TypeIdResolver result = xmlTypeResolverBuilder.idResolver(config, baseType, subtypeValidator, subtypes, true, false);
        // Assert
        assertNotNull(result);
    }

    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
