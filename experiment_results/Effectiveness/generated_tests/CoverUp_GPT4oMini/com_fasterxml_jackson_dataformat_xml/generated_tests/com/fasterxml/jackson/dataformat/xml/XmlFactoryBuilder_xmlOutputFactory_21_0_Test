package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.dataformat.xml.XmlFactoryBuilder;
import javax.xml.stream.XMLOutputFactory;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLInputFactory;
import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class XmlFactoryBuilder_xmlOutputFactory_21_0_Test {

    @Test
    public void testXmlOutputFactory() throws Exception {
        // Arrange
        XmlFactoryBuilder builder = new XmlFactoryBuilder();
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        // Act
        XmlFactoryBuilder result = invokeXmlOutputFactory(builder, xmlOutputFactory);
        // Assert
        assertNotNull(result);
        assertSame(xmlOutputFactory, getXmlOutputFactory(builder));
    }

    private XmlFactoryBuilder invokeXmlOutputFactory(XmlFactoryBuilder builder, XMLOutputFactory xmlOut) throws Exception {
        Method method = XmlFactoryBuilder.class.getDeclaredMethod("xmlOutputFactory", XMLOutputFactory.class);
        method.setAccessible(true);
        return (XmlFactoryBuilder) method.invoke(builder, xmlOut);
    }

    private XMLOutputFactory getXmlOutputFactory(XmlFactoryBuilder builder) throws Exception {
        Method method = XmlFactoryBuilder.class.getDeclaredField("_xmlOutputFactory").getDeclaringClass().getDeclaredMethod("getXmlOutputFactory");
        method.setAccessible(true);
        return (XMLOutputFactory) method.invoke(builder);
    }
}
