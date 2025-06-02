package com.fasterxml.jackson.dataformat.xml;

import javax.xml.stream.XMLInputFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLOutputFactory;
import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class XmlFactoryBuilder_xmlInputFactory_3_0_Test {

    private XmlFactoryBuilder xmlFactoryBuilder;

    @BeforeEach
    public void setUp() {
        xmlFactoryBuilder = new XmlFactoryBuilder();
    }

    @Test
    public void testXmlInputFactory_WhenXmlInputFactoryIsNull_ShouldReturnDefaultInputFactory() {
        XMLInputFactory result = xmlFactoryBuilder.xmlInputFactory();
        assertNotNull(result, "Expected default XMLInputFactory to be returned when _xmlInputFactory is null");
    }

    @Test
    public void testXmlInputFactory_WhenXmlInputFactoryIsNotNull_ShouldReturnXmlInputFactory() {
        XMLInputFactory expectedFactory = XMLInputFactory.newInstance();
        setPrivateField(xmlFactoryBuilder, "_xmlInputFactory", expectedFactory);
        XMLInputFactory result = xmlFactoryBuilder.xmlInputFactory();
        assertEquals(expectedFactory, result, "Expected the same XMLInputFactory to be returned when it is set");
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
