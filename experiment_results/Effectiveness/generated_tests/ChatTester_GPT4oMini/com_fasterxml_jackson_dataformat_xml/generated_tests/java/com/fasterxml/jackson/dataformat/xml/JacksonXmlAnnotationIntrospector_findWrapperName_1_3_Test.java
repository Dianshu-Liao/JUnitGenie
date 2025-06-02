package com.fasterxml.jackson.dataformat.xml;

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
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.*;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.dataformat.xml.annotation.*;

public class JacksonXmlAnnotationIntrospector_findWrapperName_1_3_Test {

    private JacksonXmlAnnotationIntrospector introspector;

    @BeforeEach
    public void setUp() {
        introspector = new JacksonXmlAnnotationIntrospector();
    }

    @Test
    public void testFindWrapperName_WithWrapperAnnotation_UseWrappingFalse() {
        Annotated annotated = mock(Annotated.class);
        JacksonXmlElementWrapper wrapper = mock(JacksonXmlElementWrapper.class);
        when(wrapper.useWrapping()).thenReturn(false);
        // Using reflection to set the private method _findAnnotation
        setPrivateField(introspector, "_findAnnotation", wrapper);
        PropertyName result = introspector.findWrapperName(annotated);
        assertEquals(PropertyName.NO_NAME, result);
    }

    @Test
    public void testFindWrapperName_WithWrapperAnnotation_EmptyLocalName() {
        Annotated annotated = mock(Annotated.class);
        JacksonXmlElementWrapper wrapper = mock(JacksonXmlElementWrapper.class);
        when(wrapper.useWrapping()).thenReturn(true);
        when(wrapper.localName()).thenReturn("");
        when(wrapper.namespace()).thenReturn("testNamespace");
        // Using reflection to set the private method _findAnnotation
        setPrivateField(introspector, "_findAnnotation", wrapper);
        PropertyName result = introspector.findWrapperName(annotated);
        assertEquals(PropertyName.USE_DEFAULT, result);
    }

    @Test
    public void testFindWrapperName_WithWrapperAnnotation_ValidLocalName() {
        Annotated annotated = mock(Annotated.class);
        JacksonXmlElementWrapper wrapper = mock(JacksonXmlElementWrapper.class);
        when(wrapper.useWrapping()).thenReturn(true);
        when(wrapper.localName()).thenReturn("testName");
        when(wrapper.namespace()).thenReturn("testNamespace");
        // Using reflection to set the private method _findAnnotation
        setPrivateField(introspector, "_findAnnotation", wrapper);
        PropertyName result = introspector.findWrapperName(annotated);
        assertEquals(PropertyName.construct("testName", "testNamespace"), result);
    }

    @Test
    public void testFindWrapperName_NoWrapperAnnotation_UseDefaultWrapper() {
        Annotated annotated = mock(Annotated.class);
        // No wrapper annotation set
        PropertyName result = introspector.findWrapperName(annotated);
        assertEquals(PropertyName.USE_DEFAULT, result);
    }

    @Test
    public void testFindWrapperName_NoWrapperAnnotation_NoDefaultWrapper() {
        introspector = new JacksonXmlAnnotationIntrospector(false);
        Annotated annotated = mock(Annotated.class);
        // No wrapper annotation set
        PropertyName result = introspector.findWrapperName(annotated);
        assertNull(result);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
