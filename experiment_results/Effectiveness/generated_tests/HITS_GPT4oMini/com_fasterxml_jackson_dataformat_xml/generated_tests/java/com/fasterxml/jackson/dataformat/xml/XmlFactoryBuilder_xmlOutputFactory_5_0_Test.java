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

public class XmlFactoryBuilder_xmlOutputFactory_5_0_Test {

    private XmlFactoryBuilder xmlFactoryBuilder;

    @BeforeEach
    public void setUp() {
        xmlFactoryBuilder = new XmlFactoryBuilder();
    }

    @Test
    public void testXmlOutputFactory_WhenOutputFactoryIsNull_ShouldReturnDefaultOutputFactory() {
        // Act
        XMLOutputFactory result = xmlFactoryBuilder.xmlOutputFactory();
        // Assert
        assertNotNull(result, "The default XMLOutputFactory should not be null.");
    }

    @Test
    public void testXmlOutputFactory_WhenOutputFactoryIsSet_ShouldReturnSetOutputFactory() {
        // Arrange
        XMLOutputFactory expectedOutputFactory = XMLOutputFactory.newInstance();
        xmlFactoryBuilder._xmlOutputFactory = expectedOutputFactory;
        // Act
        XMLOutputFactory result = xmlFactoryBuilder.xmlOutputFactory();
        // Assert
        assertSame(expectedOutputFactory, result, "The returned XMLOutputFactory should be the same as the set one.");
    }
}
