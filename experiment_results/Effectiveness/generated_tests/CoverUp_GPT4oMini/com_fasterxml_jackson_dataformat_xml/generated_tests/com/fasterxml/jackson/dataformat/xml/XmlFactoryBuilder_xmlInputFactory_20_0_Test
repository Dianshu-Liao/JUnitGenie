package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.dataformat.xml.XmlFactoryBuilder;
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

public class XmlFactoryBuilder_xmlInputFactory_20_0_Test {

    @Test
    public void testXmlInputFactory() throws Exception {
        // Arrange
        XmlFactoryBuilder builder = new XmlFactoryBuilder();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        // Act
        XmlFactoryBuilder result = builder.xmlInputFactory(xmlInputFactory);
        // Assert
        assertNotNull(result);
        assertEquals(xmlInputFactory, getPrivateField(builder, "_xmlInputFactory"));
    }

    private Object getPrivateField(XmlFactoryBuilder builder, String fieldName) throws Exception {
        java.lang.reflect.Field field = XmlFactoryBuilder.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(builder);
    }
}
