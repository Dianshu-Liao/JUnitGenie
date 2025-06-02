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

public class XmlMapper_setDefaultUseWrapper_7_0_Test {

    private XmlMapper xmlMapper;

    @BeforeEach
    public void setUp() {
        xmlMapper = new XmlMapper();
    }

    @Test
    public void testSetDefaultUseWrapperTrue() {
        // Arrange
        boolean state = true;
        // Act
        xmlMapper.setDefaultUseWrapper(state);
        // Assert
        AnnotationIntrospector ai0 = xmlMapper.getDeserializationConfig().getAnnotationIntrospector();
        for (AnnotationIntrospector ai : ai0.allIntrospectors()) {
            if (ai instanceof JacksonXmlAnnotationIntrospector) {
                assertEquals(state, ((JacksonXmlAnnotationIntrospector) ai)._cfgDefaultUseWrapper);
            }
        }
    }

    @Test
    public void testSetDefaultUseWrapperFalse() {
        // Arrange
        boolean state = false;
        // Act
        xmlMapper.setDefaultUseWrapper(state);
        // Assert
        AnnotationIntrospector ai0 = xmlMapper.getDeserializationConfig().getAnnotationIntrospector();
        for (AnnotationIntrospector ai : ai0.allIntrospectors()) {
            if (ai instanceof JacksonXmlAnnotationIntrospector) {
                assertEquals(state, ((JacksonXmlAnnotationIntrospector) ai)._cfgDefaultUseWrapper);
            }
        }
    }

    @Test
    public void testSetDefaultUseWrapperDoesNotReturnNull() {
        // Arrange
        boolean state = true;
        // Act
        XmlMapper returnedMapper = xmlMapper.setDefaultUseWrapper(state);
        // Assert
        assertNotNull(returnedMapper);
        assertEquals(xmlMapper, returnedMapper);
    }
}
