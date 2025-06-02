package com.fasterxml.jackson.dataformat.xml;

import com.fasterxml.jackson.dataformat.xml.XmlFactoryBuilder;
import javax.xml.stream.XMLOutputFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.xml.stream.XMLInputFactory;
import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class XmlFactoryBuilder_xmlOutputFactory_5_1_Test {

    private XmlFactoryBuilder xmlFactoryBuilder;

    @BeforeEach
    public void setUp() {
        xmlFactoryBuilder = new XmlFactoryBuilder();
    }

    @Test
    public void testXmlOutputFactory_WhenFactoryIsNull_ShouldReturnDefaultFactory() {
        // Act
        XMLOutputFactory result = xmlFactoryBuilder.xmlOutputFactory();
        // Assert
        assertNotNull(result, "Expected default XMLOutputFactory to be created.");
    }

    @Test
    public void testXmlOutputFactory_WhenFactoryIsNotNull_ShouldReturnSameFactory() {
        // Arrange
        XMLOutputFactory expectedFactory = XMLOutputFactory.newInstance();
        setPrivateField(xmlFactoryBuilder, "_xmlOutputFactory", expectedFactory);
        // Act
        XMLOutputFactory result = xmlFactoryBuilder.xmlOutputFactory();
        // Assert
        assertSame(expectedFactory, result, "Expected the same XMLOutputFactory to be returned.");
    }

    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
