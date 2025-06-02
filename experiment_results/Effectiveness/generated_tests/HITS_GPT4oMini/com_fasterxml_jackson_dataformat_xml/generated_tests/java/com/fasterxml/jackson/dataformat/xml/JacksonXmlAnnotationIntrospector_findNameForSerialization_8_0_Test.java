package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.databind.PropertyName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.annotation.Annotation;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class JacksonXmlAnnotationIntrospector_findNameForSerialization_8_0_Test {

    private JacksonXmlAnnotationIntrospector introspector;

    @BeforeEach
    public void setUp() {
        introspector = new JacksonXmlAnnotationIntrospector();
    }

    @Test
    public void testFindNameForSerialization_WithXmlPropertyAnnotation() {
        // Given
        Annotated annotated = mock(Annotated.class);
        JacksonXmlProperty xmlProperty = mock(JacksonXmlProperty.class);
        when(xmlProperty.localName()).thenReturn("customName");
        when(xmlProperty.namespace()).thenReturn("customNamespace");
        when(introspector._findXmlName(annotated)).thenReturn(PropertyName.construct("customName", "customNamespace"));
        // When
        PropertyName result = introspector.findNameForSerialization(annotated);
        // Then
        assertEquals(PropertyName.construct("customName", "customNamespace"), result);
    }

    @Test
    public void testFindNameForSerialization_WithAnnotationsToInferXmlProp() {
        // Given
        Annotated annotated = mock(Annotated.class);
        introspector = new JacksonXmlAnnotationIntrospector() {

            @Override
            protected boolean _hasOneOf(Annotated a, Class<? extends Annotation>[] classes) {
                // Mocking the behavior to return true
                return true;
            }
        };
        // When
        PropertyName result = introspector.findNameForSerialization(annotated);
        // Then
        assertEquals(PropertyName.USE_DEFAULT, result);
    }

    @Test
    public void testFindNameForSerialization_NoAnnotationsPresent() {
        // Given
        Annotated annotated = mock(Annotated.class);
        when(introspector._findXmlName(annotated)).thenReturn(null);
        when(introspector.findNameForSerialization(annotated)).thenReturn(null);
        // When
        PropertyName result = introspector.findNameForSerialization(annotated);
        // Then
        assertNull(result);
    }

    @Test
    public void testFindNameForSerialization_WithSuperClassName() {
        // Given
        Annotated annotated = mock(Annotated.class);
        when(introspector._findXmlName(annotated)).thenReturn(null);
        when(introspector.findNameForSerialization(annotated)).thenReturn(PropertyName.construct("superClassName"));
        // When
        PropertyName result = introspector.findNameForSerialization(annotated);
        // Then
        assertEquals(PropertyName.construct("superClassName"), result);
    }
}
