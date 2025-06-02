package com.fasterxml.jackson.dataformat.xml;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
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

public class XmlMapper_XmlMapper_26_0_Test {

    private XmlMapper xmlMapper;

    private JacksonXmlModule mockModule;

    @BeforeEach
    public void setUp() {
        mockModule = new JacksonXmlModule();
        xmlMapper = new XmlMapper(mockModule);
    }

    @Test
    public void testXmlMapperWithJacksonXmlModule() {
        assertNotNull(xmlMapper);
        assertNotNull(mockModule);
        // Verify that the internal XmlFactory is initialized correctly
        assertNotNull(getPrivateField(xmlMapper, "_xmlModule"));
        assertEquals(mockModule, getPrivateField(xmlMapper, "_xmlModule"));
    }

    private Object getPrivateField(Object obj, String fieldName) {
        try {
            // Fixed line: changed 'var' to 'Field' to correctly declare the variable type
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Could not access private field: " + fieldName);
            // This line will never be reached due to fail()
            return null;
        }
    }
}
