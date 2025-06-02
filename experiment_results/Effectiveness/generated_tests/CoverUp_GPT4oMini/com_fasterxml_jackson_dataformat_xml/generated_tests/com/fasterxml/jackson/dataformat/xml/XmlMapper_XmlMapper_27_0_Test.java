package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
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

public class XmlMapper_XmlMapper_27_0_Test {

    private XmlFactory xmlFactory;

    private JacksonXmlModule jacksonXmlModule;

    private XmlMapper xmlMapper;

    @BeforeEach
    public void setUp() {
        xmlFactory = new XmlFactory();
        jacksonXmlModule = new JacksonXmlModule();
        xmlMapper = new XmlMapper(xmlFactory, jacksonXmlModule);
    }

    @Test
    public void testXmlMapperInitialization() {
        assertNotNull(xmlMapper);
        assertEquals(xmlFactory, xmlMapper.getFactory());
    }

    @Test
    public void testXmlMapperWithNullModule() {
        XmlMapper xmlMapperWithNullModule = new XmlMapper(xmlFactory, null);
        assertNotNull(xmlMapperWithNullModule);
        assertEquals(xmlFactory, xmlMapperWithNullModule.getFactory());
    }

    @Test
    public void testXmlMapperWithDefaultPrettyPrinter() {
        assertEquals(xmlMapper.getSerializationConfig().getDefaultPrettyPrinter(), XmlMapper.DEFAULT_XML_PRETTY_PRINTER);
    }

    @Test
    public void testXmlMapperWithCoercionConfigDefaults() {
        // Assuming there are methods to access coercion configurations
        // This is a placeholder for actual coercion config tests
        // assertEquals(expectedCoercionConfig, xmlMapper.coercionConfigDefaults());
    }

    @Test
    public void testXmlMapperWithSerializerFactoryOverride() {
        // Mock or create a SerializerFactory to test this functionality
        // SerializerFactory mockFactory = ...
        // jacksonXmlModule.setSerializerFactoryOverride(mockFactory);
        // xmlMapper = new XmlMapper(xmlFactory, jacksonXmlModule);
        // assertEquals(mockFactory, xmlMapper.getSerializerFactory());
    }
}
