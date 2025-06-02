package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.dataformat.xml.XmlTypeResolverBuilder;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.MinimalClassNameIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.*;

class XmlTypeResolverBuilder_idResolver_1_0_Test {

    private XmlTypeResolverBuilder xmlTypeResolverBuilder;

    @BeforeEach
    void setUp() {
        xmlTypeResolverBuilder = new XmlTypeResolverBuilder();
    }

    @Test
    void testIdResolver_CustomIdResolver() throws Exception {
        // Arrange
        MapperConfig<?> mockConfig = mock(MapperConfig.class);
        JavaType mockBaseType = mock(JavaType.class);
        PolymorphicTypeValidator mockValidator = mock(PolymorphicTypeValidator.class);
        Collection<NamedType> subtypes = new ArrayList<>();
        boolean forSer = true;
        boolean forDeser = false;
        // Mock custom id resolver
        TypeIdResolver mockCustomIdResolver = mock(TypeIdResolver.class);
        setPrivateField(xmlTypeResolverBuilder, "_customIdResolver", mockCustomIdResolver);
        // Act
        TypeIdResolver result = invokeIdResolver(xmlTypeResolverBuilder, mockConfig, mockBaseType, mockValidator, subtypes, forSer, forDeser);
        // Assert
        assertNotNull(result);
        // Verify that the custom resolver was returned
        assertSame(mockCustomIdResolver, result);
    }

    @Test
    void testIdResolver_ClassType() throws Exception {
        // Arrange
        MapperConfig<?> mockConfig = mock(MapperConfig.class);
        JavaType mockBaseType = mock(JavaType.class);
        PolymorphicTypeValidator mockValidator = mock(PolymorphicTypeValidator.class);
        Collection<NamedType> subtypes = new ArrayList<>();
        boolean forSer = true;
        boolean forDeser = false;
        // Set _idType to CLASS
        setPrivateField(xmlTypeResolverBuilder, "_idType", "CLASS");
        // Act
        TypeIdResolver result = invokeIdResolver(xmlTypeResolverBuilder, mockConfig, mockBaseType, mockValidator, subtypes, forSer, forDeser);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof ClassNameIdResolver);
    }

    @Test
    void testIdResolver_MinimalClassType() throws Exception {
        // Arrange
        MapperConfig<?> mockConfig = mock(MapperConfig.class);
        JavaType mockBaseType = mock(JavaType.class);
        PolymorphicTypeValidator mockValidator = mock(PolymorphicTypeValidator.class);
        Collection<NamedType> subtypes = new ArrayList<>();
        boolean forSer = true;
        boolean forDeser = false;
        // Set _idType to MINIMAL_CLASS
        setPrivateField(xmlTypeResolverBuilder, "_idType", "MINIMAL_CLASS");
        // Act
        TypeIdResolver result = invokeIdResolver(xmlTypeResolverBuilder, mockConfig, mockBaseType, mockValidator, subtypes, forSer, forDeser);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof MinimalClassNameIdResolver);
    }

    private TypeIdResolver invokeIdResolver(XmlTypeResolverBuilder builder, MapperConfig<?> config, JavaType baseType, PolymorphicTypeValidator subtypeValidator, Collection<NamedType> subtypes, boolean forSer, boolean forDeser) throws Exception {
        Method method = XmlTypeResolverBuilder.class.getDeclaredMethod("idResolver", MapperConfig.class, JavaType.class, PolymorphicTypeValidator.class, Collection.class, boolean.class, boolean.class);
        method.setAccessible(true);
        return (TypeIdResolver) method.invoke(builder, config, baseType, subtypeValidator, subtypes, forSer, forDeser);
    }

    private void setPrivateField(Object object, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }
}
