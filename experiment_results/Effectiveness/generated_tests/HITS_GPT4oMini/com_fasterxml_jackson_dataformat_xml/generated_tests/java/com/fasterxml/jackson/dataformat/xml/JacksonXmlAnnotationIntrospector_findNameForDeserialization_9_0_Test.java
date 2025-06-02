package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.databind.PropertyName;
import java.lang.annotation.Annotation;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

public class JacksonXmlAnnotationIntrospector_findNameForDeserialization_9_0_Test {

    private JacksonXmlAnnotationIntrospector introspector;

    @BeforeEach
    public void setUp() {
        introspector = new JacksonXmlAnnotationIntrospector();
    }

    @Test
    public void testFindNameForDeserialization_WithXmlName() {
        // Arrange
        Annotated annotatedMock = mock(Annotated.class);
        JacksonXmlProperty xmlProperty = mock(JacksonXmlProperty.class);
        when(xmlProperty.localName()).thenReturn("xmlName");
        when(xmlProperty.namespace()).thenReturn("namespace");
        when(introspector._findXmlName(annotatedMock)).thenReturn(PropertyName.construct("xmlName", "namespace"));
        // Act
        PropertyName result = introspector.findNameForDeserialization(annotatedMock);
        // Assert
        assertEquals("xmlName", result.getSimpleName());
        assertEquals("namespace", result.getNamespace());
    }

    @Test
    public void testFindNameForDeserialization_WithDefaultName() {
        // Arrange
        Annotated annotatedMock = mock(Annotated.class);
        when(introspector._findXmlName(annotatedMock)).thenReturn(null);
        // Act
        PropertyName result = introspector.findNameForDeserialization(annotatedMock);
        // Assert
        assertEquals("", result.getSimpleName());
        assertEquals("", result.getNamespace());
    }

    @Test
    public void testFindNameForDeserialization_WithXmlNameAndNullDefault() {
        // Arrange
        Annotated annotatedMock = mock(Annotated.class);
        when(introspector._findXmlName(annotatedMock)).thenReturn(PropertyName.construct("xmlName", "namespace"));
        // Act
        PropertyName result = introspector.findNameForDeserialization(annotatedMock);
        // Assert
        assertEquals("xmlName", result.getSimpleName());
        assertEquals("namespace", result.getNamespace());
    }

    @Test
    public void testFindNameForDeserialization_WithNoAnnotations() {
        // Arrange
        Annotated annotatedMock = mock(Annotated.class);
        when(introspector._findXmlName(annotatedMock)).thenReturn(null);
        // Act
        PropertyName result = introspector.findNameForDeserialization(annotatedMock);
        // Assert
        assertEquals("", result.getSimpleName());
        assertEquals("", result.getNamespace());
    }
}
