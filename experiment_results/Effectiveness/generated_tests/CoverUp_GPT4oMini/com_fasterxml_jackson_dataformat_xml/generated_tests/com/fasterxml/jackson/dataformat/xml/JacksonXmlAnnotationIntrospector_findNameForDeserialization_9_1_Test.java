package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.databind.PropertyName;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.annotation.Annotation;
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

class JacksonXmlAnnotationIntrospector_findNameForDeserialization_9_1_Test {

    private JacksonXmlAnnotationIntrospector introspector;

    @BeforeEach
    void setUp() {
        introspector = new JacksonXmlAnnotationIntrospector();
    }

    @Test
    void testFindNameForDeserialization_WithXmlPropertyAnnotation() throws Exception {
        Annotated annotated = Mockito.mock(Annotated.class);
        JacksonXmlProperty xmlProperty = Mockito.mock(JacksonXmlProperty.class);
        Mockito.when(xmlProperty.localName()).thenReturn("testName");
        Mockito.when(xmlProperty.namespace()).thenReturn("testNamespace");
        setPrivateField(introspector, "_findXmlName", PropertyName.construct("testName", "testNamespace"));
        PropertyName result = introspector.findNameForDeserialization(annotated);
        assertNotNull(result);
        assertEquals("testName", result.getSimpleName());
        assertEquals("testNamespace", result.getNamespace());
    }

    @Test
    void testFindNameForDeserialization_NoAnnotations() throws Exception {
        Annotated annotated = Mockito.mock(Annotated.class);
        setPrivateField(introspector, "_findXmlName", null);
        setPrivateField(introspector, "_hasOneOf", false);
        PropertyName result = introspector.findNameForDeserialization(annotated);
        assertNull(result);
    }

    @Test
    void testFindNameForDeserialization_WithAnnotationsToInferXmlProp() throws Exception {
        Annotated annotated = Mockito.mock(Annotated.class);
        setPrivateField(introspector, "_findXmlName", null);
        setPrivateField(introspector, "_hasOneOf", true);
        PropertyName result = introspector.findNameForDeserialization(annotated);
        assertEquals(PropertyName.USE_DEFAULT, result);
    }

    @Test
    void testFindNameForDeserialization_SuperMethodReturnsName() throws Exception {
        Annotated annotated = Mockito.mock(Annotated.class);
        setPrivateField(introspector, "_findXmlName", null);
        PropertyName superName = PropertyName.construct("superName");
        setPrivateField(introspector, "super.findNameForDeserialization", superName);
        PropertyName result = introspector.findNameForDeserialization(annotated);
        assertEquals("superName", result.getSimpleName());
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
