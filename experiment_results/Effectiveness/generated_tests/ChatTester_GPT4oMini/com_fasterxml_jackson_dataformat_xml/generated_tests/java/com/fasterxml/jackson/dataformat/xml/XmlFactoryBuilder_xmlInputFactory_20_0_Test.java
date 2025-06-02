// Test method
package com.fasterxml.jackson.dataformat.xml;

import javax.xml.stream.XMLInputFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLOutputFactory;
import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class XmlFactoryBuilder_xmlInputFactory_20_0_Test {

    private XmlFactoryBuilder xmlFactoryBuilder;

    private XMLInputFactory xmlInputFactory;

    @BeforeEach
    void setUp() {
        xmlFactoryBuilder = new XmlFactoryBuilder();
        xmlInputFactory = XMLInputFactory.newInstance();
    }

    @Test
    void testXmlInputFactory() throws Exception {
        // Act
        XmlFactoryBuilder result = xmlFactoryBuilder.xmlInputFactory(xmlInputFactory);
        // Assert
        assertSame(xmlInputFactory, getPrivateField(xmlFactoryBuilder, "_xmlInputFactory"), "The XMLInputFactory should be set correctly.");
        assertSame(xmlFactoryBuilder, result, "The method should return the current instance of XmlFactoryBuilder.");
    }

    // Reflection method to access private fields
    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        // Fixed the buggy line
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
