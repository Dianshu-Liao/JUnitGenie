package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.databind.Module.SetupContext;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlBeanDeserializerModifier;
import com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerModifier;

class JacksonXmlModule_setupModule_0_0_Test {

    private JacksonXmlModule jacksonXmlModule;

    private SetupContext setupContext;

    @BeforeEach
    void setUp() {
        jacksonXmlModule = new JacksonXmlModule();
        setupContext = mock(SetupContext.class);
    }

    @Test
    void testSetupModuleWithDefaultTextElement() {
        // Arrange
        XmlMapper xmlMapper = mock(XmlMapper.class);
        when(setupContext.getOwner()).thenReturn(xmlMapper);
        jacksonXmlModule.setXMLTextElementName(FromXmlParser.DEFAULT_UNNAMED_TEXT_PROPERTY);
        // Act
        jacksonXmlModule.setupModule(setupContext);
        // Assert
        verify(setupContext).addBeanSerializerModifier(any(XmlBeanSerializerModifier.class));
        verify(setupContext).addBeanDeserializerModifier(any(XmlBeanDeserializerModifier.class));
        verify(setupContext).insertAnnotationIntrospector(any());
        verify(xmlMapper, never()).setXMLTextElementName(anyString());
    }

    @Test
    void testSetupModuleWithCustomTextElement() {
        // Arrange
        XmlMapper xmlMapper = mock(XmlMapper.class);
        when(setupContext.getOwner()).thenReturn(xmlMapper);
        jacksonXmlModule.setXMLTextElementName("customTextElement");
        // Act
        jacksonXmlModule.setupModule(setupContext);
        // Assert
        verify(setupContext).addBeanSerializerModifier(any(XmlBeanSerializerModifier.class));
        verify(setupContext).addBeanDeserializerModifier(any(XmlBeanDeserializerModifier.class));
        verify(setupContext).insertAnnotationIntrospector(any());
        verify(xmlMapper).setXMLTextElementName("customTextElement");
    }
}
