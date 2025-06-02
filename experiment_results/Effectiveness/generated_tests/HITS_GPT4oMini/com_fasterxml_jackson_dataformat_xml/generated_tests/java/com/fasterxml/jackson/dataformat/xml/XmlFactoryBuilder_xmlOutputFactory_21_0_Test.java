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

public class XmlFactoryBuilder_xmlOutputFactory_21_0_Test {

    private XmlFactoryBuilder xmlFactoryBuilder;

    @BeforeEach
    public void setUp() {
        xmlFactoryBuilder = new XmlFactoryBuilder();
    }

    @Test
    public void testXmlOutputFactory_SetAndGet() {
        // Arrange
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        // Act
        xmlFactoryBuilder.xmlOutputFactory(outputFactory);
        XmlFactory xmlFactory = new XmlFactory(null, null, outputFactory);
        // Assert
        assertNotNull(xmlFactory.getXMLOutputFactory(), "XMLOutputFactory should not be null");
        assertEquals(outputFactory, xmlFactory.getXMLOutputFactory(), "The output factory should match the one set");
    }

    @Test
    public void testXmlOutputFactory_NullInput() {
        // Act
        xmlFactoryBuilder.xmlOutputFactory(null);
        XmlFactory xmlFactory = new XmlFactory(null, null, null);
        // Assert
        assertNotNull(xmlFactory.getXMLOutputFactory(), "XMLOutputFactory should not be null after setting null");
    }
}
