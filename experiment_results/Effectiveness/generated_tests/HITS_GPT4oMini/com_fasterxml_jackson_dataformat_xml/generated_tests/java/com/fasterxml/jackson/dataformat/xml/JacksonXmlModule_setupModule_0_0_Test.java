package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlBeanDeserializerModifier;
import com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerModifier;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class JacksonXmlModule_setupModule_0_0_Test {

    private JacksonXmlModule jacksonXmlModule;

    @Mock
    private Module.SetupContext setupContext;

    private XmlMapper xmlMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        jacksonXmlModule = new JacksonXmlModule();
        xmlMapper = new XmlMapper();
        when(setupContext.getOwner()).thenReturn(xmlMapper);
    }

    @Test
    public void testSetupModule_AddsBeanSerializerModifier() {
        // Act
        jacksonXmlModule.setupModule(setupContext);
        // Assert
        verify(setupContext).addBeanSerializerModifier(any(XmlBeanSerializerModifier.class));
    }

    @Test
    public void testSetupModule_AddsBeanDeserializerModifier() {
        // Act
        jacksonXmlModule.setupModule(setupContext);
        // Assert
        verify(setupContext).addBeanDeserializerModifier(any(XmlBeanDeserializerModifier.class));
    }

    @Test
    public void testSetupModule_InsertsAnnotationIntrospector() {
        // Act
        jacksonXmlModule.setupModule(setupContext);
        // Assert
        verify(setupContext).insertAnnotationIntrospector(any(AnnotationIntrospector.class));
    }

    @Test
    public void testSetupModule_SetsXmlTextElementName_WhenNotDefault() {
        // Arrange
        String customName = "customTextElement";
        jacksonXmlModule.setXMLTextElementName(customName);
        // Act
        jacksonXmlModule.setupModule(setupContext);
        // Assert
        assertEquals(customName, xmlMapper.getFactory().getXMLTextElementName());
    }

    @Test
    public void testSetupModule_DoesNotSetXmlTextElementName_WhenDefault() {
        // Arrange
        jacksonXmlModule.setXMLTextElementName(FromXmlParser.DEFAULT_UNNAMED_TEXT_PROPERTY);
        // Act
        jacksonXmlModule.setupModule(setupContext);
        // Assert
        assertNotEquals("customTextElement", xmlMapper.getFactory().getXMLTextElementName());
    }
}
