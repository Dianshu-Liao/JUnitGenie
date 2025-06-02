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

public class XmlFactoryBuilder_xmlInputFactory_3_1_Test {

    private XmlFactoryBuilder xmlFactoryBuilder;

    @BeforeEach
    public void setUp() {
        xmlFactoryBuilder = new XmlFactoryBuilder();
    }

    @Test
    public void testXmlInputFactory_WhenXmlInputFactoryIsNull_ShouldReturnDefaultInputFactory() {
        XMLInputFactory factory = xmlFactoryBuilder.xmlInputFactory();
        assertNotNull(factory, "Expected non-null XMLInputFactory from default factory.");
    }

    @Test
    public void testXmlInputFactory_WhenXmlInputFactoryIsSet_ShouldReturnSameInstance() {
        XMLInputFactory expectedFactory = XMLInputFactory.newInstance();
        xmlFactoryBuilder._xmlInputFactory = expectedFactory;
        XMLInputFactory actualFactory = xmlFactoryBuilder.xmlInputFactory();
        assertSame(expectedFactory, actualFactory, "Expected the same XMLInputFactory instance.");
    }
}
