package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.dataformat.xml.util.AnnotationUtil;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
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
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;

public class XmlBeanDeserializerModifier__findSoleTextProp_2_1_Test {

    private XmlBeanDeserializerModifier modifier;

    private DeserializationConfig mockConfig;

    @BeforeEach
    public void setUp() {
        // Providing a String argument
        modifier = new XmlBeanDeserializerModifier("");
        mockConfig = mock(DeserializationConfig.class);
    }

    private SettableBeanProperty invokeFindSoleTextProp(DeserializationConfig config, Iterator<SettableBeanProperty> propIt) throws Exception {
        Method method = XmlBeanDeserializerModifier.class.getDeclaredMethod("_findSoleTextProp", DeserializationConfig.class, Iterator.class);
        method.setAccessible(true);
        return (SettableBeanProperty) method.invoke(modifier, config, propIt);
    }

    @Test
    public void testFindSoleTextProp_WithSingleMatchingProperty() throws Exception {
        SettableBeanProperty matchingProp = mock(SettableBeanProperty.class);
        when(matchingProp.getFullName()).thenReturn(PropertyName.construct("textValue"));
        when(matchingProp.getMember()).thenReturn(mock(AnnotatedMember.class));
        modifier._cfgNameForTextValue = "textValue";
        List<SettableBeanProperty> properties = Arrays.asList(matchingProp);
        Iterator<SettableBeanProperty> propIt = properties.iterator();
        SettableBeanProperty result = invokeFindSoleTextProp(mockConfig, propIt);
        assertEquals(matchingProp, result);
    }

    @Test
    public void testFindSoleTextProp_WithNoMatchingProperties() throws Exception {
        SettableBeanProperty nonMatchingProp = mock(SettableBeanProperty.class);
        when(nonMatchingProp.getFullName()).thenReturn(PropertyName.construct("otherValue"));
        when(nonMatchingProp.getMember()).thenReturn(mock(AnnotatedMember.class));
        List<SettableBeanProperty> properties = Arrays.asList(nonMatchingProp);
        Iterator<SettableBeanProperty> propIt = properties.iterator();
        SettableBeanProperty result = invokeFindSoleTextProp(mockConfig, propIt);
        assertNull(result);
    }

    @Test
    public void testFindSoleTextProp_WithMultipleProperties() throws Exception {
        SettableBeanProperty matchingProp = mock(SettableBeanProperty.class);
        when(matchingProp.getFullName()).thenReturn(PropertyName.construct("textValue"));
        when(matchingProp.getMember()).thenReturn(mock(AnnotatedMember.class));
        SettableBeanProperty otherProp = mock(SettableBeanProperty.class);
        when(otherProp.getFullName()).thenReturn(PropertyName.construct("anotherValue"));
        when(otherProp.getMember()).thenReturn(mock(AnnotatedMember.class));
        modifier._cfgNameForTextValue = "textValue";
        List<SettableBeanProperty> properties = Arrays.asList(matchingProp, otherProp);
        Iterator<SettableBeanProperty> propIt = properties.iterator();
        SettableBeanProperty result = invokeFindSoleTextProp(mockConfig, propIt);
        assertEquals(matchingProp, result);
    }
}
