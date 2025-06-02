package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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

class XmlMapper_XmlMapper_22_1_Test {

    private XmlMapper xmlMapper;

    @BeforeEach
    void setUp() {
        // Testing the default constructor
        xmlMapper = new XmlMapper();
    }

    @Test
    void testXmlMapperDefaultConstructor() {
        assertNotNull(xmlMapper, "XmlMapper instance should not be null");
    }

    @Test
    void testXmlMapperWithInputFactory() {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XmlMapper xmlMapperWithInputFactory = new XmlMapper(inputFactory);
        assertNotNull(xmlMapperWithInputFactory, "XmlMapper instance with input factory should not be null");
    }

    @Test
    void testXmlMapperWithOutputFactory() {
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XmlMapper xmlMapperWithOutputFactory = new XmlMapper(XMLInputFactory.newInstance(), outputFactory);
        assertNotNull(xmlMapperWithOutputFactory, "XmlMapper instance with output factory should not be null");
    }

    @Test
    void testXmlMapperWithModule() {
        JacksonXmlModule module = new JacksonXmlModule();
        XmlMapper xmlMapperWithModule = new XmlMapper(module);
        assertNotNull(xmlMapperWithModule, "XmlMapper instance with module should not be null");
    }

    @Test
    void testXmlMapperCopy() {
        XmlMapper copiedMapper = xmlMapper.copy();
        assertNotNull(copiedMapper, "Copied XmlMapper instance should not be null");
    }

    @Test
    void testXmlMapperBuilder() {
        XmlMapper.Builder builder = XmlMapper.xmlBuilder();
        assertNotNull(builder, "XmlMapper builder should not be null");
    }

    @Test
    void testXmlMapperBuilderWithFactory() {
        XmlFactory xmlFactory = new XmlFactory();
        XmlMapper.Builder builderWithFactory = XmlMapper.builder(xmlFactory);
        assertNotNull(builderWithFactory, "XmlMapper builder with factory should not be null");
    }
}
