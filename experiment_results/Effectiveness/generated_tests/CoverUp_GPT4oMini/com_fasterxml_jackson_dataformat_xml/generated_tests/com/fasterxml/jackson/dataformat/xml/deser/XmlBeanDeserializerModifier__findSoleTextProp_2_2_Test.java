package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.dataformat.xml.util.AnnotationUtil;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.*;

class XmlBeanDeserializerModifier__findSoleTextProp_2_2_Test {

    private XmlBeanDeserializerModifier modifier;

    private DeserializationConfig mockConfig;

    private Iterator<SettableBeanProperty> mockPropIt;

    private SettableBeanProperty mockProperty;

    private AnnotatedMember mockMember;

    @BeforeEach
    void setUp() {
        modifier = new XmlBeanDeserializerModifier("textValue");
        mockConfig = mock(DeserializationConfig.class);
        mockProperty = mock(SettableBeanProperty.class);
        mockMember = mock(AnnotatedMember.class);
    }

    @Test
    void testFindSoleTextProp_FoundTextProperty() throws Exception {
        when(mockConfig.getAnnotationIntrospector()).thenReturn(mock(AnnotationIntrospector.class));
        when(mockProperty.getMember()).thenReturn(mockMember);
        when(mockProperty.getFullName()).thenReturn(PropertyName.construct("textValue"));
        mockPropIt = Mockito.mock(Iterator.class);
        when(mockPropIt.hasNext()).thenReturn(true, false);
        when(mockPropIt.next()).thenReturn(mockProperty);
        SettableBeanProperty result = invokeFindSoleTextProp(modifier, mockConfig, mockPropIt);
        assertEquals(mockProperty, result);
    }

    @Test
    void testFindSoleTextProp_NoTextProperty() throws Exception {
        when(mockConfig.getAnnotationIntrospector()).thenReturn(mock(AnnotationIntrospector.class));
        when(mockProperty.getMember()).thenReturn(mockMember);
        when(mockProperty.getFullName()).thenReturn(PropertyName.construct("otherValue"));
        mockPropIt = Mockito.mock(Iterator.class);
        when(mockPropIt.hasNext()).thenReturn(true, false);
        when(mockPropIt.next()).thenReturn(mockProperty);
        SettableBeanProperty result = invokeFindSoleTextProp(modifier, mockConfig, mockPropIt);
        assertNull(result);
    }

    @Test
    void testFindSoleTextProp_AttributeAnnotation() throws Exception {
        when(mockConfig.getAnnotationIntrospector()).thenReturn(mock(AnnotationIntrospector.class));
        when(mockProperty.getMember()).thenReturn(mockMember);
        when(mockProperty.getFullName()).thenReturn(PropertyName.construct("textValue"));
        when(AnnotationUtil.findIsAttributeAnnotation(mockConfig, mockConfig.getAnnotationIntrospector(), mockMember)).thenReturn(true);
        mockPropIt = Mockito.mock(Iterator.class);
        when(mockPropIt.hasNext()).thenReturn(true, false);
        when(mockPropIt.next()).thenReturn(mockProperty);
        SettableBeanProperty result = invokeFindSoleTextProp(modifier, mockConfig, mockPropIt);
        assertNull(result);
    }

    private SettableBeanProperty invokeFindSoleTextProp(XmlBeanDeserializerModifier modifier, DeserializationConfig config, Iterator<SettableBeanProperty> propIt) throws Exception {
        Method method = XmlBeanDeserializerModifier.class.getDeclaredMethod("_findSoleTextProp", DeserializationConfig.class, Iterator.class);
        method.setAccessible(true);
        return (SettableBeanProperty) method.invoke(modifier, config, propIt);
    }
}
