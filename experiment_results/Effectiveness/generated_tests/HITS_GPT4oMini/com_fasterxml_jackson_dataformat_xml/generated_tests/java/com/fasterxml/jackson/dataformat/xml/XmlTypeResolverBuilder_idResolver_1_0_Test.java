package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.MinimalClassNameIdResolver;
import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.*;

public class XmlTypeResolverBuilder_idResolver_1_0_Test {

    private XmlTypeResolverBuilder xmlTypeResolverBuilder;

    private MapperConfig<?> mockConfig;

    private JavaType mockBaseType;

    private PolymorphicTypeValidator mockSubtypeValidator;

    private Collection<NamedType> mockSubtypes;

    private TypeIdResolver mockCustomIdResolver;

    @BeforeEach
    public void setUp() {
        xmlTypeResolverBuilder = new XmlTypeResolverBuilder();
        mockConfig = mock(MapperConfig.class);
        mockBaseType = mock(JavaType.class);
        mockSubtypeValidator = mock(PolymorphicTypeValidator.class);
        mockSubtypes = Arrays.asList(mock(NamedType.class));
        mockCustomIdResolver = mock(TypeIdResolver.class);
        // Assuming we can use reflection to set private fields.
        try {
            java.lang.reflect.Field customIdResolverField = XmlTypeResolverBuilder.class.getDeclaredField("_customIdResolver");
            customIdResolverField.setAccessible(true);
            customIdResolverField.set(xmlTypeResolverBuilder, mockCustomIdResolver);
            java.lang.reflect.Field idTypeField = XmlTypeResolverBuilder.class.getDeclaredField("_idType");
            idTypeField.setAccessible(true);
            // Set the idType to a mock representation as the actual enum is not available
            // Mocking the expected type
            idTypeField.set(xmlTypeResolverBuilder, "CLASS");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIdResolver_WithCustomIdResolver_ReturnsCustomIdResolver() {
        // Act
        TypeIdResolver result = xmlTypeResolverBuilder.idResolver(mockConfig, mockBaseType, mockSubtypeValidator, mockSubtypes, true, false);
        // Assert
        assertEquals(mockCustomIdResolver, result);
    }

    @Test
    public void testIdResolver_WithoutCustomIdResolver_ReturnsDefaultResolver() {
        // Arrange
        try {
            java.lang.reflect.Field customIdResolverField = XmlTypeResolverBuilder.class.getDeclaredField("_customIdResolver");
            customIdResolverField.setAccessible(true);
            customIdResolverField.set(xmlTypeResolverBuilder, null);
            java.lang.reflect.Field idTypeField = XmlTypeResolverBuilder.class.getDeclaredField("_idType");
            idTypeField.setAccessible(true);
            // Mocking the expected type
            idTypeField.set(xmlTypeResolverBuilder, "CLASS");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        // Act
        TypeIdResolver result = xmlTypeResolverBuilder.idResolver(mockConfig, mockBaseType, mockSubtypeValidator, mockSubtypes, true, false);
        // Assert
        assertTrue(result instanceof ClassNameIdResolver);
    }
}
