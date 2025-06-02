package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlBeanDeserializerModifier;
import com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerModifier;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class JacksonXmlModule_setupModule_0_0_Test {

    private JacksonXmlModule jacksonXmlModule;

    private JacksonXmlModule.SetupContext context;

    private XmlMapper xmlMapper;

    @BeforeEach
    void setUp() {
        jacksonXmlModule = new JacksonXmlModule();
        context = Mockito.mock(JacksonXmlModule.SetupContext.class);
        xmlMapper = mock(XmlMapper.class);
        when(context.getOwner()).thenReturn(xmlMapper);
    }

    @Test
    void testSetupModule_withDefaultTextElementName() {
        // Arrange
        when(context.getOwner()).thenReturn(xmlMapper);
        // Act
        jacksonXmlModule.setupModule(context);
        // Assert
        verify(context).addBeanSerializerModifier(any(XmlBeanSerializerModifier.class));
        verify(context).addBeanDeserializerModifier(any(XmlBeanDeserializerModifier.class));
        verify(context).insertAnnotationIntrospector(any(AnnotationIntrospector.class));
        verify(xmlMapper, never()).setXMLTextElementName(anyString());
    }

    @Test
    void testSetupModule_withCustomTextElementName() {
        // Arrange
        String customTextElementName = "customTextElement";
        jacksonXmlModule.setXMLTextElementName(customTextElementName);
        // Act
        jacksonXmlModule.setupModule(context);
        // Assert
        verify(context).addBeanSerializerModifier(any(XmlBeanSerializerModifier.class));
        verify(context).addBeanDeserializerModifier(any(XmlBeanDeserializerModifier.class));
        verify(context).insertAnnotationIntrospector(any(AnnotationIntrospector.class));
        verify(xmlMapper).setXMLTextElementName(customTextElementName);
    }

    @Test
    void testSetupModule_withDefaultUseWrapper() {
        // Arrange
        jacksonXmlModule.setDefaultUseWrapper(true);
        // Act
        jacksonXmlModule.setupModule(context);
        // Assert
        verify(context).addBeanSerializerModifier(any(XmlBeanSerializerModifier.class));
        verify(context).addBeanDeserializerModifier(any(XmlBeanDeserializerModifier.class));
        verify(context).insertAnnotationIntrospector(any(AnnotationIntrospector.class));
    }
}
