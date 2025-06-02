package com.fasterxml.jackson.dataformat.xml;

import javax.xml.stream.XMLInputFactory;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class XmlMapper_XmlMapper_24_1_Test {

    private XMLInputFactory xmlInputFactory;

    @BeforeEach
    public void setUp() {
        xmlInputFactory = XMLInputFactory.newInstance();
    }

    @Test
    public void testXmlMapperConstructor() {
        XmlMapper xmlMapper = new XmlMapper(xmlInputFactory);
        assertNotNull(xmlMapper, "XmlMapper instance should not be null");
        assertEquals(XmlFactory.class, xmlMapper.getFactory().getClass(), "XmlFactory should be initialized correctly");
    }

    @Test
    public void testXmlMapperConstructorWithNullInputFactory() {
        assertThrows(NullPointerException.class, () -> {
            // Replacing null with an instance of JacksonXmlModule
            new XmlMapper(new JacksonXmlModule());
        }, "Expected NullPointerException when XMLInputFactory is null");
    }

    @Test
    public void testXmlMapperConstructorWithDifferentInputFactory() {
        XMLInputFactory anotherInputFactory = XMLInputFactory.newInstance();
        XmlMapper anotherXmlMapper = new XmlMapper(anotherInputFactory);
        assertNotNull(anotherXmlMapper, "Another XmlMapper instance should not be null");
        assertEquals(XmlFactory.class, anotherXmlMapper.getFactory().getClass(), "Another XmlFactory should be initialized correctly");
    }
}
