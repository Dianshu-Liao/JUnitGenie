package com.fasterxml.jackson.dataformat.xml;

import javax.xml.stream.XMLOutputFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLInputFactory;
import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

class XmlFactoryBuilder_xmlOutputFactory_21_0_Test {

    @Test
    void testXmlOutputFactory() throws Exception {
        // Arrange
        XmlFactoryBuilder xmlFactoryBuilder = new XmlFactoryBuilder();
        XMLOutputFactory mockOutputFactory = XMLOutputFactory.newInstance();
        // Act
        XmlFactoryBuilder result = xmlFactoryBuilder.xmlOutputFactory(mockOutputFactory);
        // Access private field _xmlOutputFactory using reflection
        java.lang.reflect.Field field = XmlFactoryBuilder.class.getDeclaredField("_xmlOutputFactory");
        field.setAccessible(true);
        XMLOutputFactory outputFactoryFieldValue = (XMLOutputFactory) field.get(xmlFactoryBuilder);
        // Assert
        assertEquals(mockOutputFactory, outputFactoryFieldValue);
        // Ensure method returns the same instance
        assertSame(xmlFactoryBuilder, result);
    }
}
