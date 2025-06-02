package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.*;
import com.fasterxml.jackson.dataformat.xml.util.AnnotationUtil;

public class XmlBeanDeserializerModifier_updateProperties_0_0_Test {

    private XmlBeanDeserializerModifier modifier;

    private DeserializationConfig config;

    private BeanDescription beanDesc;

    private List<BeanPropertyDefinition> propDefs;

    @BeforeEach
    public void setUp() {
        modifier = new XmlBeanDeserializerModifier("");
        config = mock(DeserializationConfig.class);
        beanDesc = mock(BeanDescription.class);
        propDefs = new ArrayList<>();
    }

    @Test
    public void testUpdateProperties_WithTextAnnotation() {
        AnnotatedMember annotatedMember = mock(AnnotatedMember.class);
        BeanPropertyDefinition prop = mock(BeanPropertyDefinition.class);
        when(prop.getPrimaryMember()).thenReturn(annotatedMember);
        when(prop.getName()).thenReturn("originalName");
        when(prop.withSimpleName("")).thenReturn(prop);
        when(prop.getWrapperName()).thenReturn(PropertyName.NO_NAME);
        when(config.getAnnotationIntrospector()).thenReturn(mock(AnnotationIntrospector.class));
        when(AnnotationUtil.findIsTextAnnotation(config, config.getAnnotationIntrospector(), annotatedMember)).thenReturn(true);
        propDefs.add(prop);
        List<BeanPropertyDefinition> result = modifier.updateProperties(config, beanDesc, propDefs);
        assertEquals(1, result.size());
        assertEquals("", result.get(0).getName());
    }

    @Test
    public void testUpdateProperties_WithWrapperName() {
        AnnotatedMember annotatedMember = mock(AnnotatedMember.class);
        BeanPropertyDefinition prop = mock(BeanPropertyDefinition.class);
        when(prop.getPrimaryMember()).thenReturn(annotatedMember);
        when(prop.getName()).thenReturn("originalName");
        when(prop.withSimpleName("wrapperName")).thenReturn(prop);
        when(prop.getWrapperName()).thenReturn(new PropertyName("wrapperName"));
        propDefs.add(prop);
        List<BeanPropertyDefinition> result = modifier.updateProperties(config, beanDesc, propDefs);
        assertEquals(1, result.size());
        assertEquals("wrapperName", result.get(0).getName());
    }

    @Test
    public void testUpdateProperties_NoChanges() {
        AnnotatedMember annotatedMember = mock(AnnotatedMember.class);
        BeanPropertyDefinition prop = mock(BeanPropertyDefinition.class);
        when(prop.getPrimaryMember()).thenReturn(annotatedMember);
        when(prop.getName()).thenReturn("originalName");
        when(prop.withSimpleName("originalName")).thenReturn(prop);
        when(prop.getWrapperName()).thenReturn(PropertyName.NO_NAME);
        propDefs.add(prop);
        List<BeanPropertyDefinition> result = modifier.updateProperties(config, beanDesc, propDefs);
        assertEquals(1, result.size());
        assertEquals("originalName", result.get(0).getName());
    }

    @Test
    public void testUpdateProperties_WithMultipleProperties() {
        AnnotatedMember annotatedMember1 = mock(AnnotatedMember.class);
        BeanPropertyDefinition prop1 = mock(BeanPropertyDefinition.class);
        when(prop1.getPrimaryMember()).thenReturn(annotatedMember1);
        when(prop1.getName()).thenReturn("prop1");
        when(prop1.withSimpleName("")).thenReturn(prop1);
        when(prop1.getWrapperName()).thenReturn(PropertyName.NO_NAME);
        AnnotatedMember annotatedMember2 = mock(AnnotatedMember.class);
        BeanPropertyDefinition prop2 = mock(BeanPropertyDefinition.class);
        when(prop2.getPrimaryMember()).thenReturn(annotatedMember2);
        when(prop2.getName()).thenReturn("prop2");
        when(prop2.withSimpleName("wrapperName")).thenReturn(prop2);
        when(prop2.getWrapperName()).thenReturn(new PropertyName("wrapperName"));
        propDefs.add(prop1);
        propDefs.add(prop2);
        List<BeanPropertyDefinition> result = modifier.updateProperties(config, beanDesc, propDefs);
        assertEquals(2, result.size());
        assertEquals("", result.get(0).getName());
        assertEquals("wrapperName", result.get(1).getName());
    }
}
