package com.fasterxml.jackson.dataformat.xml;

import java.lang.reflect.Method;
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

public class XmlMapper_setDefaultUseWrapper_7_0_Test {

    private XmlMapper xmlMapper;

    @BeforeEach
    public void setUp() {
        xmlMapper = new XmlMapper();
    }

    @Test
    public void testSetDefaultUseWrapperTrue() throws Exception {
        // Call the focal method
        xmlMapper.setDefaultUseWrapper(true);
        // Use reflection to access the private field _xmlModule
        Method getFactoryMethod = XmlMapper.class.getDeclaredMethod("getFactory");
        getFactoryMethod.setAccessible(true);
        XmlFactory actualFactory = (XmlFactory) getFactoryMethod.invoke(xmlMapper);
        // Validate the state
        assertNotNull(actualFactory);
        AnnotationIntrospector ai = xmlMapper.getDeserializationConfig().getAnnotationIntrospector();
        assertTrue(ai instanceof JacksonXmlAnnotationIntrospector);
        // Validate the expected behavior
        Method getDefaultUseWrapperMethod = JacksonXmlAnnotationIntrospector.class.getDeclaredMethod("getDefaultUseWrapper");
        getDefaultUseWrapperMethod.setAccessible(true);
        assertTrue((Boolean) getDefaultUseWrapperMethod.invoke(ai));
    }

    @Test
    public void testSetDefaultUseWrapperFalse() throws Exception {
        // Call the focal method
        xmlMapper.setDefaultUseWrapper(false);
        // Use reflection to access the private field _xmlModule
        Method getFactoryMethod = XmlMapper.class.getDeclaredMethod("getFactory");
        getFactoryMethod.setAccessible(true);
        XmlFactory actualFactory = (XmlFactory) getFactoryMethod.invoke(xmlMapper);
        // Validate the state
        assertNotNull(actualFactory);
        AnnotationIntrospector ai = xmlMapper.getDeserializationConfig().getAnnotationIntrospector();
        assertTrue(ai instanceof JacksonXmlAnnotationIntrospector);
        // Validate the expected behavior
        Method getDefaultUseWrapperMethod = JacksonXmlAnnotationIntrospector.class.getDeclaredMethod("getDefaultUseWrapper");
        getDefaultUseWrapperMethod.setAccessible(true);
        assertFalse((Boolean) getDefaultUseWrapperMethod.invoke(ai));
    }

    @Test
    public void testSetDefaultUseWrapperWithJacksonXmlAnnotationIntrospector() throws Exception {
        // Call the focal method
        xmlMapper.setDefaultUseWrapper(true);
        // Use reflection to access the private field _xmlModule
        Method getFactoryMethod = XmlMapper.class.getDeclaredMethod("getFactory");
        getFactoryMethod.setAccessible(true);
        XmlFactory actualFactory = (XmlFactory) getFactoryMethod.invoke(xmlMapper);
        // Access the AnnotationIntrospector
        AnnotationIntrospector ai = xmlMapper.getDeserializationConfig().getAnnotationIntrospector();
        assertNotNull(ai);
        // Validate the state of JacksonXmlAnnotationIntrospector
        if (ai instanceof JacksonXmlAnnotationIntrospector) {
            Method getDefaultUseWrapperMethod = JacksonXmlAnnotationIntrospector.class.getDeclaredMethod("getDefaultUseWrapper");
            getDefaultUseWrapperMethod.setAccessible(true);
            assertTrue((Boolean) getDefaultUseWrapperMethod.invoke(ai));
        }
    }
}
