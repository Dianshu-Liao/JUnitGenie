package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.databind.PropertyName;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.annotation.Annotation;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

class JacksonXmlAnnotationIntrospector_findNameForSerialization_8_0_Test {

    private JacksonXmlAnnotationIntrospector introspector;

    private Annotated annotatedMock;

    @BeforeEach
    void setUp() {
        introspector = new JacksonXmlAnnotationIntrospector();
        annotatedMock = mock(Annotated.class);
    }

    @Test
    void testFindNameForSerialization_NullPropertyName() throws Exception {
        // Arrange
        Method method = JacksonXmlAnnotationIntrospector.class.getDeclaredMethod("_findXmlName", Annotated.class);
        method.setAccessible(true);
        when(method.invoke(introspector, annotatedMock)).thenReturn(null);
        // Act
        PropertyName result = introspector.findNameForSerialization(annotatedMock);
        // Assert
        assertEquals(PropertyName.USE_DEFAULT, result);
    }

    @Test
    void testFindNameForSerialization_WithPropertyName() throws Exception {
        // Arrange
        PropertyName expectedPropertyName = new PropertyName("expectedName");
        Method method = JacksonXmlAnnotationIntrospector.class.getDeclaredMethod("_findXmlName", Annotated.class);
        method.setAccessible(true);
        when(method.invoke(introspector, annotatedMock)).thenReturn(expectedPropertyName);
        // Act
        PropertyName result = introspector.findNameForSerialization(annotatedMock);
        // Assert
        assertEquals(expectedPropertyName, result);
    }

    @Test
    void testFindNameForSerialization_WithDefaultUseWrapper() throws Exception {
        // Arrange
        PropertyName expectedPropertyName = new PropertyName("someName");
        Method method = JacksonXmlAnnotationIntrospector.class.getDeclaredMethod("_findXmlName", Annotated.class);
        method.setAccessible(true);
        when(method.invoke(introspector, annotatedMock)).thenReturn(expectedPropertyName);
        // Act
        PropertyName result = introspector.findNameForSerialization(annotatedMock);
        // Assert
        assertNotNull(result);
        assertEquals("someName", result.getSimpleName());
    }

    @Test
    void testFindNameForSerialization_UsesDefaultWhenNoAnnotations() throws Exception {
        // Arrange
        Method method = JacksonXmlAnnotationIntrospector.class.getDeclaredMethod("_findXmlName", Annotated.class);
        method.setAccessible(true);
        when(method.invoke(introspector, annotatedMock)).thenReturn(null);
        when(introspector.findNameForSerialization(annotatedMock)).thenReturn(null);
        // Fixed Line: Use reflection to access the protected method
        Method hasOneOfMethod = JacksonXmlAnnotationIntrospector.class.getDeclaredMethod("_hasOneOf", Annotated.class, Class[].class);
        hasOneOfMethod.setAccessible(true);
        // Repaired Line: Use the correct method to access the private constant
        Class<?> annotationsToInferXmlPropClass = JacksonXmlAnnotationIntrospector.class;
        // <Repaired Line>: Correctly access the field ANNOTATIONS_TO_INFER_XML_PROP
        Field annotationsToInferXmlPropField = annotationsToInferXmlPropClass.getDeclaredField("ANNOTATIONS_TO_INFER_XML_PROP");
        annotationsToInferXmlPropField.setAccessible(true);
        Class<?>[] annotationsToInferXmlProp = (Class<?>[]) annotationsToInferXmlPropField.get(null);
        when(hasOneOfMethod.invoke(introspector, annotatedMock, annotationsToInferXmlProp)).thenReturn(false);
        // Act
        PropertyName result = introspector.findNameForSerialization(annotatedMock);
        // Assert
        assertEquals(PropertyName.USE_DEFAULT, result);
    }
}
