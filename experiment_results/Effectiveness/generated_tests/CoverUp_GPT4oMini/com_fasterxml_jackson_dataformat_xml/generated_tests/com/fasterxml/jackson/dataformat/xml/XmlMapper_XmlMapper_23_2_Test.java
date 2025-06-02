package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
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

public class XmlMapper_XmlMapper_23_2_Test {

    private XmlMapper xmlMapper;

    private XMLInputFactory xmlInputFactory;

    private XMLOutputFactory xmlOutputFactory;

    @BeforeEach
    public void setUp() {
        xmlInputFactory = XMLInputFactory.newInstance();
        xmlOutputFactory = XMLOutputFactory.newInstance();
        xmlMapper = new XmlMapper(xmlInputFactory, xmlOutputFactory);
    }

    @Test
    public void testXmlMapperCreation() {
        assertNotNull(xmlMapper);
    }

    @Test
    public void testXmlMapperWithDefaultModule() {
        XmlMapper xmlMapperWithDefaultModule = new XmlMapper();
        assertNotNull(xmlMapperWithDefaultModule);
    }

    @Test
    public void testXmlMapperWithXmlFactory() {
        XmlFactory xmlFactory = new XmlFactory(xmlInputFactory, xmlOutputFactory);
        XmlMapper xmlMapperWithFactory = new XmlMapper(xmlFactory);
        assertNotNull(xmlMapperWithFactory);
    }

    @Test
    public void testXmlMapperWithJacksonXmlModule() {
        JacksonXmlModule module = new JacksonXmlModule();
        XmlMapper xmlMapperWithModule = new XmlMapper(module);
        assertNotNull(xmlMapperWithModule);
    }

    @Test
    public void testXmlMapperWithXmlFactoryAndJacksonXmlModule() {
        JacksonXmlModule module = new JacksonXmlModule();
        XmlFactory xmlFactory = new XmlFactory(xmlInputFactory, xmlOutputFactory);
        XmlMapper xmlMapperWithFactoryAndModule = new XmlMapper(xmlFactory, module);
        assertNotNull(xmlMapperWithFactoryAndModule);
    }

    @Test
    public void testGetFactory() {
        assertNotNull(xmlMapper.getFactory());
    }

    @Test
    public void testSetXMLTextElementName() throws Exception {
        String testName = "testName";
        xmlMapper.setXMLTextElementName(testName);
        String name = (String) xmlMapper.getFactory().getClass().getDeclaredMethod("getXMLTextElementName").invoke(xmlMapper.getFactory());
        assertNotNull(name);
        assertEquals(testName, name);
    }
}
