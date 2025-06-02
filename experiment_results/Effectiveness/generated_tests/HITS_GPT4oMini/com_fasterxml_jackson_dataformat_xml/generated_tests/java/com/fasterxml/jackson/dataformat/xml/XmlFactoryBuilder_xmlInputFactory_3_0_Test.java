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

public class XmlFactoryBuilder_xmlInputFactory_3_0_Test {

    private XmlFactoryBuilder xmlFactoryBuilder;

    @BeforeEach
    public void setUp() {
        xmlFactoryBuilder = new XmlFactoryBuilder();
    }

    @Test
    public void testXmlInputFactory_NullFactory() {
        // Test when _xmlInputFactory is null, should return a new default factory
        XMLInputFactory factory = xmlFactoryBuilder.xmlInputFactory();
        assertNotNull(factory, "Expected a non-null XMLInputFactory when _xmlInputFactory is null");
    }

    @Test
    public void testXmlInputFactory_ExistingFactory() {
        // Test when _xmlInputFactory is already set
        XMLInputFactory existingFactory = XMLInputFactory.newInstance();
        xmlFactoryBuilder._xmlInputFactory = existingFactory;
        XMLInputFactory factory = xmlFactoryBuilder.xmlInputFactory();
        assertSame(existingFactory, factory, "Expected to return the existing XMLInputFactory");
    }
}
