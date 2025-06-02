package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.dataformat.xml.util.AnnotationUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.*;

class XmlBeanDeserializerModifier_updateProperties_0_0_Test {

    private XmlBeanDeserializerModifier modifier;

    private DeserializationConfig mockConfig;

    private BeanDescription mockBeanDesc;

    @BeforeEach
    void setUp() {
        modifier = new XmlBeanDeserializerModifier("");
        mockConfig = mock(DeserializationConfig.class);
        mockBeanDesc = mock(BeanDescription.class);
    }

    @Test
    void testUpdateProperties_WithTextAnnotation() {
        List<BeanPropertyDefinition> properties = new ArrayList<>();
        AnnotatedMember mockMember = mock(AnnotatedMember.class);
        BeanPropertyDefinition mockProperty = mock(BeanPropertyDefinition.class);
        when(mockProperty.getPrimaryMember()).thenReturn(mockMember);
        when(mockProperty.getName()).thenReturn("originalName");
        when(mockProperty.withSimpleName(anyString())).thenReturn(mockProperty);
        properties.add(mockProperty);
        when(mockConfig.getAnnotationIntrospector()).thenReturn(mock(AnnotationIntrospector.class));
        when(AnnotationUtil.findIsTextAnnotation(any(), any(), any())).thenReturn(true);
        List<BeanPropertyDefinition> updatedProperties = modifier.updateProperties(mockConfig, mockBeanDesc, properties);
        assertEquals(1, updatedProperties.size());
        assertEquals("", updatedProperties.get(0).getName());
    }

    @Test
    void testUpdateProperties_WithWrapperName() {
        List<BeanPropertyDefinition> properties = new ArrayList<>();
        AnnotatedMember mockMember = mock(AnnotatedMember.class);
        BeanPropertyDefinition mockProperty = mock(BeanPropertyDefinition.class);
        when(mockProperty.getPrimaryMember()).thenReturn(mockMember);
        when(mockProperty.getName()).thenReturn("originalName");
        when(mockProperty.getWrapperName()).thenReturn(new PropertyName("wrapperName"));
        when(mockProperty.withSimpleName(anyString())).thenReturn(mockProperty);
        properties.add(mockProperty);
        when(mockConfig.getAnnotationIntrospector()).thenReturn(mock(AnnotationIntrospector.class));
        when(AnnotationUtil.findIsTextAnnotation(any(), any(), any())).thenReturn(null);
        List<BeanPropertyDefinition> updatedProperties = modifier.updateProperties(mockConfig, mockBeanDesc, properties);
        assertEquals(1, updatedProperties.size());
        assertEquals("wrapperName", updatedProperties.get(0).getName());
    }

    @Test
    void testUpdateProperties_NoChanges() {
        List<BeanPropertyDefinition> properties = new ArrayList<>();
        AnnotatedMember mockMember = mock(AnnotatedMember.class);
        BeanPropertyDefinition mockProperty = mock(BeanPropertyDefinition.class);
        when(mockProperty.getPrimaryMember()).thenReturn(mockMember);
        when(mockProperty.getName()).thenReturn("originalName");
        when(mockProperty.getWrapperName()).thenReturn(null);
        when(mockProperty.withSimpleName(anyString())).thenReturn(mockProperty);
        properties.add(mockProperty);
        when(mockConfig.getAnnotationIntrospector()).thenReturn(mock(AnnotationIntrospector.class));
        when(AnnotationUtil.findIsTextAnnotation(any(), any(), any())).thenReturn(null);
        List<BeanPropertyDefinition> updatedProperties = modifier.updateProperties(mockConfig, mockBeanDesc, properties);
        assertEquals(1, updatedProperties.size());
        assertEquals("originalName", updatedProperties.get(0).getName());
    }

    @Test
    void testUpdateProperties_WithNullPrimaryMember() {
        List<BeanPropertyDefinition> properties = new ArrayList<>();
        BeanPropertyDefinition mockProperty = mock(BeanPropertyDefinition.class);
        when(mockProperty.getPrimaryMember()).thenReturn(null);
        properties.add(mockProperty);
        List<BeanPropertyDefinition> updatedProperties = modifier.updateProperties(mockConfig, mockBeanDesc, properties);
        assertEquals(1, updatedProperties.size());
        assertSame(mockProperty, updatedProperties.get(0));
    }
}
