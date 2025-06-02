package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
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

class XmlMapper_XmlMapper_26_0_Test {

    private XmlMapper xmlMapper;

    private JacksonXmlModule module;

    @BeforeEach
    void setUp() {
        module = new JacksonXmlModule();
        xmlMapper = new XmlMapper(module);
    }

    @Test
    void testConstructorWithJacksonXmlModule() {
        assertNotNull(xmlMapper);
    }

    @Test
    void testConstructorWithXmlFactoryAndJacksonXmlModule() throws Exception {
        XmlFactory xmlFactory = new XmlFactory();
        XmlMapper xmlMapperWithFactory = invokePrivateConstructor(xmlFactory, module);
        assertNotNull(xmlMapperWithFactory);
    }

    private XmlMapper invokePrivateConstructor(XmlFactory xmlFactory, JacksonXmlModule module) throws Exception {
        java.lang.reflect.Constructor<XmlMapper> constructor = XmlMapper.class.getDeclaredConstructor(XmlFactory.class, JacksonXmlModule.class);
        constructor.setAccessible(true);
        return constructor.newInstance(xmlFactory, module);
    }
}
