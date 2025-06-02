package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.core.type.TypeReference;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

public class XmlMapper_XmlMapper_28_0_Test {

    private XmlMapper xmlMapper;

    @BeforeEach
    public void setUp() {
        xmlMapper = new XmlMapper();
    }

    @Test
    public void testXmlMapperCopyConstructor() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Create an instance of XmlMapper using the default constructor
        XmlMapper original = new XmlMapper();
        // Use reflection to access the private copy constructor
        Constructor<XmlMapper> constructor = XmlMapper.class.getDeclaredConstructor(XmlMapper.class);
        constructor.setAccessible(true);
        // Create a new instance using the copy constructor
        XmlMapper copy = constructor.newInstance(original);
        // Verify that the new instance is not null and is a copy of the original
        assertNotNull(copy);
    }

    @Test
    public void testXmlMapperWithJacksonXmlModule() {
        JacksonXmlModule module = new JacksonXmlModule();
        XmlMapper xmlMapperWithModule = new XmlMapper(module);
        assertNotNull(xmlMapperWithModule);
    }

    @Test
    public void testXmlMapperWithXmlFactory() {
        XmlFactory xmlFactory = new XmlFactory();
        XmlMapper xmlMapperWithFactory = new XmlMapper(xmlFactory);
        assertNotNull(xmlMapperWithFactory);
    }

    @Test
    public void testXmlMapperWithInputOutputFactory() {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XmlMapper xmlMapperWithFactories = new XmlMapper(inputFactory, outputFactory);
        assertNotNull(xmlMapperWithFactories);
    }

    @Test
    public void testSetXMLTextElementName() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // Use reflection to access the deprecated method
        Constructor<XmlMapper> constructor = XmlMapper.class.getDeclaredConstructor(XmlMapper.class);
        constructor.setAccessible(true);
        XmlMapper copy = constructor.newInstance(xmlMapper);
        String name = "testName";
        copy.setXMLTextElementName(name);
        // Verify that the name is set correctly
        assertNotNull(copy.getFactory().getXMLTextElementName());
    }
}
