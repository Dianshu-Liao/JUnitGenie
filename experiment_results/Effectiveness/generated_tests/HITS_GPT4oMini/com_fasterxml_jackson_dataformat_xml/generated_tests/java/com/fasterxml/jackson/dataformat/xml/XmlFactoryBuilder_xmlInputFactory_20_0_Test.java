package com.fasterxml.jackson.dataformat.xml;

import javax.xml.stream.XMLInputFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLOutputFactory;
import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class XmlFactoryBuilder_xmlInputFactory_20_0_Test {

    private XmlFactoryBuilder xmlFactoryBuilder;

    @BeforeEach
    public void setUp() {
        xmlFactoryBuilder = new XmlFactoryBuilder();
    }

    @Test
    public void testXmlInputFactory_SetAndGet() {
        // Arrange
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        // Act
        xmlFactoryBuilder.xmlInputFactory(xmlInputFactory);
        // Assert
        assertNotNull(xmlFactoryBuilder._xmlInputFactory, "XMLInputFactory should not be null");
        assertEquals(xmlInputFactory, xmlFactoryBuilder._xmlInputFactory, "XMLInputFactory should be the same as the one set");
    }

    @Test
    public void testXmlInputFactory_NullInput() {
        // Act
        xmlFactoryBuilder.xmlInputFactory(null);
        // Assert
        assertNotNull(xmlFactoryBuilder._xmlInputFactory, "XMLInputFactory should not be null after setting it to null");
    }
}
