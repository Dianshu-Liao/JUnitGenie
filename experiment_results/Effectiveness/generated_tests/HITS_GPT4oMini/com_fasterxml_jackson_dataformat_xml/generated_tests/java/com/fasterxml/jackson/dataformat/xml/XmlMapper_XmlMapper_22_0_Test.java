package com.fasterxml.jackson.dataformat.xml;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import javax.xml.stream.XMLInputFactory;
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

public class XmlMapper_XmlMapper_22_0_Test {

    @Test
    public void testDefaultConstructor() {
        XmlMapper xmlMapper = new XmlMapper();
        assertNotNull(xmlMapper, "XmlMapper instance should not be null");
    }

    @Test
    public void testConstructorWithInputFactory() {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XmlMapper xmlMapper = new XmlMapper(inputFactory);
        assertNotNull(xmlMapper, "XmlMapper instance should not be null");
    }

    @Test
    public void testConstructorWithOutputFactory() {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XmlMapper xmlMapper = new XmlMapper(inputFactory, outputFactory);
        assertNotNull(xmlMapper, "XmlMapper instance should not be null");
    }

    @Test
    public void testConstructorWithXmlFactory() {
        XmlFactory xmlFactory = new XmlFactory();
        XmlMapper xmlMapper = new XmlMapper(xmlFactory);
        assertNotNull(xmlMapper, "XmlMapper instance should not be null");
    }

    @Test
    public void testConstructorWithJacksonXmlModule() {
        JacksonXmlModule module = new JacksonXmlModule();
        XmlMapper xmlMapper = new XmlMapper(module);
        assertNotNull(xmlMapper, "XmlMapper instance should not be null");
    }

    @Test
    public void testConstructorWithXmlFactoryAndModule() {
        XmlFactory xmlFactory = new XmlFactory();
        JacksonXmlModule module = new JacksonXmlModule();
        XmlMapper xmlMapper = new XmlMapper(xmlFactory, module);
        assertNotNull(xmlMapper, "XmlMapper instance should not be null");
    }

    @Test
    public void testCopyConstructor() {
        XmlMapper originalXmlMapper = new XmlMapper();
        XmlMapper copiedXmlMapper = new XmlMapper(originalXmlMapper);
        assertNotNull(copiedXmlMapper, "Copied XmlMapper instance should not be null");
    }
}
