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

public class XmlMapper_XmlMapper_26_0_Test {

    private XmlMapper xmlMapper;

    @BeforeEach
    public void setUp() {
        // Initialize XmlMapper with default JacksonXmlModule
        JacksonXmlModule module = new JacksonXmlModule();
        xmlMapper = new XmlMapper(module);
    }

    @Test
    public void testXmlMapperInitialization() {
        // Verify that the XmlMapper is initialized correctly
        assertNotNull(xmlMapper);
    }

    @Test
    public void testXmlMapperWithCustomFactories() {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XmlMapper customXmlMapper = new XmlMapper(inputFactory, outputFactory);
        // Verify that the custom XmlMapper is initialized correctly
        assertNotNull(customXmlMapper);
        // We can't access the factories directly, so we will assert the XmlMapper is functional
        assertDoesNotThrow(() -> customXmlMapper.writeValueAsString(new Object()));
    }

    @Test
    public void testXmlMapperWithXmlFactory() {
        XmlFactory xmlFactory = new XmlFactory();
        XmlMapper xmlMapperWithFactory = new XmlMapper(xmlFactory);
        // Verify that the XmlMapper is initialized with the provided XmlFactory
        assertNotNull(xmlMapperWithFactory);
        // Assert the XmlMapper is functional
        assertDoesNotThrow(() -> xmlMapperWithFactory.writeValueAsString(new Object()));
    }
}
