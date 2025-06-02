package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.dataformat.xml.util.AnnotationUtil;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.*;

class XmlBeanDeserializerModifier__findSoleTextProp_2_0_Test {

    private XmlBeanDeserializerModifier modifier;

    private DeserializationConfig config;

    private Iterator<SettableBeanProperty> propIt;

    @BeforeEach
    void setUp() {
        // Assuming a constructor that takes String
        modifier = new XmlBeanDeserializerModifier("textValue");
        config = mock(DeserializationConfig.class);
    }

    @Test
    void testFindSoleTextProp_WithMatchingProperty() throws Exception {
        // Arrange
        SettableBeanProperty matchingProp = mock(SettableBeanProperty.class);
        AnnotatedMember member = mock(AnnotatedMember.class);
        when(matchingProp.getMember()).thenReturn(member);
        when(matchingProp.getFullName()).thenReturn(new PropertyName("textValue"));
        List<SettableBeanProperty> properties = new ArrayList<>();
        properties.add(matchingProp);
        propIt = properties.iterator();
        when(config.getAnnotationIntrospector()).thenReturn(mock(AnnotationIntrospector.class));
        // Act
        Method method = XmlBeanDeserializerModifier.class.getDeclaredMethod("_findSoleTextProp", DeserializationConfig.class, Iterator.class);
        method.setAccessible(true);
        SettableBeanProperty result = (SettableBeanProperty) method.invoke(modifier, config, propIt);
        // Assert
        assertNotNull(result);
        assertEquals(matchingProp, result);
    }

    @Test
    void testFindSoleTextProp_WithNonMatchingProperty() throws Exception {
        // Arrange
        SettableBeanProperty nonMatchingProp = mock(SettableBeanProperty.class);
        AnnotatedMember member = mock(AnnotatedMember.class);
        when(nonMatchingProp.getMember()).thenReturn(member);
        when(nonMatchingProp.getFullName()).thenReturn(new PropertyName("otherValue"));
        List<SettableBeanProperty> properties = new ArrayList<>();
        properties.add(nonMatchingProp);
        propIt = properties.iterator();
        when(config.getAnnotationIntrospector()).thenReturn(mock(AnnotationIntrospector.class));
        // Act
        Method method = XmlBeanDeserializerModifier.class.getDeclaredMethod("_findSoleTextProp", DeserializationConfig.class, Iterator.class);
        method.setAccessible(true);
        SettableBeanProperty result = (SettableBeanProperty) method.invoke(modifier, config, propIt);
        // Assert
        assertNull(result);
    }

    @Test
    void testFindSoleTextProp_WithAttributeAnnotation() throws Exception {
        // Arrange
        SettableBeanProperty attributeProp = mock(SettableBeanProperty.class);
        AnnotatedMember member = mock(AnnotatedMember.class);
        when(attributeProp.getMember()).thenReturn(member);
        when(attributeProp.getFullName()).thenReturn(new PropertyName("textValue"));
        List<SettableBeanProperty> properties = new ArrayList<>();
        properties.add(attributeProp);
        propIt = properties.iterator();
        AnnotationIntrospector ai = mock(AnnotationIntrospector.class);
        when(config.getAnnotationIntrospector()).thenReturn(ai);
    }
}
