package com.fasterxml.jackson.dataformat.xml;

import javax.xml.stream.XMLInputFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import javax.xml.stream.XMLOutputFactory;
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

public class XmlMapper_XmlMapper_24_0_Test {

    private XMLInputFactory xmlInputFactory;

    private XmlMapper xmlMapper;

    @BeforeEach
    public void setUp() {
        // Initialize the XMLInputFactory before each test
        xmlInputFactory = XMLInputFactory.newInstance();
        xmlMapper = new XmlMapper(xmlInputFactory);
    }

    @Test
    public void testXmlMapperInitialization() {
        // Test that XmlMapper is initialized correctly with XMLInputFactory
        assertNotNull(xmlMapper, "XmlMapper should not be null after initialization");
        assertNotNull(xmlMapper.getFactory(), "XmlFactory should not be null in XmlMapper");
        assertNotNull(xmlMapper.getFactory().getXMLInputFactory(), "XMLInputFactory should not be null in XmlFactory");
    }

    @Test
    public void testXmlMapperDefaultModule() {
        // Test that the default JacksonXmlModule is set correctly
        JacksonXmlModule defaultModule = XmlMapper.DEFAULT_XML_MODULE;
        assertNotNull(defaultModule, "Default JacksonXmlModule should not be null");
    }
}
