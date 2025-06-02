package com.fasterxml.jackson.dataformat.xml.util;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import javax.xml.namespace.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.util.LRUMap;

@ExtendWith(MockitoExtension.class)
class XmlRootNameLookup__findRootName_3_0_Test {

    @Test
    void testFindRootNameWithCustomRootName() {
        // Arrange
        XmlRootNameLookup lookup = new XmlRootNameLookup();
        MapperConfig<?> mockConfig = mock(MapperConfig.class);
        Class<?> mockClass = TestClassWithRootName.class;
        AnnotationIntrospector mockIntrospector = mock(AnnotationIntrospector.class);
        BeanDescription mockBeanDescription = mock(BeanDescription.class);
        when(mockConfig.getAnnotationIntrospector()).thenReturn(mockIntrospector);
        when(mockConfig.introspectClassAnnotations(mockClass)).thenReturn(mockBeanDescription);
        when(mockIntrospector.findRootName(any())).thenReturn(new PropertyName("CustomRootName"));
        // Act
        QName result = lookup._findRootName(mockConfig, mockClass);
        // Assert
        assertEquals(new QName("", "CustomRootName"), result);
    }

    @Test
    void testFindRootNameWithDefaultName() {
        // Arrange
        XmlRootNameLookup lookup = new XmlRootNameLookup();
        MapperConfig<?> mockConfig = mock(MapperConfig.class);
        Class<?> mockClass = TestClassWithoutRootName.class;
        AnnotationIntrospector mockIntrospector = mock(AnnotationIntrospector.class);
        BeanDescription mockBeanDescription = mock(BeanDescription.class);
        when(mockConfig.getAnnotationIntrospector()).thenReturn(mockIntrospector);
        when(mockConfig.introspectClassAnnotations(mockClass)).thenReturn(mockBeanDescription);
        when(mockIntrospector.findRootName(any())).thenReturn(null);
        // Act
        QName result = lookup._findRootName(mockConfig, mockClass);
        // Assert
        assertEquals(new QName("", "TestClassWithoutRootName"), result);
    }

    // Sample classes for testing
    private static class TestClassWithRootName {
    }

    private static class TestClassWithoutRootName {
    }
}
