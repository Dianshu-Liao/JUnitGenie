package com.fasterxml.jackson.dataformat.xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlDeserializationContext;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;

public class XmlMapper_XmlMapper_23_0_Test {

    private XMLInputFactory xmlInputFactory;

    private XMLOutputFactory xmlOutputFactory;

    private XmlMapper xmlMapper;

    @BeforeEach
    public void setUp() {
        xmlInputFactory = XMLInputFactory.newInstance();
        xmlOutputFactory = XMLOutputFactory.newInstance();
        xmlMapper = new XmlMapper(xmlInputFactory, xmlOutputFactory);
    }

    @Test
    public void testXmlMapperNotNull() {
        assertNotNull(xmlMapper, "XmlMapper instance should not be null after initialization.");
    }

    @Test
    public void testXmlFactoryInitialization() {
        assertNotNull(xmlMapper.getFactory(), "XmlFactory should be initialized inside XmlMapper.");
    }

    @Test
    public void testXmlInputFactoryNotNull() {
        assertNotNull(xmlMapper.getFactory().getXMLInputFactory(), "XMLInputFactory should be set.");
    }

    @Test
    public void testXmlOutputFactoryNotNull() {
        assertNotNull(xmlMapper.getFactory().getXMLOutputFactory(), "XMLOutputFactory should be set.");
    }

    @Test
    public void testDefaultXmlModuleNotNull() {
        assertNotNull(xmlMapper.DEFAULT_XML_MODULE, "Default XML Module should not be null.");
    }

    @Test
    public void testDefaultXmlPrettyPrinterNotNull() {
        assertNotNull(xmlMapper.DEFAULT_XML_PRETTY_PRINTER, "Default XML Pretty Printer should not be null.");
    }

    @Test
    public void testJacksonXmlModuleInitialization() {
        JacksonXmlModule module = new JacksonXmlModule();
        xmlMapper.registerModule(module);
        assertNotNull(module, "Custom JacksonXmlModule should be initialized.");
    }
}
