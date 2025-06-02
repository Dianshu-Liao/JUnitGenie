package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.dataformat.xml.util.AnnotationUtil;
import com.fasterxml.jackson.dataformat.xml.util.TypeUtil;
import com.fasterxml.jackson.dataformat.xml.util.XmlInfo;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.*;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;

public class XmlBeanSerializerModifier_changeProperties_0_0_Test {

    private XmlBeanSerializerModifier modifier;

    private SerializationConfig mockConfig;

    private BeanDescription mockBeanDescription;

    private List<BeanPropertyWriter> beanPropertyWriters;

    @BeforeEach
    public void setUp() {
        modifier = new XmlBeanSerializerModifier();
        mockConfig = mock(SerializationConfig.class);
        mockBeanDescription = mock(BeanDescription.class);
        beanPropertyWriters = new ArrayList<>();
    }

    @Test
    public void testChangeProperties_WithAttributeAnnotation() throws Exception {
        // Arrange
        BeanPropertyWriter mockWriter = mock(BeanPropertyWriter.class);
        AnnotatedMember mockMember = mock(AnnotatedMember.class);
        when(mockWriter.getMember()).thenReturn(mockMember);
        when(mockWriter.getType()).thenReturn(mock(JavaType.class));
        when(mockWriter.getName()).thenReturn("propertyName");
        when(mockWriter.getWrapperName()).thenReturn(PropertyName.construct("wrapperName"));
        // Mock AnnotationUtil methods
        when(mockConfig.getAnnotationIntrospector()).thenReturn(mock(AnnotationIntrospector.class));
        when(AnnotationUtil.findNamespaceAnnotation(any(), any(), any())).thenReturn("namespace");
        when(AnnotationUtil.findIsAttributeAnnotation(any(), any(), any())).thenReturn(true);
        when(AnnotationUtil.findIsTextAnnotation(any(), any(), any())).thenReturn(false);
        when(AnnotationUtil.findIsCDataAnnotation(any(), any(), any())).thenReturn(false);
        beanPropertyWriters.add(mockWriter);
        // Act
        List<BeanPropertyWriter> result = modifier.changeProperties(mockConfig, mockBeanDescription, beanPropertyWriters);
        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("propertyName", result.get(0).getName());
        // Verify internal setting
        Field field = XmlBeanPropertyWriter.class.getDeclaredField("xmlInfo");
        field.setAccessible(true);
        XmlInfo xmlInfo = (XmlInfo) field.get(result.get(0));
        assertTrue(xmlInfo.isAttribute());
        assertEquals("namespace", xmlInfo.getNamespace());
    }

    @Test
    public void testChangeProperties_NoWrapperName() throws Exception {
        // Arrange
        BeanPropertyWriter mockWriter = mock(BeanPropertyWriter.class);
        AnnotatedMember mockMember = mock(AnnotatedMember.class);
        when(mockWriter.getMember()).thenReturn(mockMember);
        when(mockWriter.getType()).thenReturn(mock(JavaType.class));
        when(mockWriter.getName()).thenReturn("propertyName");
        when(mockWriter.getWrapperName()).thenReturn(PropertyName.NO_NAME);
        beanPropertyWriters.add(mockWriter);
        // Act
        List<BeanPropertyWriter> result = modifier.changeProperties(mockConfig, mockBeanDescription, beanPropertyWriters);
        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("propertyName", result.get(0).getName());
    }

    @Test
    public void testChangeProperties_NonIndexedType() throws Exception {
        // Arrange
        BeanPropertyWriter mockWriter = mock(BeanPropertyWriter.class);
        AnnotatedMember mockMember = mock(AnnotatedMember.class);
        when(mockWriter.getMember()).thenReturn(mockMember);
        when(mockWriter.getType()).thenReturn(mock(JavaType.class));
        when(mockWriter.getName()).thenReturn("propertyName");
        when(mockWriter.getWrapperName()).thenReturn(PropertyName.construct("wrapperName"));
        // Mock isIndexedType to return false
        when(TypeUtil.isIndexedType(any())).thenReturn(false);
        beanPropertyWriters.add(mockWriter);
        // Act
        List<BeanPropertyWriter> result = modifier.changeProperties(mockConfig, mockBeanDescription, beanPropertyWriters);
        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("propertyName", result.get(0).getName());
    }
}
