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

public class XmlFactoryBuilder_xmlInputFactory_20_2_Test {

    private XmlFactoryBuilder xmlFactoryBuilder;

    @BeforeEach
    public void setUp() {
        xmlFactoryBuilder = new XmlFactoryBuilder();
    }

    @Test
    public void testXmlInputFactory_SetAndGet() {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        xmlFactoryBuilder.xmlInputFactory(xmlInputFactory);
        assertNotNull(xmlFactoryBuilder._xmlInputFactory, "XMLInputFactory should not be null after setting.");
        assertEquals(xmlInputFactory, xmlFactoryBuilder._xmlInputFactory, "The XMLInputFactory should match the set instance.");
    }

    @Test
    public void testXmlInputFactory_NullInput() {
        xmlFactoryBuilder.xmlInputFactory(null);
        assertNull(xmlFactoryBuilder._xmlInputFactory, "XMLInputFactory should be null when set to null.");
    }

    @Test
    public void testXmlInputFactory_ChangeInputFactory() {
        XMLInputFactory firstFactory = XMLInputFactory.newInstance();
        xmlFactoryBuilder.xmlInputFactory(firstFactory);
        assertEquals(firstFactory, xmlFactoryBuilder._xmlInputFactory, "Should return the first XMLInputFactory set.");
        XMLInputFactory secondFactory = XMLInputFactory.newInstance();
        xmlFactoryBuilder.xmlInputFactory(secondFactory);
        assertEquals(secondFactory, xmlFactoryBuilder._xmlInputFactory, "Should return the second XMLInputFactory set.");
    }
}
